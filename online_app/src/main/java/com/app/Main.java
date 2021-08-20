package com.app;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import com.app.dao.OrderDAO;
import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.OrderDAOImpl;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.model.Product;

import org.apache.log4j.Logger;
import com.app.exception.BusinessException;
import com.app.dao.LoginValidation;
import com.app.dao.CartDAO;
import com.app.dao.impl.CartDAOImpl;
import com.app.dao.CustomerRegDAO;
import com.app.dao.impl.LoginValidationImpl;
import com.app.dao.impl.CustomerRegDAOImpl;
import com.app.model.Customer;
import com.app.model.Order;
import com.app.model.Cart;
import com.app.dao.EmployeeDAO;
import com.app.dao.impl.EmployeeDAOImpl;
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
				log.info("login successfull");
				int CHOICE=0;
				do {
					log.info("-------------------------");
					log.info("1) Add product");
					log.info("2)view products");
					log.info("3)exit");
					try {
						CHOICE = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {

					}
					switch(CHOICE) {
					case 1:	log.info("Adding Products");
					EmployeeDAO employeeDAO = new EmployeeDAOImpl();
					Product product = new Product();

					log.info("Enter Product Id");
					int product_id = Integer.parseInt(scanner.nextLine());
					product.setProduct_id(product_id);
					log.info("Enter product_name");
					String product_name = scanner.nextLine();
					product.setProduct_name(product_name);
					log.info("Enter price");
					Double price=Double.parseDouble(scanner.nextLine());
					product.setPrice(price);
					log.info("enter quantity");
					Float quantity=Float.parseFloat(scanner.nextLine());
					product.setQuantity(quantity);
					log.info(" enter rating");
					Float rating=Float.parseFloat(scanner.nextLine());
					product.setRating(rating);
					log.info("enter Category");
					String category = scanner.nextLine();
					product.setCategory(category);
					try {
						if (employeeDAO.Addproduct(product)== 1) {
							log.info("Products Added  with below details successfully");
							log.info(product);
						}
					} catch (BusinessException e) {
						System.out.println(e.getMessage());
					}
					

			
						break;
					case 2:log.info("displaying all products");
						ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
					try {
						List<Product> productList=productSearchDAO.getAllProducts();
						for(Product product1:productList) {
							log.info(product1);
						}
					} catch (BusinessException e) {
						log.warn(e.getMessage());
					}
						
						break;
					case 3:log.info("THANK YOU");
						break;
					default: 
						log.warn("Invalid choice.....choice shoulde be between 1 -3 only!!1");
						break;
					}
				}while(CHOICE!=3);

				break;
			case 2:
				log.info("WELCOME TO CUSTOMER PAGE");
				log.info("**------------***-------------**");
				log.info("\n Enter your Email:");
				String email = scanner.nextLine();
				LoginValidation a = new LoginValidationImpl();
				Customer customer1 = new Customer();
				customer1 = a.isValidUser(email);
				 int id = customer1.getId();
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
					log.info("---------------------");
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
							log.info("1)Displaying all the products");
							log.info("2)By product_id");
							log.info("3)By product_name ");
							log.info("4)By price ");
							log.info("5)By quantity ");
							log.info("6)By rating ");
							log.info("7)By category");
							log.info("8)viewcart");
							log.info("9)logout");
							log.info("-----------------------");
							log.info("Enter ur choice");
							try {
								choice = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {

							}
							switch (choice) {
							case 1:ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();

							try {
								List<Product> productList=productSearchDAO.getAllProducts();
								for(Product product:productList) {
									log.info(product);
								}
							} catch (BusinessException e) {
								log.warn(e.getMessage());
							}
								break;

							case 2:
								log.info("Enter prouct id to get product details");
								log.info("----------------------------------------------");
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
							case 3:
								log.info("Enter the name to get the Product details");
								log.info("----------------------------------------------");
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
							case 4:
								log.info("Enter the price to get the Product details");
								log.info("----------------------------------------------");
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
							case 5:
								log.info("Enter the quantity to get the Product details");
								log.info("----------------------------------------------");
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
							case 6:
								log.info("Enter the rating to get the Product details");
								log.info("----------------------------------------------");
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
							case 7:
								log.info("Enter the category to get the Product details");
								log.info("----------------------------------------------");
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

							case 8:
								log.info("View Your Cart");
								log.info("------------------");
								int op = 0;
								CartDAO cartDAO = new CartDAOImpl();
								do {

									log.info("1)Add to Cart ");
									log.info("2)view Cart");
									log.info("3)Exit");

									log.info("---------------------");
									try {
										op = Integer.parseInt(scanner.nextLine());
									} catch (NumberFormatException e) {

									}

									switch (op) {
									case 1:
										log.info("Enter Product Id Inorder to ADD to cart");
										int product_id = Integer.parseInt(scanner.nextLine());
										try {
											Product product = productSearchService.getProductByProduct_id(product_id);
											if (cartDAO.addcart(id, product_id) == 1) {
												log.info("Product added to cart successfully");
												log.info(product);

											}
										} catch (BusinessException e) {
											System.out.println(e.getMessage());
										}break;
									case 2:
										log.info("Enter Customer Id to view items in the cart");
										int id1=Integer.parseInt(scanner.nextLine());
										try {
										List<Product> product=cartDAO.getAllItemsIncart(id);
										log.info(id);
										if(product !=null && product.size()>0) {
											log.info("Items in the cart are :");
											for(Product c : product) {
												log.info(c);
											}
										}
										else {
											log.info("SORRY!! No items in your cart .....Keep shopping");
										}
										}
										catch (BusinessException e) {
											log.warn(e.getMessage());
										}
										
									default:
										log.warn("Invalid choice...choice should be only number between 1-3 only");

										break;
									}
								} while (op != 3);
							case 9:
								log.info("Logout");

								break;
							default:
								log.warn("Invalid choice ...choice should be only number between 1-9 only");
								break;
							}
						} while (choice != 9);

						break;

					case 2:
						log.info("   Orders    ");
						log.info("-----------------");
						int OPTION=0;
						do {
							log.info("Display orders");
							log.info("place order");
							log.info("Exit");
							try {
							OPTION = Integer.parseInt(scanner.nextLine());
							} catch (NumberFormatException e) {

							}
							switch (OPTION) {

							case 1:
								OrderDAO orderDAO=new OrderDAOImpl();
								try {
									List<Order> orderList=orderDAO.displayOrder();
									for(Order order:orderList) {
										log.info(order);
									}
								} catch (BusinessException e) {
									log.warn(e.getMessage());
								}
								break;
							case 2:
								CartDAO cartDAO=new CartDAOImpl();
								List<Product> product=new ArrayList();
								product=cartDAO.getAllItemsIncart(id);
								log.info("enter customer id");
								int id1=Integer.parseInt(scanner.nextLine());
								OrderDAO orderDAO1=new OrderDAOImpl();
								double n = orderDAO1.placingOrder(product,id1);
								if(n!=0) {
									log.info("placing your order");
									log.info("Total cost:"+n);
								
								}else {
									log.info("no items in cart.....Keep shopping");
								}
								break;
							case 3:log.info("exit");
								break;
							default:
									break;
							}
						}while(OPTION!=3);
						break;
					case 3:
						log.info("Thank you !!!");
						break;
					default:
						log.warn("Invalid choice... Choice should be only number between 1-3 only ");
						break;
					}
				} while (option != 3);

				break;
			case 3:
				CustomerRegDAO customerRegDAO = new CustomerRegDAOImpl();
				Customer customer = new Customer();

				log.info("Enter Id");
				int Id = Integer.parseInt(scanner.nextLine());
				customer.setId(Id);
				log.info("Enter Firstname");
				String firstname = scanner.nextLine();
				customer.setFirstname(firstname);
				log.info("Enter Lastname");
				String lastname = scanner.nextLine();
				customer.setLastname(lastname);
				log.info("Enter EmailId");
				String emailid = scanner.nextLine();
				customer.setEmail(emailid);
				log.info("Enter Password");
				String Password = scanner.nextLine();
				customer.setPassword(Password);

				try {
					if (customerRegDAO.createAccount(customer) == 1) {
						log.info("Customer registered with below details successfully");
						log.info(customer);
					}
				} catch (BusinessException e) {
					log.info(e);
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
