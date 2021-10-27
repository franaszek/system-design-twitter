package dk.nykredit.upskilling.twitter.service;

import java.util.UUID;

import dk.nykredit.upskilling.twitter.dto.UserDto;
import dk.nykredit.upskilling.twitter.repository.UserRepository;
import dk.nykredit.upskilling.twitter.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(UserDto userDto) {
        User user = User.Builder.anUser()
            .withName(userDto.getName())
            .withAvatar(userDto.getPicture())
            .withPassword(userDto.getPassword())
            .build();
        userRepository.save(user);
        return user.getId();
    }
}
