package com.exprotmeteexcel.service.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.exprotmeteexcel.dao.BaseDbDao;
import com.exprotmeteexcel.dao.impl.BaseDbDaoI;
import com.exprotmeteexcel.dao.impl.GbaseDbDaoI;
import com.exprotmeteexcel.utl.Getjdbcconfig;
import com.exprotmeteexcel.utl.Utl;

/**
 * JDBC����������
 * 
 * @author admin
 *
 */

public class FactoryBaseDbDaoServiceImp {
	private static final Log log = LogFactory.getLog(FactoryBaseDbDaoServiceImp.class);

	/**
	 * ���jdbc��DAO��
	 * 
	 * @param path
	 *            ����·��
	 * @return db ��
	 */
	public static BaseDbDaoI getBaseDbDaoI(String path) {

		Getjdbcconfig dbcof = new Getjdbcconfig(path);
		BaseDbDaoI db = null;
		if (!Utl.isEmpty(dbcof.getDbtype())) {

			if ("Gbase".equals(dbcof.getDbtype().toLowerCase())) {
				if (Utl.isEmpty(dbcof.getProperties().getProperty("hostList"))) {
					db = new GbaseDbDaoI(dbcof.getDatabasename(), dbcof.getIp(), dbcof.getPort(), dbcof.getUsername(),
							dbcof.getPassword());
					db.setDb_type(dbcof.getDbtype());
				} else {
					db = new GbaseDbDaoI(dbcof.getDatabasename(), dbcof.getIp(), dbcof.getPort(), dbcof.getUsername(),
							dbcof.getPassword(), dbcof.getProperties().getProperty("hostList"));
					db.setDb_type(dbcof.getDbtype());
				}
				return db;

			}
		}
		return db;
	}

	/**
	 * ���jdbc��DAO������
	 * 
	 * @param path
	 *            ����·��
	 * @return db ��
	 */
	public static BaseDbDao getBaseDbDao(String path) {

		Getjdbcconfig dbcof = new Getjdbcconfig(path);
		BaseDbDao db = null;
		if ("gbase".equals(dbcof.getDbtype().toLowerCase())) {
			if (Utl.isEmpty(dbcof.getProperties().getProperty("hostList"))) {
				db = new GbaseDbDaoI(dbcof.getDatabasename(), dbcof.getIp(), dbcof.getPort(), dbcof.getUsername(),
						dbcof.getPassword());
			} else {
				db = new GbaseDbDaoI(dbcof.getDatabasename(), dbcof.getIp(), dbcof.getPort(), dbcof.getUsername(),
						dbcof.getPassword(), dbcof.getProperties().getProperty("hostList"));
			}
			return db;

		}
		return db;
	}
}
