
class Library
{
public BookDTO[] books;
private int index;
	
	
public Library(int size){
		books = new BookDTO[size];
	}
	
	
public boolean createBooksDetails(BookDTO books){
		boolean bookAdded=false;
		System.out.println("Inside createBook()");
		if(books!=null){
			this.books[index++]=books;
			bookAdded=true;
		}
		else{
			System.out.println("No books added");
			return bookAdded=false;
		}
		return bookAdded;
	}
	
	
public void getAllBooks()
	{
		for(int i=0; i<books.length; i++)
		{
			System.out.println(books[i]);
		}
	
	}
	

public BookDTO getBookById(int bookId){
		BookDTO bookDTO=null;
		System.out.println("Inside getBookById()");
		if(bookId!=0){
			for(int i=0;i<books.length; i++){
				if(books[i].getBookId()==(bookId)){
					System.out.println("Book found by bookId:"+bookId);
					bookDTO =books[i];
				}
				
				}
			}
                    else{
				System.out.println("Book not found by bookId"+bookId);
			}
		return bookDTO;
}


public String getBookByAuthorName(String authorName){
		System.out.println("Inside Get book name by author method");
		String bookName=null;
		if(authorName!= null)
		{
			for(int i=0; i<books.length; i++)
			{
				if(books[i].getAuthorName().equals(authorName))
				{
                                      System.out.println("Author is found by:"+authorName);
					authorName=books[i].getAuthorName();
					}
			}
		}
				else{
				System.out.println("author is not found by:"+authorName);
			}
		return authorName;
	}



public String getBookByPublisherName(String publisher){
		System.out.println("Inside getBookByPublisherName()");
		String bookName=null;
		if(publisher != null){
			for(int i=0; i<books.length; i++){
				if(books[i].getBookName().equals(bookName)){
					bookName=books[i].getBookName();
				System.out.println("Publisher name is found by:"+publisher);
			}
	}
}
			else
			{
				System.out.println("Publisher name is not found by:"+publisher);
			
		}
		return publisher;
	}



	

public double getBookByPrice(double price){
		String  bookName=null;
		System.out.println("Inside getBookByPrice()");
		
		if(price!=0d){
			for(int i=0; i<books.length; i++){
				if(books[i].getPrice()==(price)){
					System.out.println("Book is found by a price:"+price);
				 price=books[i].getPrice();
			}
		}
	}
	else{
				System.out.println("Book is not found  a price"+price);
			}
		return price;
	}




public String getEditionByPublisherName(String publisher){
             String edition=null;
		System.out.println("Inside getEditionByPublisherName()");
		if(publisher != null){
			for(int i=0; i<books.length; i++){
				if(books[i].getPublisher()==(publisher)){
			System.out.println("Publisher is found by:"+publisher);
                    publisher=books[i].getPublisher();
				}
			}
		}
else{
		System.out.println("Publisher is not found"+publisher);
		}
		return publisher; 
	}

	


public void updateAuthorNameByBookId(String authorName, int bookId){	
		System.out.println("Inside updateAuthorNameByBookId()");
		BookDTO bookDTO=null;
		if(authorName!=null && bookId>0)
		{
			for(int i=0; i<books.length; i++)
			{
				if(books[i].getBookId()==(bookId))
				{
					System.out.println("Author name updated by : "+authorName);
					books[i].setAuthorName(authorName);
					}
				}
			}
			else{
		
				System.out.println("Author name is not updated");
                                 
			}
 
		

}
		

public  void deleteBookByName(String bookName){
		System.out.println("Inside deleteBookByName()");
		if(bookName!=null){
			for(int i=0; i<books.length; i++){
					if(books[i].getBookName()==(bookName))
				{
					System.out.println("Book deleted by name: "+bookName);
					books[i].setBookName(bookName);
				}
			}
		}
else{
		System.out.println("Book is not deleted");
		}
		
	}
}