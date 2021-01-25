package com.chufeng.dao;

import com.chufeng.pojo.User;
import com.chufeng.utils.MybatisUtils;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {
  @Test
  public void test() {
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserDao mapper = sqlSession.getMapper(UserDao.class);
    List<User> userList = mapper.getUserList();
    for (User user : userList) {
      System.out.println(user.toString());
    }
    sqlSession.close();
  }
}
