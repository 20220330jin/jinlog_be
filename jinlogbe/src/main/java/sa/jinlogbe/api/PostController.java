package sa.jinlogbe.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sa.jinlogbe.model.PostDto;
import sa.jinlogbe.service.PostService;

/**
 * 블로그 글 관련 APIs
 *
 * @author hjkim
 */
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PostController {

    private final PostService postService;

    @GetMapping("/getPosts")
    public void getPosts() {}

    /**
     * 블로그 글 작성 api
     * @param createPostRequest
     * @return
     */
    @PostMapping("/createPost")
    public ResponseEntity<Void> createPost(@RequestBody PostDto.createPostRequest createPostRequest) {
        postService.createPost(createPostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
