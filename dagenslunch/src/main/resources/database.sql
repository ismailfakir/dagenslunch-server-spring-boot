-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
  id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
  user_name character varying(255) NOT NULL,
  user_password character varying(255) NOT NULL,
  user_email character varying(255) NOT NULL,
  user_role character varying(255) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id),
  CONSTRAINT user_user_email_key UNIQUE (user_email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."user"
  OWNER TO dagenslunch;

-- Table: public.restaurant

-- DROP TABLE public.restaurant;

CREATE TABLE public.restaurant
(
  id integer NOT NULL DEFAULT nextval('restaurant_id_seq'::regclass),
  name character varying(255) NOT NULL,
  latitude double precision NOT NULL,
  longitude double precision NOT NULL,
  street character varying(255) NOT NULL,
  post_code character varying(255) NOT NULL,
  city character varying(255) NOT NULL,
  country character varying(255) NOT NULL,
  email character varying(255) NOT NULL,
  password character varying(255) NOT NULL,
  telephone character varying(255) NOT NULL,
  opening_hours character varying(255) NOT NULL,
  category character varying(255) NOT NULL,
  rating smallint,
  active boolean DEFAULT false,
  validity_date date,
  CONSTRAINT pk_restaurant PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.restaurant
  OWNER TO dagenslunch;

-- Table: public.people

-- DROP TABLE public.people;

CREATE TABLE public.people
(
  id bigint NOT NULL DEFAULT nextval('people_id_seq'::regclass),
  full_name character varying(255) NOT NULL,
  job_title character varying(255) NOT NULL,
  CONSTRAINT people_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.people
  OWNER TO dagenslunch;

// insert queries
INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Bee bar Göteborg', 57.703540, 11.967894, 'Kungstorget 13', '41110', 'Göteborg', 'Sweden', 'personal@beebar.se', 'bee123', '031-13 38 39', 'Mon-Fri: 11:30 - 15:00', 'X', 0, true, '2017-04-06');

INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Bee bar Malmö', 58.508393, 13.135094, 'Förstadsgatan 36', '21143', 'Malmö', 'Sweden', 'personal@beebar.se', 'bee456', '040-30 77 28', 'Mon-Fri: 11:30 - 15:00', 'X', 0, true, '2017-04-06');

INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Hard Rock Cafe', 57.701381, 11.974537, 'Kungsportsavenyen 10', '41136', 'Göteborg', 'Sweden', 'gothenburg@hardrock.se', 'secret1', '3110233', 'Mon-Fri: 11:30 - 15:00', 'Y', 0, true, '2017-04-06');


INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Göteborg wok', 57.709316, 11.966394, 'Östra Hamngatan 5', '41110', 'Göteborg', 'Sweden', 'no', 'secret1', '031 13 51 52', 'Mon-Fri: 11:30 - 16:00', 'Y', 0, true, '2017-04-06');

INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Göteborg wok', 57.722906, 11.954941, 'Backavägen 2', '41705', 'Göteborg', 'Sweden', 'no', 'secret1', '031 51 50 80', 'Mon-Fri: 11:30 - 16:00', 'Z', 0, true, '2017-04-06');

INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Restaurang Saray', 57.741848, 12.008720, 'ALEKÄRRSGATAN 8', '41525', 'Göteborg', 'Sweden', 'no', 'secret1', '031-489800', 'Mon-Fri: 11:30 - 15:00', 'Z', 0, true, '2017-04-06');

INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Fiskekrogen', 57.705526, 11.961373, 'Lilla torget 1', '41118', 'Göteborg', 'Sweden', 'info@fiskekrogen.se', 'secret2', '031-10 10 05', 'Mon-Fri: 11:30 - 15:00', 'A', 0, true, '2017-04-06');

INSERT INTO public.restaurant(
    name, latitude, longitude, street, post_code, city, country, email, password, telephone, opening_hours, category, rating, active, validity_date)
    VALUES ('Hello Monkey', 57.693591, 11.953009, 'Linnégatan 52', '41308', 'Göteborg', 'Sweden', '52@hellomonkey.net', 'secret3', '031-12 52 10', 'Mon-Fri: 11:30 - 15:00', 'B', 0, true, '2017-04-06');
