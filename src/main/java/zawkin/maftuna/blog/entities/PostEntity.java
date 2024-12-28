package zawkin.maftuna.blog.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("posts")
public class PostEntity {
    @Id
    private String id;
    private String title;
    private LocalDateTime createdDate;
}
