package me.tya.zawkin_writes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("posts")
public class PostEntity {
  @Id
  private String id;
  private String title;
  private String content;
  private List<String> tags;
  private LocalDateTime createdDate;
}
