import java.util.*;
class LibraryTester
{

public static void main(String args[]){
		
System.out.println("Enter No of Books");
Scanner sc=new Scanner(System.in);
int size=sc.nextInt();
Library lib=new Library(size);
		
for(int i=0;i<size;i++){
	BookDTO book=new BookDTO();
        System.out.println("Enter the Books details");
				
        System.out.println("Enter the book id ");
	int bookId=sc.nextInt();
        book.setBookId(bookId);
				
	System.out.println("Enter the book name");
	String bookName=sc.next();
	book.setBookName(bookName);
				
	System.out.println("Enter the Author name");
	String authorName=sc.next();
	book.setAuthorName(authorName);
				
	System.out.println("Enter the publisher name");
	String publisher=sc.next();
	book.setPublisher(publisher);
				
	System.out.println("Enter the Book price");
	double price=sc.nextLong();
        book.setPrice(price);
				
	System.out.println("Enter the No of pages");
	int pages=sc.nextInt();
	book.setNoOfPages(pages);
				
	System.out.println("Enter the Edition of book");
	int edition=sc.nextInt();
	book.setEdition(edition);
				
	boolean isAdded=lib.createBooksDetails(book);
        System.out.println(isAdded);
}
			

lib.getAllBooks();
			
System.out.println("Enter the book id to get Book details");
int id=sc.nextInt();
System.out.println(lib.getBookById(id));
			
System.out.println("Enter the author name to get Book name");
String aut=sc.next();
System.out.println(lib.getBookByAuthorName(aut));
			
System.out.println("Enter the book name to publisher");
String pub=sc.next();
System.out.println(lib.getBookByPublisherName(pub));
			
System.out.println("Enter the Price to get author name");
double price=sc.nextDouble();
System.out.println(lib.getBookByPrice(price));
			
System.out.println("Enter the Publisher to get edition of the book");
String publisher=sc.next();
System.out.println(lib.getEditionByPublisherName(publisher));
			
System.out.println("Enter Book id and Author Name to update");
int bookId=sc.nextInt();
String author=sc.next();
			
lib.updateAuthorNameByBookId(author,bookId);
			
lib.getAllBooks();
			
System.out.println("Enter book Name to delete");
String name=sc.next();
lib.deleteBookByName(name);
			
lib.getAllBooks();
		
		
	}
}