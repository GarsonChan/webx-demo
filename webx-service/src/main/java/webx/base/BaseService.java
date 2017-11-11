package webx.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Garson in 18:56 2017/11/10
 * Description :
 */
public interface BaseService<T> {

	int insert(T t);

	int deleteById(Long id);

	int update(T t);

	List<T> select(T t);

	T selectOneById(Long id);

	List<T> selectPage(@Param("t") T t);

	int getTotal(T t);

}
