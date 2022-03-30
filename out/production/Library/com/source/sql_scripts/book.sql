SELECT
    book.isbn,
    book.title,
    book.publisher,
    book.language_code,
    book.number_of_pages,
    subject.name AS category
FROM book
         JOIN subject
              ON book.subject_id = subject.id;

SELECT
b.title,
a.name
FROM book_author
JOIN author a on a.id = book_author.author_id
JOIN book b on b.isbn = book_author.book_isbn;



INSERT INTO book(isbn,title,publisher,language_code,number_of_pages,subject_id) VALUES (9780439785969,'Harry Potter and the Half-Blood Prince (Harry Potter  #6)','Scholastic Inc.','eng',652,27);
INSERT INTO book(isbn,title,publisher,language_code,number_of_pages,subject_id) VALUES (9780439358071,'Harry Potter and the Order of the Phoenix (Harry Potter  #5)', 'Scholastic Inc.','eng',870,8);
INSERT INTO book(isbn,title,publisher,language_code,number_of_pages,subject_id) VALUES (9780439554893,'Harry Potter and the Chamber of Secrets (Harry Potter  #2)','Scholastic Inc.','eng',352,12);
INSERT INTO book(isbn,title,publisher,language_code,number_of_pages,subject_id) VALUES (9780439655484,'Harry Potter and the Prisoner of Azkaban (Harry Potter  #3)','Scholastic Inc.','eng',435,17);
INSERT INTO book(isbn,title,publisher,language_code,number_of_pages,subject_id) VALUES (9780439682589,'Harry Potter Boxed Set  book 1-5 (Harry Potter  #1-5)','Scholastic','eng',2690,7);

