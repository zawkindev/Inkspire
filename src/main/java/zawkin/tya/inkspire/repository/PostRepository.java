package zawkin.tya.inkspire.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zawkin.tya.inkspire.entities.PostEntity;

public interface PostRepository extends MongoRepository<PostEntity, String> {
}
