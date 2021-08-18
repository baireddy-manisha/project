package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.app.exception.BusinessException;
import com.app.dao.LoginValidation;
import com.app.dao.CustomerRegDAO;
import com.app.dao.impl.LoginValidationImpl;
import com.app.dao.impl.CustomerRegDAOImpl;
import com.app.model.Customer;
import com.app.model.Product;
import com.app.search.service.ProductSearchService;
import com.app.search.service.impl.ProductSearchServiceImpl;

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
				String Eusername = scanner.nextLine();
				log.info("\nEnter your password :");
				String Epassword = scanner.nextLine();

				break;
			case 2:
				log.info("WELCOME TO CUSTOMER PAGE");
				log.info("**------------***-------------**");
				log.info("\n Enter your Email:");
				String email = scanner.nextLine();
				LoginValidation a = new LoginValidationImpl();
				Customer customer1 = new Customer();
				customer1 = a.isValidUser(email);
				final int id = customer1.getId();
				log.info("\n Enter your password:");
				String password = scanner.nextLine();
				String b = customer1.getPassword();
				if (customer1.getPassword().equals(password)) 
					log.info("\n customer login successfull ");
					log.info("\n Welcome  " + customer1.getFirstname());
				int option = 0;
				do {
					log.info("---------------------");
					log.info("1)search product");
					log.info("2)view orders");
					log.info("3)Exit");
					log.info("enter ur choice");
					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {

					}

					switch (option) {
					case 1:
						int choice = 0;
						ProductSearchService productSearchService = new ProductSearchServiceImpl();
						do {
							log.info("Search Product Based on ");
							log.info("----------------------");
							log.info("1)By product_id");
							log.info("2)By product_name ");
							log.info("3)By price ");
							log.info("4)By quantity ");
							log.info("5)By rating ");
							log.info("6)By category");
							log.info("7)Previous menu");
							log.info("8)Logout");
							log.info("9)ViewCart");

							log.info("Enter ur choice");
							try {
								choice = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {

							}
							switch (choice) {

							case 1:
								log.info("Enter prouct id to get product details");
								try {
									int product_id = Integer.parseInt(scanner.nextLine());
									Product product = productSearchService.getProductByProduct_id(product_id);
									if (product != null) {
										log.info("Product with id " + product_id
												+ " found successfully... Below is the details");
										log.info(product);
									}
								} catch (NumberFormatException e) {
									log.warn("Product Id should be digit only... Try Again");
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 2:
								log.info("Enter the name to get the Product details");
								String product_name = scanner.nextLine();
								try {
									List<Product> productList = productSearchService
											.getProductByProduct_name(product_name);
									if (productList != null && productList.size() > 0) {
										log.info("Total there are " + productList.size() + " number of products with "
												+ product_name.toUpperCase());
										for (Product product : productList) {
											log.info(product);
										}
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 3:
								log.info("Enter the price to get the Product details");
								Double price = Double.parseDouble(scanner.nextLine());
								try {
									List<Product> productList = productSearchService.getProductByPrice(price);
									if (productList != null && productList.size() > 0) {
										log.info("Total there are " + productList.size() + " number of products with "
												+ price);
										for (Product product : productList) {
											log.info(product);
										}
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 4:
								log.info("Enter the quantity to get the Product details");
								float quantity = Integer.parseInt(scanner.nextLine());
								try {
									List<Product> productList = productSearchService.getProductByQuantity(quantity);
									if (productList != null && productList.size() > 0) {
										log.info("Total there are " + productList.size() + " number of products with "
												+ quantity);
										for (Product product : productList) {
											log.info(product);
										}
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 5:
								log.info("Enter the rating to get the Product details");
								float rating = Float.parseFloat(scanner.nextLine());
								try {
									List<Product> productList = productSearchService.getProductByRating(rating);
									if (productList != null && productList.size() > 0) {
										log.info("Total there are " + productList.size() + " number of products with "
												+ rating);
										for (Product product : productList) {
											log.info(product);
										}
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 6:
								log.info("Enter the category to get the Product details");
								String category = scanner.nextLine();
								try {
									List<Product> productList = productSearchService.getProductByCategory(category);
									if (productList != null && productList.size() > 0) {
										log.info("Total there are " + productList.size() + " number of products with "
												+ category);
										for (Product product : productList) {
											log.info(product);
										}
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 7:
								log.info("\n\nGO BACK TO MAIN MENU......\n\n");
								break;
							case 8:
								break;
							case 9:
								break;
							default:
								log.warn("Invalid choice ...choice should be only number between 1-9 only");
								break;
							}
						} while (choice != 9);

						break;
				
					case 2:
						break;
					case 3:
						break;
					default:
						log.warn("Invalid choice... Choice should be only number between 1-3 only ");
						break;
					}
				} while (option != 3);

				break;
			case 3:
				CustomerRegDAO customerRegDAO = new CustomerRegDAOImpl();
				Customer customer = new Customer(105, "shoba", "baireddy", "shobabaireddy@gmail.com", "shoba");
				try {
					if (customerRegDAO.createAccount(customer) == 1) {
						System.out.println("Customer registered with below details successfully");
						System.out.println(customer);
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				log.info("");

				break;
			case 4:
				log.info("Thanks for using this APP we will see you soon.... ");

				break;
			default:
				log.warn("Invalid choice... Choice should be only number between 1-4 only ");
				break;
			}
		} while (ch != 4);

	}

}
