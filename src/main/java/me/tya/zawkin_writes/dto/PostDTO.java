package me.tya.zawkin_writes.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PostDTO(
    String id,
    String title,
    String content,
    List<String> tags,
    LocalDateTime createdDate) {
}
