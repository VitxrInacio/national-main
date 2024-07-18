package configuration.national;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/users")
    public String users() {
        return "Usuário autorizado";
    }

    @GetMapping("/manager")
    public String managers() {
        return "Gerente autorizado";
    }
}
