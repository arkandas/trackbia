-- DROP SCHEMA trackbia;

CREATE SCHEMA trackbia AUTHORIZATION arkandas;

-- trackbia.pageview definition

-- Drop table

-- DROP TABLE trackbia.pageview;

CREATE TABLE trackbia.pageview (
	id bigserial NOT NULL,
	asn_number varchar(255) NULL,
	asn_operator varchar(255) NULL,
	city varchar(255) NULL,
	country varchar(255) NULL,
	country_iso_code varchar(255) NULL,
	hash_id varchar(255) NULL,
	ip_address varchar(255) NULL,
	latitude varchar(255) NULL,
	longitude varchar(255) NULL,
	page varchar(255) NULL,
	postal_code varchar(255) NULL,
	"timestamp" timestamptz NOT NULL,
	time_zone varchar(255) NULL,
	user_browser varchar(255) NULL,
	user_browser_version varchar(255) NULL,
	user_device varchar(255) NULL,
	user_device_type varchar(255) NULL,
	user_id int4 NULL,
	user_os varchar(255) NULL,
	user_os_version varchar(255) NULL,
	CONSTRAINT pageview_pkey PRIMARY KEY (id)
);


-- trackbia.qr_code definition

-- Drop table

-- DROP TABLE trackbia.qr_code;

CREATE TABLE trackbia.qr_code (
	id serial4 NOT NULL,
	creation_date timestamptz NOT NULL,
	description varchar(255) NULL,
	hash_id varchar(255) NULL,
	"type" int4 NULL,
	url varchar(255) NULL,
	user_id int4 NULL,
	CONSTRAINT qr_code_pkey PRIMARY KEY (id)
);


-- trackbia.roles definition

-- Drop table

-- DROP TABLE trackbia.roles;

CREATE TABLE trackbia.roles (
	id serial4 NOT NULL,
	"name" varchar(20) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);


-- trackbia.users definition

-- Drop table

-- DROP TABLE trackbia.users;

CREATE TABLE trackbia.users (
	id bigserial NOT NULL,
	email varchar(255) NULL,
	"password" varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
	CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- trackbia.user_roles definition

-- Drop table

-- DROP TABLE trackbia.user_roles;

CREATE TABLE trackbia.user_roles (
	user_id int8 NOT NULL,
	role_id int4 NOT NULL,
	CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id),
	CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES trackbia.roles(id),
	CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES trackbia.users(id)
);

INSERT INTO trackbia.roles
(id, "name")
VALUES(1, 'ROLE_ADMIN');
INSERT INTO trackbia.roles
(id, "name")
VALUES(2, 'ROLE_USER');
