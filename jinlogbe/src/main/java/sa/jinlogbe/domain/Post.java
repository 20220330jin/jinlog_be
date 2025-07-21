package sa.jinlogbe.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import sa.jinlogbe.model.PostDto;

import java.util.function.Supplier;

/**
 * 블로그 글 관련 Entity
 *
 * @author hjkim
 */
@Entity
@Table(name = "posts")
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column
    private String summary;

    private String imageUrl;

    private String readTime;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer viewCount = 0;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer likeCount = 0;

    public Post(PostDto.createPostRequest createPostRequest){
        this.title = createPostRequest.getTitle();
        this.summary = createPostRequest.getSummary();
        this.content = createPostRequest.getContent();
        this.imageUrl = createPostRequest.getImageUrl();
    }

    public static Supplier<Post> create(PostDto.createPostRequest createPostRequest) {
        return () -> new Post(createPostRequest);
    }

}
