package dk.nykredit.upskilling.twitter.dto;

public class SharePostDto {

    private String userIdFrom;
    private String userIdTo;

    public String getUserIdFrom() {
        return userIdFrom;
    }

    public String getUserIdTo() {
        return userIdTo;
    }

    @Override
    public String toString() {
        return "SharePostDto{" +
            "userIdFrom='" + userIdFrom + '\'' +
            ", userIdTo='" + userIdTo + '\'' +
            '}';
    }
}
