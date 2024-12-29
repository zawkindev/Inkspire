package zawkin.tya.inkspire.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("tags")
public class TagEntity {
    @Id
    private String id;
    private String name;
}
