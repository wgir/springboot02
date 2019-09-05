--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.3

-- Started on 2019-08-09 15:41:34

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
-- TOC entry 197 (class 1259 OID 24800)
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
-- TOC entry 196 (class 1259 OID 24798)
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
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contacto_id_seq OWNED BY public.contacto.id;


--
-- TOC entry 199 (class 1259 OID 24811)
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
-- TOC entry 198 (class 1259 OID 24809)
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
-- TOC entry 2842 (class 0 OID 0)
-- Dependencies: 198
-- Name: persona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;


--
-- TOC entry 201 (class 1259 OID 24822)
-- Name: tipodocumento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipodocumento (
    id integer NOT NULL,
    glosa character varying(50)
);


ALTER TABLE public.tipodocumento OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24820)
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
-- TOC entry 2843 (class 0 OID 0)
-- Dependencies: 200
-- Name: tipodocumento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipodocumento_id_seq OWNED BY public.tipodocumento.id;


--
-- TOC entry 2699 (class 2604 OID 24803)
-- Name: contacto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto ALTER COLUMN id SET DEFAULT nextval('public.contacto_id_seq'::regclass);


--
-- TOC entry 2700 (class 2604 OID 24814)
-- Name: persona id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 24825)
-- Name: tipodocumento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipodocumento ALTER COLUMN id SET DEFAULT nextval('public.tipodocumento_id_seq'::regclass);


--
-- TOC entry 2831 (class 0 OID 24800)
-- Dependencies: 197
-- Data for Name: contacto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contacto (id, documento, firstname, lastname) FROM stdin;
1	1	b	bu
2	2	nombre 2	apellido 2
3	1	nombre 2	apellido 2
4	1	b	bu
5	1	b	bu
6	6	nombre 6	apellido 6
7	1	b	bu
8	1	b	bu
9	9	nombre 9	apellido 9
10	8	nombre 9	apellido 9
11	11	nombre 11	apellido 11
12	10	nombre 11	apellido 11
13	13	nombre 13	apellido 13
\.


--
-- TOC entry 2833 (class 0 OID 24811)
-- Dependencies: 199
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id, email, firstname, lastname, phonenumber, tipodocumentoid) FROM stdin;
1	xxx@gmail.com	nombre 1	apellido	111111	1
2	xxx@gmail.com	nombre 1	apellido	111111	1
3	xxx@gmail.com	nombre 1	apellido	111111	1
4	xxx@gmail.com	nombre 1	apellido	111111	1
5	xxx@gmail.com	nombre 1	apellido	111111	1
6	xxx@gmail.com	nombre 1	apellido	111111	1
7	xxx@gmail.com	nombre 1	apellido	111111	1
8	xxx@gmail.com	nombre 1	apellido	111111	1
9	xxx@gmail.com	nombre 1	apellido	111111	1
10	xxx@gmail.com	nombre 1	apellido	111111	1
11	xxx@gmail.com	nombre 1	apellido	111111	1
\.


--
-- TOC entry 2835 (class 0 OID 24822)
-- Dependencies: 201
-- Data for Name: tipodocumento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipodocumento (id, glosa) FROM stdin;
1	Cedula
\.


--
-- TOC entry 2844 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contacto_id_seq', 13, true);


--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 198
-- Name: persona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_seq', 11, true);


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 200
-- Name: tipodocumento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipodocumento_id_seq', 1, true);


--
-- TOC entry 2703 (class 2606 OID 24808)
-- Name: contacto contacto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contacto
    ADD CONSTRAINT contacto_pkey PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 24819)
-- Name: persona persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);


--
-- TOC entry 2707 (class 2606 OID 24827)
-- Name: tipodocumento tipodocumento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipodocumento
    ADD CONSTRAINT tipodocumento_pkey PRIMARY KEY (id);


--
-- TOC entry 2708 (class 2606 OID 24828)
-- Name: persona fkf4hf0hahwm90epdj0nvax055o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT fkf4hf0hahwm90epdj0nvax055o FOREIGN KEY (tipodocumentoid) REFERENCES public.tipodocumento(id);


-- Completed on 2019-08-09 15:41:40

--
-- PostgreSQL database dump complete
--

