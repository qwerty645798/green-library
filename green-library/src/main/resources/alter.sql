-- 전체 시퀀스와 테이블 제거
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
DROP SEQUENCE interest_idx;

DROP INDEX idx_rents_user_id;
DROP INDEX idx_rents_book_id;
DROP INDEX idx_interest_user_id;
DROP INDEX idx_interest_book_id;

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
DROP TABLE interested_books CASCADE CONSTRAINTS;

-- 책 테이블
ALTER TABLE books
    ADD CONSTRAINT fk_books_author_id
        FOREIGN KEY (author_id) REFERENCES authors(author_id);

ALTER TABLE books
    ADD CONSTRAINT fk_books_publisher_id
        FOREIGN KEY (publisher_id) REFERENCES publishers(publisher_id);

ALTER TABLE books
    ADD CONSTRAINT fk_books_genre_id
        FOREIGN KEY (genre_id) REFERENCES genres(genre_id);

-- 관리자 테이블
ALTER TABLE admins
    ADD CONSTRAINT fk_admins_grant_rank
        FOREIGN KEY (grant_rank) REFERENCES admin_grants(grant_rank);

-- 공지사항 테이블
ALTER TABLE announcements
    ADD CONSTRAINT fk_announcements_writer_id
        FOREIGN KEY (writer_id) REFERENCES admins(admin_id);

-- 문의사항 테이블
ALTER TABLE inquiries
    ADD CONSTRAINT fk_inquiries_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE;

-- 문의사항 답변 테이블
ALTER TABLE inquiry_responses
    ADD CONSTRAINT fk_inquiry_responses_inquiry_id
        FOREIGN KEY (inquiry_id) REFERENCES inquiries(inquiry_id);

ALTER TABLE inquiry_responses
    ADD CONSTRAINT fk_inquiry_responses_admin_id
        FOREIGN KEY (admin_id) REFERENCES admins(admin_id);

-- 정지 테이블
ALTER TABLE suspensions
    ADD CONSTRAINT fk_suspensions_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE;

-- 대여기록 테이블
ALTER TABLE rents
    ADD CONSTRAINT fk_rents_book_id
        FOREIGN KEY (book_id) REFERENCES books(book_id);

ALTER TABLE rents
    ADD CONSTRAINT fk_rents_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE;

-- 위시리스트 테이블
ALTER TABLE wishlists
    ADD CONSTRAINT fk_wishlists_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE;

-- 예약 테이블
ALTER TABLE reservations
    ADD CONSTRAINT fk_reservations_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE;

ALTER TABLE reservations
    ADD CONSTRAINT fk_reservations_book_id
        FOREIGN KEY (book_id) REFERENCES books(book_id);

-- 관심 도서 테이블
ALTER TABLE interested_books
    ADD CONSTRAINT fk_interested_books_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE;

ALTER TABLE interested_books
    ADD CONSTRAINT fk_interested_books_book_id
        FOREIGN KEY (book_id) REFERENCES books(book_id);
