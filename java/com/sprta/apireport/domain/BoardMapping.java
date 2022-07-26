package com.sprta.apireport.domain;

import java.time.LocalDateTime;

public interface BoardMapping {
    Long getId();
    String getTitle();
    String getAuthor();
    LocalDateTime getCreatedAt();
}
