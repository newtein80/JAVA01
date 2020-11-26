-- https://www.lesstif.com/dbms/dbms-nosql-17105048.html


----------------------------------------
-- 1) 지정 DB 사용 권한 계정 등록
----------------------------------------
CREATE USER testuser WITH ENCRYPTED PASSWORD '#skdlf12';

-- 비밀번호 변경
-- ALTER USER testuser WITH PASSWORD '#skdlf123'


-- Database: javatest

-- DROP DATABASE "javatest";
CREATE DATABASE "javatest"
    WITH 
    OWNER = testuser
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

----------------------------------------
-- 2. SUPERUSER야만 COPY 기능을 사용할 수 있다.
----------------------------------------
ALTER USER testuser WITH SUPERUSER;
-- "must be superuser to COPY to or from a file"

-- Role: testuser

-- DROP ROLE testuser;
CREATE ROLE testuser WITH
  LOGIN
  SUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;

----------------------------------------
-- 3). 데이터베이스 소유자 변경 <- LMS_v2.0 생성할 때 소유자를 등록하면 됨
----------------------------------------
--ALTER DATABASE "LMS_v2.0" OWNER TO lmsuser;
ALTER DATABASE "javatest" OWNER TO testuser; -- 먼저 사용 권한 변경

CREATE EXTENSION dblink SCHEMA public VERSION "1.2";

CREATE EXTENSION pgcrypto SCHEMA public VERSION "1.3";

CREATE EXTENSION tablefunc SCHEMA public VERSION "1.0";

CREATE EXTENSION tsm_system_rows SCHEMA public VERSION "1.0";

CREATE EXTENSION "uuid-ossp" SCHEMA public VERSION "1.1";

----------------------------------------

/*
-- SEQUENCE: public.t_com_category_seq

-- DROP SEQUENCE public.t_com_category_seq;

CREATE SEQUENCE public.t_com_category_seq
    INCREMENT 1
    START 4
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.t_com_category_seq
    OWNER TO lmsuser;
-- Table: public.t_com_category

-- DROP TABLE public.t_com_category;
DROP TABLE IF EXISTS public.t_plsql_error CASCADE;

CREATE TABLE IF NOT EXISTS public.t_com_category
(
    category_seq integer NOT NULL DEFAULT nextval('t_com_category_seq'::regclass),
    category_nm character varying(128) COLLATE pg_catalog."default" NOT NULL,
    category_type character varying(64) COLLATE pg_catalog."default" NOT NULL,
    upper_category_seq integer NOT NULL DEFAULT 0,
    category_level integer NOT NULL DEFAULT 0,
    category_order integer NOT NULL DEFAULT 0,
    create_user_id character varying(64) COLLATE pg_catalog."default",
    create_dt timestamp without time zone,
    update_user_id character varying(64) COLLATE pg_catalog."default",
    update_dt timestamp without time zone,
    sort_order integer DEFAULT 0,
    CONSTRAINT pk_t_com_category PRIMARY KEY (category_seq)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_com_category OWNER to lmsuser;

COMMENT ON TABLE public.t_com_category
    IS '공통 카테고리';

COMMENT ON COLUMN public.t_com_category.category_seq
    IS '카테고리 일련번호';

COMMENT ON COLUMN public.t_com_category.category_nm
    IS '카테고리 명';

COMMENT ON COLUMN public.t_com_category.category_type
    IS '카테고리 구분';

COMMENT ON COLUMN public.t_com_category.upper_category_seq
    IS '상위 일련번호';

COMMENT ON COLUMN public.t_com_category.category_level
    IS '카테고리 레벨';

COMMENT ON COLUMN public.t_com_category.category_order
    IS '카테고리 순서';

COMMENT ON COLUMN public.t_com_category.create_user_id
    IS '작성자';

COMMENT ON COLUMN public.t_com_category.create_dt
    IS '작성 일시';

COMMENT ON COLUMN public.t_com_category.update_user_id
    IS '수정자';

COMMENT ON COLUMN public.t_com_category.update_dt
    IS '수정 일시';

COMMENT ON COLUMN public.t_com_category.sort_order
    IS '정렬 순서';
*/

-- SEQUENCE: public.t_project_seq

-- DROP SEQUENCE public.t_project_seq;

CREATE SEQUENCE public.t_project_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.t_project_seq
    OWNER TO testuser;

-- Table: public.t_project

-- DROP TABLE public.t_project;
DROP TABLE IF EXISTS public.t_project CASCADE;

CREATE TABLE IF NOT EXISTS public.t_project
(
    prj_no integer NOT NULL DEFAULT nextval('t_project_seq'::regclass),
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    decpt text COLLATE pg_catalog."default",
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    CONSTRAINT pk_t_project PRIMARY KEY (prj_no)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_project OWNER to testuser;

COMMENT ON TABLE public.t_project
    IS '프로젝트정보';

COMMENT ON COLUMN public.t_project.prj_no
    IS '프로젝트 일련번호';

COMMENT ON COLUMN public.t_project.title
    IS '프로젝트 명';

COMMENT ON COLUMN public.t_project.decpt
    IS '프로젝트 설명';

COMMENT ON COLUMN public.t_project.start_date
    IS '프로젝트 시작일';

COMMENT ON COLUMN public.t_project.end_date
    IS '프로젝트 종료일';

    
-- Table: public.t_member

-- DROP TABLE public.t_member;
DROP TABLE IF EXISTS public.t_member CASCADE;

CREATE TABLE IF NOT EXISTS public.t_member
(
    email character varying(64) COLLATE pg_catalog."default" NOT NULL,
    name character varying(64) COLLATE pg_catalog."default",
    tel character varying(64) COLLATE pg_catalog."default",
    det_addr character varying(64) COLLATE pg_catalog."default",
    pst_id integer DEFAULT 0,
    CONSTRAINT pk_t_member PRIMARY KEY (email)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.t_member OWNER to testuser;

COMMENT ON TABLE public.t_member
    IS '회원정보';

COMMENT ON COLUMN public.t_member.email
    IS '회원 이메일';

COMMENT ON COLUMN public.t_member.name
    IS '회원 이름';

COMMENT ON COLUMN public.t_member.tel
    IS '회원 전화번호';

COMMENT ON COLUMN public.t_member.det_addr
    IS '회원 주소';

COMMENT ON COLUMN public.t_member.pst_id
    IS '회원 사번';
