package com.balram.urlShortner.exceptions.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;

public record UrlShortenerError(
        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime timestamp,
        Integer code,
        String status,
        List<String> errors
) {
        // Static method to initialize the builder
        public static Builder builder() {
                return new Builder();
        }

        public static class Builder {
                private LocalDateTime timestamp;
                private Integer code;
                private String status;
                private List<String> errors;

                public Builder timestamp(LocalDateTime timestamp) {
                        this.timestamp = timestamp;
                        return this;
                }

                public Builder code(Integer code) {
                        this.code = code;
                        return this;
                }

                public Builder status(String status) {
                        this.status = status;
                        return this;
                }

                public Builder errors(List<String> errors) {
                        this.errors = errors;
                        return this;
                }

                public UrlShortenerError build() {
                        return new UrlShortenerError(timestamp, code, status, errors);
                }
        }
}
