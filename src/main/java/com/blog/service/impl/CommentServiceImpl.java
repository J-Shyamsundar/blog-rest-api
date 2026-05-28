package com.blog.service.impl;

import com.blog.dto.CommentDto;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.CommentNotFoundException;
import com.blog.exception.PostNotFoundException;
import com.blog.mapper.CommentMapper;
import com.blog.repo.CommentRepo;
import com.blog.repo.PostRepo;
import com.blog.repo.UserRepo;
import com.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final CommentRepo commentRepo;

    @Override
    public CommentDto createComment(Long userId, Long postId, CommentDto commentDto) {
        Comment comment = CommentMapper.mapToComment(commentDto);
        User user = userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("User not found"));
        Post post = postRepo.findById(postId).orElseThrow(()->
                new PostNotFoundException("Post not found"));
        comment.setUser(user);
        comment.setPost(post);
        Comment saved = commentRepo.save(comment);
        return CommentMapper.mapToCommentDto(saved);
    }

    @Override
    public List<CommentDto> getCommentsByPost(Long postId) {
        List<Comment> comments = commentRepo.findByPostId(postId);
        return comments.stream().map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow(()->
                new CommentNotFoundException("Comment not found"));
        commentRepo.delete(comment);
    }
}
