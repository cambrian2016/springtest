package net.htwater.springtest;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.*;

public class DataSourseTest {

    @Test
    //测试c3p0数据源
    public void test3() throws PropertyVetoException, SQLException {
        //读取配置文件
        ResourceBundle resourceBundle=ResourceBundle.getBundle("jdbc");
        String driver=resourceBundle.getString("jdbc.driver");
        String url=resourceBundle.getString("jdbc.url");
        String username=resourceBundle.getString("jdbc.username");
        String password=resourceBundle.getString("jdbc.password");


        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);

            Connection connection = dataSource.getConnection();
            System.out.println(connection);

            connection.close();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //测试druid数据源
    public void test2() throws PropertyVetoException, SQLException {
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?3useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        DruidPooledConnection druidPooledConnection=druidDataSource.getConnection();
        System.out.println(druidPooledConnection);

        druidPooledConnection.close();
    }

    @Test
    //测试c3p0数据源
    public void test1() throws PropertyVetoException, SQLException {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?3useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=true");
            dataSource.setUser("root");
            dataSource.setPassword("123456");

            Connection connection = dataSource.getConnection();
            System.out.println(connection);

            connection.close();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    //测试jdbc
    public void test0() throws PropertyVetoException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test?3useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false","root","123456");
            String sql="SELECT * from test";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            List list=convertList(resultSet);

            System.out.println(list);

            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static List convertList(ResultSet rs) throws SQLException{
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return list;
    }
}
