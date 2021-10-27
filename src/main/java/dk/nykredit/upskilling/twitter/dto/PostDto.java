package dk.nykredit.upskilling.twitter.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostDto {

    private String title;

    private String description;

    private String picture;

    private LocalDateTime createdAt;

    private String userId;


    public static final class Builder {
        private String title;
        private String description;
        private String picture;
        private LocalDateTime createdAt;
        private String userId;

        private Builder() {
        }

        public static Builder aPostDto() {
            return new Builder();
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPicture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public PostDto build() {
            PostDto postDto = new PostDto();
            postDto.description = this.description;
            postDto.userId = this.userId;
            postDto.picture = this.picture;
            postDto.title = this.title;
            postDto.createdAt = this.createdAt;
            return postDto;
        }
    }
}
