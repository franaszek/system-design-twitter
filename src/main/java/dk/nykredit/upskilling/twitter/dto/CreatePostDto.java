package dk.nykredit.upskilling.twitter.dto;

public class CreatePostDto {

    private String title;
    private String description;
    private String picture;
    private String userId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "CreatePostDto{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", picture='" + picture + '\'' +
            ", userId='" + userId + '\'' +
            '}';
    }
}
