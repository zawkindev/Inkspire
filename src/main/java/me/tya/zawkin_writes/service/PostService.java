package me.tya.zawkin_writes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import me.tya.zawkin_writes.exception.AnyException;
import me.tya.zawkin_writes.exception.NotSameIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.tya.zawkin_writes.dto.PostDTO;
import me.tya.zawkin_writes.entity.PostEntity;
import me.tya.zawkin_writes.mapper.PostMapper;
import me.tya.zawkin_writes.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    @Autowired
    private PostMapper mapper;

    public List<PostDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public PostDTO save(PostDTO dto) {
        PostEntity entity = mapper.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        repository.save(entity);

        return mapper.toDTO(entity);
    }

    public PostDTO update(String postId, PostDTO dto) {
        if (dto.id() != null && !Objects.equals(postId, dto.id())) {
            throw new NotSameIdException("Post IDs in the url and json are not same");
        }
        repository.findById(postId).orElseThrow(() -> new AnyException("Post with ID: " + postId + " Not Found"));

        PostEntity entity = mapper.toEntity(dto);
        repository.save(entity);

        return mapper.toDTO(entity);
    }

    public boolean delete(String postId) {
        PostEntity entity = repository.findById(postId).orElseThrow(() -> new AnyException("Post with ID: " + postId + " Not found"));
        repository.delete(entity);

        return repository.findById(postId).isEmpty();
    }

    public List<PostDTO> filter(String title, String content, String tag, String startDate, String endDate) {
        return mapper.toDTOList(repository.filterPosts(title, content, tag, startDate, endDate));
    }
}
