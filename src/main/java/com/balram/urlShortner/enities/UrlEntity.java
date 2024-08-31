package com.balram.urlShortner.enities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "url")
@Data
public class UrlEntity {

    @Id
    private String id;

    private String url;

    @Indexed(expireAfterSeconds = 3600)
    private LocalDateTime expiresAt;

    // Constructors
    public UrlEntity(String id, String url, LocalDateTime expiresAt) {
        this.id = id;
        this.url = url;
        this.expiresAt = expiresAt;
    }

    public UrlEntity() {}

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
