package zawkin.maftuna.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zawkin.maftuna.blog.entities.PostEntity;
import zawkin.maftuna.blog.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostEntity saveStudent(PostEntity student) {
        return postRepository.save(student);
    }

    public List<PostEntity> getAllStudents() {
        return postRepository.findAll();
    }
}