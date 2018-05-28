package ru.testtask.springbootstackexchange.services;

import ru.testtask.springbootstackexchange.domain.StackExchangeItem;

import java.util.List;

/**
 * Сервис получения данных из StackExchang
 */
public interface StackExchangService {
    List<StackExchangeItem> getQuestions(String findString, Long offset, Long limit);
}
