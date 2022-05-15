package com.soj.dao;

import com.soj.entity.Submission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubmissionMapper {

    @Insert("insert into submission(id, user_id, problem_id) VALUES (#{id}, #{userId}, #{problemId})")
    int addSubmission(Submission submission);

    @Delete("delete from submission where id = #{id}")
    int deleteSubmission(int id);

    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "problem_id", property = "problemId")
    })
    @Select("select * from submission where user_id = #{userId}")
    List<Submission> getSubmissionByUserId(int userId);

    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "problem_id", property = "problemId")
    })
    @Select("select * from submission where problem_id = #{problemId}")
    List<Submission> getSubmissionByProblemId(int problemId);

    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "problem_id", property = "problemId")
    })
    @Select("select * from submission")
    List<Submission> getSubmissions();
}
