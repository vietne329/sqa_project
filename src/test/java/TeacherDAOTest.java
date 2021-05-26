import Bean.Teacher;
import DAO.TeacherDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;
import java.sql.SQLException;

public class TeacherDAOTest {
    Teacher teacher;
    @BeforeEach
    void initData(){

        teacher = new Teacher();
        teacher.setName("Mai Đắc Việt");
    }

    @Test
    @DisplayName("Test get teacher by username")
    void getTeacherIdByUsername() throws SQLException, ClassNotFoundException {
        String teacher_name = teacher.getName();
        teacher = TeacherDAO.getTeacherID(teacher_name);
        assertNotNull(teacher);
        assertEquals(1,teacher.getId());
    }

    @Test
    @DisplayName("Test get teacher by wrong username")
    void getTeacherIdByUsername2() throws SQLException, ClassNotFoundException {
        teacher.setName("Maaaaaa");
        String teacher_name = teacher.getName();
        Teacher teacher2 = TeacherDAO.getTeacherID(teacher_name);
        assertNull(teacher2);
        System.out.println(teacher2);
    }



}
