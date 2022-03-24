CREATE DATABASE springbootDB;
CREATE SCHEMA public;

CREATE TABLE IF NOT EXISTS public.event
(
    id integer NOT NULL DEFAULT nextval('event_id_seq'::regclass),
    date_time timestamp without time zone,
    event_type character varying(255) COLLATE pg_catalog."default",
    place character varying(255) COLLATE pg_catalog."default",
    speaker character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT event_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.event
    OWNER to postgres;