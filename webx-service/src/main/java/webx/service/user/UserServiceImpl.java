package webx.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import webx.base.BaseServiceImpl;
import webx.engine.base.BaseDao;
import webx.engine.dao.UserDao;
import webx.po.User;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Garson in 19:10 2017/11/10
 * Description :
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public User selectByName(String userName) {
		return userDao.selectByName(userName);
	}

	@Override
	public Set<String> getRoles(String userName) {
		return userDao.getRoles(userName);
	}

	@Override
	protected BaseDao<User> getDao() {
		return userDao;
	}
}
