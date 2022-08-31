DROP SEQUENCE SEQ_MEMBER_CODE;
CREATE SEQUENCE SEQ_MEMBER_CODE;

DROP TABLE MEMBER_INFO CASCADE CONSTRAINTS;

CREATE TABLE member_info
(
    member_code NUMBER NOT NULL,
    member_id   VARCHAR2(30) NOT NULL,
    member_pwd  VARCHAR2(30) NOT NULL,
    name        VARCHAR2(30) NOT NULL,
    gender      VARCHAR2(30) NOT NULL,
    level       VARCHAR2(20) NOT NULL,
    regist_date DATE,
    extends_yn  VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN member_info.member_code IS '회원코드';
COMMENT ON COLUMN member_info.member_id IS '아이디';
COMMENT ON COLUMN member_info.member_pwd IS '비밀번호';
COMMENT ON COLUMN member_info.name IS '이름';
COMMENT ON COLUMN member_info.gender IS '성별';
COMMENT ON COLUMN member_info.level IS '레벨';
COMMENT ON COLUMN member_info.regist_date IS '등록일자';
COMMENT ON COLUMN member_info.extends_yn IS '연장여부';

CREATE UNIQUE INDEX index_member_code ON member_info
( member_code );

ALTER TABLE member_info
 ADD CONSTRAINT pk_member_code PRIMARY KEY ( member_code )
 USING INDEX index_member_code;
 
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user1', 'user1', '송다인', '여', '초급' , 'Y');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user2', 'user2', '박빌리', '남', '초급');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user3', 'user3', '박후추', '여', '중급');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user4', 'user4', '박초희', '여', '고급');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user5', 'user5', '김지은', '남', '입문');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user6', 'user6', '강지수', '남', '고급');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user7', 'user7', '윤미진', '여', '초급');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user8', 'user8', '윤이서', '남', '입문');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user9', 'user9', '김지호', '남', '중급');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user10', 'user10', '김슬기', '여', '중급');

DROP TABLE MEMBER_INFO;

COMMIT;