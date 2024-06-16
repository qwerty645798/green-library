-- 테이블 삭제
DROP TABLE reservations CASCADE CONSTRAINTS;
DROP TABLE wishlists CASCADE CONSTRAINTS;
DROP TABLE user_genres CASCADE CONSTRAINTS;
DROP TABLE rents CASCADE CONSTRAINTS;
DROP TABLE suspensions CASCADE CONSTRAINTS;
DROP TABLE inquiry_responses CASCADE CONSTRAINTS;
DROP TABLE inquiries CASCADE CONSTRAINTS;
DROP TABLE announcements CASCADE CONSTRAINTS;
DROP TABLE admins CASCADE CONSTRAINTS;
DROP TABLE admin_grants CASCADE CONSTRAINTS;
DROP TABLE books CASCADE CONSTRAINTS;
DROP TABLE genres CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE publishers CASCADE CONSTRAINTS;
DROP TABLE authors CASCADE CONSTRAINTS;

-- 시퀀스 삭제
DROP SEQUENCE author_idx;
DROP SEQUENCE publisher_idx;
DROP SEQUENCE book_idx;
DROP SEQUENCE announce_idx;
DROP SEQUENCE inquiry_idx;
DROP SEQUENCE response_idx;
DROP SEQUENCE suspend_idx;
DROP SEQUENCE rents_idx;
DROP SEQUENCE wishlist_idx;
DROP SEQUENCE reservation_idx;

-- 작가
CREATE TABLE authors (
    author_id NUMBER(10) PRIMARY KEY,
    author_name VARCHAR2(20)
);
-- 출판사
CREATE TABLE publishers (
    publisher_id NUMBER(10) PRIMARY KEY,
    publisher_name VARCHAR2(20)
);

-- 유저
CREATE TABLE users (
    user_id VARCHAR2(20) PRIMARY KEY NOT NULL,
    user_pass VARCHAR2(80),
    name VARCHAR2(20),
    email VARCHAR2(40),
    phone VARCHAR2(14),
    birth VARCHAR2(10),
    overdue_count NUMBER(10),
    suspended CHAR(1) DEFAULT '0' CHECK (suspended IN ('0', '1'))
);
-- user_pass 칼럼 varchar2(20) -> varchar2(80)으로 변경
-- alter table users modify user_pass varchar2(80);

-- 장르
CREATE TABLE genres (
    genre_id VARCHAR2(3) PRIMARY KEY,
    genre_name VARCHAR2(20)
);

-- 책
CREATE TABLE books (
    book_id NUMBER(10) PRIMARY KEY,
    author_id NUMBER(10) REFERENCES authors(author_id),
    publisher_id NUMBER(10) REFERENCES publishers(publisher_id),
    genre_id VARCHAR2(3) REFERENCES genres(genre_id),
    genre_fullname VARCHAR2(20),
    title VARCHAR2(50),
    img VARCHAR2(255),
    isbn VARCHAR2(20),
    location VARCHAR2(50),
    availability CHAR(1) DEFAULT '1' CHECK (availability IN ('0', '1')),
    summary VARCHAR2(500),
    publication_date DATE,
    borrow_count NUMBER(10)
);

-- 관리자 등급
CREATE TABLE admin_grants (
    grant_rank NUMBER(1) PRIMARY KEY,
    grant_name VARCHAR2(10)
);

-- 관리자
CREATE TABLE admins (
    admin_id VARCHAR2(20) PRIMARY KEY,
    admin_name VARCHAR2(5),
    admin_pass VARCHAR2(20),
    admin_email VARCHAR2(40),
    grant_rank NUMBER(1) REFERENCES admin_grants(grant_rank)
);

-- 공지사항
CREATE TABLE announcements (
    announcement_id NUMBER(10) PRIMARY KEY,
    announce_title VARCHAR2(50),
    writer_id VARCHAR2(20) REFERENCES admins(admin_id),
    write_date DATE,
    fileName VARCHAR2(255),
    contents VARCHAR2(500),
    view_count NUMBER(10)
);

-- 문의사항
CREATE TABLE inquiries (
    inquiry_id NUMBER(10) PRIMARY KEY,
    inquiry_title VARCHAR2(50),
    contents VARCHAR2(500),
    user_id VARCHAR2(20) REFERENCES users(user_id)
);

-- 문의사항 답변
CREATE TABLE inquiry_responses (
    response_id NUMBER(10) PRIMARY KEY,
    inquiry_id NUMBER(10) REFERENCES inquiries(inquiry_id),
    response_date DATE,
    response_content VARCHAR2(500),
    admin_id VARCHAR2(20) REFERENCES admins(admin_id)
);

-- 정지
CREATE TABLE suspensions (
    suspension_id NUMBER(10) PRIMARY KEY,
    start_date DATE,
    end_date DATE,
    reason VARCHAR2(50),
    user_id VARCHAR2(20) REFERENCES users(user_id)
);

-- 대여기록
CREATE TABLE rents (
    rent_num NUMBER(10) PRIMARY KEY,
    rent_history DATE,
    book_id NUMBER(10) REFERENCES books(book_id),
    user_id VARCHAR2(20) REFERENCES users(user_id),
    returned CHAR(1) DEFAULT '0' CHECK (returned IN ('0', '1'))
);

-- 유저의 선호 장르
CREATE TABLE user_genres (
    user_id VARCHAR2(20) REFERENCES users(user_id),
    genre_id VARCHAR2(3) REFERENCES genres(genre_id),
    PRIMARY KEY (user_id, genre_id)
);

-- 위시리스트
CREATE TABLE wishlists (
    wishlist_id NUMBER(10) PRIMARY KEY,
    wish_title VARCHAR2(50),
    wish_author VARCHAR2(50),
    wish_publisher VARCHAR2(50),
    wish_publication DATE,
    wish_price NUMBER(10),
    wish_isbn VARCHAR2(20),
    wish_date DATE,
    user_id VARCHAR2(20) REFERENCES users(user_id)
);

-- 예약
CREATE TABLE reservations (
    reservation_id NUMBER(10) PRIMARY KEY,
    user_id VARCHAR2(20) REFERENCES users(user_id),
    book_id NUMBER(10) REFERENCES books(book_id),
    reservation_date DATE
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
