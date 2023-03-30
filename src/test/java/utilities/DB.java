package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB implements DBMethods{

    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet;
    private ResultSetMetaData reSetMetaData;

    public DB() throws SQLException {
       connection = DriverManager.getConnection(
                ConfigReader.getProperty("DBURL"),
                ConfigReader.getProperty("DBusername"),
                ConfigReader.getProperty("DBPassword"));
         statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    public ResultSet executeSelectQuery(String query) throws SQLException {
         resultSet = statement.executeQuery(query);

        return resultSet;
    }
    public ResultSetMetaData getMetaForResultSet(ResultSet resultSet) throws SQLException {
        return reSetMetaData = resultSet.getMetaData();
    }

    public List<Map<String,Object>>  getTableForQuery(String query) throws SQLException {
        resultSet = executeSelectQuery(query);
        reSetMetaData = getMetaForResultSet(resultSet);
        List<Map<String, Object>> list = new ArrayList<>();

        while (resultSet.next()){
            Map<String, Object> map = new HashMap<>();
            for(int i =1; i < reSetMetaData.getColumnCount(); i++){
                map.put(reSetMetaData.getColumnName(i),resultSet.getString(reSetMetaData.getColumnName(i)));
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public ResultSet runSelectQuery(String query) throws SQLException {
        return resultSet = statement.executeQuery(query);
    }

    public ResultSet runSelectQuery(String query, String tableName) throws SQLException {
        return resultSet = statement.executeQuery(query);
    }

    @Override
    public void runUpdateQuery(String query) throws SQLException {
             statement.executeUpdate(query);
             System.out.println("DB was updated");
    }

    @Override
    public void runInsertQuery(String query) throws SQLException {
            statement.executeUpdate(query);
            System.out.println("DB was update with insert query");
    }
    @Override
    public void runDeleteQuery(String query) throws SQLException {
        statement.executeUpdate(query);
        System.out.println("Delete was successful");
    }

    public ResultSet runSelectQuery(ArrayList<String> columnNames, String tableName) throws SQLException {
        String query = "select ";
        for(String cName: columnNames){
            query = query + cName + ", ";
        }
        query = query.substring(0,query.length()-2);
        query = query + " from " + tableName;
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public ResultSetMetaData getReSetMetaData() {
        return reSetMetaData;
    }

    public void setReSetMetaData(ResultSetMetaData reSetMetaData) {
        this.reSetMetaData = reSetMetaData;
    }


}
