package a7.zheye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 表单用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String username;
    private String password;
    private String phone;
    @Autowired
    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username,passwordEncoder.encode(password),phone);
    }
}
