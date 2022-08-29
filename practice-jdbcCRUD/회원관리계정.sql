DROP SEQUENCE SEQ_MEMBER_CODE;
CREATE SEQUENCE SEQ_MEMBER_CODE;

DROP TABLE MEMBER_INFO CASCADE CONSTRAINTS;

CREATE TABLE member_info
(
    member_code NUMBER NOT NULL,
    member_id   VARCHAR2(30) NOT NULL,
    member_pwd  VARCHAR2(30) NOT NULL,
    name        VARCHAR2(30) NOT NULL,
    gender      VARCHAR2(30) NOT NULL
);

COMMENT ON COLUMN member_info.member_code IS 'ȸ���ڵ�';
COMMENT ON COLUMN member_info.member_id IS '���̵�';
COMMENT ON COLUMN member_info.member_pwd IS '��й�ȣ';
COMMENT ON COLUMN member_info.name IS '�̸�';
COMMENT ON COLUMN member_info.gender IS '����';

CREATE UNIQUE INDEX index_member_code ON member_info
( member_code );

ALTER TABLE member_info
 ADD CONSTRAINT pk_member_code PRIMARY KEY ( member_code )
 USING INDEX index_member_code;
 
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user1', 'user1', '�۶���', '��');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user2', 'user2', '�ں���', '��');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user3', 'user3', '������', '��');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user4', 'user4', '������', '��');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user5', 'user5', '�ֶ���', '��');


COMMIT;