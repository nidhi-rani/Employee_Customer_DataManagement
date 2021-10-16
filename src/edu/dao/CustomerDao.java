package edu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.dto.CustomerDto;
import edu.util.DBUtil;
import java.sql.Connection;

public class CustomerDao {
     public boolean insertCustomer(CustomerDto cust) {
    	 boolean status=false;
    	 try {
    		 Connection con=DBUtil.connect();
    	     String query="INSERT INTO Customer(accno,cname,email,balance) VALUES(?,?,?,?)";
    	     PreparedStatement ps=con.prepareStatement(query);
    	     ps.setInt(1,cust.getAccno());
    	     ps.setString(2,cust.getCname());
    	     ps.setString(3,cust.getEmail());
    	     ps.setInt(4, cust.getBalance());
    	     ps.executeUpdate();
    	     status=true;
    	 }catch(Exception e) {
    		System.out.println("CustomerDao.insertCustomer(): "+e); 
    	 }
    	 return status;
     }
     public boolean deleteCustomer(int accno) {
    	 boolean status=false;
    	 try {
    		 Connection con=DBUtil.connect();
    		 String query="DELETE FROM Customer WHERE accno=?";
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ps.setInt(1, accno);
    		 ps.executeUpdate();
    		 status=true;
    	 }catch(Exception e) {
    		 System.out.println("CustomerDao.deleteCustomer(): "+e);
    	 }
    	 return status;
     }
     public CustomerDto selectCustomer(int accno) {
    	 CustomerDto c=null;
    	 try {
    		 Connection con=DBUtil.connect();
    		 String query="SELECT * FROM Customer WHERE accno=?";
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ps.setInt(1, accno);
    		 ResultSet rs=ps.executeQuery();
    		 if(rs.next()) {
    			 c=new CustomerDto();
    			 c.setAccno(rs.getInt(1));
    			 c.setCname(rs.getString(2));
    			 c.setEmail(rs.getString(3));
    			 c.setBalance(rs.getInt(4));
    		 }
    	 }catch(Exception exc) {
    		 System.out.println("CustomerDao.selectCustomer():"+exc);
    	 }
    	 return c;
     }
     public ArrayList<CustomerDto> selectAllCustomer(){
    	 CustomerDto c=null;
    	 ArrayList<CustomerDto> list=new ArrayList<CustomerDto>();
    	 try {
    		 Connection con=DBUtil.connect();
    		 String query="SELECT * FROM Customer";
    		 PreparedStatement ps=con.prepareStatement(query);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next()) {
    			 c=new CustomerDto();
    			 c.setAccno(rs.getInt(1));
    			 c.setCname(rs.getString(2));
    			 c.setEmail(rs.getString(3));
    			 c.setBalance(rs.getInt(4)); 
    			 list.add(c);
    		 }
    	 }catch(Exception exc) {
    		 System.out.println("CustomerDao.selectAllCustomer():"+exc);
    	 }
    	 return list;
     }
     public boolean updateCustomer(CustomerDto cust) {
    	 boolean flag=false;
    	 String query="UPDATE customer SET cname=? ,email=? ,balance=? WHERE accno=?";
    	 Connection con=null;
    	 PreparedStatement ps=null;
    	 try {
    		 con=DBUtil.connect();
    		 ps=con.prepareStatement(query);
    		 ps.setString(1, cust.getCname());
    		 ps.setString(2, cust.getEmail());
    		 ps.setInt(3,cust.getBalance());
    		 ps.setInt(4, cust.getAccno());
    		 if(ps.executeUpdate()>0) {
    			 flag=true;
    		 }
    	 }catch(Exception exc) {
    		 System.out.println("CustomerDao.updateCustomer():"+exc);
    	 }
    	 return flag;
     }
}
