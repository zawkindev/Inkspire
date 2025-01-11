package me.tya.zawkin_writes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.tya.zawkin_writes.entity.PostEntity;

public interface PostRepository extends MongoRepository<PostEntity, String>, PostRepositoryCustom {

}
