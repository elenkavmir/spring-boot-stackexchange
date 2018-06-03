package ru.testtask.springbootstackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Информация по вопросу
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeItem {
    /**
     * Теги вопроса
     */
    List<String> tags;
    /**
     * Пользователь, задавший вопрос
     */
    StackExchangeOwner owner;
    /**
     * Есть ли решение вопроса
     */
    @JsonProperty("is_answered")
    Boolean isAnswered;
    /**
     * Количество ответов на вопрос
     */
    @JsonProperty("answer_count")
    Long answerCount;
    /**
     * Дата последней активности по вопросу
     */
    @JsonProperty("last_activity_date")
    Long lastActivityDate;
    /**
     * Дата создания вопроса
     */
    @JsonProperty("creation_date")
    Long createDate;
    /**
     * Дата последнего редактирования вопроса
     */
    @JsonProperty("last_edit_date")
    Long lastEditDate;
    /**
     * Идентификатор вопроса
     */
    @JsonProperty("question_id")
    Long questionId;
    /**
     * Ссылка на вопрос
     */
    String link;
    /**
     * Тема вопроса
     */
    String title;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public StackExchangeOwner getOwner() {
        return owner;
    }

    public void setOwner(StackExchangeOwner owner) {
        this.owner = owner;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Long getCreateLong() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
