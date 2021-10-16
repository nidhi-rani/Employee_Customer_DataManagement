package edu.dao;

import edu.dto.EmployeeDto;

import edu.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EmployeeDao {
   public boolean insertEmployee(EmployeeDto emp) {
	   boolean status=false;
	   try {
		 Connection con=DBUtil.connect();
		 String query="INSERT INTO Employee(eid,ename,salary,deptno) VALUES(?,?,?,?)";
		 PreparedStatement ps=con.prepareStatement(query);
		 ps.setInt(1,emp.getEid());
		 ps.setString(2,emp.getEname());
		 ps.setDouble(3,emp.getSalary());
		 ps.setString(4,emp.getDeptno());
		 ps.executeUpdate();
		 status=true;
	   }catch(Exception e) {
		   System.out.println("EmployeeDao.insertEmployee():" +e);
	   }
	   return status;
   }
    public boolean deleteEmployee(int eid) {
    	boolean status=false;
    	try {
    		Connection con=DBUtil.connect();
    		String query="DELETE FROM Employee WHERE eid=?";
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setInt(1,eid);
    		ps.executeUpdate();
    		status=true;
    	}catch(Exception e) {
    		System.out.println("EnployeeDao.deleteEmployee():"+e);
    	}
    	return status;
    }
    public EmployeeDto selectEmployee(int eid) {
    	EmployeeDto e=null;
    	try {
    		Connection con=DBUtil.connect();
    		String query="SELECT * FROM Employee WHERE eid=?";
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setInt(1,eid);
    		ResultSet rs=ps.executeQuery();
            if(rs.next()) {
            	e=new EmployeeDto();
            	e.setEid(rs.getInt(1));
            	e.setEname(rs.getString(2));
            	e.setSalary(rs.getDouble(3));
            	e.setDeptno(rs.getString(4));
            }
    	}catch(Exception exc){
        	System.out.println("EmployeeDao.selectEmployee():"+e);
        }
        return e;
    }
    public ArrayList<EmployeeDto> selectAllEmployee(){
    	EmployeeDto e=null;
    	ArrayList<EmployeeDto> list=new ArrayList<EmployeeDto>();
    	try {
    		Connection con=DBUtil.connect();
    		String query="SELECT * FROM Employee";
    		PreparedStatement ps=con.prepareStatement(query);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()) {
    			e=new EmployeeDto();
    			e.setEid(rs.getInt(1));
            	e.setEname(rs.getString(2));
            	e.setSalary(rs.getDouble(3));
            	e.setDeptno(rs.getString(4));
            	list.add(e);
    		}
    	}catch(Exception exc) {
    		System.out.println("EmployeeDao.selectAllEmployee():"+e);
    	}
    	return list;
    }
    public boolean updateEmployee(EmployeeDto  edto) {
    	boolean flag=false;
    	String query="UPDATE Employee SET ename=?,salary=?,deptno=? WHERE eid=?";
    	Connection con=null;
    	PreparedStatement ps=null;
    	try {
    		con=DBUtil.connect();
    		ps=con.prepareStatement(query);
    		ps.setString(1,edto.getEname());
    		ps.setDouble(2,edto.getSalary());
    		ps.setString(3,edto.getDeptno());
    		ps.setInt(4, edto.getEid());
    		if(ps.executeUpdate()>0)
    			flag=true;
    	}catch(Exception exc){
    		System.out.println("EmployeeDao.updateEmployee():"+exc);
    	}
    	return flag;
    }
}
