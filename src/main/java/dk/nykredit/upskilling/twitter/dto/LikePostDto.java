package dk.nykredit.upskilling.twitter.dto;


public class LikePostDto {

    private String userId;

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "LikePostDto{" +
            "userId='" + userId + '\'' +
            '}';
    }
}
