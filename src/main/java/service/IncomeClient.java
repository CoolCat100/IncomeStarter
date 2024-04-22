package service;

import lombok.AllArgsConstructor;
import org.example.config.StarterIncomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import dto.UserDto;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class IncomeClient {
    private final StarterIncomeProperties properties;
    private final RestTemplate restTemplate;


    public long getUserIncome(long id) {
        System.out.println("URL = " + properties.getPath());
        List<UserDto> users = getUsersDto();
        for (UserDto user : users) {
            if (user.getId() == id) {
                return user.getIncome();
            }
        }
        return 0;
    }

    private List<UserDto> getUsersDto() {
        String url = properties.getPath();
        return List.of(restTemplate.getForObject(url, UserDto[].class));
    }
}
