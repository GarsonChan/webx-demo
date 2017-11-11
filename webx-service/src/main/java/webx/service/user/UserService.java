package webx.service.user;

import webx.engine.base.BaseDao;
import webx.po.User;

import java.util.Set;

/**
 * Created by Garson in 19:03 2017/11/10
 * Description :
 */
public interface UserService extends BaseDao<User> {

	User selectByName(String userName);

	Set<String> getRoles(String userName);

}
