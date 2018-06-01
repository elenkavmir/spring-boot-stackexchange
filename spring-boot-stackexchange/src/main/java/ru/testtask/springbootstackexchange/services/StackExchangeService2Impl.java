package ru.testtask.springbootstackexchange.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testtask.springbootstackexchange.domain.StackExchangeWrapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

@Service
public class StackExchangeService2Impl implements StackExchangService {

    @Autowired
    public StackExchangeService2Impl() {}

    @Override
    public StackExchangeWrapper getQuestions(String findString, Long offset, Long limit){
        try {
            String url_ = "https://api.stackexchange.com/2.2/search?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=activity&intitle=java&filter=default";
            URL url = new URL(url_);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            System.out.println("RC:" + conn.getResponseCode());    // 200
            System.out.println("RM:" + conn.getResponseMessage()); // "OK"
            System.out.println("TYPE:" + conn.getContentType());

            // NOTE: Content is compressed by default.
            // Some proxies decompress and deliver uncompressed content.
            System.out.println("ENC:" + conn.getContentEncoding());

            InputStream content = conn.getInputStream(); // InputStream
            String encoding = conn.getContentEncoding();
            if (encoding != null && encoding.equals("gzip")) {
                content = new GZIPInputStream(content);
            }
            String result = new Scanner(content, "UTF-8").useDelimiter("\\A").next();
            content.close();

            System.out.println(result);
            ObjectMapper mapper = new ObjectMapper();
            StackExchangeWrapper myObjects = mapper.readValue(result, StackExchangeWrapper.class);
            return myObjects;
        } catch (Exception e) {
            System.out.println(e);
        }
         return null;
    }
}
