package com.etiya.ecommercedemopair1.dataAccess.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.CommentReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentReplyDao extends JpaRepository<CommentReply, Integer> {
}
