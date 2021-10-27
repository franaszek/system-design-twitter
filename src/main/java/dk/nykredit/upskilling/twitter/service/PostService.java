package dk.nykredit.upskilling.twitter.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dk.nykredit.upskilling.twitter.dto.CreatePostDto;
import dk.nykredit.upskilling.twitter.dto.PostDto;
import dk.nykredit.upskilling.twitter.dto.SharePostDto;
import dk.nykredit.upskilling.twitter.exception.UserNotFoundException;
import dk.nykredit.upskilling.twitter.model.Post;
import dk.nykredit.upskilling.twitter.model.PostLiked;
import dk.nykredit.upskilling.twitter.model.User;
import dk.nykredit.upskilling.twitter.repository.LikePostRepository;
import dk.nykredit.upskilling.twitter.repository.PostRepository;
import dk.nykredit.upskilling.twitter.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikePostRepository likePostRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository,
                       LikePostRepository likePostRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.likePostRepository = likePostRepository;
    }

    public String createPost(CreatePostDto createPostDto) {
        User user = userRepository.findById(createPostDto.getUserId())
            .orElseThrow(() -> new UserNotFoundException(createPostDto.getUserId()));

        Post post = new Post(createPostDto.getTitle(), createPostDto.getDescription(), createPostDto.getPicture(), user);
        postRepository.save(post);
        return post.getId();
    }

    public List<PostDto> listUserPosts(String userId, int limit, int offset) {
        List<Post> posts = postRepository.listPosts(userId, PageRequest.of(offset, limit));
        return posts.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }

    public List<PostDto> listFavourite(long limit) {
        return Collections.emptyList();
    }

    private PostDto map(Post post) {
        return PostDto.Builder.aPostDto()
            .withCreatedAt(post.getCreatedAt())
            .withDescription(post.getDescription())
            .withPicture(post.getPicture())
            .withUserId(post.getCreatedBy().getId())
            .withTitle(post.getTitle())
            .build();

    }

    public String likePost(String postId, String userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));

        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new UserNotFoundException(postId));

        PostLiked postLiked = new PostLiked(user, post);
        likePostRepository.save(postLiked);
        return postId;
    }

    public String sharePost(String postId, SharePostDto sharePostDto) {
        return "string";
    }

}
