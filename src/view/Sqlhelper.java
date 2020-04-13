package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Sqlhelper {
	// 数据库常量
	Connection ct = null;
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test1?useSSL=false&serverTimezone=UTC";
	String username = "root";
	String password = "123456";
	PreparedStatement ps = null;
	ResultSet rs = null;
	Vector rowData = null;
	Vector columnNames = null;
	public Sqlhelper() {
		// JTable所需行数据
				rowData = new Vector();
				columnNames=new Vector();
				// 链接数据库读取数据的一般操作 sqlhelper
				// 链接数据库读取数据的一般操作 sqlhelper
				try {
					// 加载驱动
					Class.forName(jdbcDriver);// 创建Driver对象
					ct = DriverManager.getConnection(url, username, password);// 初始化Driver对象连接数据库
					ps = ct.prepareStatement(" select * from peopleInfo");
			
					rs = ps.executeQuery();

			
					int rs_columnsize = rs.getMetaData().getColumnCount();
					for(int i=1;i<=rs_columnsize;i++) {
						columnNames.add(rs.getMetaData().getColumnName(i));
						
					}
					
					while (rs.next()) {
						Vector temp = new Vector();

						int i = rs_columnsize;

						while (i != 0)
							temp.add(rs.getObject(i--));

						rowData.add(temp);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (ps != null)
							ps.close();
						if (ct != null)
							ct.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
		
	}
	
	public Vector getRowData() {
		return this.rowData;
	}
	
	public Vector getColumnNames() {
		return this.columnNames;
	}
}
