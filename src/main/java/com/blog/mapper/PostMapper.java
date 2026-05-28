package com.blog.mapper;

import com.blog.dto.PostDto;
import com.blog.entity.Post;

public class PostMapper {

    public static Post mapToPost(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCreatedAt(postDto.getCreatedAt());
        return post;
    }

    public static PostDto mapToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setCreatedAt(post.getCreatedAt());
        if(post.getUser()!=null){
            postDto.setAuthorId(post.getUser().getId());
            postDto.setAuthorName(post.getUser().getName());
        }
        return postDto;
    }
}
