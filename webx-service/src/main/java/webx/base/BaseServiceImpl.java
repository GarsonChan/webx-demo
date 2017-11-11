package webx.base;

import webx.engine.base.BaseDao;

import java.util.List;

/**
 * Created by Garson in 18:59 2017/11/10
 * Description :
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	protected abstract BaseDao<T> getDao();

	@Override
	public int insert(T t) {
		return getDao().insert(t);
	}

	@Override
	public int deleteById(Long id) {
		return getDao().deleteById(id);
	}

	@Override
	public int update(T t) {
		return getDao().update(t);
	}

	@Override
	public List<T> select(T t) {
		return getDao().select(t);
	}

	@Override
	public T selectOneById(Long id) {
		return getDao().selectOneById(id);
	}

	@Override
	public List<T> selectPage(T t) {
		return getDao().selectPage(t);
	}

	@Override
	public int getTotal(T t) {
		return getDao().getTotal(t);
	}
}
