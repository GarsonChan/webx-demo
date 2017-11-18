package webx.engine.util.redis;

import java.io.Serializable;

/**
 * Created by Garson in 15:38 2017/11/18
 * Description : 测试redis存储pojo对象的类
 */
public class Role implements Serializable {

	int id;
	String name;

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
