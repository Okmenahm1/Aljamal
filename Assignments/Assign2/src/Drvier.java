// class name drvier its responsible to test the library by adding books and return books and borrow books //
public class Drvier{
    public static void main(String[] args) {
        Library library = new Library(); // calling arrays from class name Library  //

        // Add 10  Books to the library //
        library.newBook(new Book("Math132", "Author-1", "BZU", "English", 1));
        library.newBook(new Book("phys111", "Author-2", "QOP", "English", 2));
        library.newBook(new Book("arabic136", "Author-3", "DPQ", "Arabic", 4));
        library.newBook(new Book("english242", "Author-4", "GHY", "English", 8));
        library.newBook(new Book("Book-5", "Author-5", "MON", "English", 13));
        library.newBook(new Book("Book-6", "Author-6", "LMK", "English", 17));
        library.newBook(new Book("Biology", "Author-7", "LIM", "English", 15));
        library.newBook(new Book("Book-8", "Author-8", "OPT", "English", 12));
        library.newBook(new Book("Book-9", "Author-9", "GITHUB", "English", 11));
        library.newBook(new Book("Book-10", "Author-10", "FGA", "English", 10));

        // Borrow the 5th and 6th book from the library //
        library.borrow("Book-5");
        library.borrow("Book-6");

        //  borrow the 5th book again //
        library.borrow("Book-5");

        // Return the 6th book to the library //
        library.returnBook("Book-6");


        // Print the available  books in the library //
        library.printAvailableBooks();
    }
}