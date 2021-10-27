package dk.nykredit.upskilling.twitter;

import javax.validation.Valid;

import dk.nykredit.upskilling.twitter.dto.LoginDto;
import dk.nykredit.upskilling.twitter.dto.UserDto;
import dk.nykredit.upskilling.twitter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user")
    @ResponseBody
    public String createUser(@Valid @RequestBody UserDto userDto) {
        logger.info("create user {}", userDto);
        return userService.createUser(userDto);
    }

    @PostMapping("/api/auth")
    @ResponseBody
    public String login(@RequestBody LoginDto loginDto) {
        logger.info("login {}", loginDto);
        return loginDto.getName();
    }
}
