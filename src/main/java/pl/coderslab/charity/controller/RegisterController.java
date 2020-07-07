package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.user.RegisterUserDTO;
import pl.coderslab.charity.service.RegisterService;
import pl.coderslab.charity.service.UserService;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public String register(){
        return "/register";
    }

    @PostMapping
    public String registerAction(@RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String password2){
        log.info("Dane do rejestracji: {} {} {}", email, password, password2);

        RegisterUserDTO registerUserDTO = new RegisterUserDTO(email,password,password2);
        registerService.saveUser(registerUserDTO);
        return "redirect:/donation/create";
    }
}
