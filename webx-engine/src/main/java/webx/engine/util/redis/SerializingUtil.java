package webx.engine.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Garson in 10:02 2017/11/18
 * Description : 为了将javabean存储进redis中，需要将其序列化存入再反序列化取出，再没有加入spring-data-redis前要先进行序列化操作，该工具类
 * 				 为序列化操作的类，前提是需要将要序列化的javabean先标记为可序列化的，即implements Serializable
 */
public class SerializingUtil{

	private static Logger logger = LoggerFactory.getLogger(SerializingUtil.class);

	/**
	 * 对pojo类对象进行序列化，转换为二进制数据，以便存进redis中
	 * @param source pojo类对象
	 * @return pojo类对象的二进制数据
	 */
	public static byte[] serialize(Object source){
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(source);
			objectOutputStream.flush();
			logger.info(source.getClass().getName()+"序列化中");
		} catch (IOException e) {
			logger.error(source.getClass().getName() + "序列化失败 " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return byteArrayOutputStream.toByteArray();
	}

	/**
	 * 对从redis中获取的pojo对象的二进制数据进行反序列化，获得Object对象
	 * @param source pojo对象的二进制数据
	 * @return object对象
	 */
	public static Object deserialize(byte[] source){
		ObjectInputStream objectInputStream = null;
		Object object = null;
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source);
			objectInputStream = new ObjectInputStream(byteArrayInputStream);
			object = objectInputStream.readObject();
			logger.info("反序列化中");
		} catch (Exception e) {
			logger.error("反序列化失败 " + e.getMessage());
			e.printStackTrace();
		} finally {
			try{
				if(objectInputStream != null){
					objectInputStream.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return object;
	}

}
