package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {

        //create connection
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );
        //create statement

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


//        //read data
//        ResultSet resultSet = statement.executeQuery("Select * from jobs");
////        resultSet.next();
////        resultSet.next();
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("job_id"));
//            System.out.println(resultSet.getString("job_title"));
//            System.out.println(resultSet.getString("min_salary"));
//        }

        //read data
//        ResultSet resultSet = statement.executeQuery("select concat (e.first_name, ' ' , e.last_name) as pfullName, concat(d.first_name,' ', d.last_name) as dfullName from employees e \n" +
//                "inner join dependents d on e.employee_id = d.employee_id;");
//
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("pfullName" )+ " is a parent of " + resultSet.getString("dfullName"));
//        }
        //read data
        findDifferentEmail(connection,statement);

    }

        private static void findDifferentEmail (Connection connection, Statement statement) throws SQLException {

            ResultSet resultSet = statement.executeQuery("Select email from employees");

            List<String> email = new ArrayList<>();

            while (resultSet.next()){
                email.add(resultSet.getString("email"));
            }
            boolean isWrongEmail = false;

            for(String emails: email) {
                if (!emails.endsWith("@sqltutorial.org")) {
                    System.out.println("Wrong email " + emails);
                    isWrongEmail = true;
                }
            }
                if(isWrongEmail){
                    System.out.println("Found different email");
                }
                else {
                    System.out.println("All emails are the same");
                }



        }

}
