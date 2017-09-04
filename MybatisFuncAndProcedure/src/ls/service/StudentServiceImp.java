package ls.service;

import java.util.Map;

import ls.dao.StudentMapper;
import ls.model.Student;

public class StudentServiceImp implements IStudentService {
	private StudentMapper stuMap;
	
	public StudentMapper getStuMap() {
		return stuMap;
	}

	public void setStuMap(StudentMapper stuMap) {
		this.stuMap = stuMap;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		return stuMap.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Student record) {
		return stuMap.insert(record);
	}

	@Override
	public int insertSelective(Student record) {
		return stuMap.insertSelective(record);
	}

	@Override
	public Student selectByPrimaryKey(Long id) {
		return stuMap.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return stuMap.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return stuMap.updateByPrimaryKey(record);
	}

	@Override
	public void selectByTest(Map<String, Object> parms) {
		stuMap.selectByTest(parms);
	}

}
