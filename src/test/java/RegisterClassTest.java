import Bean.RegisterdClass;
import Bean.StudyClass;
import Bean.Teacher;
import static org.junit.Assert.*;

import DAO.RegisterDAO;
import DAO.RegisterdClassDAO;
import DAO.StudyClassDAO;
import DB.DBConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterClassTest {
    Connection conn= DBConnection.CreateConnection(); ;
    RegisterdClass rc;
    StudyClass sc;
    Teacher teacher;

    @BeforeEach

    void initData() throws SQLException, ClassNotFoundException {
        teacher = new Teacher();
        teacher.setId(1);
        sc = new StudyClass();
        rc = new RegisterdClass();
    }

//    @Test
//    @DisplayName("Test a teacher is register class that not exist in database")
//    void check1(){
//        sc.setId(7);
//        rc.setGiaovien_id(teacher.getId());
//        rc.setClass_id(sc.getId());
//        boolean check = RegisterdClassDAO.addRegisterdClass(conn,rc);
//        assertEquals(true,check);
//    }

//    @Test
//    @DisplayName("Test a teacher is register class that exist in database")
//    void check2(){
//        sc.setId(1);
//        rc.setGiaovien_id(teacher.getId());
//        rc.setClass_id(sc.getId());
//        boolean check = RegisterdClassDAO.addRegisterdClass(conn,rc);
//        assertEquals(false,check);
//    }
//@Test
//@DisplayName("Test a teacher is register class that field id is not exist in database")
//void check2(){
//    sc.setId(15);
//    rc.setGiaovien_id(teacher.getId());
//    rc.setClass_id(sc.getId());
//    boolean check = RegisterdClassDAO.addRegisterdClass(conn,rc);
//    assertEquals(false,check);
//}
//
//    @Test
//    @DisplayName("Test load list class from database")
//    void check3(){
//        List<StudyClass> studyClassList = new ArrayList<StudyClass>();
//        studyClassList = RegisterDAO.listClass(conn);
//        assertNotNull(studyClassList);
//        System.out.println(studyClassList.toArray());
//        for (StudyClass sc: studyClassList) {
//            System.out.println(sc.getId());
//            System.out.println(sc.getTenmonhoc());
//            System.out.println(sc.getThoigian());
//        }
//    }

//    @Test
//    @DisplayName("Test load list class registerd from database")
//    void check3(){
//        teacher.setId(1);
//        List<StudyClass> list = new ArrayList<>();
//        list = RegisterdClassDAO.listRegisterdClass(conn,String.valueOf(teacher.getId()));
//        int count = list.size();
//        System.out.println(count);
//        assertEquals(5,count);
//    }


//    @Test
//    @DisplayName("Test get class by id")
//    void check3(){
//        sc.setId(0);
//        StudyClassDAO studyClassDAO = new StudyClassDAO();
//        StudyClass studyClass = studyClassDAO.selectClassById(sc.getId());
//        assertNull(studyClass);
//    }
//    @Test
//    @DisplayName("Test search class by name")
//    void searchClassByName(){
//        StudyClassDAO studyClassDAO=  new StudyClassDAO();
//        sc.setTenmonhoc("aaaaaaaaaa");
//        List<StudyClass> list = studyClassDAO.searchClassByName(sc.getTenmonhoc());
//        int count = list.size();
//        assertEquals(0,count);
//    }

    @Test
    @DisplayName("Test delete class by id")
    void deleteClass() throws SQLException {
        StudyClassDAO studyClassDAO=  new StudyClassDAO();
        sc.setId(10);

        boolean check = studyClassDAO.deleteClass(sc.getId());
        assertNotEquals(true,check);
    }



}
