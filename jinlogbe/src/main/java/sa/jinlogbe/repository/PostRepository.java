package sa.jinlogbe.repository;

import sa.jinlogbe.model.PostDto;

/**
 * 블로그 글 관련 Repository
 *
 * @author hjkim
 */
public interface PostRepository {
    /**
     * 블로그 글 작성
     * @param createPostRequest
     */
    void createPost(PostDto.createPostRequest createPostRequest);
}
