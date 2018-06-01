package ru.testtask.springbootstackexchange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.testtask.springbootstackexchange.domain.StackExchangeWrapper;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Сервис получения данных из StackExchange
 */
//@Service
public class StackExchangeServiceImpl implements StackExchangService {

    static final String urlStackExchange = "http://api.stackexchange.com/2.2";
    static final String urlSearch = "/search#order=desc&sort=activity&filter=default&site=stackoverflow&run=true";

    @Autowired
    public StackExchangeServiceImpl() {}

    /**
     * Получтиь список вопросов в StackExchange
     * @param findString - строка поискового запроса
     * @param offset - смещение страницы
     * @param limit - количество результатов на странице
     * @return список вопросов StackExchangeItem
     */
    @Override
    public StackExchangeWrapper getQuestions(String findString, Long offset, Long limit) {
        /*List<StackExchangeItem> items = new ArrayList<>();
        StackExchangeOwner owner = new StackExchangeOwner();
        owner.setDisplayName("sdfvsdfb");
        owner.setLink("");
        owner.setUserId(1105011L);
        StackExchangeItem item = new StackExchangeItem();
        item.setTags(Arrays.asList("java", "spring"));
        item.setOwner(owner);
        item.setAnswerCount(1L);
        item.setCreateDate(new Date());
        item.setLastActivityDate(new Date());
        item.setLastEditDate(new Date());
        item.setLink("https://stackoverflow.com/questions/50563866/combine-multiple-collectorsgroupby-functions-with-java-streams");
        items.add(item);*/
        String url = urlStackExchange + urlSearch
                + "&intitle=" + findString
                + ((offset != null) ? "&page=" + offset : "")
                + ((limit != null) ? "&pagesize=" + limit : ""); // todo url encode
/*        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<List<StackExchangeItem>> listResponseEntity = restTemplate.exchange(
                    "http://api.stackexchange.com/2.2/search?site=stackoverflow&page=1&pagesize=10&order=desc&sort=activity&intitle=java&filter=default",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<StackExchangeItem>>() {});
            if(listResponseEntity != null && listResponseEntity.hasBody()){
                return listResponseEntity.getBody();
            }
        } catch (RestClientException e) {
            throw e;
        }*/

        try {
            RestTemplate restTemplate = new RestTemplate();

            String url_ = "https://api.stackexchange.com/2.2/search?key=U4DMV*8nvpm3EOpvf69Rxw((&site=stackoverflow&order=desc&sort=activity&intitle=java&filter=default";
//            String page = restTemplate.getForObject(
//                    url_,
//                    String.class);
//            System.out.println(page);
//
//                String decom = decompress(page.getBytes("UTF-8"));
//                System.out.println(decom);



            HttpHeaders headers = new HttpHeaders();
            headers.add("Accept-Encoding", "gzip");
            HttpEntity entity = new HttpEntity(headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url_, HttpMethod.GET, entity, String.class);

            System.out.println(response.toString());
        } catch (RestClientException e) {
            throw e;
//        } catch (IOException e){
//            System.out.println(e);
        } catch (Exception e){
            throw e;
        }

        return null;
    }

    public static byte[] compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
    }

    public static String decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gis = new GZIPInputStream(bis);
        BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        gis.close();
        bis.close();
        return sb.toString();
    }


}
