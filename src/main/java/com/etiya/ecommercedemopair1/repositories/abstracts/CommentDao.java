package com.etiya.ecommercedemopair1.repositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Integer> {
    @Query("from Comment where likeCount>=:likeCount")
    List<Comment> getCommentByLikeCount(int likeCount);
}
