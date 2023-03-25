package devs.moigorod.RegisterLogin.service.impl;

import devs.moigorod.RegisterLogin.dto.LoginDTO;
import devs.moigorod.RegisterLogin.dto.PersonDto;
import devs.moigorod.RegisterLogin.entity.Person;
import devs.moigorod.RegisterLogin.repo.PeopleRepository;
import devs.moigorod.RegisterLogin.response.LoginResponse;
import devs.moigorod.RegisterLogin.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleImpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addPerson(PersonDto personDto) {
        Person person = new Person(personDto.getUsername(),
                personDto.getEmail(),
                this.passwordEncoder.encode(personDto.getPassword()),
                personDto.getPhoneNumber()
        );
        peopleRepository.save(person);
        return person.getUsername();
    }

    @Override
    public LoginResponse loginPerson(LoginDTO loginDTO) {
        String msg = "";
        Person person1 = peopleRepository.findByEmail(loginDTO.getEmail());
        if (person1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = person1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Person> person = peopleRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (person.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }

    }
}
