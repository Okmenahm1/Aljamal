// book class //
class Book {
    private String Author;
    private String Title;
    private String Publisher;
    private String  Language;                   //  Atributes  //
    private int Edition;
    private boolean Borrow;


    // No argument constructor //
   public Book(){

        this.Author = "Matt Bishop";
        this.Title = "Computer security";
        this.Publisher = "Addison-Wesley Professional";
        this.Language = "English";
        this.Edition = 2;
        this.Borrow = false;



   }

    // constructors with argument //
    public Book(String Title,String Author,String Publisher,String Language,int Edition){

        this.Author = Author;
        this.Title = Title;
        this.Publisher = Publisher;
        this.Language = Language;
        this.Edition = Edition;
        this.Borrow = false;


    }

// Geter and setter method //
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        this.Language = language;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        this.Publisher = publisher;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }



    public int getEdition() {
        return Edition;
    }

    public void setEdition(int edition) {
        this.Edition = edition;
    }


    public boolean isBorrow() {
        return Borrow;
    }

    public void setBorrow(boolean Borrow) {
       this.Borrow = Borrow;
    }

    // Method That return the default values //
    @Override
    public  String toString(){

        return ("Book Details:\n"+ "Author: " +Author+"  Title: "+Title+"  Publisher: "+Publisher+"  Language: "+Language+"  Edition: "+Edition);


    }


}



