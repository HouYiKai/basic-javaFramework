package view;

/*
 * ����һ���������JDBCʵ��
 * ������
 * 1. JTable �����������ݺ������� �Ľ���
 * 2. ��������columnNames�Ľ���
 * 3. ����������rowData�Ľ������ְ�����
 *  3.1�� �������ݿ�
 *     ���賣����
 *      a��jdbcDriver ���ݿ���������
 *      b��url ���ݿ��ַ
 *      c��username �û���
 *      d��password ����
 *      �������
 *      a��Connection ����
 *      b��Statement/PreparedStatement ���
 *      c��ResultSet �����
 *      �������̣�
 *      Class.forName(jdbcDriver) ��������������Driver�������DriverManager
 *      DriverManager.getConnection����url��ַ���û�������õ�����
 *      Connection�����sql��䣨Statement ���󣩷��͸����ݿ⣬�����ؽ������ResultSet
 *      ͨ��ResultSet��next��������ÿ�У�getObject(��������1��ʼ��������ÿ�е�ĳ������
 *     
 *      //ʱ�䣺2020/4/10
 */
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//������
public class test extends JFrame {

	// �����ݺ�����
	Vector rowData, columnNames;
	JTable jt = null;
	JScrollPane jsp = null;

	// ���ݿⳣ��
	Connection ct = null;
	// ?���ָ���
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test1?useSSL=false&serverTimezone=UTC";
	String username = "root";
	String password = "123456";
	PreparedStatement ps = null;
	/*
	 * PreparedStatement �� Statement ������ PreparedStatement
	 * ����JDBC�洢���̣�ӵ�����ݿ�洢���̵��ص㣬Ԥ����֧������������� Statement ��������󣬶�һ���Բ���û�кô���
	 */
	// �����
	ResultSet rs = null;
	int rs_columnsize=0;
	
	
	// ����ʵ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();

	}

	// �����ڹ��캯��
	public test() {
		stumodel sm=new stumodel();
		// ��ʼ��JTable�Լ������ڵ�����
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
