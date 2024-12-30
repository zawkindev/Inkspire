package zawkin.tya.inkspire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zawkin.tya.inkspire.dto.PostDTO;
import zawkin.tya.inkspire.entities.PostEntity;
import zawkin.tya.inkspire.mapper.PostMapper;
import zawkin.tya.inkspire.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    public PostDTO savePost(PostDTO dto) {
        PostEntity entity = postMapper.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        postRepository.save(entity);

        return postMapper.toDTO(entity);
    }

    public List<PostDTO> getAllPosts() {
        return postMapper.toDTOList(postRepository.findAll());
    }
}