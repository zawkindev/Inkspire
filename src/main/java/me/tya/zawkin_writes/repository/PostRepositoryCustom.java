package me.tya.zawkin_writes.repository;

import me.tya.zawkin_writes.entity.PostEntity;

import java.util.List;

public interface PostRepositoryCustom {
    List<PostEntity> filterPosts(String title, String content, String tag, String startDate, String endDate);
}
