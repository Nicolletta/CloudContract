-- Database: contracts

-- DROP DATABASE contracts;

CREATE DATABASE contracts
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United Kingdom.1252'
    LC_CTYPE = 'English_United Kingdom.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.account

-- DROP TABLE public.account;

CREATE TABLE public.account
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name character varying COLLATE pg_catalog."default",
    CONSTRAINT reservation_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.account
    OWNER to postgres;