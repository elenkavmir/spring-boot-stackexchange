package ru.testtask.springbootstackexchange.domain;

/**
 * Пользователь, породивший запрос
 */
public class StackExchangeoOwner {
    /**
     * Идентификатор пользователя
     */
    Long userId;
    /**
     * ссылка на изображение профиля полльзователя
     */
    String profileImgUrl;
    /**
     * Логин пользователя
     */
    String displayName;
    /**
     * ссылка на профиль пользователя
     */
    String link;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
