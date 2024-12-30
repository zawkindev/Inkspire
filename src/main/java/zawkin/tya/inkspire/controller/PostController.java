package zawkin.tya.inkspire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zawkin.tya.inkspire.dto.PostDTO;
import zawkin.tya.inkspire.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping({"", "/"})
    public PostDTO createPost(@RequestBody PostDTO post) {
        return postService.savePost(post);
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }
}

