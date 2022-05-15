package com.soj.service;

import com.soj.entity.Submission;

import java.util.List;

public interface SubmissionService {

    int addSubmission(Submission submission);

    int deleteSubmission(int id);

    List<Submission> getSubmissionByUserId(int userId);

    List<Submission> getSubmissionByProblemId(int problemId);

    List<Submission> getSubmissions();
}
