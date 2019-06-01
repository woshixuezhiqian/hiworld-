package tk.wkkany.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {
    private  static DataSource ds;

    static {
       // 1:加载配置文件
        Properties pro=new Properties();
        //使用classloder加载文件
        try {
            pro.load(JDBCutils.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds= DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
* 获取连接池对象
* */
public static  DataSource getdatasourse(){

    return ds;
}



/*
* 获取connection对象
* */
public static Connection getconnection() throws SQLException {
    return  ds.getConnection();
}


}
