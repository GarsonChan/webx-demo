package webx.engine.dao;

import org.springframework.stereotype.Repository;
import webx.engine.base.BaseDao;
import webx.po.User;

import java.util.Set;

/**
 * Created by Garson in 14:03 2017/11/10
 * Description :
 */
@Repository("userDao")
public interface UserDao extends BaseDao<User> {

	User selectByName(String userName);

	Set<String> getRoles(String userName);

}
