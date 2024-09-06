DROP TABLE IF EXISTS book;

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

INSERT INTO book (title, author, isbn, published_date, price) VALUES
('Dracula', 'Bram Stoker', '9780486282114', '1897-05-26', 9.99),
('Frankenstein', 'Mary Shelley', '9780486282114', '1818-01-01', 8.99),
('The Shining', 'Stephen King', '9780307743657', '1977-01-28', 12.99),
('Pet Sematary', 'Stephen King', '9780307946620', '1983-11-14', 10.99),
('The Haunting of Hill House', 'Shirley Jackson', '9780143039983', '1959-10-01', 11.49),
('Bird Box', 'Josh Malerman', '9780062259655', '2014-05-13', 13.49),
('The Exorcist', 'William Peter Blatty', '9780061007221', '1971-02-01', 14.99),
('The Silence of the Lambs', 'Thomas Harris', '9780316494680', '1988-08-16', 15.99),
('The Amityville Horror', 'Jay Anson', '9780451166204', '1977-09-01', 12.49),
('The Texas Chain Saw Massacre', 'Grady Hendrix', '9781683693404', '2019-09-24', 11.99);
