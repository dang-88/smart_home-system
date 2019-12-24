/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.dal.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import studentapp.dal.DBUtil;
import studentapp.dal.Entity.Student;
import studentapp.dal.dao.StudentDao;

/**
 *
 * @author apple
 */
public class StudentDaoImpl implements StudentDao{

   @Override
    public boolean addStudent(Student stu) {
        String insert = "insert into user(sname,saircon,swindow,sdoor,slight) "
                +"values('"+stu.getSname()+"','"+stu.getSnumber()+"','"+stu.getSage()+"','"+stu.getSphone()+"','"+stu.getSaddress()+"')";
        
        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
      public boolean updateStudent(Student stu){
        String update="update user set sname='"+stu.getSname()+"',saircon='"+stu.getSnumber()+
                "',swindow="+stu.getSage()+",sdoor='"+stu.getSphone()+"',slight='"+stu.getSaddress()+"' where sid="+stu.getSid();
          System.out.println(update);
        try {
            DBUtil.runUpdate(update);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delStudentbyID(int id) {
        String delete = "delete from user where sid = '"+id+"'";
        
        try {
            DBUtil.runUpdate(delete);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    @Override
    public Student getStudentbyID(int id) {
        String select="select * from user where sid="+id;
        try {
            Student student = new Student();
            ResultSet rs=DBUtil.runQuery(select);
            while(rs.next())
            {
               student.setSid(rs.getInt("sid"));
               student.setSname(rs.getString("sname"));
               student.setSnumber(rs.getString("saircon"));
               student.setSage(rs.getString("swindow"));
               student.setSphone(rs.getString("sdoor"));
               student.setSaddress(rs.getString("slight"));
            }
            DBUtil.realeaseAll();
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student getStudentbyNum(String snum) {
        String select="select * from user where saircon='"+snum+"'";
        try {
            Student student = new Student();
            ResultSet rs=DBUtil.runQuery(select);
            while(rs.next())
            {
               student.setSid(rs.getInt("sid"));
               student.setSname(rs.getString("sname"));
               student.setSnumber(rs.getString("saircon"));
               student.setSage(rs.getString("swindow"));
               student.setSphone(rs.getString("sdoor"));
               student.setSaddress(rs.getString("slight"));
            }
            DBUtil.realeaseAll();
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getStudentbyName(String name) {
        String select="select * from user where sname='"+name+"'";
        try {
            List<Student> students = new ArrayList<Student>();
            ResultSet rs=DBUtil.runQuery(select);
            while(rs.next())
            {
               Student student = new Student();
               student.setSid(rs.getInt("sid"));
               student.setSname(rs.getString("sname"));
               student.setSnumber(rs.getString("saircon"));
               student.setSage(rs.getString("swindow"));
               student.setSphone(rs.getString("sdoor"));
               student.setSaddress(rs.getString("slight"));
               students.add(student);
            }
            DBUtil.realeaseAll();
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        String select="select * from user";
        try {
            List<Student> students = new ArrayList<Student>();
            ResultSet rs=DBUtil.runQuery(select);
            while(rs.next())
            {
               Student student = new Student();
               student.setSid(rs.getInt("sid"));
               student.setSname(rs.getString("sname"));
               student.setSnumber(rs.getString("saircon"));
               student.setSage(rs.getString("swindow"));
               student.setSphone(rs.getString("sdoor"));
               student.setSaddress(rs.getString("slight"));
               students.add(student);
            }
            DBUtil.realeaseAll();
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    
}
