-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-03-24 17:32:10.686




-- tables
-- Table: APPOINTMENTS
CREATE TABLE APPOINTMENTS (
    id_app number(4,0)  NOT NULL,
    user_id number(4,0)  NOT NULL,
    id_type number(4,0)  NOT NULL,
    "date" date  NOT NULL,
    location varchar2(30)  NULL,
    doctor varchar2(40)  NULL,
    phone varchar2(11)  NULL,
    frequency number(3,0)  NULL,
    description varchar2(30)  NULL,
    time_reminder number(2,0)  NULL,
    CONSTRAINT APPOINTMENTS_pk PRIMARY KEY (id_app)
) ;




-- Table: BLOOD_TESTS
CREATE TABLE BLOOD_TESTS (
    user_id number(4,0)  NOT NULL,
    id_test number(4,0)  NOT NULL,
    name varchar2(30)  NOT NULL,
    value number(6,2)  NULL,
    type number(1,0)  NULL,
    result number(1,0)  NOT NULL,
    CONSTRAINT BLOOD_TESTS_pk PRIMARY KEY (id_test)
) ;




-- Table: DEFAULT_DATA
CREATE TABLE DEFAULT_DATA (
    id_ide number(2,0)  NOT NULL,
    value number(3,0)  NOT NULL,
    CONSTRAINT DEFAULT_DATA_pk PRIMARY KEY (id_ide)
) ;




-- Table: PROFILES
CREATE TABLE PROFILES (
    birth_date date  NULL,
    user_id number(4,0)  NOT NULL,
    sex char(1)  NOT NULL,
    weight number(4,1)  NULL,
    height number(3,0)  NULL,
    default_reminder_time number(2,0)  NULL,
    default_btests number(2,0)  NULL,
    CONSTRAINT PROFILES_pk PRIMARY KEY (user_id)
) ;




-- Table: REMINDERS
CREATE TABLE REMINDERS (
    id_reminder number(4,0)  NOT NULL,
    id_app number(4,0)  NULL,
    date_reminder date  NOT NULL,
    title varchar2(20)  NOT NULL,
    description varchar2(100)  NULL,
    CONSTRAINT REMINDERS_pk PRIMARY KEY (id_reminder)
) ;




-- Table: TYPE
CREATE TABLE TYPE (
    id_type number(4,0)  NOT NULL,
    name varchar2(30)  NOT NULL,
    CONSTRAINT TYPE_pk PRIMARY KEY (id_type)
) ;




-- Table: USERS
CREATE TABLE USERS (
    user_id number(4,0)  NOT NULL,
    username varchar2(30)  NOT NULL,
    password varchar2(20)  NOT NULL,
    email varchar2(40)  NOT NULL,
    CONSTRAINT USERS_pk PRIMARY KEY (user_id)
) ;








-- foreign keys
-- Reference:  APPOINTMENTS_PROFILES (table: APPOINTMENTS)

ALTER TABLE APPOINTMENTS ADD CONSTRAINT APPOINTMENTS_PROFILES 
    FOREIGN KEY (user_id)
    REFERENCES PROFILES (user_id)
    ;

-- Reference:  BLOOD_TESTS_PROFILES (table: BLOOD_TESTS)

ALTER TABLE BLOOD_TESTS ADD CONSTRAINT BLOOD_TESTS_PROFILES 
    FOREIGN KEY (user_id)
    REFERENCES PROFILES (user_id)
    ;

-- Reference:  PROFILES_USERS (table: PROFILES)

ALTER TABLE PROFILES ADD CONSTRAINT PROFILES_USERS 
    FOREIGN KEY (user_id)
    REFERENCES USERS (user_id)
    ;

-- Reference:  REMINDERS_APPOINTMENTS (table: REMINDERS)

ALTER TABLE REMINDERS ADD CONSTRAINT REMINDERS_APPOINTMENTS 
    FOREIGN KEY (id_app)
    REFERENCES APPOINTMENTS (id_app)
    ;




-- sequences
-- Sequence: secv_app
--- 
CREATE SEQUENCE secv_app
      INCREMENT BY 5
      NOMINVALUE
      NOMAXVALUE
      START WITH 0 
      NOCACHE 
      NOCYCLE
      ;
      
-- Sequence: secv_remindere
--- 
CREATE SEQUENCE secv_remindere
      INCREMENT BY 10
      NOMINVALUE
      NOMAXVALUE
      START WITH 101 
      NOCACHE 
      NOCYCLE
      ;
      
-- Sequence: secv_test
--- 
CREATE SEQUENCE secv_test
      INCREMENT BY 5
      NOMINVALUE
      NOMAXVALUE
      START WITH 2 
      NOCACHE 
      NOCYCLE
      ;
      
-- Sequence: secv_user
--- 
CREATE SEQUENCE secv_user
      INCREMENT BY 10
      NOMINVALUE
      NOMAXVALUE
      START WITH 0 
      NOCACHE 
      NOCYCLE
      ;
      



-- End of file.

