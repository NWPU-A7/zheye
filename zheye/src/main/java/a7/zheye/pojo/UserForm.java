package a7.zheye.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 表单用户类
 */
public class UserForm {
    private String username;
    private String password;
    private String phone;
    @Autowired
    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username,passwordEncoder.encode(password),phone);
    }

    public UserForm(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public UserForm(){

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
