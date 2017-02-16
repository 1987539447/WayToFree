package com.github.siemen;

import com.github.siemen.model.Grade;
import com.github.siemen.model.Student;
import com.github.siemen.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

/**
 * Created by 西门 on 2017/2/15 0015.
 */
public class One2ManyTest {
    public static void main(String[] args) {
        //one2Many();
        many2One();
        //findGradeByStudent();
        //findStudentsByGrade();
        //update();
        //delete();
    }

    public static void one2Many() {
        Grade g = new Grade("Java一班","Java软件开发一班");
        Student stu1 = new Student("张三","男");
        Student stu2 = new Student("小花","女");

        g.getStudents().add(stu1);
        g.getStudents().add(stu2);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(g);
        //session.save(stu1);
        //session.save(stu2);
        tx.commit();
        HibernateUtil.closeSession();
    }

    public static void many2One() {
        Grade g = new Grade("Java一班","Java软件开发一班");
        Student stu1 = new Student("张三","男");
        Student stu2 = new Student("小花","女");
        stu1.setGrade(g);
        stu2.setGrade(g);
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //session.save(g);
        session.save(stu1);
        session.save(stu2);
        tx.commit();
        HibernateUtil.closeSession();
    }

    public static void findStudentsByGrade(){
        Session session = HibernateUtil.getSession();
        Grade grade = session.get(Grade.class,1);
        System.out.println(grade.getGname()+":"+grade.getGdesc());
        Set<Student> students = grade.getStudents();
        for (Student stu:students) {
            System.out.println(stu.getSname()+":"+stu.getSex());
        }
    }

    public static void findGradeByStudent(){
        Session session = HibernateUtil.getSession();
        Student student = session.get(Student.class,1);
        System.out.println(student.getSname()+":"+student.getSex());
        Grade grade = student.getGrade();
        System.out.println(grade.getGname()+":"+grade.getGdesc());


    }

    public static void update(){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Grade grade = new Grade("Java二班","Java软件开发二班");
        Student student = session.get(Student.class,1);
        grade.getStudents().add(student);
        session.save(grade);
        tx.commit();
        HibernateUtil.closeSession();
    }
    public static void delete(){
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class,1);
        session.delete(student);
        tx.commit();
        HibernateUtil.closeSession();
    }
}
