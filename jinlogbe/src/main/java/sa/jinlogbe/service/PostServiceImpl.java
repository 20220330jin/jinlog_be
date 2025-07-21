package sa.jinlogbe.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sa.jinlogbe.model.PostDto;
import sa.jinlogbe.repository.PostRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void createPost(PostDto.createPostRequest createPostRequest) {
        postRepository.createPost(createPostRequest);
    }
}
