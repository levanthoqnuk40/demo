package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;


public class AccountDAO{
	Connection conn=null;//ket noi toi sql server
	PreparedStatement ps=null;//dua cau lenh sql tu ide sang sql server
	ResultSet rs=null;//nhan ket qua tra ve
	
	public List<Account> getListAccount() {
		try {
			String query="select * from account";
			conn =new DBContext().getConnection();//mo ket noi toi sql server
			ps =conn.prepareStatement(query);//dua cau lenh cao sql server
			rs=ps.executeQuery();//thuc thi sql va nhan ket qua tra ve
			
			List<Account> list=new ArrayList<>();
			while (rs.next()) {
				Account a=new Account(rs.getString(1),rs.getString(2));
				list.add(a);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

