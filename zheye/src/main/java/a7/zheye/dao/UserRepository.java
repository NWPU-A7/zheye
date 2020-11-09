package a7.zheye.dao;

import a7.zheye.pojo.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}
