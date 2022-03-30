package com.model;

import java.time.LocalDate;
import java.util.Optional;

public class BookItem extends Book{
    public static class BookItemBuilder {
        private Book book;
        private String barcode;
        private int price;
        private BookFormat bookFormat;
        private boolean isReference;
        private BookStatus status;
        private LocalDate purchasedDate;
        private LocalDate publicationDate;

        public BookItemBuilder() {

        }

        public BookItem build() {
            return new BookItem(this);
        }

        public BookItemBuilder book(Book book) {
            this.book = book;
            return this;
        }

        public BookItemBuilder barcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        public BookItemBuilder isReference(Boolean isReference) {
            this.isReference = isReference;
            return this;
        }

        public BookItemBuilder price(int price) {
            this.price = price;
            return this;
        }

        public BookItemBuilder bookFormat(BookFormat bookFormat) {
            this.bookFormat = bookFormat;
            return this;
        }

        public BookItemBuilder bookStatus(BookStatus bookStatus) {
            this.status = bookStatus;
            return this;
        }

        public BookItemBuilder purchasedDate(LocalDate purchasedDate) {
            this.purchasedDate = purchasedDate;
            return this;
        }

        public BookItemBuilder publicationDate(LocalDate publicationDate) {
            this.publicationDate = publicationDate;
            return this;
        }

    }
    private final String barcode;
    private final int price;
    private final BookFormat bookFormat;
    private final boolean isReference;
    private final BookStatus status;
    private final LocalDate purchasedDate;
    private final LocalDate publicationDate;
    public static final int allowedPeriod = 14;

    public BookItem(BookItemBuilder builder) {
        super(builder.book.getIsbn(), builder.book.getTitle(), builder.book.getAuthors(), builder.book.getSubject(), builder.book.getLanguage(), builder.book.getNumberOfPages());
        this.barcode = builder.barcode;
        this.price = builder.price;
        this.bookFormat = builder.bookFormat;
        this.isReference = builder.isReference;
        this.status = builder.status;
        this.purchasedDate = builder.purchasedDate;
        this.publicationDate = builder.publicationDate;
    }

    public boolean isReference() {
        return isReference;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Optional<BorrowTransaction> borrowBook(String username) {
        LocalDate creationDate = LocalDate.now();
        BorrowTransaction borrowTransaction = new BorrowTransaction(username, this, creationDate, creationDate.plusDays(allowedPeriod));
        return Optional.of(borrowTransaction);
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "barcode='" + barcode + '\'' +
                ", price=" + price +
                ", bookFormat=" + bookFormat +
                ", isReference=" + isReference +
                ", status=" + status +
                ", dateOfPurchase=" + purchasedDate +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
