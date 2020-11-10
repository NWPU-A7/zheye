package a7.zheye.pojo;


import javax.persistence.*;

/**
 * 用户类型实体类
 */
@Entity
@Table(name="usertype")
public class UserType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userTypeID;
    @Column(unique = true)
    private String userTypeName;
    public UserType (String userTypeName){
        this.userTypeName=userTypeName;
    }
    public UserType(){}

    public Long getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(Long userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
