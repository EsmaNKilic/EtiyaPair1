package com.etiya.ecommercedemopair1.ropositories.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.CommentReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentReplyDao extends JpaRepository<CommentReply, Integer> {
    @Query("from CommentReply where account=:accountId")
    List<CommentReply> getCommentReplyByAccountId(int accountId);

}
