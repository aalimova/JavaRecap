package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTest  {

    public static void main(String[] args) throws SQLException {

        DB db = new DB();

//        String query = "insert into countries values ('BR', 'Brazil', 2)";
//        db.runInsertQuery(query);

        ArrayList<String> columnName = new ArrayList<>();
        columnName.add("first_name");
        columnName.add("last_name");
        columnName.add("phone_number");

        ResultSet resultSet = db.runSelectQuery(columnName,"employees");
        while (resultSet.next()) System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("phone_number") + " " + resultSet.getString("last_name"));


//        List<Map<String,Object>>list = db.getTableForQuery(query);
//        System.out.println(list);
//        ResultSet resultSet = db.runSelectQuery(query);
//        while (resultSet.next()) System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));


    }


}
