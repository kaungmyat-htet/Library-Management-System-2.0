package com.model;

import java.time.LocalDate;

public class BookItem extends Book{
    private String barcode;
    private int price;
    private BookFormat bookFormat;
    private boolean isReference;
    private BookStatus status;
    private LocalDate dateOfPurchase;
    private LocalDate publicationDate;
    public static final int allowedPeriod = 14;

    public BookItem(Book book, String barcode, int price, BookFormat bookFormat, boolean isReference, BookStatus status, LocalDate dateOfPurchase, LocalDate publicationDate) {
        super(book.getIsbn(), book.getTitle(), book.getAuthors() ,book.getSubject(), book.getLanguage(), book.getNumberOfPages());
        this.barcode = barcode;
        this.price = price;
        this.bookFormat = bookFormat;
        this.isReference = isReference;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
    }

    public BookItem(String isbn, String barcode, int price, BookFormat bookFormat, boolean isReference, LocalDate dateOfPurchase, LocalDate publicationDate) {
        super(isbn);
        this.barcode = barcode;
        this.price = price;
        this.bookFormat = bookFormat;
        this.isReference = isReference;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
    }

    public BookItem(String isbn, String barcode) {
        super(isbn);
        this.barcode = barcode;
    }

    public boolean isReference() {
        return isReference;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "barcode='" + barcode + '\'' +
                ", price=" + price +
                ", bookFormat=" + bookFormat +
                ", isReference=" + isReference +
                ", status=" + status +
                ", dateOfPurchase=" + dateOfPurchase +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
