package ru.testtask.springbootstackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Формат ответа
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeWrapper {
    /**
     * Список найденных вопросов
     */
    List<StackExchangeItem> items;
    /**
     * Есть ли еще данные по запросу
     */
    @JsonProperty("has_more")
    boolean hasMore;
    /**
     * Сообщение ошибки, если была ошибка
     */
    @JsonProperty("error_message")
    String errorMessage;

    public List<StackExchangeItem> getItems() {
        return items;
    }

    public void setItems(List<StackExchangeItem> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
