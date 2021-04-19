package com.zql.dao;

import com.zql.bean.Emp;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface EmpDao {
    @Select("select * from emp")
    List<Emp> selectAllEmp();

    List<Emp> selectAll();

    List<Emp> selectOne(Integer deptNo);
}
