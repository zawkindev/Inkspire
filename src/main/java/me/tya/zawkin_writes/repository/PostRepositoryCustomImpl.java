package me.tya.zawkin_writes.repository;

import me.tya.zawkin_writes.entity.PostEntity;
import me.tya.zawkin_writes.exception.InvalidDateException;
import me.tya.zawkin_writes.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PostMapper mapper;

    @Override
    public List<PostEntity> filterPosts(String title, String content, String tag, String startDate, String endDate) {
        Criteria criteria = new Criteria();
        if (title != null) {
            criteria.and("title").regex(".*" + title + ".*", "i");
        }
        if (content != null) {
            criteria.and("content").regex(".*" + content + ".*", "i");
        }
        if (tag != null) {
            criteria.and("tags").is(tag);
        }
        if (startDate != null && endDate != null) {
            try {
                LocalDateTime startDateTime = LocalDate.parse(startDate).atTime(LocalTime.MIN);
                LocalDateTime endDateTime = LocalDate.parse(endDate).atTime(LocalTime.MAX);
                criteria.and("createdDate").gte(startDateTime).lte(endDateTime);
            } catch (DateTimeException e) {
                throw new InvalidDateException("The date format is invalid. Please use the format yyyy-MM-dd (e.g., 2025-01-02).");
            }
        }

        Query query = new Query(criteria);
        return mongoTemplate.find(query, PostEntity.class);
    }
}
