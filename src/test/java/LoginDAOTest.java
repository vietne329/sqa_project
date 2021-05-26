import Bean.Account;
import DAO.LoginDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;

import java.sql.SQLException;

public class LoginDAOTest {

    Account account = new Account();
    LoginDAO loginDAO = new LoginDAO();

    @BeforeEach
    void initData(){
        account.setUsername("viet123");
        account.setPassword("123456");
    }

    @Test
    @DisplayName("Check account exist in database")
    void checkAccount() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
         account =loginDAO.checkLogin("viet123","123456");
        assertNotNull(account);
        assertEquals("viet123",account.getUsername());
        assertEquals("123456",account.getPassword());
    }

    @Test
    @DisplayName("Check account doesn't exist in database")
    void checkAccount1() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123111","123456111");
        assertNull(account);
    }

    @Test
    @DisplayName("Check password is wrong")
    void checkAccount2() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123","1111111111");
        assertNull(account);
    }

    @Test
    @DisplayName("Check username and password is wrong")
    void checkAccount3() throws SQLException, ClassNotFoundException {
        //test tai khoan da co trong database
        account =loginDAO.checkLogin("viet123111","0000000");
        assertNull(account);
    }


}
