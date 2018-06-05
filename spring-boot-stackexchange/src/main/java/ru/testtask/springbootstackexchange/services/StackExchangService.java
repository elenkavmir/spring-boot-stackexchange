package ru.testtask.springbootstackexchange.services;

import ru.testtask.springbootstackexchange.domain.StackExchangeWrapper;

/**
 * Сервис получения данных из StackExchang
 */
public interface StackExchangService {
    /**
     * Получение вопросов по заголовку
     * @param title - строка поиска
     * @param page - страница поиска
     * @param pagesize - размер страницы поиска
     * @return StackExchangeWrapper
     */
    StackExchangeWrapper getQuestions(String title, Long page, Long pagesize);
}
