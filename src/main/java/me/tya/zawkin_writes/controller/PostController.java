package me.tya.zawkin_writes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.tya.zawkin_writes.dto.PostDTO;
import me.tya.zawkin_writes.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping({"", "/"})
    private ResponseEntity<List<PostDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/filter")
    private ResponseEntity<List<PostDTO>> filter(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        return ResponseEntity.ok(service.filter(title, content, tag, startDate, endDate));
    }

    @PostMapping({"", "/"})
    private ResponseEntity<PostDTO> save(@RequestBody PostDTO post) {
        return ResponseEntity.ok(service.save(post));
    }

    @PutMapping("/{id}")
    private ResponseEntity<PostDTO> update(@PathVariable String postId, @RequestBody PostDTO post) {
        return ResponseEntity.ok(service.update(postId, post));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable String postId) {
        return ResponseEntity.ok(service.delete(postId));
    }
}
