package ru.testtask.springbootstackexchange.services;

import ru.testtask.springbootstackexchange.domain.StackExchangeItem;
import ru.testtask.springbootstackexchange.domain.StackExchangeWrapper;

import java.util.List;

/**
 * Сервис получения данных из StackExchang
 */
public interface StackExchangService {
    StackExchangeWrapper getQuestions(String title, Long page, Long pagesize);
}
