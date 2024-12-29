package zawkin.tya.inkspire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zawkin.tya.inkspire.entities.PostEntity;
import zawkin.tya.inkspire.repository.PostRepository;

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