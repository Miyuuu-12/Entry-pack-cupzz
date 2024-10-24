package datapemasukanbarang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static Connection mysqlconfig;

    public static Connection configDB() throws SQLException {
        try {
            String URL = "jdbc:mysql://localhost:3306/pemasukkan_barang";
            String USER = "root";
            String PASSWORD = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
        return mysqlconfig;
    }
}
