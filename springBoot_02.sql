--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.5

-- Started on 2019-09-07 15:27:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16410)
-- Name: contacto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contacto (
    id bigint NOT NULL,
    documento character varying(255),
    firstname character varying(255),
    lastname character varying(255)
);


ALTER TABLE public.contacto OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16408)
-- Name: contacto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contacto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contacto_id_seq OWNER TO postgres;

--
-- TOC entry 3541 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contacto_id_seq OWNED BY public.contacto.id;


--
-- TOC entry 199 (class 1259 OID 16421)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.persona (
    id bigint NOT NULL,
    email character varying(255),
    firstname character varying(255) NOT NULL,
    lastname character varying(255),
    phonenumber character varying(255),
    tipodocumentoid integer NOT NULL
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16419)
-- Name: persona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_id_seq OWNER TO postgres;

--
-- TOC entry 3542 (class 0 OID 0)
-- Dependencies: 198
-- Name: persona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;


--
-- TOC entry 201 (class 1259 OID 16432)
-- Name: tipodocumento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipodocumento (
    id integer NOT NULL,
    glosa character varying(50)
);


ALTER TABLE public.tipodocumento OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16430)
-- Name: tipodocumento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipodocumento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipodocumento_id_seq OWNER TO postgres;

--
-- TOC entry 3543 (class 0 OID 0)
-- Dependencies: 200
-- Name: tipodocumento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipodocumento_id_seq OWNED BY public.tipodocumento.id;


--
-- TOC entry 3398 (class 2604 OID 16413)
-- Name: contacto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto ALTER COLUMN id SET DEFAULT nextval('public.contacto_id_seq'::regclass);


--
-- TOC entry 3399 (class 2604 OID 16424)
-- Name: persona id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);


--
-- TOC entry 3400 (class 2604 OID 16435)
-- Name: tipodocumento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipodocumento ALTER COLUMN id SET DEFAULT nextval('public.tipodocumento_id_seq'::regclass);


--
-- TOC entry 3530 (class 0 OID 16410)
-- Dependencies: 197
-- Data for Name: contacto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contacto (id, documento, firstname, lastname) FROM stdin;
\.


--
-- TOC entry 3532 (class 0 OID 16421)
-- Dependencies: 199
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id, email, firstname, lastname, phonenumber, tipodocumentoid) FROM stdin;
\.


--
-- TOC entry 3534 (class 0 OID 16432)
-- Dependencies: 201
-- Data for Name: tipodocumento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipodocumento (id, glosa) FROM stdin;
\.


--
-- TOC entry 3544 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contacto_id_seq', 1, false);


--
-- TOC entry 3545 (class 0 OID 0)
-- Dependencies: 198
-- Name: persona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_seq', 1, false);


--
-- TOC entry 3546 (class 0 OID 0)
-- Dependencies: 200
-- Name: tipodocumento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipodocumento_id_seq', 1, false);


--
-- TOC entry 3402 (class 2606 OID 16418)
-- Name: contacto contacto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT contacto_pkey PRIMARY KEY (id);


--
-- TOC entry 3404 (class 2606 OID 16429)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 3406 (class 2606 OID 16437)
-- Name: tipodocumento tipodocumento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipodocumento
    ADD CONSTRAINT tipodocumento_pkey PRIMARY KEY (id);


--
-- TOC entry 3407 (class 2606 OID 16438)
-- Name: persona fkf4hf0hahwm90epdj0nvax055o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT fkf4hf0hahwm90epdj0nvax055o FOREIGN KEY (tipodocumentoid) REFERENCES public.tipodocumento(id);


--
-- TOC entry 3540 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: cloudsqlsuperuser
--

REVOKE ALL ON SCHEMA public FROM cloudsqladmin;
REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO cloudsqlsuperuser;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2019-09-07 15:27:51

--
-- PostgreSQL database dump complete
--

