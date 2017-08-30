package com.exprotmeteexcel.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Teradata��JDBC����dao��
 * 
 * @author admin
 *
 */
public class GbaseDbDaoI extends BaseDbDaoI {

	private static final Log log = LogFactory.getLog(GbaseDbDaoI.class);

	/**
	 * ���췽��
	 * 
	 * @param url
	 *            URL·��
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
	 */
	public GbaseDbDaoI(String url, String userName, String passWord) {
		super();
		db_url = url;
		db_userName = userName;
		db_userPass = passWord;
		DRIVER = "com.gbase.jdbc.Driver";
	}

	/**
	 * ���캯��
	 * 
	 * @param url
	 *            URL·��
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
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
	 * ���캯��
	 * 
	 * @param dbName
	 *            ���ݿ���
	 * @param ip
	 *            IP
	 * @param port
	 *            �˿�
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
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
	 * ���캯��
	 * 
	 * @param dbName
	 *            ���ݿ���
	 * @param ip
	 *            IP
	 * @param port
	 *            �˿�
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
	 * @param hostList
	 *            ��ȺIP�б�
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
	 * ��ȡ����url
	 * 
	 * @param dbName
	 *            ���ݿ�ʵ����
	 * @param ip
	 *            ���ݿ�ip
	 * @param port
	 *            ���ݿ�˿�
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
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
	 * ��ȡ����url
	 * 
	 * @param dbName
	 *            ���ݿ�ʵ����
	 * @param ip
	 *            ���ݿ�ip
	 * @param port
	 *            ���ݿ�˿�
	 * @param userName
	 *            �û���
	 * @param passWord
	 *            ����
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
