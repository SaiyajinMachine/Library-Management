DROP TABLE book;

CREATE TABLE book (
  id INTEGER NOT NULL AUTO_INCREMENT,
  title VARCHAR(64) NOT NULL,
  author VARCHAR(64) NOT NULL,
  isbn VARCHAR(64) NOT NULL,
  published_date DATE NOT NULL,
  price DOUBLE(4,2) NOT NULL,
  version INTEGER DEFAULT '1',
  creation_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

INSERT INTO book (title, author, isbn, published_date, price)
VALUES ('The Fellowship of the Ring', 'J.R.R.Tolkien', "9780261102354", "1954-07-29", 11.69);
