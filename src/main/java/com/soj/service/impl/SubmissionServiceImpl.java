package com.soj.service.impl;

import com.soj.dao.SubmissionMapper;
import com.soj.entity.Submission;
import com.soj.service.SubmissionService;
import com.soj.utils.MybatisUtil;
import lombok.Builder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SubmissionServiceImpl implements SubmissionService {

    @Override
    public int addSubmission(Submission submission) {
        try (SqlSession session = MybatisUtil.openSession()) {
            SubmissionMapper mapper = session.getMapper(SubmissionMapper.class);
            return mapper.addSubmission(submission);
        }
    }

    @Override
    public int deleteSubmission(int id) {
        try (SqlSession session = MybatisUtil.openSession()) {
            SubmissionMapper mapper = session.getMapper(SubmissionMapper.class);
            return mapper.deleteSubmission(id);
        }
    }

    @Override
    public List<Submission> getSubmissionByUserId(int userId) {
        try (SqlSession session = MybatisUtil.openSession()) {
            SubmissionMapper mapper = session.getMapper(SubmissionMapper.class);
            return mapper.getSubmissionByUserId(userId);
        }
    }

    @Override
    public List<Submission> getSubmissionByProblemId(int problemId) {
        try (SqlSession session = MybatisUtil.openSession()) {
            SubmissionMapper mapper = session.getMapper(SubmissionMapper.class);
            return mapper.getSubmissionByProblemId(problemId);
        }
    }

    @Override
    public List<Submission> getSubmissions() {
        try (SqlSession session = MybatisUtil.openSession()) {
            SubmissionMapper mapper = session.getMapper(SubmissionMapper.class);
            return mapper.getSubmissions();
        }
    }
}
