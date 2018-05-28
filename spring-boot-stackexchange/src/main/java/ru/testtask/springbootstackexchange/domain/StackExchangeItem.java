package ru.testtask.springbootstackexchange.domain;

import java.util.Date;
import java.util.List;

/**
 * Информация по вопросу
 */
public class StackExchangeItem {
    /**
     * Теги вопроса
     */
    List<String> tags;
    /**
     * Пользователь, задавший вопрос
     */
    StackExchangeoOwner owner;
    /**
     * Есть ли решение вопроса
     */
    Boolean isAnswered;
    /**
     * Количество ответов на вопрос
     */
    Long answerCount;
    /**
     * Дата последней активности по вопросу
     */
    Date lastActivityDate;
    /**
     * Дата создания вопроса
     */
    Date createDate;
    /**
     * Дата последнего редактирования вопроса
     */
    Date lastEditDate;
    /**
     * Идентификатор вопроса
     */
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

    public StackExchangeoOwner getOwner() {
        return owner;
    }

    public void setOwner(StackExchangeoOwner owner) {
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

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
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
