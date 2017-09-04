package ls.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
//	=======================存储过程测试=========================
	@Test
	public void testProcedure(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("V_stuid", 5L);
		param.put("V_inoutT", 1); // inout参数只需要赋值in就可以
		/*param.put("stu_cursor", );*/ // 如果是out参数不许要赋值
		
		ops.selectOne("ls.dao.StudentMapper.selectByTest", param);
		// param.get("stu_cursor") 是out参数
		//System.out.println("存储过程 out cursor是" + param.get("stu_cursor"));
		for (Student stu: (List<Student>)param.get("stu_cursor")){
			System.out.println(stu);
		}
		// in out 参数获取
		System.out.println(param.get("V_inoutT"));
	}
	
	@Test
	public void testProcedure2(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("V_stuid", 5L);
		param.put("V_inoutT", 1); // inout参数只需要赋值in就可以
		/*param.put("stu_cursor", );*/ // 如果是out参数不许要赋值
		
		ops.selectOne("ls.dao.StudentMapper.selectByTest2", param);
		// param.get("stu_cursor") 是out参数
		//System.out.println("存储过程 out cursor是" + param.get("stu_cursor"));
		for (Student stu: (List<Student>)param.get("stu_cursor")){
			System.out.println(stu);
		}
		// in out 参数获取
		System.out.println(param.get("V_inoutT"));
	}
	
//	========================函数测试===========================
	@Test
	public void testFunc1(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("V_stuid", 5L);
		param.put("V_inoutT", 1); // inout参数只需要赋值in就可以
		ops.selectOne("ls.dao.StudentMapper.selectByFuncTest", param);
		// param.get("result") 是返回值
//		System.out.println("存储过程 out cursor是" + param.get("result"));
		for (Student stu: (List<Student>)param.get("result")){
			System.out.println(stu);
		}
		// in out 参数获取	
		System.out.println(param.get("V_inoutT"));
		
		// out 参数获取	
		System.out.println(param.get("V_outT"));
	}
	
	@Test
	public void testFunc2(){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("V_stuid", 5L);
		param.put("V_inoutT", 1); // inout参数只需要赋值in就可以
		ops.selectOne("ls.dao.StudentMapper.selectByFuncTest2", param);
		// param.get("result") 是返回值
//		System.out.println("存储过程 out cursor是" + param.get("result"));
		for (Student stu: (List<Student>)param.get("result")){
			System.out.println(stu);
		}
		// in out 参数获取	
		System.out.println(param.get("V_inoutT"));
		
		// out 参数获取	
		System.out.println(param.get("V_outT"));
	}
}
