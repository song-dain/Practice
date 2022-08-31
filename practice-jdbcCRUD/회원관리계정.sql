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

COMMENT ON COLUMN member_info.member_code IS 'ȸ���ڵ�';
COMMENT ON COLUMN member_info.member_id IS '���̵�';
COMMENT ON COLUMN member_info.member_pwd IS '��й�ȣ';
COMMENT ON COLUMN member_info.name IS '�̸�';
COMMENT ON COLUMN member_info.gender IS '����';
COMMENT ON COLUMN member_info.level IS '����';
COMMENT ON COLUMN member_info.regist_date IS '�������';
COMMENT ON COLUMN member_info.extends_yn IS '���忩��';

CREATE UNIQUE INDEX index_member_code ON member_info
( member_code );

ALTER TABLE member_info
 ADD CONSTRAINT pk_member_code PRIMARY KEY ( member_code )
 USING INDEX index_member_code;
 
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user1', 'user1', '�۴���', '��', '�ʱ�' , 'Y');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user2', 'user2', '�ں���', '��', '�ʱ�');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user3', 'user3', '������', '��', '�߱�');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user4', 'user4', '������', '��', '���');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user5', 'user5', '������', '��', '�Թ�');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user6', 'user6', '������', '��', '���');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user7', 'user7', '������', '��', '�ʱ�');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user8', 'user8', '���̼�', '��', '�Թ�');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user9', 'user9', '����ȣ', '��', '�߱�');
INSERT INTO MEMBER_INFO VALUES (SEQ_MEMBER_CODE.NEXTVAL, 'user10', 'user10', '�载��', '��', '�߱�');

DROP TABLE MEMBER_INFO;

COMMIT;