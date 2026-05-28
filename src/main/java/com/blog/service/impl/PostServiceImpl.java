package com.blog.service.impl;

import com.blog.dto.PostDto;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.PostNotFoundException;
import com.blog.mapper.PostMapper;
import com.blog.repo.PostRepo;
import com.blog.repo.UserRepo;
import com.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @Override
    public PostDto createPost(Long userId, PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);
        User user = userRepo.findById(userId).orElseThrow(()->
                new RuntimeException("User not found"));
        post.setUser(user);
        Post saved = postRepo.save(post);
        return PostMapper.mapToPostDto(saved);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepo.findById(id).orElseThrow(()->
                new PostNotFoundException("Post not found"));
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepo.findById(id).orElseThrow(()->
                new PostNotFoundException("Post not found"));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post saved = postRepo.save(post);
        return PostMapper.mapToPostDto(saved);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(()->
                new PostNotFoundException("Post not found"));
        postRepo.delete(post);
    }
}
