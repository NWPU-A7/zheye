package a7.zheye.controller;

import a7.zheye.dao.UserRepository;
import a7.zheye.dao.UserTypeRepository;
import a7.zheye.pojo.Result;
import a7.zheye.pojo.User;
import a7.zheye.pojo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/register")
    public ModelAndView registerForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register.html");
        return mv;
    }

    /**
     * 处理用户注册
     * @param userForm 前端传来的表单用户信息
     * @return 注册后重定向到login页面
     */
    @PostMapping("/register.do")
    public Result processRegistraion(@RequestBody UserForm userForm){
        // 将表单用户信息转换为User实体，并且加密，再存储到数据库
        try{
            if(userRepository.existsByUsername(userForm.getUsername())){
                return Result.error("用户名已存在，注册失败");
            }
            User user=userForm.toUser(passwordEncoder);
            user.setType(userTypeRepository.findByUserTypeName("USER"));
            userRepository.save(user);
            return Result.ok("注册成功");
        }catch (Exception e){
            return Result.error("注册失败--"+e.getMessage());
        }

    }
}
