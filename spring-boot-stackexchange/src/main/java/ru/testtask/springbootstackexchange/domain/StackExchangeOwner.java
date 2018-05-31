package ru.testtask.springbootstackexchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Пользователь, породивший запрос
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackExchangeOwner {
    /**
     * Идентификатор пользователя
     */
    @JsonProperty("user_id")
    Long userId;
    /**
     * ссылка на изображение профиля полльзователя
     */
    @JsonProperty("profile_image")
    String profileImgUrl;
    /**
     * Логин пользователя
     */
    @JsonProperty("display_name")
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
