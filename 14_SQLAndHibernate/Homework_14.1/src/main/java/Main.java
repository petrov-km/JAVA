import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?" +
                "useUnicode=true&serverTimezone=UTC&useSSL=false&verifyServerCertificate=false";
        String user = "root";
        String pass = "Petrovkm10081008";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_name, " +
                    "(count(*))/(max(month(subscription_date))-min(month(subscription_date))+1) " +
                    "as AVG_sales_per_month from purchaselist group by course_name");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " = " + resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
