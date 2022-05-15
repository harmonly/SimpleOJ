package com.soj.service;

import com.soj.entity.Problem;

import java.util.List;

public interface ProblemService {

    int addProblem(Problem problem);

    int deleteProblem(int id);

    Problem getProblem(int id);

    List<Problem> getProblems();
}
