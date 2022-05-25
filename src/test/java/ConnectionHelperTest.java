import util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectionHelperTest {
    public void test(){
        try {
            Connection connection= ConnectionHelper.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("select * from user where");
        }
    }


}
