package view;

/*
 * 这是一个最基本的JDBC实例
 * 包含：
 * 1. JTable （包含行数据和列名） 的建立
 * 2. 列名数组columnNames的建立
 * 3. 行数据数组rowData的建立，又包括：
 *  3.1） 连接数据库
 *     所需常量：
 *      a）jdbcDriver 数据库连接驱动
 *      b）url 数据库地址
 *      c）username 用户名
 *      d）password 密码
 *      所需对象：
 *      a）Connection 连接
 *      b）Statement/PreparedStatement 语句
 *      c）ResultSet 结果集
 *      基本过程：
 *      Class.forName(jdbcDriver) 加载驱动，创建Driver对象加入DriverManager
 *      DriverManager.getConnection根据url地址和用户名密码得到链接
 *      Connection对象把sql语句（Statement 对象）发送给数据库，并返回结果集到ResultSet
 *      通过ResultSet的next方法读出每行，getObject(列数【从1开始】）读出每行的某列数据
 *     
 *      //时间：2020/4/10
 */
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//主窗口
public class test extends JFrame {

	// 行数据和列名
	Vector rowData, columnNames;
	JTable jt = null;
	JScrollPane jsp = null;

	// 数据库常量
	Connection ct = null;
	// ?做分隔符
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test1?useSSL=false&serverTimezone=UTC";
	String username = "root";
	String password = "123456";
	PreparedStatement ps = null;
	/*
	 * PreparedStatement 和 Statement 的区别： PreparedStatement
	 * 叫做JDBC存储过程，拥有数据库存储过程的特点，预编译支持批处理，但相比 Statement 对象体积大，对一次性操作没有好处。
	 */
	// 结果集
	ResultSet rs = null;
	int rs_columnsize=0;
	
	
	// 生成实例
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();

	}

	// 主窗口构造函数
	public test() {
		stumodel sm=new stumodel();
		// 初始化JTable以及主窗口的设置
		jt = new JTable(sm);
		jsp = new JScrollPane(jt);
		this.add(jsp);
		this.setLocation(800, 500);
		this.setTitle("JDBC TEST");
		this.setResizable(false);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

}
