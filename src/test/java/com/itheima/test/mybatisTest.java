package com.itheima.test;
import java.util.Date;


import com.itheima.dao.Empdao;
import com.itheima.domain.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class mybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private Empdao empdao;
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("sqlMAppconfig.xml");
        //2.获取sqlsessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //3.使用sqlSessionfactory获得一个sqlsesssion对象
        sqlSession = sqlSessionFactory.openSession();
        //4.使用sqlsession创建dao的代理对象
        empdao=sqlSession.getMapper(Empdao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void insertEmp(){
        //A、插入一个员工
        Emp e=new Emp();
        e.setEpno(8005);
        e.setEname("梁思德5");
        e.setJob("clark");
        e.setMgr(7698);
        e.setBir(new Date());
        e.setSal(8000D);
        e.setComm(2000.0D);
        e.setDepo(30);
        empdao.insertEmp(e);
        System.out.println(e+"插入之后");
    }
    @Test
    public void UpdateEmp(){
        // B、修改员工信息
        Emp emp=new Emp();
        emp.setEpno(8001);
        emp.setEname("liangside2");
        emp.setJob("laoban");
        emp.setMgr(7839);
        emp.setBir(new Date());
        emp.setSal(13000D);
        emp.setComm(2000.0D);
       empdao.UpdateEmp(emp);
    }
    @Test
    public void deleteEmp(){
        // C、根据empno删除一个员工
        empdao.deleteEmp(8001);
    }
    @Test
    public void getEmpByid(){
        // D、根据empno获取一个员工Pojo对象
        Emp e=empdao.getEmpByid(8000);
        System.out.println(e);
    }
    @Test
    public void findEmpAll(){
        //E、找出所有员工
        List<Emp> list=empdao.findEmpAll();
        for(Emp e:list){
            System.out.println(e);
        }
    }
    @Test //F、找出薪水在某个范围之间的所有员工
    public void findEmpBysal(){
        List<Emp> list=empdao.findEmpBysal(5000d,15000d);
        for(Emp e:list){
            System.out.println(e);
        }
        System.out.println("tom");

    }


}
