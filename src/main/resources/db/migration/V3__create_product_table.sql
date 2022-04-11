CREATE TABLE IF NOT EXISTS public.category_tbl
(
    category_id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    category_fld character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT category_tbl_pkey PRIMARY KEY (category_id),
    CONSTRAINT category_tbl_category_fld_key UNIQUE (category_fld)
);

CREATE TABLE IF NOT EXISTS public.brand_tbl
(
    brand_id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    brand_fld character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT brand_tbl_pkey PRIMARY KEY (brand_id),
    CONSTRAINT brand_tbl_brand_fld_key UNIQUE (brand_fld)
);

CREATE TABLE IF NOT EXISTS public.image_tbl
(
    image_id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    image_fld character varying(255),
    CONSTRAINT image_tbl_pkey PRIMARY KEY (image_id),
    CONSTRAINT image_tbl_brand_fld_key UNIQUE (image_fld)
);

CREATE TABLE IF NOT EXISTS public.product_tbl
(
    id smallint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 32767 CACHE 1 ),
    product_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    brand_id smallint NOT NULL,
    category_id smallint NOT NULL,
	price DECIMAL(8,2),
	image_id smallint,
	description  character varying(500),
    recording_time DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT product_tbl_pkey PRIMARY KEY (id),
   	CONSTRAINT category_fk FOREIGN KEY (category_id)
        REFERENCES public.category_tbl (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT image_fk FOREIGN KEY (image_id)
        REFERENCES public.image_tbl (image_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT brand_fk FOREIGN KEY (brand_id)
        REFERENCES public.brand_tbl (brand_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
