package a7.zheye.controller;

import a7.zheye.dao.UserRepository;
import a7.zheye.dao.UserTypeRepository;
import a7.zheye.pojo.RespBean;
import a7.zheye.pojo.User;
import a7.zheye.pojo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping
    public String registerForm(){
        return "register.html";
    }
    @PostMapping
    public String processRegistraion( UserForm userForm){
        User user=userForm.toUser(passwordEncoder);
        user.setType(userTypeRepository.findByUserTypeName("USER"));
        userRepository.save(user);
        return "redirect:/login";
    }
}
