package net.proselyte.springbootdemo.comtroller;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping(value = "/userInfo")
    public String showUserInfo(ModelMap modelMap, Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        modelMap.addAttribute("user", user);

        return "userinfo";

    }
}