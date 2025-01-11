package me.tya.zawkin_writes.mapper;

import org.mapstruct.Mapper;

import me.tya.zawkin_writes.dto.PostDTO;
import me.tya.zawkin_writes.entity.PostEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
  PostDTO toDTO(PostEntity entity);

  PostEntity toEntity(PostDTO dto);

  List<PostDTO> toDTOList(List<PostEntity> entities);

  List<PostEntity> toEntityList(List<PostDTO> dtos);
}
