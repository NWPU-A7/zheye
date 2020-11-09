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

    /**
     * 处理用户注册
     * @param userForm 前端传来的表单用户信息
     * @return 注册后重定向到login页面
     */
    @PostMapping
    public String processRegistraion( UserForm userForm){
        // 将表单用户信息转换为User实体，并且加密，再存储到数据库
        User user=userForm.toUser(passwordEncoder);
        user.setType(userTypeRepository.findByUserTypeName("USER"));
        userRepository.save(user);
        return "redirect:/login";
    }
}
