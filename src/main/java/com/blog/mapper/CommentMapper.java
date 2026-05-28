package com.blog.mapper;

import com.blog.dto.CommentDto;
import com.blog.entity.Comment;

public class CommentMapper {

    public static Comment mapToComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        return comment;
    }

    public static CommentDto mapToCommentDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setCreatedAt(comment.getCreatedAt());
        if(comment.getUser()!=null){
            commentDto.setAuthorName(comment.getUser().getName());
            commentDto.setPostId(comment.getPost().getId());
        }
        return commentDto;
    }
}
