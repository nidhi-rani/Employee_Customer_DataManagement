package edu.test;

import java.util.ArrayList;
import java.util.Scanner;

import edu.dao.EmployeeDao;
import edu.dto.EmployeeDto;

public class EmployeeTest {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		EmployeeDao empDao = new EmployeeDao();
		String flag="";
		int choice;
		int eid;
		String ename;
		double salary;
		String deptno;
		while (true) {
			System.out.println("1. INSERT EMPLOYEE");
			System.out.println("2. DELETE EMPLOYEE");
			System.out.println("3. SELECT GIVEN EMPLOYEE");
			System.out.println("4. SELECT ALL EMPLOYEE");
			System.out.println("5.UPDATE EMPLOYEE");
			System.out.println("Enter your choice");
			
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter emp id");
				eid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter emp name");
				ename = sc.nextLine();
				System.out.println("Enter emp salary");
				salary = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter dept no");
				deptno = sc.nextLine();
				EmployeeDto empDto = new EmployeeDto();
				empDto.setEid(eid);
				empDto.setEname(ename);
				empDto.setSalary(salary);
				empDto.setDeptno(deptno);

				if (empDao.insertEmployee(empDto))
					System.out.println("Employee registered successfully!");
				else
					System.out.println("Failed to register new employee");
				break;
			case 2:
				System.out.println("Enter emp id");
				eid = sc.nextInt();
				sc.nextLine();
				if (empDao.deleteEmployee(eid))
					System.out.println("Employee deregistered successfully!");
				else
					System.out
							.println("Failed to deregistering existing employee");
				break;
			case 3:
				System.out.println("Enter emp id");
				eid = sc.nextInt();
				sc.nextLine();
				EmployeeDto emp = empDao.selectEmployee(eid);
				System.out.println(emp);
				break;
			case 4:
				ArrayList<EmployeeDto> emps = empDao.selectAllEmployee();
				if(emps.size()==0)
					System.out.println("No employee found!");
				else{
					System.out.println("Display All Employee Details");
					for(EmployeeDto e:emps)
						System.out.println(e);
				}
				break;
			case 5:
				System.out.println("Enter Employee id");
				eid=sc.nextInt();
				sc.nextLine();
				emp=empDao.selectEmployee(eid);
				System.out.println(emp);
				System.out.println("Do you want to change name(yes/no)");
				flag=sc.nextLine();
				if(flag.equalsIgnoreCase("yes")) {
					System.out.println("Enter new name");
					emp.setEname(sc.nextLine());
					sc.nextLine();
				}
				System.out.println("Do you want to change salary(yes/no)");
				flag=sc.nextLine();
				if(flag.equalsIgnoreCase("yes")) {
					System.out.println("Enter new salary");
					emp.setSalary(sc.nextInt());
					sc.nextLine();
				}
				System.out.println("Do you want to change dept(yes/no)");
				flag=sc.nextLine();
				if(flag.equalsIgnoreCase("yes")) {
					System.out.println("Enter new department id");
					emp.setDeptno(sc.nextLine());
				}
				if(empDao.updateEmployee(emp)){
					System.out.println("Employee datails updated successfully");
					System.out.println(emp);
				}else {
					System.out.println("Failed to update employee details");
				}
			default:
				System.exit(1);
			}
          sc.close();
		}
	}
}
