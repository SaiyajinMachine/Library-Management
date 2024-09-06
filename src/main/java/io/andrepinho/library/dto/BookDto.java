package io.andrepinho.library.dto;

import javax.validation.constraints.*;

public class BookDto {

    @NotNull(message = "Title is mandatory")
    @NotBlank(message = "Title is required")
    @Size(max = 64, message = "Title cannot exceed 64 characters")
    private String title;

    @NotNull(message = "Author is mandatory")
    @NotBlank(message = "Author is required")
    @Size(max = 64, message = "Author's name cannot exceed 64 characters")
    private String author;

    @NotNull(message = "ISBN is mandatory")
    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "\\d{13}", message = "ISBN must be exactly 13 digits")
    private String isbn;

    @NotNull(message = "Published Date is mandatory")
    @NotBlank(message = "Published date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Published date must be in the format YYYY-MM-DD")
    private String published_date;

    @NotNull(message = "Price is mandatory")
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 5, fraction = 2, message = "Price must be a valid amount with up to 2 decimal places")
    private double price;

    private Integer id;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", published_date=" + published_date +
                ", price=" + price +
                '}';
    }
}
