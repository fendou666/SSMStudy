package ls.dao;

import java.util.List;
import java.util.Map;

import ls.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    void selectByTest(Map<String, Object> parms);
    void selectByTest2(Map<String, Object> parms);
    
    List<Student> selectByFuncTest(Map<String, Object> parms);
    List<Student> selectByFuncTest2(Map<String, Object> parms);
}