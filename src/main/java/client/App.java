package client;

import java.util.Scanner;

import dao.BookDao;
import dao.BookDaoImplementation;
import domain.Book;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDao bd = new BookDaoImplementation();
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		do {
			System.out.println("********** MENU **********");
			System.out.println("1 - Create");
			System.out.println("2 - Read all books");
			System.out.println("3 - Read by Id");
			System.out.println("4 - Update a book");
			System.out.println("5 - Delete a book");
			System.out.println("6 - Exit");
			System.out.println("Enter your choice :");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1 : 
				System.out.println("Enter the book details :  ");
				System.out.println("Enter title : ");
				String name = sc.next();
				
				System.out.println("Enter price of the book");
				int price = sc.nextInt();
				
				Book book = new Book(name,price);
				bd.create(book);
				System.out.println("Book created successfully!");
				break;
				
			case 2 :
				
				System.out.println("Book details : ");
				for (Book b : bd.readAll()) {
			        System.out.println(b);
			    }
			    break;
				
			case 3 :
				System.out.println("Enter the id of the book you would like to read : ");
				int id = sc.nextInt();
				Book bookById = bd.readById(id);
			    if (bookById != null) {
			        System.out.println("Book details : " + bookById);
			    } else {
			        System.out.println("Book with ID " + id + " not found.");
			    }
			    break;
				
			case 4 :
				
				System.out.println("Enter the id of the book you would like to update : ");
				int id1 = sc.nextInt();
				
			    Book bookToUpdate = bd.readById(id1);
			    
			    
			    if (bookToUpdate != null) {
			        System.out.println("Enter new title for the book:");
			        String newTitle = sc.next();
			        
			        System.out.println("Enter new price for the book:");
			        int newPrice = sc.nextInt();
			        
			        
			        bookToUpdate.setName(newTitle);
			        bookToUpdate.setPrice(newPrice);
			        
			        
			        bd.update(bookToUpdate);
			        
			        System.out.println("Book record updated successfully");
			        System.out.println("Updated record : ");
			        
			        System.out.println(bookToUpdate);
			    } else {
			        System.out.println("Book with ID " + id1 + " not found.");
			    }
			    break;
			    
//				bd.update(book);
//				System.out.println("Book record updated successfully");
//				System.out.println("Updated record : ");
//				bd.readAll();
//				break;
				
			case 5 :
				System.out.println("Enter the id of the book needed to delete");
				int id2=sc.nextInt();
				Book bookToDelete = bd.readById(id2);
			    
			   
			    if (bookToDelete != null) {
			        
			        bd.delete(bookToDelete);
			        System.out.println("Book deleted successfully.");
			    } else {
			        System.out.println("Book with ID " + id2 + " not found.");
			    }
			    break;
				
//				bd.delete(book);
//				break;
				
			case 6 :
				System.out.println("Exiting...");
				break;
				
			default :
				System.out.println("Invalid input of choice !!");
				break;
			}
			
		}while(choice!=6);
				
		sc.close();
	}

}
