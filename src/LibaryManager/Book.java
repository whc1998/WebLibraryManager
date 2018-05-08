package LibaryManager;

public class Book {

    public int id;
    public String bookname;
    public String bookAuthor;
    public double bookprice;

    public Book(int id,String bookname, String bookAuthor, double bookprice) {
        this.id=id;
        this.bookname = bookname;
        this.bookAuthor = bookAuthor;
        this.bookprice = bookprice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book){
            Book book= (Book) obj;
            return this.bookname.equals(book.bookname)&&this.bookAuthor.equals(book.bookAuthor)
                    &&(this.bookprice==book.bookprice)&&(this.id==book.id);
        }
        return super.equals(obj);
    }
}
