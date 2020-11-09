package a7.zheye.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户类型实体类
 */
@Entity
@Table(name="usertype")
@NoArgsConstructor(force=true)
@AllArgsConstructor
@Data
public class UserType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userTypeID;
    @Column(unique = true)
    private String userTypeName;
    public UserType (String userTypeName){
        this.userTypeName=userTypeName;
    }
}
