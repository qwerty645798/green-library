-- 작가
CREATE TABLE authors
(
    author_id   NUMBER(10) PRIMARY KEY,
    author_name VARCHAR2(20)
);

-- 출판사
CREATE TABLE publishers
(
    publisher_id   NUMBER(10) PRIMARY KEY,
    publisher_name VARCHAR2(20)
);

-- 장르
CREATE TABLE genres
(
    genre_id   VARCHAR2(3) PRIMARY KEY,
    genre_name VARCHAR2(20)
);

-- 유저
CREATE TABLE users
(
    user_id       VARCHAR2(20) PRIMARY KEY NOT NULL,
    user_pass     VARCHAR2(80),
    name          VARCHAR2(20),
    email         VARCHAR2(40),
    phone         VARCHAR2(14),
    birth         VARCHAR2(10),
    overdue_count NUMBER(10) DEFAULT 0,
    suspended     CHAR(1)    DEFAULT '0' CHECK (suspended IN ('0', '1'))
);

-- 책
CREATE TABLE books
(
    book_id          NUMBER(10) PRIMARY KEY,
    author_id        NUMBER(10),
    publisher_id     NUMBER(10),
    genre_id         VARCHAR2(3),
    genre_fullname   VARCHAR2(20),
    title            VARCHAR2(50),
    img              VARCHAR2(255),
    isbn             VARCHAR2(20),
    location         VARCHAR2(50),
    availability     CHAR(1)    DEFAULT '1' CHECK (availability IN ('0', '1')), --0 : 대여가능, 1 : 대여불가능
    summary          VARCHAR2(500),
    publication_date DATE,
    borrow_count     NUMBER(10) DEFAULT 0,
    CONSTRAINT fk_books_author_id FOREIGN KEY (author_id) REFERENCES authors (author_id) ON DELETE CASCADE,
    CONSTRAINT fk_books_publisher_id FOREIGN KEY (publisher_id) REFERENCES publishers (publisher_id) ON DELETE CASCADE,
    CONSTRAINT fk_books_genre_id FOREIGN KEY (genre_id) REFERENCES genres (genre_id)
);

-- 관리자 등급
CREATE TABLE admin_grants
(
    grant_rank NUMBER(1) PRIMARY KEY,
    grant_name VARCHAR2(10)
);

-- 관리자
CREATE TABLE admins
(
    admin_id    VARCHAR2(20) PRIMARY KEY,
    admin_name  VARCHAR2(10), -- Changed from VARCHAR2(5) to VARCHAR2(10) as per your ALTER TABLE statement
    admin_pass  VARCHAR2(20),
    admin_email VARCHAR2(40),
    grant_rank  NUMBER(1),
    CONSTRAINT fk_admins_grant_rank FOREIGN KEY (grant_rank) REFERENCES admin_grants (grant_rank)
);

-- 공지사항
CREATE TABLE announcements
(
    announcement_id NUMBER(10) PRIMARY KEY,
    announce_title  VARCHAR2(50),
    writer_id       VARCHAR2(20),
    write_date      DATE,
    fileName        VARCHAR2(255),
    contents        VARCHAR2(500),
    view_count      NUMBER(10) DEFAULT 0,
    CONSTRAINT fk_announcements_writer_id FOREIGN KEY (writer_id) REFERENCES admins (admin_id) ON DELETE CASCADE
);

-- 문의사항
CREATE TABLE inquiries
(
    inquiry_id    NUMBER(10) PRIMARY KEY,
    inquiry_date  DATE,
    inquiry_title VARCHAR2(50),
    contents      VARCHAR2(500),
    responseTF    CHAR(1) DEFAULT '0' CHECK (responseTF IN ('0', '1')),
    user_id       VARCHAR2(20),
    CONSTRAINT fk_inquiries_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- 문의사항 답변
CREATE TABLE inquiry_responses
(
    response_id      NUMBER(10) PRIMARY KEY,
    inquiry_id       NUMBER(10),
    response_date    DATE,
    response_content VARCHAR2(500),
    admin_id         VARCHAR2(20),
    CONSTRAINT fk_inquiry_responses_inquiry_id FOREIGN KEY (inquiry_id) REFERENCES inquiries (inquiry_id) ON DELETE CASCADE,
    CONSTRAINT fk_inquiry_responses_admin_id FOREIGN KEY (admin_id) REFERENCES admins (admin_id) ON DELETE CASCADE
);

-- 정지
CREATE TABLE suspensions
(
    suspension_id NUMBER(10) PRIMARY KEY,
    start_date    DATE,
    end_date      DATE,
    reason        VARCHAR2(50),
    user_id       VARCHAR2(20),
    CONSTRAINT fk_suspensions_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- 대여기록
CREATE TABLE rents
(
    rent_num     NUMBER(10) PRIMARY KEY,
    rent_history DATE,
    return_date  DATE, --sysdate + 14
    book_id      NUMBER(10),
    user_id      VARCHAR2(20),
    returned     CHAR(1) DEFAULT '0' CHECK (returned IN ('0', '1')),
    CONSTRAINT fk_rents_book_id FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE,
    CONSTRAINT fk_rents_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- 유저의 선호 장르
CREATE TABLE user_genres
(
    user_id  VARCHAR2(20),
    genre_id VARCHAR2(3),
    PRIMARY KEY (user_id, genre_id),
    CONSTRAINT fk_user_genres_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_user_genres_genre_id FOREIGN KEY (genre_id) REFERENCES genres (genre_id)
);

-- 위시리스트
CREATE TABLE wishlists
(
    wishlist_id      NUMBER(10) PRIMARY KEY,
    wish_title       VARCHAR2(50),
    wish_author      VARCHAR2(50),
    wish_publisher   VARCHAR2(50),
    wish_publication DATE,
    wish_price       NUMBER(10) DEFAULT 10000,
    wish_isbn        VARCHAR2(20),
    wish_date        DATE,
    complete         CHAR(1)    DEFAULT 'W' CHECK (complete IN ('Y', 'W', 'N')), -- W : wait, Y : accept, N : decline
    user_id          VARCHAR2(20),
    CONSTRAINT fk_wishlists_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE
);

-- 예약
CREATE TABLE reservations
(
    reservation_id   NUMBER(10) PRIMARY KEY,
    user_id          VARCHAR2(20),
    book_id          NUMBER(10),
    reservation_date DATE,
    CONSTRAINT fk_reservations_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_reservations_book_id FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE
);

-- 관심 도서
CREATE TABLE interested_books
(
    interest_id NUMBER(10) PRIMARY KEY,
    user_id     VARCHAR2(20),
    book_id     NUMBER(10),
    CONSTRAINT fk_interested_books_user_id FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    CONSTRAINT fk_interested_books_book_id FOREIGN KEY (book_id) REFERENCES books (book_id) ON DELETE CASCADE
);

-- 이메일 인증 테이블
CREATE TABLE email_token
(
    token VARCHAR2(255) NOT NULL,
    email VARCHAR2(255) NOT NULL,
    PRIMARY KEY (token)
);

-- 시퀀스 생성
CREATE SEQUENCE author_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE publisher_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE book_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE announce_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE inquiry_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE response_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE suspend_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE rents_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE wishlist_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE reservation_idx START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE interest_idx START WITH 1 INCREMENT BY 1;

-- 인덱스 추가
CREATE INDEX idx_rents_user_id ON rents (user_id);
CREATE INDEX idx_rents_book_id ON rents (book_id);
CREATE INDEX idx_interest_user_id ON interested_books (user_id);
CREATE INDEX idx_interest_book_id ON interested_books (book_id);

-- 커밋
COMMIT;
