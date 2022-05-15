package com.soj.dao;

import com.soj.entity.Problem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProblemMapper {

    @Insert("insert into problem(id, name, difficulty) VALUES (#{id}, #{name}, #{difficulty})")
    int addProblem(Problem problem);

    @Delete("delete from problem where id = #{id}")
    int deleteProblem(int id);

    @Select("select * from problem where id = #{id}")
    Problem getProblem(int id);

    @Select("select * from problem")
    List<Problem> getProblems();
}
