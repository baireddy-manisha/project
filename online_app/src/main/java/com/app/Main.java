package com.app;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.app.exception.BusinessException;
import com.app.dao.LoginValidation;
import com.app.dao.impl.LoginValidationImpl;
import com.app.model.Customer;


public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) throws BusinessException {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to Console Based Online App");
		log.info("------------------------------------");

		int ch = 0;
		do {
			log.info("\n Main Menu");
			log.info("1)Login As Employee");
			log.info("2)Login As Customer");
			log.info("3)Register Customer");
			log.info("4)EXIT");
			log.info("Please enter your choice(1-4)");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			
			}
			switch (ch) {
			case 1:
				log.info("WELCOME TO EMPLOYEE LOGIN PAGE");
				log.info("**------------***-------------**");
				log.info("\nEnter your UserName/Email :");
				String Eusername=scanner.nextLine();
				log.info("\nEnter your password :");
				String Epassword=scanner.nextLine();
				
				break;
			case 2:
				log.info("WELCOME TO CUSTOMER PAGE");
				log.info("**------------***-------------**");
				log.info("/n Enter your Email:");
				String email=scanner.nextLine();
				LoginValidation a=new LoginValidationImpl();
			    Customer customer1=new Customer();
			    customer1=a.isValidUser(email);
			    final int id=customer1.getId();
				log.info("\n Enter your password:");
				String password=scanner.nextLine();
				String b=customer1.getPassword();
				if(customer1.getPassword().equals(password)) {
					log.info("\n customer login successfull ");
					log.info("\n Welcome"+customer1.getFirstname());
					int option=0;
					do
					 {
						log.info("---------------------");
						log.info("1)search product"       );
						log.info("2)view orders"        );
						log.info("3)Exit"               );
						log.info("enter ur choice");
						try {
							ch = Integer.parseInt(scanner.nextLine());
						} catch (NumberFormatException e) {
						
						}
						switch (option) {
						case 1:
							break;
						case 2:
							break;
						case 3:
							break;
						default:
							log.warn("Invalid choice... Choice should be only number between 1-3 only ");
							break;
						}
					 }while(option!=3);
				        break;
				}
			case 3:
				log.info("");

				break;
			case 4:
				log.info("Thanks for using this APP we will see you soon :) ");

				break;
		default:
			log.warn("Invalid choice... Choice should be only number between 1-4 only ");
			break;
			}
	} while (ch != 4);
		
		}

}


