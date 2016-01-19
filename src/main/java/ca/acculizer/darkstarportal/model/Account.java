package ca.acculizer.darkstarportal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Francois Dickey on 2016-01-18.
 */
public class Account {
    private Long id;
    private String login;
    private String email;
    private Integer contentIds;
    private Integer status;
    private Integer privilege;

    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty
    public String getLogin() {
        return login;
    }

    @JsonProperty
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty
    public Integer getContentIds() {
        return contentIds;
    }

    @JsonProperty
    public void setContentIds(Integer contentIds) {
        this.contentIds = contentIds;
    }

    @JsonProperty
    public Integer getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty
    public Integer getPrivilege() {
        return privilege;
    }

    @JsonProperty
    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }
}
