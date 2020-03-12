package com.itheima.dao;

import com.itheima.domain.Emp;

import java.util.List;


public interface Empdao {
    /**
     * 插入一个员工
     * @param emp
     */
     void insertEmp(Emp emp);
    // B、修改员工信息
    /**
     * 插入数据
     * @param emp
     */
    void UpdateEmp(Emp emp);
    /**
     *  // C、根据empno删除一个员工
     * @param id
     */
    void deleteEmp(int id);
    /**
     * // D、根据empno获取一个员工Pojo对象
     * @param id
     * @return
     */
    Emp getEmpByid(int id);
    /**
     * //E、找出所有员工
     * @return
     */
    List<Emp> findEmpAll();
    /**
     *   //F、找出薪水在某个范围之间的所有员工
     * @param a
     * @param b
     * @return
     */
    List<Emp> findEmpBysal(double a,double b);
}
