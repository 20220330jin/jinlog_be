package sa.jinlogbe.service;

import sa.jinlogbe.model.PostDto;

/**
 * 블로그 글 관련 Service
 *
 * @author hjkim
 */
public interface PostService {
    /**
     * 블로그 글 작성
     * @param createPostRequest
     */
    void createPost(PostDto.createPostRequest createPostRequest);
}
