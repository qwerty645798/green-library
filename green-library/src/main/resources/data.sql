-- 작가
INSERT INTO authors(author_id, author_name)
VALUES(author_idx.NEXTVAL, '작가1');

-- 출판사
INSERT INTO publishers(publisher_id, publisher_name)
VALUES(publisher_idx.NEXTVAL, '출판사1');

-- 유저
INSERT INTO users(user_id, user_pass, name, email, phone, birth, overdue_count, suspended)
VALUES('id1', '$2b$12$aVAu2OU4I0efQn8fPgwGreoJAguc3JGT5wGeAyVo7GIY2Bw0LA7gO', '이름1', 'e@gmail.com', '000-0000-0000', '1990-01-01', 0, '0');
-- 유저 비밀번호(pass1)해싱한값


-- 장르
INSERT INTO genres(genre_id, genre_name) VALUES('000', '총류');
INSERT INTO genres(genre_id, genre_name) VALUES('100', '철학');
INSERT INTO genres(genre_id, genre_name) VALUES('200', '종교');
INSERT INTO genres(genre_id, genre_name) VALUES('300', '사회과학');
INSERT INTO genres(genre_id, genre_name) VALUES('400', '자연과학');
INSERT INTO genres(genre_id, genre_name) VALUES('500', '기술과학');
INSERT INTO genres(genre_id, genre_name) VALUES('600', '예술');
INSERT INTO genres(genre_id, genre_name) VALUES('700', '언어');
INSERT INTO genres(genre_id, genre_name) VALUES('800', '문학');
INSERT INTO genres(genre_id, genre_name) VALUES('900', '역사');

-- 책
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '834.42바', '책이름', 'ex1.png', '456123789', '3층 2번째 책장', '1', '요약', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 0);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '813.9가', '버터', 'ex2.png', '456123790', '2층 3번째 책장', '0', '요약이 조아요', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 0);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '834.42바', '책이름', 'ex3.png', '456123789', '3층 2번째 책장', '1', '요약', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 2);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '813.9가', '버터', 'ex4.png', '456123790', '2층 3번째 책장', '0', '요약이 조아요', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 1);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '834.42바', '책이름', 'ex5.png', '456123789', '3층 2번째 책장', '1', '요약', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 1);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '813.9가', '버터', 'ex6.png', '456123790', '2층 3번째 책장', '0', '요약이 조아요', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 1);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '834.42바', '책이름', 'ex7.png', '456123789', '3층 2번째 책장', '1', '요약', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 1);
INSERT INTO books (book_id, author_id, publisher_id, genre_id, genre_fullname, title,
img, isbn, location, availability, summary, publication_date, borrow_count)
VALUES (book_idx.NEXTVAL, 1, 1, '800', '813.9가', '버터', 'ex8.png', '456123790', '2층 3번째 책장', '0', '요약이 조아요', TO_DATE('2022-02-02', 'YYYY-MM-DD'), 1);

-- 관리자 등급
INSERT INTO admin_grants(grant_rank, grant_name) VALUES(3, 'super');
INSERT INTO admin_grants(grant_rank, grant_name) VALUES(2, 'board');
INSERT INTO admin_grants(grant_rank, grant_name) VALUES(1, '관리');

-- 관리자
INSERT INTO admins (admin_id, admin_name, admin_pass, grant_rank) VALUES('admin0', 'name', 'admin0', 1);
INSERT INTO admins (admin_id, admin_name, admin_pass, grant_rank) VALUES('admin1', 'name', 'admin1', 2);
INSERT INTO admins (admin_id, admin_name, admin_pass, grant_rank) VALUES('system', 'name', 'system', 3);


-- 이후는 JDBC query 작성 참고용으로 작성된 것들 입니다.

INSERT INTO announcements(announcement_id, announce_title, writer_id, write_date, fileName, contents, view_count)
VALUES(announce_idx.NEXTVAL, '첫 공지사항', 'admin1', SYSDATE, 'asdf.hwp', '첫 공지사항 example 작성해봅니다', 0);

INSERT INTO inquiries(inquiry_id, inquiry_title, contents, user_id)
VALUES(inquiry_idx.NEXTVAL, '문의 처음으로 드립니다', '사이트좀 제대로 만들어주라', 'id1');

INSERT INTO inquiry_responses(response_id, inquiry_id, response_date, response_content, admin_id)
VALUES(response_idx.NEXTVAL, 1, SYSDATE, '불편을 끼쳐 죄송합니다', 'admin1');

INSERT INTO suspensions(suspension_id, start_date, end_date, reason, user_id)
VALUES(suspend_idx.NEXTVAL, '2024-06-11', '2024-06-25', '그냥 테스트로', 'id1');



commit;


