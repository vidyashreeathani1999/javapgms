class AmezonPrime{

static String movies[]={"Shershah","Cindrella","RakthaCharitra","Jaathi Rathnalu","Robert","KGF2","Yuvarathna","Master"};
static String series[]={"Mizapur","The Family Man","Four more shots","Vampire Diaries","Mumbai Diaries","Originals","The last ship","Inside edges"};


static String movie="Dia";

	public static void main(String a[]){
	System.out.println("Main method started");
	getMovies(movies);
	getSeries(series);
	String mov=getMovies(movie);
	System.out.println(mov);
	
	}

	public static void getMovies(String[] movies){
	System.out.println("Inside the getmovies method with string array parameter");
	for(int i=0;i<movies.length;i++)
	System.out.println(movies[i]);

	}
	

	public static String getMovies(String movies){
	System.out.println("Inside the get movies method");
	return movie;

	}




public static void getSeries(String []Series){
System.out.println("Inside the getseries method with string array parameter");
for(int i=0;i<series.length;i++)
System.out.println(series[i]);
}

}