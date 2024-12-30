package zawkin.tya.inkspire.mapper;

import org.mapstruct.Mapper;
import zawkin.tya.inkspire.dto.PostDTO;
import zawkin.tya.inkspire.entities.PostEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO toDTO(PostEntity entity);

    PostEntity toEntity(PostDTO dto);

    List<PostDTO> toDTOList(List<PostEntity> entities);

    List<PostEntity> toEntityList(List<PostDTO> dtos);
}
