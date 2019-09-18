package com.internousdev.webproj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnecter;

public class HelloStrutsDAO {

	public boolean select() {


	boolean ret = false;
	DBConnecter db = new DBConnecter();
	Connection con = db.getConnection();
	String sql = "select * from users";

	if(con==null){
		System.out.println("conヌルだよー");
	}

	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			ret = true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return ret;
}
}