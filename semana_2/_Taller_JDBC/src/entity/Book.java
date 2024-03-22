package entity;

public class Book {
    private int id;


    private String title;
    private int yearOfPublication;
    private int authorId;
    private double price;

    public Book() {

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book " +
                "id: " + id +
                ", title: " + title + '\'' +
                ", yearOfPublication: " + yearOfPublication +
                ", authorId: " + authorId +
                ", price: " + price;
    }
}
