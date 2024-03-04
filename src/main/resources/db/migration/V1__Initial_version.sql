-- Table: public._user

-- DROP TABLE IF EXISTS public._user;

CREATE TABLE IF NOT EXISTS public._user
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    firstname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT _user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public._user
    OWNER to postgres;

-- Table: public.quack_post

-- DROP TABLE IF EXISTS public.quack_post;

CREATE TABLE IF NOT EXISTS public.quack_post
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    created_on timestamp(6) with time zone NOT NULL DEFAULT now(),
    content character varying(300) COLLATE pg_catalog."default" NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT quack_post_pkey PRIMARY KEY (id),
    CONSTRAINT fk_user_quack_post FOREIGN KEY (user_id)
            REFERENCES public._user (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.quack_post
    OWNER to postgres;

-- Table: public.token

-- DROP TABLE IF EXISTS public.token;

CREATE TABLE IF NOT EXISTS public.token
(
    id integer NOT NULL,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(255) COLLATE pg_catalog."default",
    token_type character varying(255) COLLATE pg_catalog."default",
    user_id integer,
    CONSTRAINT token_pkey PRIMARY KEY (id),
    CONSTRAINT token_token_type_check CHECK (token_type::text = 'BEARER'::text),
    CONSTRAINT fk_user_token FOREIGN KEY (user_id)
                REFERENCES public._user (id) MATCH SIMPLE
                ON UPDATE NO ACTION
                ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.token
    OWNER to postgres;