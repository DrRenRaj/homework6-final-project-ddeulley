package hw6;
import java.util.ArrayList;
import java.util.Scanner;

//Delaney Deulley 5-13-25
//aa

class BookInfo{
	private String title;
	private String author;
	private String isbn;
	private boolean isAvailable;
	
	public BookInfo(String title, String author, String isbn, boolean isAvailable) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.isAvailable = true;	
	}
	//Get methods 
	public String getTitle(){
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getIsbn(){
		return isbn;
	}
	public boolean isAvailable(){
		return isAvailable;
	}
	public void setAvailable(boolean available){
		this.isAvailable = available;
	}
	
	
	//Displays book details 
	public String toString() {
		return title + " By: " + author + " ISBN: " + isbn;
	}
}

class Library{
	ArrayList<BookInfo> bookCatalog = new ArrayList<>();
	
	public Library() {
		bookCatalog.add(new BookInfo("Goodnight Moon", "Margaret Brown", "123",true));
		bookCatalog.add(new BookInfo("Pinkalicious", "Victoria Kann", "222",true));
		bookCatalog.add(new BookInfo("Corduroy", "Don Freeman", "333",true));
	}
	//Add Book Method
	public void addBook(BookInfo book) {
		bookCatalog.add(book);
	}
	
	//Removes Book by ISBN
	public void removeBook(String isbn) {
		for(BookInfo book : bookCatalog){
			if(book.getIsbn().equals(isbn)){
			bookCatalog.remove(book);
			System.out.println("Removing Book...");
			return;
			}
		}	
		System.out.println("Book not found.");
	}
	
	//Display all books 
	public void displayAllBooks() {
		for(BookInfo book : bookCatalog) {
			System.out.println(book);
		}
	}
	
	//Search by title
	public void searchTitle(String title){
		boolean found = false;
		for(BookInfo book : bookCatalog){
			if(book.getTitle().equalsIgnoreCase(title)) {
				found = true;
				System.out.println(book);
			}
		}
		if(!found){
			System.out.println("No book under that title!");
		}
	}
	//Search by author
	public void searchAuthor(String author){
		boolean found = false;
		for(BookInfo book : bookCatalog){
			if(book.getAuthor().equalsIgnoreCase(author)) {
				found = true;
				System.out.println(book);
			}
		}
		if(!found){
			System.out.println("No author under that name!");
		}
	}
	
	//check out book
	public void checkOutBook(String insb){
		for(BookInfo book : bookCatalog) {
			if(book.getIsbn().equals(insb)){
				if(book.isAvailable()){
					book.setAvailable(false);
					System.out.println("Renting " + book.getTitle() + "...");
				}
				else {
					System.out.println("The book: " + book.getTitle()+ " is currently unavailable.");
				}
				return;
			}
		}
		System.out.println("Book not found in system.");
	}
	
	//return book
	public void returnBook(String insb){
		for(BookInfo book : bookCatalog) {
			if(book.getIsbn().equals(insb)){
				if(book.isAvailable()){
					System.out.println("The book: " + book.getTitle()+ " is already available.");
				}
				else {
					book.setAvailable(true);
					System.out.println("Returning " + book.getTitle() + "...");
				}
				return;
			}
		}
		System.out.println("Book not found in system.");
	}
}


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Library library = new Library();
		
	while(true) {	
		System.out.println("=== Library Menu ===");
		System.out.println("1. Add Book");
		System.out.println("2. Remove Book");
		System.out.println("3. Display All Books");
		System.out.println("4. Search by Title");
		System.out.println("5. Search by Author");
		System.out.println("6. Check Out Book");
		System.out.println("7. Return Book");
		System.out.println("8. Exit");
		System.out.print("Choose an option (1-8): ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		//prints according response to user inputs
		
		//Adds book
		if(choice == 1) {
			System.out.println("Enter title: ");
			String title = scanner.nextLine();
			System.out.print("Enter author: ");
			String author = scanner.nextLine();
			System.out.print("Enter the ISBN: ");
			String isbn = scanner.nextLine();
		
			//this takes the users input and creates a book
			library.addBook(new BookInfo(title, author, isbn, true));
			}
		//Book removal
		else if(choice == 2) {
			System.out.println("Enter INBS to remove: ");
			library.removeBook(scanner.nextLine());
			}
		
		//prints all books
		else if (choice == 3) {
			library.displayAllBooks();
			}
		
		//Search for book using title
		else if (choice == 4) {
			System.out.print("Please enter a title to search: ");
			library.searchTitle(scanner.nextLine());
			}
		//Search for book using author
		else if (choice == 5) {
			System.out.print("Please enter authors name to search: ");
			library.searchAuthor(scanner.nextLine());
			}
		//Checks out book using isbn
		else if(choice == 6) {
			System.out.print("Please enter ISBN to check out: ");
			library.checkOutBook(scanner.nextLine());
			}
		//Returns book using isbn
		else if(choice == 7) {
			System.out.print("Please enter ISBN to return book: ");
			library.returnBook(scanner.nextLine());
			}
		//Exiting the system
		else if(choice == 8) {
			System.out.println("Exiting the system. Thank you!");
			System.exit(0);//ends the loop
			}
		else{//Output for invalid inputs from user
			System.out.println("Invalid input.");			
			}
		}
	}
}

