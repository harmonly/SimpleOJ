package com.soj.service.impl;

import com.soj.dao.ProblemMapper;
import com.soj.entity.Problem;
import com.soj.service.ProblemService;
import com.soj.utils.FileUtil;
import com.soj.utils.MybatisUtil;
import com.soj.utils.YamlUtil;
import lombok.Builder;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ProblemServiceImpl implements ProblemService {

    /**
     * 用于保存问题信息的本地路径
     * 将 %s 替换为 {@link Problem} id
     */
    private static final String PATH = "D:/all/idea/SimpleOJ/database/problem/%s.yml";

    /**
     * 用于保存问题信息的网络路径
     * 将 %s 替换为 {@link Problem} id
     */
    private static final String URL_PATH = "http://localhost:8080/soj/database/problem/%s.yml";

    @Override
    public int addProblem(Problem problem) {
        try (SqlSession session = MybatisUtil.openSession()) {
            ProblemMapper mapper = session.getMapper(ProblemMapper.class);
            if (mapper.getProblem(problem.getId()) != null) return 0;
            if (problem.getDesc() != null && problem.getExplain() != null &&
                    problem.getInput() != null && problem.getOutput() != null) {
                YamlUtil.create(String.format(PATH, problem.getId()), problem);
                return mapper.addProblem(problem);
            }
        }
        return 0;
    }

    @Override
    public int deleteProblem(int id) {
        try (SqlSession session = MybatisUtil.openSession()) {
            ProblemMapper mapper = session.getMapper(ProblemMapper.class);
            FileUtil.deleteFile(String.format(PATH, id));
            return mapper.deleteProblem(id);
        }
    }

    @Override
    public Problem getProblem(int id) {
        try (SqlSession session = MybatisUtil.openSession()) {
            ProblemMapper mapper = session.getMapper(ProblemMapper.class);
            if (mapper.getProblem(id) != null)
                return YamlUtil.load(new URL(String.format(URL_PATH, id)).openStream(), Problem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从数据库取出基本信息
     * 再从 Resource 取出 {@link Problem} 的所有信息
     */
    @Override
    public List<Problem> getProblems() {
        try (SqlSession session = MybatisUtil.openSession()) {
            ProblemMapper mapper = session.getMapper(ProblemMapper.class);
            List<Problem> problems = mapper.getProblems();
            for (int i = 0; i < problems.size(); ++i)
                problems.set(i, YamlUtil.load(
                        new URL(String.format(URL_PATH, problems.get(i).getId())).openStream(),
                        Problem.class));
            return problems;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
