package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC2 {

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query = "Select * from employees";

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        ResultSetMetaData reSetMetaData = resultSet.getMetaData();

        System.out.println(reSetMetaData.getColumnCount() );

        for (int i =1; i <= reSetMetaData.getColumnCount(); i++){
            System.out.println("Column # " + i + ":" + reSetMetaData.getColumnName(i));
        }

        List<Map<String, Object>> list = new ArrayList<>();

        while (resultSet.next()){
            Map<String, Object> map = new HashMap<>();
            for(int i =1; i < reSetMetaData.getColumnCount(); i++){
                map.put(reSetMetaData.getColumnName(i),resultSet.getString(reSetMetaData.getColumnName(i)));
            }
            list.add(map);
        }
        System.out.println(list);

        findEmployeeWithEmpID(list,100);
        findEmployeeEmailWithEmployyFname(list, "Irene");
    }

    private static void findEmployeeEmailWithEmployyFname(List<Map<String, Object>> list, String fname) {
        for(Map row : list){
            if(row.get("first_name").toString().equalsIgnoreCase(fname)){
                System.out.println(row.get("email"));
                break;
            }
        }
        System.out.println("Finished");

    }

    public static void findEmployeeWithEmpID(List<Map<String,Object>> list, int id){
        for(Map row: list){
            if(Integer.parseInt(row.get("employee_id").toString())== id){
                System.out.println(row.get("first_name"));
                break;
            }
        }
        System.out.println("Finished");
    }
}
