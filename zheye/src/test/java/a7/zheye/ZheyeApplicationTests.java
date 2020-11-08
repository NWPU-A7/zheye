package a7.zheye;

import a7.zheye.dao.UserRepository;
import a7.zheye.dao.UserTypeRepository;
import a7.zheye.pojo.User;
import a7.zheye.pojo.UserForm;
import a7.zheye.pojo.UserType;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest(classes = ZheyeApplication.class)
@RunWith(SpringRunner.class)
class ZheyeApplicationTests {
    PasswordEncoder passwordEncoder;
    UserRepository us;
    UserTypeRepository utr;
    @Autowired
    public ZheyeApplicationTests(PasswordEncoder passwordEncoder,UserRepository userRepository,UserTypeRepository userTypeRepository){
        this.us = userRepository;
        this.utr = userTypeRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Test
    void contextLoads() {
        UserType type= utr.findByUserTypeName("USER");
        UserForm userForm=new UserForm("2121","222222","18558976782");
        User user=userForm.toUser(passwordEncoder);
        user.setType(type);
        us.save(user);

    }

}
