package edu.test;

import java.util.ArrayList;
import java.util.Scanner;
import edu.dao.CustomerDao;
import edu.dto.CustomerDto;
import edu.dto.EmployeeDto;

public class CustomerTest {
		public static void main(String []args) {
			Scanner sc=new Scanner(System.in);
			CustomerDao custDao=new CustomerDao();
			String flag="";
			int accno;
			String cname;
			String email;
			int balance;
			int choice;
			while(true) {
				System.out.println("1.INSERT CUSTOMER");
				System.out.println("2.DELETE CUSTOMER");
				System.out.println("3.SELECT CUSTOMER");
				System.out.println("4.SELECT ALL CUSTOMER");
				System.out.println("5.UPDATE CUSTOMER DETAILS");
				System.out.println("Select Choice");
				CustomerDto cus=null;
				choice=sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1:
					System.out.println("Enter customer accno");
					accno=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter customer name");
					cname=sc.nextLine();
					sc.nextLine();
					System.out.println("Enter customer email");
					email=sc.nextLine();
					sc.nextLine();
					System.out.println("Enter customer balance");
					balance=sc.nextInt();
					sc.nextLine();
					cus=new CustomerDto();
					cus.setAccno(accno);
				    cus.setCname(cname);
					cus.setEmail(email);
				    cus.setBalance(balance);
					if(custDao.insertCustomer(cus))
						System.out.println("Customer registered successfully!");
					else
						System.out.println("Failed to register!");
					break;
				case 2:
					System.out.println("Enter customer accno");
					accno=sc.nextInt();
					sc.nextLine();
					if(custDao.deleteCustomer(accno))
						System.out.println("Customer deleted successfully");
					else
						System.out.println("Failed to delete");
					break;
				case 3:
					System.out.println("Enter Customer accno");
					accno=sc.nextInt();
					sc.nextLine();
				    cus=custDao.selectCustomer(accno);
					System.out.println(cus);
					break;
				case 4:
					System.out.println("Display All Customer Details");
					ArrayList<CustomerDto> custs=custDao.selectAllCustomer();
					if(custs.size()==0)
						System.out.println("No Employee Found");
					else {
						for(CustomerDto c:custs)
							System.out.println(c);
					}
					break;
				case 5:
					System.out.println("Enter Customer accno");
				    accno=sc.nextInt();
					sc.nextLine();
					cus=custDao.selectCustomer(accno);
					System.out.println(cus);
					System.out.println("Do you want to change Customer name(yes/no)");
					flag=sc.nextLine();
					if(flag.equalsIgnoreCase("yes")) {
						System.out.println("Enter new Customer name");
						cus.setCname(sc.nextLine());
						sc.nextLine();
					}
					System.out.println("Do you want to change email(yes/no)");
					flag=sc.nextLine();
					if(flag.equalsIgnoreCase("yes")) {
						System.out.println("Enter new email");
						cus.setEmail(sc.nextLine());
						sc.nextLine();
					}
					System.out.println("Do you want to change balance(yes/no)");
					flag=sc.nextLine();
					if(flag.equalsIgnoreCase("yes")) {
						System.out.println("Enter new balance");
						cus.setBalance(sc.nextInt());
						sc.nextLine();
					}
					if(custDao.updateCustomer(cus)){
						System.out.println("Customer datails updated successfully");
						System.out.println(cus);
					}else {
						System.out.println("Failed to update employee details");
					}
					break;
				default:
					System.exit(choice);
					
				}
			}
		}

	}


