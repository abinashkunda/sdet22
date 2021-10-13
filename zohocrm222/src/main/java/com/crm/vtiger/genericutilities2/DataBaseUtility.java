package com.crm.vtiger.genericutilities2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con= null;
	ResultSet result = null;
	Driver driverRefDriver;
	/**
	 * Connection with database is established
	 * @throws Throwable 
	 * @throws Throwable
	 * 
	 */
	public void connectToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRefDriver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root", "root");
	}
	/**
	 * DB connection is closed
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	/**
	 * This method returns the data wrt to column index
	 * @param query
	 * @param Columnindex
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query, int Columnindex) throws Throwable
	{
		String valueString = null;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			result.getString(Columnindex);
		}
		return valueString;
	}
		
		
	}


