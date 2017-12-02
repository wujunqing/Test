package com.exprotmeteexcel.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Teradata的JDBC操作dao类
 * 
 * @author admin
 *
 */
public class GbaseDbDaoI extends BaseDbDaoI {

	private static final Log log = LogFactory.getLog(GbaseDbDaoI.class);

	/**
	 * 构造方法
	 * 
	 * @param url
	 *            URL路径
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 */
	public GbaseDbDaoI(String url, String userName, String passWord) {
		super();
		db_url = url;
		db_userName = userName;
		db_userPass = passWord;
		DRIVER = "com.gbase.jdbc.Driver";
	}

	/**
	 * 构造函数
	 * 
	 * @param url
	 *            URL路径
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @param overTime
	 */
	public GbaseDbDaoI(String url, String userName, String passWord, int overTime) {
		super();
		db_url = url;
		db_userName = userName;
		db_userPass = passWord;
		db_overtime = overTime;
		DRIVER = "com.gbase.jdbc.Driver";
	}

	/**
	 * 构造函数
	 * 
	 * @param dbName
	 *            数据库名
	 * @param ip
	 *            IP
	 * @param port
	 *            端口
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 */
	public GbaseDbDaoI(String dbName, String ip, String port, String userName, String passWord) {
		super();
		db_url = getUrl(dbName, ip, port);
		db_userName = userName;
		db_userPass = passWord;
		db_ssid = dbName;
		DRIVER = "com.gbase.jdbc.Driver";
	}

	
	/**
	 * 构造函数
	 * 
	 * @param dbName
	 *            数据库名
	 * @param ip
	 *            IP
	 * @param port
	 *            端口
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @param hostList
	 *            集群IP列表
	 */
	public GbaseDbDaoI(String dbName, String ip, String port, String userName, String passWord,String hostList) {
		super();
		
		db_userName = userName;
		db_userPass = passWord;
		db_ssid = dbName;
		db_url = getUrl(dbName, ip, port,hostList);
		DRIVER = "com.gbase.jdbc.Driver";
	}
	/**
	 * 获取连接url
	 * 
	 * @param dbName
	 *            数据库实例名
	 * @param ip
	 *            数据库ip
	 * @param port
	 *            数据库端口
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return
	 */
	public String getUrl(String dbName, String ip, String port,String hostList) {
		// return "jdbc:teradata://"+ip+"//database="+dbName;
        String url="jdbc:gbase://" + ip + "/" + dbName+"?user="+db_userName+"&password="+db_userPass+"&failoverEnable=true&hostList="+hostList+"&gclusterId=gcl1";
		System.out.print(url);
        return url;
		//jdbc:gbase://192.168.1.56/test?user=gbase&password=gbase20110531&fa
		//	iloverEnable=true&hostList=192.168.1.57,192.168.1.58&gclusterId=gcl1
		// "jdbc:teradata://172.21.29.177//database=ODS_DATA";

	}
	
	/**
	 * 获取连接url
	 * 
	 * @param dbName
	 *            数据库实例名
	 * @param ip
	 *            数据库ip
	 * @param port
	 *            数据库端口
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return
	 */
	public String getUrl(String dbName, String ip, String port) {
		// return "jdbc:teradata://"+ip+"//database="+dbName;
		
		//"jdbc:gbase://host:port/dbname ",	"user", "password");

		return "jdbc:gbase://" + ip + ":"+port+"/" + dbName;
	
	}

	@Override
	public List<Map<String, Object>> getTableColumn() {
		// TODO Auto-generated method stub
		return null;
	}

}
