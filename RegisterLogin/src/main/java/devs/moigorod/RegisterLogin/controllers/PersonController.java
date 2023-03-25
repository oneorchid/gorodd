package devs.moigorod.RegisterLogin.controllers;

import devs.moigorod.RegisterLogin.dto.LoginDTO;
import devs.moigorod.RegisterLogin.dto.PersonDto;
import devs.moigorod.RegisterLogin.response.LoginResponse;
import devs.moigorod.RegisterLogin.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
@CrossOrigin
public class PersonController {
     @Autowired
    private PeopleService peopleService;


    @PostMapping("/register")

        public String registerPerson(@RequestBody PersonDto personDto){
        String name= peopleService.addPerson(personDto);
        return name;
    }

    @PostMapping(path = "/login")

    public ResponseEntity<?> loginPerson (@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = peopleService.loginPerson(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
