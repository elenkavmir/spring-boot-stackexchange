package ru.testtask.springbootstackexchange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.testtask.springbootstackexchange.domain.StackExchangeItem;
import ru.testtask.springbootstackexchange.domain.StackExchangeOwner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Сервис получения данных из StackExchange
 */
@Service
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
    public List<StackExchangeItem> getQuestions(String findString, Long offset, Long limit) {
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

        RestTemplate restTemplate = new RestTemplate();
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
        }

/*        try {
        RestTemplate restTemplate = new RestTemplate();
        String page = restTemplate.getForObject("http://api.stackexchange.com/2.2/search?site=stackoverflow&page=1&pagesize=10&order=desc&sort=activity&intitle=java&filter=default", String.class);
        System.out.println(page);
        } catch (RestClientException e) {
            throw e;
        }*/

        return null;
    }
}
