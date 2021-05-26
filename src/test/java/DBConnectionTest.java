import DB.DBConnection;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;


import java.sql.Connection;


public class DBConnectionTest {

    @Test
    @DisplayName("Test connect db thanh cong")
    public void testDBConnect(){
        Connection conn = DBConnection.CreateConnection();
        assertNotNull(conn);

    }
}
