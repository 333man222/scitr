package user.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis의 환경 설정 읽고 객체 생성
 */
public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory;

	// Static 블럭 : 객체가 호출되면 자동으로 불러짐 ,,초기화 할 때 주로 사용! 생성자보다 먼저 불러짐
	static {
		String resource = "mybatis-config.xml";		//Mybatis 환경설정 파일 읽기. src 경로에 저장.
		

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
