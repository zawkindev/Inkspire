package zawkin.maftuna.blog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zawkin.maftuna.blog.entities.PostEntity;

public interface PostRepository extends MongoRepository<PostEntity, String> {
}
