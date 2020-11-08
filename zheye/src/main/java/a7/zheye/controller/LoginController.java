package a7.zheye.controller;

import a7.zheye.pojo.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    @GetMapping("/")
    public String home(){ return "login.html";}
}

