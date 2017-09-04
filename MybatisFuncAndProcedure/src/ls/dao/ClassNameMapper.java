package ls.dao;

import ls.model.ClassName;

public interface ClassNameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassName record);

    int insertSelective(ClassName record);

    ClassName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassName record);

    int updateByPrimaryKey(ClassName record);
}