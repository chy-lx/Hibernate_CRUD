package com.chy.crud;

import com.chy.po.Student;
import com.chy.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class crud {
    private static Session session = HibernateUtil.getSession();
    private static Transaction tr = session.beginTransaction();
    public static void main(String[] args) {
        /*添加*/
        //add();
        /*修改*/
        //update();
        /*删除信息*/
        //del();
        /*根据ID查找信息*/
        select(5);
    }
    /**
     * 增加信息
     */
    public static void add(){
        //循环添加
        for (int i = 1; i <11 ; i++) {
            //创建对象
            Student student=new Student(i,"张三"+i,'男',12+i);
            //执行添加
            session.save(student);
        }
        //提交事务
        tr.commit();
    }
    /**
     *修改信息
     */
    public static void update(){
        //通过ID找到对象
        Student student = (Student)session.get(Student.class, 5);
        //设置新的对象值
        student.setAge(25);
        student.setName("李四");
        student.setGender('女');
        //执行修改
        session.update(student);
        //提交事务
        tr.commit();
    }
    /**
     * 删除信息
     */
    public static void del(){
        Student student = (Student) session.get(Student.class,2);
        session.delete(student);
        tr.commit();
    }
    /**
     * 查找信息
     */
    public static void select(int id){
        Student student = (Student) session.get(Student.class,id);
        System.out.println(student);
    }
}
