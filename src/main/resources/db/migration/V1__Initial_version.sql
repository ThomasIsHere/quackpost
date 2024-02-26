-- Extension: "uuid-ossp"

-- DROP EXTENSION "uuid-ossp";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp"
    SCHEMA public
    VERSION "1.1";

-- Table: public.quack_post

-- DROP TABLE IF EXISTS public.quack_post;

CREATE TABLE IF NOT EXISTS public.quack_post
(
    id uuid NOT NULL DEFAULT uuid_generate_v4(),
    created_on timestamp(6) with time zone NOT NULL DEFAULT now(),
    content character varying(300) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT quack_post_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.employee
    OWNER to postgres;