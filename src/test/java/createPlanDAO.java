import Bean.RegisterdClass;
import Bean.StudyClass;
import Bean.TeachPlan;
import Bean.Teacher;
import DAO.CreatePlanDAO;
import DAO.StudyClassDAO;
import DB.DBConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class createPlanDAO {
    Connection conn= DBConnection.CreateConnection(); ;
    RegisterdClass rc;
    StudyClass sc;
    CreatePlanDAO createPlanDAO;
    Teacher teacher;
    TeachPlan teachPlan;
    @BeforeEach
    void initData(){
        sc = new StudyClass();
        createPlanDAO = new CreatePlanDAO();
        teachPlan = new TeachPlan();
    }

    @Test
    @DisplayName("Test createPlan")
    void createPlan() throws SQLException {
        StudyClassDAO studyClassDAO=  new StudyClassDAO();
        sc.setId(13);
        teachPlan = new TeachPlan();
        teachPlan.setKip(3);
        teachPlan.setTenbaihoc("Báo cáo btl");
        teachPlan.setLoai("Lý thuyết");
        teachPlan.setGhichu("kiem tra nửa lớp");
        teachPlan.setLophoc_id(sc.getId());
        boolean check = createPlanDAO.insertTeachPlan(teachPlan);
        assertEquals(false,check);
    }


}
