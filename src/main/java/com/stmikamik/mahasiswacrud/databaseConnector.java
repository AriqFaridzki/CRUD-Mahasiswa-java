package com.stmikamik.mahasiswacrud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luminescenents
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Digunakan untuk seluruh operasi Database, 
 * biasanya 
 * databaseConnector connector = new databaseConnector();
 * Connection connection = connector.getConnection();
 * @author Luminescenents
 */
public class databaseConnector {
    
    private static final String url = "jdbc:mysql://localhost:3306/collage_db_2";
    private static final String username = "root";
    private static final String password ="";
    
    private Connection connection;
//    private Statement statement;
//    private ResultSet resultSet;
//    
    
    public databaseConnector(){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
                System.out.println("Failed to load MySQL JDBC driver.");
                e.printStackTrace();
        }
    }
    
    /**
     * Method ini digunakan untuk Mengkoneksikan ke database.
     * panggil sebelum memulai apapun :D.
     * 
     * @return 
     */
    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                connection.setAutoCommit(true);

            } catch (SQLException e) {
                System.out.println("Failed to connect to the database.");
                e.printStackTrace();
            }
        }
        return connection;
    }
   
    /**
     *  pada objek Connection digunakan untuk menutup koneksi fisik antara aplikasi Java dan database.
     */
   public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the database connection.");
                e.printStackTrace();
            }
        }
    }
   
   /**
    * 
    * Gunakan untuk Operasi SELECT aja.
    * biasanya ResultSet resultSet = connector.executeQueryRead(query);
    * @param queryStatement isi Query mu ( Contoh ; SELECT * FROM table )
    * @param values (opsional, akan mengisi tanda ? yg pertama dan seterusnya yang ada di queryStatement
    * @return hasil querynya, jangan lupa di loop pake method .next() didalamnya *pake while aja
    * contoh ( resultSet.next())
    */
   public ResultSet executeQueryRead(String queryStatement, Object... values) {
        ResultSet resultSet = null;
        
        try {
            Connection connection = getConnection();
            
            PreparedStatement statement = connection.prepareStatement(queryStatement);
//            resultSet = statement.executeQuery();
            
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);

            }
            
           resultSet= statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + queryStatement);
            e.printStackTrace();
        }
        return resultSet;
    }
   
   /**
    * Gunakan ini untuk operasi DML 
    * DML : Create, Delete, Insert, UPDATE
    * 
    * biasanya int rowsAffected = connector.executeQueryDML(queryStatement,values);
    * 
    * @param queryStatement isi dengan query mu (contoh : INSERT INTO tables VALUES(?,?))
    * @param values isi dengan value yang mau di diberikan ke query, nanti akan mengisi tanda "?" yang pertama dan seterusnya
    * @return berapa banyak data yang sudah di kena di manipulasi
    */
   public int executeQueryDML(String queryStatement, Object... values) {
        int rowsAffected = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(queryStatement);
            
            
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);

            }
            
//           rowsAffected= statement.executeQ
           rowsAffected = statement.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Failed to execute update: " + queryStatement);
            e.printStackTrace();
        }
        return rowsAffected;
    }
   
   /**
    * untuk mengecek apakah koneksi telah berhasil
    * 
    * @throws SQLException jika ada error
    */
   public void checkConnection() throws SQLException{
       try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(true);

            System.out.println("Connect Success");
        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("Error LMAO");
   }

   }
   /**
    * Close hasil resultSetnya nanti ndak bisa diakses lagi hasil dari querynya :D
    * @param resultSet 
    */
   public void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the result set.");
                e.printStackTrace();
            }
        }
    }
   
   /**
    * Close hasil statement initnya nanti ndak bisa diakses lagi hasil dari querynya :D
    *  Metode close() pada objek Statement atau PreparedStatement digunakan untuk menutup pernyataan 
    * SQL yang telah dieksekusi atau yang akan dibatalkan.
    * @param statement 
    */
   public void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the statement.");
                e.printStackTrace();
            }
        }
    }

   
}
