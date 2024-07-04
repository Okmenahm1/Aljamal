// Class Name library //

 class Library {
     private Book[] books;               // Arry its store to Book class //     // Atributes //
     private int booksnumber;            // Atributes //


     // constructer no Argument //
     Library() {

         books = new Book[30];      // Arrys that containg maxmuim 30 elemnts to store in //
         booksnumber = 0;             // to count the book in the library //

     }

     // Method To Add the books inside the library //
     public void newBook(Book book) {
// If Statment to check if the library is full or not // // to add more books //
         if (booksnumber < 30) {

             books[booksnumber] = book;
             booksnumber++;
             System.out.println("Book ("+book.getTitle()+") Has Been Added: ");    // using get method to get the titel from onther class //
         } else {                                                                 // showing the name of the books which has been added to the library //
             System.out.println("Unfortunately The Library Is Full You Cant Add More Books.");
         }
     }

     // Method to check if the book has been borrowed or not and if it's existed or not and  //
     public void borrow(String Title) {

         boolean getbook = false;                   // its the responsible to find the book if its inside the library or not //
         for (int i = 0; i < booksnumber; i++) {

             if (books[i].getTitle().contains(Title)) {

                 if (books[i].isBorrow()==false) {          // if the statement inside if is false then set borrow=true //
                     // if statements if you chose a book its will mark it as borrowed by make borrow= true //
                     books[i].setBorrow(true);
                     getbook = true;
                     System.out.println("You Borrow This Book: " + books[i].getTitle());
                     break;

                 } else {
                     System.out.println(books[i].getTitle()+"  not Available Yet.");    // if the user trying to borrow the same book its will print this statment //

                 }
             }
         }
         if (getbook==false) {                                            // if getbook= false then the book not inside the library //
             System.out.println("The Required Book Not In Library .");
         }
     }

// this method return the book if the book borrowed so it will return it to let the user borrow the book //
     public void returnBook(String Title){

         for (int i = 0; i < booksnumber; i++) {
             if (books[i].getTitle().contains(Title)) {
                 if (books[i].isBorrow()) {              // if is Borrow is true then set it false and mark the book as borrowed //
                     books[i].setBorrow(false);
                     System.out.println("Returned This Book: " + books[i].getTitle());
                 } else {                                                               // check if the book has been borrowed or not //
                     System.out.println("The book is  not borrowed");
                 }

             }
         }

     }
// method with no argument thats check if the library are empty or not and if its not empty show what books are available //
public void printAvailableBooks(){

// the booksnumber=0 it means that the library is empty there is no books //
    if (booksnumber == 0) {
        System.out.println("Empty Library! ");
    } else {
        System.out.println("Available Books Are: ");
        for (int i = 0; i < booksnumber; i++) {               // for loop to print all if the available and not borrowed  books in the library //
            if (books[i].isBorrow()==false) {
                System.out.println(books[i]);
            }
        }
    }


}

 }

