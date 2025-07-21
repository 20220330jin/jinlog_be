package sa.jinlogbe.model;

import lombok.Getter;

public class PostDto {

    @Getter
    public static class createPostRequest {
        private String title;
        private String summary;
        private String content;
        private String imageUrl;
    }

}
