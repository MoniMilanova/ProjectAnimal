package com.puppiespassion.service;

import com.puppiespassion.model.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class UserClientService {

    private final RestTemplate restTemplate;
    private final String USER_SERVICE_URL = "http://localhost:8081"; // user-service работи на порт 8081

    @Autowired
    public UserClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserLoginDTO> getAllUsers() {
        ResponseEntity<UserLoginDTO[]> response = restTemplate.getForEntity(USER_SERVICE_URL + "/users", UserLoginDTO[].class);
        return Arrays.asList(response.getBody());
    }

    public UserLoginDTO createUser(UserLoginDTO userDTO) {
        ResponseEntity<UserLoginDTO> response = restTemplate.postForEntity(USER_SERVICE_URL + "/users", userDTO, UserLoginDTO.class);
        return response.getBody();
    }
}
