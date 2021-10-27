package dk.nykredit.upskilling.twitter;

import java.util.List;

import dk.nykredit.upskilling.twitter.dto.CreatePostDto;
import dk.nykredit.upskilling.twitter.dto.LikePostDto;
import dk.nykredit.upskilling.twitter.dto.PostDto;
import dk.nykredit.upskilling.twitter.dto.SharePostDto;
import dk.nykredit.upskilling.twitter.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/post/favourite")
    public List<PostDto> listFavourite(@RequestParam long limit) {
        logger.info("listFavourite with limit {}", limit);
        return postService.listFavourite(limit);
    }

    @GetMapping("/api/post/user/{userId}")
    public List<PostDto> listUserPosts(@PathVariable String userId, @RequestParam int limit, @RequestParam int offset) {
        logger.info("listFavourite with limit {}", limit);
        return postService.listUserPosts(userId, limit, offset);
    }

    @PostMapping("/api/post/{postId}/like")
    public String likePost(@PathVariable String postId, @RequestBody LikePostDto likePostDto) {
        logger.info("likePost with postId {}, userID {} ", postId, likePostDto.getUserId());
        return postService.likePost(postId, likePostDto.getUserId());
    }

    @PostMapping("/api/post")
    public String createPost(@RequestBody CreatePostDto createPostDto) {
        logger.info("createPost {}", createPostDto);
        return postService.createPost(createPostDto);
    }

    @PostMapping("/api/post/{postId}/share")
    public String sharePost(@PathVariable String postId, @RequestBody SharePostDto sharePostDto) {
        logger.info("sharePost with postId {}", postId);
        return postService.sharePost(postId, sharePostDto);
    }
}
