package zawkin.maftuna.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zawkin.maftuna.blog.entities.PostEntity;
import zawkin.maftuna.blog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping({"", "/"})
    public PostEntity createStudent(@RequestBody PostEntity student) {
        return postService.saveStudent(student);
    };

    @GetMapping({"", "/"})
    public List<PostEntity> getAllStudents() {
        return postService.getAllStudents();
    }
}

