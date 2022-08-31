CREATE TABLE SP_MEMBER
(
    MEMBER_CODE NUMBER NOT NULL,
    MEMBER_ID   VARCHAR2(30) NOT NULL,
    MEMBER_PWD  VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    GENDER      VARCHAR2(30) NOT NULL,
    MEMBER_LEVEL VARCHAR2(20) NOT NULL,
    REGIST_DATE DATE NOT NULL,
    EXTEND_YN  VARCHAR2(20) DEFAULT 'N',
    EXPIRY_DATE DATE NOT NULL
);

COMMENT ON COLUMN sp_member.member_code IS '회원코드';
COMMENT ON COLUMN sp_member.member_id IS '아이디';
COMMENT ON COLUMN sp_member.member_pwd IS '비밀번호';
COMMENT ON COLUMN sp_member.name IS '이름';
COMMENT ON COLUMN sp_member.gender IS '성별';
COMMENT ON COLUMN sp_member.member_level IS '레벨';
COMMENT ON COLUMN sp_member.regist_date IS '등록일자';
COMMENT ON COLUMN sp_member.extend_yn IS '연장여부';
COMMENT ON COLUMN sp_member.expiry_date IS '만료일';

CREATE UNIQUE INDEX index_member_code ON sp_member
( member_code );

ALTER TABLE sp_member
 ADD CONSTRAINT pk_member_code PRIMARY KEY ( member_code )
 USING INDEX index_member_code;
 
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user1', 'user1', '송다인', '여', '초급', '2022-06-11', 'Y', '2022-08-30');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user2', 'user2', '박빌리', '남', '초급', '2022-07-05', 'N', '2022-08-30');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user3', 'user3', '김해경', '여', '중급', '2022-01-01', 'Y', '2022-08-29');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user4', 'user4', '박초희', '여', '고급', '2021-08-22', 'N', '2022-08-28');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user5', 'user5', '박진주', '남', '입문', '2022-08-30', 'Y', '2022-08-21');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user6', 'user6', '강지수', '남', '고급', '2020-05-15', 'Y', '2022-08-29');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user7', 'user7', '윤미진', '여', '초급', '2022-07-01', 'N', '2022-08-29');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user8', 'user8', '윤이서', '남', '입문', '2022-08-13', 'Y', '2022-08-30');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user9', 'user9', '김지호', '남', '중급', '2021-12-26', 'Y', '2022-08-31');
INSERT INTO SP_MEMBER VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user10', 'user10', '김다은', '여', '중급', '2022-02-02', 'Y', '2022-08-31');

COMMIT;