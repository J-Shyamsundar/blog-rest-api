package com.blog.service;

import com.blog.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(Long userId, PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(Long id);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
}
