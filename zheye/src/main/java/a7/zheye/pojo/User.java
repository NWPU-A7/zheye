package a7.zheye.pojo;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Data
@NoArgsConstructor(force=true)
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

    @ManyToOne(optional = false,cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "userTypeID")
    private UserType type;
    public User(String username,String password,String phone){
        this.username = username;
        this.password = password;
        this.phone = phone;
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
