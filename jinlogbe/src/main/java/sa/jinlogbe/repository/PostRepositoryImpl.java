package sa.jinlogbe.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import sa.jinlogbe.domain.Post;
import sa.jinlogbe.domain.QPost;
import sa.jinlogbe.model.PostDto;

@Repository
public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepository {
    private final JPAQueryFactory jpaQueryFactory;
    public PostRepositoryImpl(EntityManager entityManager) {
        super(Post.class);
        setEntityManager(entityManager);
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public void createPost(PostDto.createPostRequest createPostRequest) {
        final EntityManager entityManager = super.getEntityManager();
        Post post = Post.create(createPostRequest).get();
        entityManager.persist(post);
    }
}
