--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.3

-- Started on 2021-12-30 15:11:21

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

--
-- TOC entry 210 (class 1255 OID 16426)
-- Name: seleccionarcategoria(integer); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.seleccionarcategoria(id integer) RETURNS TABLE(idcategoria integer, nombrecategoria character varying, descripcioncategoria character varying)
    LANGUAGE sql
    AS $$
    SELECT * FROM Categoria where idCategoria = id;
$$;


ALTER FUNCTION public.seleccionarcategoria(id integer) OWNER TO postgres;

--
-- TOC entry 206 (class 1255 OID 16422)
-- Name: seleccionatodocategoria(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.seleccionatodocategoria() RETURNS TABLE(idcategoria integer, nombrecategoria character varying, descripcioncategoria character varying)
    LANGUAGE sql
    AS $$
    SELECT * FROM Categoria;
$$;


ALTER FUNCTION public.seleccionatodocategoria() OWNER TO postgres;

--
-- TOC entry 208 (class 1255 OID 16424)
-- Name: spactualizarcategoria(character varying, character varying, integer); Type: PROCEDURE; Schema: public; Owner: postgres
--

CREATE PROCEDURE public.spactualizarcategoria(nombre character varying, descripcion character varying, id integer)
    LANGUAGE sql
    AS $$
    update  Categoria set nombreCategoria = nombre, descripcionCategoria = descripcion where idCategoria = id;
$$;


ALTER PROCEDURE public.spactualizarcategoria(nombre character varying, descripcion character varying, id integer) OWNER TO postgres;

--
-- TOC entry 209 (class 1255 OID 16425)
-- Name: speliminarcategoria(integer); Type: PROCEDURE; Schema: public; Owner: postgres
--

CREATE PROCEDURE public.speliminarcategoria(id integer)
    LANGUAGE sql
    AS $$
    delete from Categoria where idCategoria= id;
$$;


ALTER PROCEDURE public.speliminarcategoria(id integer) OWNER TO postgres;

--
-- TOC entry 207 (class 1255 OID 16423)
-- Name: spinsertarcategoria(character varying, character varying); Type: PROCEDURE; Schema: public; Owner: postgres
--

CREATE PROCEDURE public.spinsertarcategoria(nombre character varying, descripcion character varying)
    LANGUAGE sql
    AS $$
    insert into Categoria (nombreCategoria, descripcionCategoria) values (nombre, descripcion);
$$;


ALTER PROCEDURE public.spinsertarcategoria(nombre character varying, descripcion character varying) OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16397)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    idcategoria integer NOT NULL,
    nombrecategoria character varying(50) NOT NULL,
    descripcioncategoria character varying(100) NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: categoria_idcategoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_idcategoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_idcategoria_seq OWNER TO postgres;

--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 200
-- Name: categoria_idcategoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_idcategoria_seq OWNED BY public.categoria.idcategoria;


--
-- TOC entry 203 (class 1259 OID 16408)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    idproducto integer NOT NULL,
    nombreproducto character varying(50) NOT NULL,
    descripcionproducto character varying(100) NOT NULL,
    precio numeric NOT NULL,
    existencia integer NOT NULL,
    stockminimo integer DEFAULT 10,
    clavecategoria integer NOT NULL
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16406)
-- Name: producto_idproducto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.producto_idproducto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_idproducto_seq OWNER TO postgres;

--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 202
-- Name: producto_idproducto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.producto_idproducto_seq OWNED BY public.producto.idproducto;


--
-- TOC entry 205 (class 1259 OID 16467)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    idusuario integer NOT NULL,
    nombre character varying(50),
    paterno character varying(50),
    materno character varying(50),
    email character varying(50),
    nombreusuario character varying(20),
    claveusuario character varying(20)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16465)
-- Name: usuario_idusuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_idusuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_idusuario_seq OWNER TO postgres;

--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 204
-- Name: usuario_idusuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_idusuario_seq OWNED BY public.usuario.idusuario;


--
-- TOC entry 2868 (class 2604 OID 16400)
-- Name: categoria idcategoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN idcategoria SET DEFAULT nextval('public.categoria_idcategoria_seq'::regclass);


--
-- TOC entry 2869 (class 2604 OID 16411)
-- Name: producto idproducto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto ALTER COLUMN idproducto SET DEFAULT nextval('public.producto_idproducto_seq'::regclass);


--
-- TOC entry 2871 (class 2604 OID 16470)
-- Name: usuario idusuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN idusuario SET DEFAULT nextval('public.usuario_idusuario_seq'::regclass);


--
-- TOC entry 3008 (class 0 OID 16397)
-- Dependencies: 201
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (idcategoria, nombrecategoria, descripcioncategoria) FROM stdin;
5	Categoria vhgjgj	jgjkgjkg 1
8	si cambiado	yesido
9	ffr	wewe
10	dwdw	erwre
12	sia	sia
\.


--
-- TOC entry 3010 (class 0 OID 16408)
-- Dependencies: 203
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (idproducto, nombreproducto, descripcionproducto, precio, existencia, stockminimo, clavecategoria) FROM stdin;
1	PC	PC para juegos	1000	100	10	5
2	PC	PC para juegos	1000	100	10	5
3	PC	PC para juegos	1000	100	10	5
4	PC	PC para juegos	1000	100	10	5
5	PC	PC para juegos	1000	100	10	8
6	PC	PC para juegos	1000	100	10	8
7	PC	PC para juegos	1000	100	10	8
8	PC	PC para juegos	1000	100	10	8
9	PC	PC para juegos	1000	100	10	8
10	PC	PC para juegos	1000	100	10	9
11	PC	PC para juegos	1000	100	10	9
12	PC	PC para juegos	1000	100	10	9
\.


--
-- TOC entry 3012 (class 0 OID 16467)
-- Dependencies: 205
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (idusuario, nombre, paterno, materno, email, nombreusuario, claveusuario) FROM stdin;
\.


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 200
-- Name: categoria_idcategoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_idcategoria_seq', 13, true);


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 202
-- Name: producto_idproducto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.producto_idproducto_seq', 2, true);


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 204
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_idusuario_seq', 1, false);


--
-- TOC entry 2873 (class 2606 OID 16402)
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (idcategoria);


--
-- TOC entry 2875 (class 2606 OID 16414)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (idproducto);


--
-- TOC entry 2876 (class 2606 OID 16415)
-- Name: producto producto_clavecategoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_clavecategoria_fkey FOREIGN KEY (clavecategoria) REFERENCES public.categoria(idcategoria) ON UPDATE CASCADE ON DELETE CASCADE;


-- Completed on 2021-12-30 15:11:21

--
-- PostgreSQL database dump complete
--

