package datasource;

import datasource.annotations.Column;
import datasource.annotations.Table;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {

   private final String CONNECTION_STRING;
   private final String LOGIN;
   private final String PASSWORD;

   protected Connection conn;

   public Datasource(String connectionString, String login, String password) {
      this.CONNECTION_STRING = connectionString;
      this.LOGIN = login;
      this.PASSWORD = password;
   }

   public boolean openConnection() {
      try {
         conn = DriverManager.getConnection(CONNECTION_STRING, LOGIN, PASSWORD);
         return true;
      } catch (SQLException e) {
         System.out.println("Couldn't open connection " + e.getMessage());
         return false;
      }
   }

   public boolean closeConnection() {
      try {

         if (conn != null) {
            conn.close();
         }
         return true;
      } catch (SQLException e) {
         System.out.println("Couldn't close connection " + e.getMessage());
         return false;
      }
   }

   public boolean insertIntoTable(Object ob) {
      try {
         String table = ob.getClass().getConstructor().getAnnotation(Table.class).value();

         StringBuilder queryBegining = new StringBuilder("INSERT INTO ");
         queryBegining.append(table);
         queryBegining.append(" (");

         StringBuilder values = new StringBuilder();
         values.append("VALUES (");


         Field[] fieldArr = ob.getClass().getDeclaredFields();

         ArrayList<Object> valuesToInsert = new ArrayList<>();

         for (Field f : fieldArr) {
            f.setAccessible(true);
            String name = f.getAnnotation(Column.class).value();
            queryBegining.append(name + ", ");
            values.append("?, ");
            if (f.get(ob) == null) {
               valuesToInsert.add(null);
            } else {
               valuesToInsert.add(f.get(ob).toString());
            }
         }

         queryBegining.setLength(queryBegining.length() - 2);
         queryBegining.append(") ");
         values.setLength(values.length() - 2);
         values.append(")");

         String sql = queryBegining.toString() + values.toString();

         PreparedStatement statement = conn.prepareStatement(sql);

         for (int i = 1; i <= valuesToInsert.size(); i++) {
            statement.setObject(i, valuesToInsert.get(i - 1));
         }

         System.out.println(statement.toString());

         statement.executeUpdate();

         return true;
      } catch (IllegalAccessException | NoSuchMethodException | SQLException e) {
         e.printStackTrace();
         return false;
      }
   }

   public List<?> getAllItemsFromTable(Class clazz) {
      try {

         ObjectMapper objectMapper = new ObjectMapper(clazz);
         String table = ((Table) clazz.getConstructor().getAnnotation(Table.class)).value();
         String sql = "Select * FROM " + table;

         Statement statement = conn.createStatement();

         return objectMapper.map(statement.executeQuery(sql));

      } catch (NoSuchMethodException | SQLException e) {
         e.printStackTrace();
         return null;
      }
   }

}
