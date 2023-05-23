package com.zz.Service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zz.Service.ExamService;
import com.zz.bean.Exam;
import com.zz.dao.ExamDao;
import com.zz.utils.Code;
import com.zz.utils.result.ApiResult;
import com.zz.utils.result.TempResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDao examDao;

    //创建考试
    @Override
    public TempResult createExam(Exam exam) {
        System.out.println("create Exam print" + exam.toString());
        TempResult tempResult = new TempResult();
        Integer exam1 = examDao.createExam(exam);
        if (exam1 != 0) {
            tempResult.setFlag(true);
            tempResult.setMsg("创建成功！");
        } else {
            tempResult.setFlag(false);
            tempResult.setMsg("创建失败！");
        }
        return tempResult;
    }

    //注销考试
    @Override
    public TempResult deleteExam(Integer examId) {
        TempResult tempResult = new TempResult();
        Integer exam1 = examDao.deleteExam(examId);
        if (exam1 != 0) {
            tempResult.setFlag(true);
            tempResult.setMsg("删除成功！");
        } else {
            tempResult.setFlag(false);
            tempResult.setMsg("删除失败！");
        }
        return tempResult;
    }


    //考试信息更改 时间、试卷等。
    @Override
    public ApiResult updateExamInfo(Exam exam) {
        System.out.println(exam);
        Integer flag = examDao.updateExamInfo(exam);//返回更新后的考试实体
        ApiResult apiResult = new ApiResult();

        if (flag != null) {
            apiResult.setMsg("修改成功");
            apiResult.setData(exam);
        } else {
            apiResult.setMsg("修改失败");
            apiResult.setData(null);//返回原exam
        }
        return apiResult;
    }

    @Override
    public ApiResult selectAll(String pageNumNow) {
        ApiResult apiResult = new ApiResult();
        Page<?> page = PageHelper.startPage(Integer.parseInt(pageNumNow), 5);  //设置第几条记录开始，多少条记录为一页
        //通过userService获取user的信息，其sql语句为"select * from user" 但因pageHelper已经注册为插件，所以pageHelper会在原sql语句上增加limit，从而实现分页
        examDao.selectAll();  //因而获得的是分好页的结果集
        PageInfo<?> pageHelper = page.toPageInfo(); //获取页面信息的对象，里面封装了许多页面的信息 如：总条数，当前页码，需显示的导航页等等
        apiResult.setData(pageHelper);
        if (apiResult.getData() != null) {
            apiResult.setMsg("分页查询成功");
            apiResult.setCode(Code.GET_OK);
        } else {
            apiResult.setMsg("分页查询失败!");
            apiResult.setCode(Code.GET_ERR);
        }
        return apiResult;
    }

    @Override
    public ApiResult selectOne(Integer examId) {
        /**
         * 查询结果
         */
        Exam exam = examDao.selectOne(examId);
        ApiResult apiResult = new ApiResult();
        if (exam != null) {
            apiResult.setData(exam);
            apiResult.setCode(Code.GET_OK);
            apiResult.setMsg("查询成功！");
        } else {
            apiResult.setData(null);
            apiResult.setCode(Code.GET_ERR);
            apiResult.setMsg("查询失败！");
        }
        return apiResult;
    }
}
