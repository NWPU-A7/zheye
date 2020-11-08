package a7.zheye.dao;

import a7.zheye.pojo.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
public interface UserTypeRepository extends CrudRepository<UserType,Long> {
    UserType findByUserTypeName(String name);
}
