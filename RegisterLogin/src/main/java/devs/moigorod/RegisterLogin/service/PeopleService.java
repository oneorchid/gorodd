package devs.moigorod.RegisterLogin.service;

import devs.moigorod.RegisterLogin.dto.LoginDTO;
import devs.moigorod.RegisterLogin.dto.PersonDto;
import devs.moigorod.RegisterLogin.response.LoginResponse;
import org.springframework.stereotype.Service;


public interface PeopleService {
    public String addPerson(PersonDto personDto);

    LoginResponse loginPerson(LoginDTO loginDTO);
}
