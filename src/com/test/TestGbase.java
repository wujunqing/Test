package com.test;

import com.exprotmeteexcel.dao.BaseDbDao;
import com.exprotmeteexcel.service.imp.FactoryBaseDbDaoServiceImp;

public class TestGbase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BaseDbDao  db=FactoryBaseDbDaoServiceImp.getBaseDbDao("jdbcconfig\\gbase.properties");
		 
		System.out.println( db.getDateForMap("select * from information_schema.TABLES  "));
	}

}
