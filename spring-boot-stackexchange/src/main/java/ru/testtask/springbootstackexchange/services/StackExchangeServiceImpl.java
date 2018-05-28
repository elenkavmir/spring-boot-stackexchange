package ru.testtask.springbootstackexchange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.testtask.springbootstackexchange.domain.StackExchangeItem;
import ru.testtask.springbootstackexchange.domain.StackExchangeoOwner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Сервис получения данных из StackExchange
 */
@Service
public class StackExchangeServiceImpl implements StackExchangService {

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
        List<StackExchangeItem> items = new ArrayList<>();
        StackExchangeoOwner owner = new StackExchangeoOwner();
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
        items.add(item);
        return items;// fixme Todo
    }
}
