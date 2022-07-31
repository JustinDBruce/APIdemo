package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
public class apiEntries {
    @JsonPropertyOrder({
            "API",
            "Description",
            "Auth",
            "HTTPS",
            "Cors",
            "Link",
            "Category"
    })
    @JsonProperty("API")
    String api;
    @JsonProperty("Description")
    String description;
    @JsonProperty("Auth")
    String auth;
    @JsonProperty("HTTPS")
    boolean https;
    @JsonProperty("Cors")
    String cors;
    @JsonProperty("Link")
    String link;
    @JsonProperty("Category")
    String catagory;

    /**
     * Getters
     * Lombok should take care of this, but it is not recognized by thymeleaf
     * @return
     */
    public String getApi() {
        return api;
    }

    public String getDescription() {
        return description;
    }

    public String getAuth() {
        return auth;
    }

    public boolean isHttps() {
        return https;
    }

    public String getCors() {
        return cors;
    }

    public String getLink() {
        return link;
    }

    public String getCatagory() {
        return catagory;
    }
}
