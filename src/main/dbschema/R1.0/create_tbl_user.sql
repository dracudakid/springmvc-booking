--liquibase formatted sql

--changeset hcao:2
CREATE TABLE public.tbl_user
(
  user_id SERIAL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  fullname TEXT,
  dob DATE,
  email TEXT
);