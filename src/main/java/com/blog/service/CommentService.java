package com.blog.service;

import com.blog.dto.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long userId, Long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPost(Long postId);
    void deleteComment(Long commentId);
}
