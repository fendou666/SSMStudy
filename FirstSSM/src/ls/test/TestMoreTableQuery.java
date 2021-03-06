package ls.test;

import java.io.IOException;
import java.io.InputStream;

import jdk.nashorn.internal.ir.annotations.Ignore;
import ls.dao.StudentMapper;
import ls.model.Student;
import ls.service.IStudentService;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMoreTableQuery {
	private SqlSessionFactory sqfc;
	private SqlSession ops;
	@Ignore
	@Before
	public void initFactory(){
		InputStream is;
		try {
//			================== 这里配置如果不是src直接目录， 应该写为src下的目录锁定到对应文件， 注意第一个目录不加/
//			================== 对于这种配置有时候需要加/, 有时候不需要加
			is = Resources.getResourceAsStream("config/mybatic/configuration.xml");
			sqfc = new SqlSessionFactoryBuilder().build(is);
			ops = sqfc.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testMybatisENV(){
		Student stu  = ops.selectOne("ls.dao.StudentMapper.selectByPrimaryKey", 5L);
		System.out.println("学生姓名:" + stu.getName());
	}
	
	@Test
	public void testSpring(){
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("/config/spring/AC.xml");
		System.out.println("cp:" + cp);
		Student stu = cp.getBean("stu", Student.class);
		System.out.println(stu);
	}
	
	@Test
	public void testSpringAndMybatisDAO(){
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("/config/spring/SpringAndMybatisAC.xml");
		StudentMapper stuMap = cp.getBean("stuMapperDAO", StudentMapper.class);
		Student stu = stuMap.selectByPrimaryKey(3L);
		System.out.println(stu.getName());
	}
	
	@Test
	public void testSpringAndMybatisService(){
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("/config/spring/SpringAndMybatisAC.xml");
		IStudentService stuService = cp.getBean("stuService", IStudentService.class);
		Student stu = stuService.selectByPrimaryKey(3L);
		System.out.println(stu.getName());
	}
	
	@Test
	public void testSSM(){
		
	}
	
	@Test
	public void testConfig(){
		MapperFactoryBean m = new MapperFactoryBean();
		//m.setSqlSessionFactory();
	}
	
}
