package com.puppiespassion.web;

import ch.qos.logback.core.model.Model;
import com.puppiespassion.model.dto.UserLoginDTO;
import com.puppiespassion.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/external-users")
public class UserClientController {

    private final UserClientService userClientService;

    @Autowired
    public UserClientController(UserClientService userClientService) {
        this.userClientService = userClientService;
    }

    @GetMapping
    public List<UserLoginDTO> getAllUsersFromMicroservice() {
        return userClientService.getAllUsers();
    }

    @PostMapping
    public UserLoginDTO createUserInMicroservice(@RequestBody UserLoginDTO userDTO) {
        return userClientService.createUser(userDTO);
    }

    public String getAllUsers(Model model) {
        List<UserLoginDTO> users = userClientService.getAllUsers();
        model.addText("users");
        return "client-users";
    }
}
