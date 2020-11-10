package a7.zheye.pojo;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * 用户实体类
 */
@Entity
@DynamicInsert
@Table(name="user")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "username",unique = true)
    @Size(min=3)
    private String username;

    @NotNull
    @Size(min=6)
    @Column(name = "password")
    private String password;

    @Pattern(regexp = "^(.+)@(.+)$",message = "邮箱的格式不合法")
    @Column(name = "mail")
    private String mail;

    @Column(name = "head")
    private String head;

    @NotNull
    @Size(min=11,max=11,message = "请输入11位有效手机号")
    @Column(name = "phone")
    private String phone;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "registertime")
    private Date registertime; // 注册时间

    @Column(name = "userstatement")
    private String userStatement; // 用户个人说明

    @ManyToOne(optional = false)
    @JoinColumn(name = "userTypeID")
    private UserType type;
    public User(String username,String password,String phone){
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
    public User(){

    }
    @PrePersist
    void set(){
        this.registertime = new Date();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(getType().getUserTypeName()));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getUserStatement() {
        return userStatement;
    }

    public void setUserStatement(String userStatement) {
        this.userStatement = userStatement;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
