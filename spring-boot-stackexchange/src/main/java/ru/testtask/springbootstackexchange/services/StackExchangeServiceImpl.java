package ru.testtask.springbootstackexchange.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testtask.springbootstackexchange.domain.StackExchangeWrapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

@Service
public class StackExchangeServiceImpl implements StackExchangService {

    static final String urlStackExchange = "http://api.stackexchange.com/2.2";
    static final String urlSearch = "/search?order=desc&sort=activity&filter=default&site=stackoverflow&run=true";

    @Autowired
    public StackExchangeServiceImpl() {}


//    @Override //todo ?
    public StackExchangeWrapper getQuestions(String title, Long page, Long pagesize){
        try {
            String url_ = urlStackExchange + urlSearch
                    + "&intitle=" + URLEncoder.encode(title,"UTF-8")
                    + ((page != null) ? "&page=" + page : "")
                    + ((pagesize != null) ? "&pagesize=" + pagesize : "");
            URL url = new URL(url_);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            //System.out.println(url_);

            InputStream content = conn.getInputStream();
            String encoding = conn.getContentEncoding();
            // проверяем формат
            if (encoding != null && encoding.equals("gzip")) {
                content = new GZIPInputStream(content);
            }
            String result = new Scanner(content, "UTF-8").useDelimiter("\\A").next();
            content.close();

            //System.out.println(result);
            // json -> object
            ObjectMapper mapper = new ObjectMapper();
            StackExchangeWrapper myObjects = mapper.readValue(result, StackExchangeWrapper.class);
            return myObjects;
        } catch (Exception e) {
            System.out.println(e);
        }
         return null;
    }
}
