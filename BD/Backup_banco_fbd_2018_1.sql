--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.17
-- Dumped by pg_dump version 9.4.17
-- Started on 2018-07-17 21:29:36

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2353 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 221 (class 1259 OID 26261)
-- Name: caixa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.caixa (
    id integer NOT NULL,
    saldo double precision,
    nome character varying(255)
);


ALTER TABLE public.caixa OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 26259)
-- Name: caixa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.caixa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.caixa_id_seq OWNER TO postgres;

--
-- TOC entry 2354 (class 0 OID 0)
-- Dependencies: 220
-- Name: caixa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.caixa_id_seq OWNED BY public.caixa.id;


--
-- TOC entry 202 (class 1259 OID 26115)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.cargo (
    id integer NOT NULL,
    descricao_cargo character varying(4000),
    nome character varying(255)
);


ALTER TABLE public.cargo OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 26113)
-- Name: cargo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cargo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cargo_id_seq OWNER TO postgres;

--
-- TOC entry 2355 (class 0 OID 0)
-- Dependencies: 201
-- Name: cargo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cargo_id_seq OWNED BY public.cargo.id;


--
-- TOC entry 178 (class 1259 OID 25907)
-- Name: clinica; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.clinica (
    id integer NOT NULL,
    nome character varying(255),
    cnpj character varying(14),
    descricao_complemento character varying(500),
    telefone character varying(20),
    id_endereco integer
);


ALTER TABLE public.clinica OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 25905)
-- Name: clinica_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clinica_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clinica_id_seq OWNER TO postgres;

--
-- TOC entry 2356 (class 0 OID 0)
-- Dependencies: 177
-- Name: clinica_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clinica_id_seq OWNED BY public.clinica.id;


--
-- TOC entry 190 (class 1259 OID 26012)
-- Name: consulta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.consulta (
    id integer NOT NULL,
    tipo character varying(100),
    horario character varying(20),
    id_paciente integer,
    id_medico integer,
    _data date,
    situacao boolean
);


ALTER TABLE public.consulta OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 26010)
-- Name: consulta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.consulta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consulta_id_seq OWNER TO postgres;

--
-- TOC entry 2357 (class 0 OID 0)
-- Dependencies: 189
-- Name: consulta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.consulta_id_seq OWNED BY public.consulta.id;


--
-- TOC entry 227 (class 1259 OID 26295)
-- Name: contas_pagar; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.contas_pagar (
    id integer NOT NULL,
    valor double precision,
    id_caixas integer,
    id_dispesas integer
);


ALTER TABLE public.contas_pagar OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 26293)
-- Name: contas_pagar_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contas_pagar_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contas_pagar_id_seq OWNER TO postgres;

--
-- TOC entry 2358 (class 0 OID 0)
-- Dependencies: 226
-- Name: contas_pagar_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contas_pagar_id_seq OWNED BY public.contas_pagar.id;


--
-- TOC entry 223 (class 1259 OID 26269)
-- Name: contas_receber; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.contas_receber (
    id integer NOT NULL,
    valor double precision,
    id_caixas integer,
    id_vendas integer
);


ALTER TABLE public.contas_receber OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 26267)
-- Name: contas_receber_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contas_receber_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contas_receber_id_seq OWNER TO postgres;

--
-- TOC entry 2359 (class 0 OID 0)
-- Dependencies: 222
-- Name: contas_receber_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contas_receber_id_seq OWNED BY public.contas_receber.id;


--
-- TOC entry 204 (class 1259 OID 26131)
-- Name: convenio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.convenio (
    id integer NOT NULL,
    data_inicio date,
    descricao_regiao character varying,
    nome character varying
);


ALTER TABLE public.convenio OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 26129)
-- Name: convenio_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.convenio_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.convenio_id_seq OWNER TO postgres;

--
-- TOC entry 2360 (class 0 OID 0)
-- Dependencies: 203
-- Name: convenio_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.convenio_id_seq OWNED BY public.convenio.id;


--
-- TOC entry 225 (class 1259 OID 26287)
-- Name: despesa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.despesa (
    id integer NOT NULL,
    categoria character varying(255),
    valor double precision,
    data_vencimento date
);


ALTER TABLE public.despesa OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 26285)
-- Name: despesa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.despesa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.despesa_id_seq OWNER TO postgres;

--
-- TOC entry 2361 (class 0 OID 0)
-- Dependencies: 224
-- Name: despesa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.despesa_id_seq OWNED BY public.despesa.id;


--
-- TOC entry 184 (class 1259 OID 25950)
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.endereco (
    id integer NOT NULL,
    cep character varying(20),
    estado character varying(255),
    logradouro character varying(20),
    complemento character varying(20),
    bairro character varying(255),
    rua character varying(255),
    pais character varying(255),
    cidade character varying(255),
    numero integer
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 25948)
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_id_seq OWNER TO postgres;

--
-- TOC entry 2362 (class 0 OID 0)
-- Dependencies: 183
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;


--
-- TOC entry 216 (class 1259 OID 26217)
-- Name: estoque; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.estoque (
    id integer NOT NULL,
    id_fornecedores integer,
    id_produtos integer,
    total_produtos integer
);


ALTER TABLE public.estoque OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 26215)
-- Name: estoque_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estoque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estoque_id_seq OWNER TO postgres;

--
-- TOC entry 2363 (class 0 OID 0)
-- Dependencies: 215
-- Name: estoque_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estoque_id_seq OWNED BY public.estoque.id;


--
-- TOC entry 198 (class 1259 OID 26083)
-- Name: exame; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.exame (
    id integer NOT NULL,
    id_receita integer,
    observacoes character varying(4000),
    nome character varying(255)
);


ALTER TABLE public.exame OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 26081)
-- Name: exame_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exame_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exame_id_seq OWNER TO postgres;

--
-- TOC entry 2364 (class 0 OID 0)
-- Dependencies: 197
-- Name: exame_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exame_id_seq OWNED BY public.exame.id;


--
-- TOC entry 186 (class 1259 OID 25961)
-- Name: fornecedor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.fornecedor (
    id integer NOT NULL,
    incs_municipal integer,
    cnpj character varying(14),
    insc_estadual integer,
    nome character varying(255),
    telefone character varying(20),
    id_endereco integer
);


ALTER TABLE public.fornecedor OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 25959)
-- Name: fornecedor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fornecedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fornecedor_id_seq OWNER TO postgres;

--
-- TOC entry 2365 (class 0 OID 0)
-- Dependencies: 185
-- Name: fornecedor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fornecedor_id_seq OWNED BY public.fornecedor.id;


--
-- TOC entry 180 (class 1259 OID 25924)
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.funcionario (
    id integer NOT NULL,
    nome character varying(255),
    cpf character varying(11),
    id_clinicas integer,
    admim character varying(255),
    senha character varying(255),
    id_cargos integer,
    nome_usuario character varying(255),
    data_acesso date,
    telefone character varying(20),
    rg character varying(9),
    id_endereco integer
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 25922)
-- Name: funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.funcionario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.funcionario_id_seq OWNER TO postgres;

--
-- TOC entry 2366 (class 0 OID 0)
-- Dependencies: 179
-- Name: funcionario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.id;


--
-- TOC entry 192 (class 1259 OID 26030)
-- Name: laudo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.laudo (
    id integer NOT NULL,
    _data date,
    horario character varying(20),
    descricao character varying(4000),
    id_paciente integer,
    id_medico integer
);


ALTER TABLE public.laudo OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 26028)
-- Name: laudo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.laudo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.laudo_id_seq OWNER TO postgres;

--
-- TOC entry 2367 (class 0 OID 0)
-- Dependencies: 191
-- Name: laudo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.laudo_id_seq OWNED BY public.laudo.id;


--
-- TOC entry 200 (class 1259 OID 26099)
-- Name: local_end; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.local_end (
    id integer NOT NULL,
    rua character varying(255),
    nome_clinica character varying(255),
    telefone character varying(20),
    bairro character varying(255),
    id_exame integer
);


ALTER TABLE public.local_end OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 26097)
-- Name: local_end_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.local_end_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.local_end_id_seq OWNER TO postgres;

--
-- TOC entry 2368 (class 0 OID 0)
-- Dependencies: 199
-- Name: local_end_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.local_end_id_seq OWNED BY public.local_end.id;


--
-- TOC entry 182 (class 1259 OID 25942)
-- Name: log_acesso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.log_acesso (
    id integer NOT NULL,
    data_acesso date,
    nome_usuario character varying(255)
);


ALTER TABLE public.log_acesso OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 25940)
-- Name: log_acesso_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.log_acesso_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.log_acesso_id_seq OWNER TO postgres;

--
-- TOC entry 2369 (class 0 OID 0)
-- Dependencies: 181
-- Name: log_acesso_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.log_acesso_id_seq OWNED BY public.log_acesso.id;


--
-- TOC entry 194 (class 1259 OID 26051)
-- Name: medicamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.medicamento (
    id integer NOT NULL,
    descricao_laboratorio character varying(4000),
    desricao_generica character varying(4000),
    descricao_substancia character varying(4000),
    nome character varying(255)
);


ALTER TABLE public.medicamento OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 26049)
-- Name: medicamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medicamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicamento_id_seq OWNER TO postgres;

--
-- TOC entry 2370 (class 0 OID 0)
-- Dependencies: 193
-- Name: medicamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medicamento_id_seq OWNED BY public.medicamento.id;


--
-- TOC entry 176 (class 1259 OID 25894)
-- Name: medico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.medico (
    id integer NOT NULL,
    cpf character varying(11),
    area character varying(255),
    especialidade character varying(255),
    nome_usuario character varying(255),
    senha character varying(255),
    nome character varying(255),
    rg character varying(9),
    id_endereco integer,
    admim character varying(255)
);


ALTER TABLE public.medico OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 25892)
-- Name: medico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medico_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medico_id_seq OWNER TO postgres;

--
-- TOC entry 2371 (class 0 OID 0)
-- Dependencies: 175
-- Name: medico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medico_id_seq OWNED BY public.medico.id;


--
-- TOC entry 174 (class 1259 OID 25881)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.paciente (
    id integer NOT NULL,
    nome character varying(255),
    rg character varying(11),
    cpf character varying(11),
    telefone character varying(20),
    id_prontuario integer,
    id_endereco integer,
    nome_mae character varying(255),
    datanascimento date,
    nome_pai character varying(255),
    id_convenio integer
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 25879)
-- Name: paciente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.paciente_id_seq OWNER TO postgres;

--
-- TOC entry 2372 (class 0 OID 0)
-- Dependencies: 173
-- Name: paciente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_id_seq OWNED BY public.paciente.id;


--
-- TOC entry 208 (class 1259 OID 26162)
-- Name: pagamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.pagamento (
    id integer NOT NULL,
    valor double precision
);


ALTER TABLE public.pagamento OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 26160)
-- Name: pagamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pagamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pagamento_id_seq OWNER TO postgres;

--
-- TOC entry 2373 (class 0 OID 0)
-- Dependencies: 207
-- Name: pagamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pagamento_id_seq OWNED BY public.pagamento.id;


--
-- TOC entry 210 (class 1259 OID 26170)
-- Name: pagamentos_vendas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.pagamentos_vendas (
    id integer NOT NULL,
    id_vendas integer,
    id_pagamento integer
);


ALTER TABLE public.pagamentos_vendas OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 26168)
-- Name: pagamentos_vendas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pagamentos_vendas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pagamentos_vendas_id_seq OWNER TO postgres;

--
-- TOC entry 2374 (class 0 OID 0)
-- Dependencies: 209
-- Name: pagamentos_vendas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pagamentos_vendas_id_seq OWNED BY public.pagamentos_vendas.id;


--
-- TOC entry 212 (class 1259 OID 26188)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.produto (
    id integer NOT NULL,
    tipo character varying(255),
    unidade_entrada integer,
    unidade_saida integer,
    quantidade integer,
    preco double precision,
    nome character varying(255)
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 26186)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 2375 (class 0 OID 0)
-- Dependencies: 211
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 214 (class 1259 OID 26199)
-- Name: produtos_vendas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.produtos_vendas (
    id integer NOT NULL,
    id_produtos integer,
    id_vendas integer
);


ALTER TABLE public.produtos_vendas OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 26197)
-- Name: produtos_vendas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produtos_vendas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produtos_vendas_id_seq OWNER TO postgres;

--
-- TOC entry 2376 (class 0 OID 0)
-- Dependencies: 213
-- Name: produtos_vendas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produtos_vendas_id_seq OWNED BY public.produtos_vendas.id;


--
-- TOC entry 188 (class 1259 OID 25996)
-- Name: prontuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.prontuario (
    id integer NOT NULL,
    data_exame date,
    data_inicio date,
    data_final date,
    descricao_resultado character varying(4000),
    observacao character varying(4000)
);


ALTER TABLE public.prontuario OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 25994)
-- Name: prontuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prontuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prontuario_id_seq OWNER TO postgres;

--
-- TOC entry 2377 (class 0 OID 0)
-- Dependencies: 187
-- Name: prontuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prontuario_id_seq OWNED BY public.prontuario.id;


--
-- TOC entry 196 (class 1259 OID 26062)
-- Name: receita; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.receita (
    id integer NOT NULL,
    observacoes character varying(4000),
    id_medicamentos integer,
    nome_clinica character varying(255),
    id_medico integer
);


ALTER TABLE public.receita OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 26060)
-- Name: receita_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.receita_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.receita_id_seq OWNER TO postgres;

--
-- TOC entry 2378 (class 0 OID 0)
-- Dependencies: 195
-- Name: receita_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.receita_id_seq OWNED BY public.receita.id;


--
-- TOC entry 218 (class 1259 OID 26235)
-- Name: servico; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.servico (
    id integer NOT NULL,
    valor double precision,
    tipo character varying(255),
    descricao character varying(4000)
);


ALTER TABLE public.servico OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 26233)
-- Name: servico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.servico_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.servico_id_seq OWNER TO postgres;

--
-- TOC entry 2379 (class 0 OID 0)
-- Dependencies: 217
-- Name: servico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.servico_id_seq OWNED BY public.servico.id;


--
-- TOC entry 219 (class 1259 OID 26244)
-- Name: servicos_vendas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.servicos_vendas (
    id integer NOT NULL,
    id_vendas integer,
    id_servicos integer,
    id_produtos integer
);


ALTER TABLE public.servicos_vendas OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 26147)
-- Name: venda; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.venda (
    id integer NOT NULL,
    data date,
    nota_fiscal integer,
    status boolean,
    total double precision,
    desconto double precision,
    valor_recebido double precision,
    troco double precision,
    id_pacientes integer
);


ALTER TABLE public.venda OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 26145)
-- Name: venda_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venda_id_seq OWNER TO postgres;

--
-- TOC entry 2380 (class 0 OID 0)
-- Dependencies: 205
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venda_id_seq OWNED BY public.venda.id;


--
-- TOC entry 2079 (class 2604 OID 26264)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.caixa ALTER COLUMN id SET DEFAULT nextval('public.caixa_id_seq'::regclass);


--
-- TOC entry 2070 (class 2604 OID 26118)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo ALTER COLUMN id SET DEFAULT nextval('public.cargo_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 25910)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clinica ALTER COLUMN id SET DEFAULT nextval('public.clinica_id_seq'::regclass);


--
-- TOC entry 2064 (class 2604 OID 26015)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta ALTER COLUMN id SET DEFAULT nextval('public.consulta_id_seq'::regclass);


--
-- TOC entry 2082 (class 2604 OID 26298)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contas_pagar ALTER COLUMN id SET DEFAULT nextval('public.contas_pagar_id_seq'::regclass);


--
-- TOC entry 2080 (class 2604 OID 26272)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contas_receber ALTER COLUMN id SET DEFAULT nextval('public.contas_receber_id_seq'::regclass);


--
-- TOC entry 2071 (class 2604 OID 26134)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.convenio ALTER COLUMN id SET DEFAULT nextval('public.convenio_id_seq'::regclass);


--
-- TOC entry 2081 (class 2604 OID 26290)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.despesa ALTER COLUMN id SET DEFAULT nextval('public.despesa_id_seq'::regclass);


--
-- TOC entry 2061 (class 2604 OID 25953)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);


--
-- TOC entry 2077 (class 2604 OID 26220)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque ALTER COLUMN id SET DEFAULT nextval('public.estoque_id_seq'::regclass);


--
-- TOC entry 2068 (class 2604 OID 26086)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exame ALTER COLUMN id SET DEFAULT nextval('public.exame_id_seq'::regclass);


--
-- TOC entry 2062 (class 2604 OID 25964)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor ALTER COLUMN id SET DEFAULT nextval('public.fornecedor_id_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 25927)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.funcionario_id_seq'::regclass);


--
-- TOC entry 2065 (class 2604 OID 26033)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laudo ALTER COLUMN id SET DEFAULT nextval('public.laudo_id_seq'::regclass);


--
-- TOC entry 2069 (class 2604 OID 26102)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.local_end ALTER COLUMN id SET DEFAULT nextval('public.local_end_id_seq'::regclass);


--
-- TOC entry 2060 (class 2604 OID 25945)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.log_acesso ALTER COLUMN id SET DEFAULT nextval('public.log_acesso_id_seq'::regclass);


--
-- TOC entry 2066 (class 2604 OID 26054)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicamento ALTER COLUMN id SET DEFAULT nextval('public.medicamento_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 25897)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico ALTER COLUMN id SET DEFAULT nextval('public.medico_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 25884)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente ALTER COLUMN id SET DEFAULT nextval('public.paciente_id_seq'::regclass);


--
-- TOC entry 2073 (class 2604 OID 26165)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento ALTER COLUMN id SET DEFAULT nextval('public.pagamento_id_seq'::regclass);


--
-- TOC entry 2074 (class 2604 OID 26173)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamentos_vendas ALTER COLUMN id SET DEFAULT nextval('public.pagamentos_vendas_id_seq'::regclass);


--
-- TOC entry 2075 (class 2604 OID 26191)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 2076 (class 2604 OID 26202)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos_vendas ALTER COLUMN id SET DEFAULT nextval('public.produtos_vendas_id_seq'::regclass);


--
-- TOC entry 2063 (class 2604 OID 25999)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prontuario ALTER COLUMN id SET DEFAULT nextval('public.prontuario_id_seq'::regclass);


--
-- TOC entry 2067 (class 2604 OID 26065)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita ALTER COLUMN id SET DEFAULT nextval('public.receita_id_seq'::regclass);


--
-- TOC entry 2078 (class 2604 OID 26238)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servico ALTER COLUMN id SET DEFAULT nextval('public.servico_id_seq'::regclass);


--
-- TOC entry 2072 (class 2604 OID 26150)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda ALTER COLUMN id SET DEFAULT nextval('public.venda_id_seq'::regclass);


--
-- TOC entry 2338 (class 0 OID 26261)
-- Dependencies: 221
-- Data for Name: caixa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.caixa (id, saldo, nome) FROM stdin;
\.


--
-- TOC entry 2381 (class 0 OID 0)
-- Dependencies: 220
-- Name: caixa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.caixa_id_seq', 1, false);


--
-- TOC entry 2319 (class 0 OID 26115)
-- Dependencies: 202
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cargo (id, descricao_cargo, nome) FROM stdin;
\.


--
-- TOC entry 2382 (class 0 OID 0)
-- Dependencies: 201
-- Name: cargo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cargo_id_seq', 1, false);


--
-- TOC entry 2295 (class 0 OID 25907)
-- Dependencies: 178
-- Data for Name: clinica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clinica (id, nome, cnpj, descricao_complemento, telefone, id_endereco) FROM stdin;
\.


--
-- TOC entry 2383 (class 0 OID 0)
-- Dependencies: 177
-- Name: clinica_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clinica_id_seq', 1, false);


--
-- TOC entry 2307 (class 0 OID 26012)
-- Dependencies: 190
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consulta (id, tipo, horario, id_paciente, id_medico, _data, situacao) FROM stdin;
\.


--
-- TOC entry 2384 (class 0 OID 0)
-- Dependencies: 189
-- Name: consulta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.consulta_id_seq', 1, false);


--
-- TOC entry 2344 (class 0 OID 26295)
-- Dependencies: 227
-- Data for Name: contas_pagar; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contas_pagar (id, valor, id_caixas, id_dispesas) FROM stdin;
\.


--
-- TOC entry 2385 (class 0 OID 0)
-- Dependencies: 226
-- Name: contas_pagar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contas_pagar_id_seq', 1, false);


--
-- TOC entry 2340 (class 0 OID 26269)
-- Dependencies: 223
-- Data for Name: contas_receber; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contas_receber (id, valor, id_caixas, id_vendas) FROM stdin;
\.


--
-- TOC entry 2386 (class 0 OID 0)
-- Dependencies: 222
-- Name: contas_receber_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contas_receber_id_seq', 1, false);


--
-- TOC entry 2321 (class 0 OID 26131)
-- Dependencies: 204
-- Data for Name: convenio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.convenio (id, data_inicio, descricao_regiao, nome) FROM stdin;
\.


--
-- TOC entry 2387 (class 0 OID 0)
-- Dependencies: 203
-- Name: convenio_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.convenio_id_seq', 1, false);


--
-- TOC entry 2342 (class 0 OID 26287)
-- Dependencies: 225
-- Data for Name: despesa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.despesa (id, categoria, valor, data_vencimento) FROM stdin;
\.


--
-- TOC entry 2388 (class 0 OID 0)
-- Dependencies: 224
-- Name: despesa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.despesa_id_seq', 1, false);


--
-- TOC entry 2301 (class 0 OID 25950)
-- Dependencies: 184
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (id, cep, estado, logradouro, complemento, bairro, rua, pais, cidade, numero) FROM stdin;
1	21635-270	PE		casa	Parque Anchieta	Rua Lisses Melgaço	Brasil	Rio de Janeiro	78
2	56820-000	PE					Brasil		10
3	56200-000	PE	Folha	casa	Konoha	Rua da Folha	Brasil	Aldeia da Folha	11
4	 5682-000	PE	Folha	casa	Konoha	Rua da Folha	Brasil	Aldeia da Folha	12
5	56200-000	PE	Folha	casa	Konoha	Rua da Folha	Brasil	Aldeia da Folha	11
6	56200-000	PE	Folha	casa	Konoha	Rua da Folha	Brasil	Aldeia da Folha	11
7	56820-000	PE	Folha	Casa	Konoha	Rua da Folha	Brasil	Aldeia da Folha	16
8	56820-000	PE	Aria	casa	Areia	Areia	Brasil	Aldeia da Areia	22
9	56820-000	PE	Folha	Casa	Konoha	Rua da Folha	Brasil	Aldeia da Folha	111
\.


--
-- TOC entry 2389 (class 0 OID 0)
-- Dependencies: 183
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_id_seq', 9, true);


--
-- TOC entry 2333 (class 0 OID 26217)
-- Dependencies: 216
-- Data for Name: estoque; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estoque (id, id_fornecedores, id_produtos, total_produtos) FROM stdin;
\.


--
-- TOC entry 2390 (class 0 OID 0)
-- Dependencies: 215
-- Name: estoque_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estoque_id_seq', 1, false);


--
-- TOC entry 2315 (class 0 OID 26083)
-- Dependencies: 198
-- Data for Name: exame; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exame (id, id_receita, observacoes, nome) FROM stdin;
\.


--
-- TOC entry 2391 (class 0 OID 0)
-- Dependencies: 197
-- Name: exame_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exame_id_seq', 1, false);


--
-- TOC entry 2303 (class 0 OID 25961)
-- Dependencies: 186
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fornecedor (id, incs_municipal, cnpj, insc_estadual, nome, telefone, id_endereco) FROM stdin;
\.


--
-- TOC entry 2392 (class 0 OID 0)
-- Dependencies: 185
-- Name: fornecedor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fornecedor_id_seq', 1, false);


--
-- TOC entry 2297 (class 0 OID 25924)
-- Dependencies: 180
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (id, nome, cpf, id_clinicas, admim, senha, id_cargos, nome_usuario, data_acesso, telefone, rg, id_endereco) FROM stdin;
\.


--
-- TOC entry 2393 (class 0 OID 0)
-- Dependencies: 179
-- Name: funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.funcionario_id_seq', 1, false);


--
-- TOC entry 2309 (class 0 OID 26030)
-- Dependencies: 192
-- Data for Name: laudo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.laudo (id, _data, horario, descricao, id_paciente, id_medico) FROM stdin;
\.


--
-- TOC entry 2394 (class 0 OID 0)
-- Dependencies: 191
-- Name: laudo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.laudo_id_seq', 1, false);


--
-- TOC entry 2317 (class 0 OID 26099)
-- Dependencies: 200
-- Data for Name: local_end; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.local_end (id, rua, nome_clinica, telefone, bairro, id_exame) FROM stdin;
\.


--
-- TOC entry 2395 (class 0 OID 0)
-- Dependencies: 199
-- Name: local_end_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.local_end_id_seq', 1, false);


--
-- TOC entry 2299 (class 0 OID 25942)
-- Dependencies: 182
-- Data for Name: log_acesso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.log_acesso (id, data_acesso, nome_usuario) FROM stdin;
\.


--
-- TOC entry 2396 (class 0 OID 0)
-- Dependencies: 181
-- Name: log_acesso_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.log_acesso_id_seq', 1, false);


--
-- TOC entry 2311 (class 0 OID 26051)
-- Dependencies: 194
-- Data for Name: medicamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medicamento (id, descricao_laboratorio, desricao_generica, descricao_substancia, nome) FROM stdin;
\.


--
-- TOC entry 2397 (class 0 OID 0)
-- Dependencies: 193
-- Name: medicamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medicamento_id_seq', 1, false);


--
-- TOC entry 2293 (class 0 OID 25894)
-- Dependencies: 176
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medico (id, cpf, area, especialidade, nome_usuario, senha, nome, rg, id_endereco, admim) FROM stdin;
\.


--
-- TOC entry 2398 (class 0 OID 0)
-- Dependencies: 175
-- Name: medico_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medico_id_seq', 1, false);


--
-- TOC entry 2291 (class 0 OID 25881)
-- Dependencies: 174
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.paciente (id, nome, rg, cpf, telefone, id_prontuario, id_endereco, nome_mae, datanascimento, nome_pai, id_convenio) FROM stdin;
2	Boruto Uzumaki	123456781	87723868006	(87)99999-9999	\N	3	Hinata Hyuga	2007-05-12	Naruto Uzumaki	\N
3	Sarada Uchiha	1234561234	91876559004	(87)99999-9299	\N	4	Sakura Haruno	2007-05-12	Sasuke Uchiha	\N
5	Naruto Uzumaki	123432154	91767227086	(87)99919-9999	\N	6	Kushina Uzumaki	2007-05-12	Minato Uzumaki	\N
6	Mbape	123122312	72881233082	(11) 1 1221-2122	\N	7	Tsunade	1998-08-18	Killer	\N
7	Gaara da Areia	187899991	46962659008	(  )       -	\N	8	Kakura	1999-03-14	Quarto  Kazekage	\N
8	Assuma Sarutobi	123423455	72521273031	(11) 1 1112-1211	\N	9	Sarutobi	1981-10-10	Hiruzen Sarutobi	\N
\.


--
-- TOC entry 2399 (class 0 OID 0)
-- Dependencies: 173
-- Name: paciente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paciente_id_seq', 8, true);


--
-- TOC entry 2325 (class 0 OID 26162)
-- Dependencies: 208
-- Data for Name: pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento (id, valor) FROM stdin;
\.


--
-- TOC entry 2400 (class 0 OID 0)
-- Dependencies: 207
-- Name: pagamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamento_id_seq', 1, false);


--
-- TOC entry 2327 (class 0 OID 26170)
-- Dependencies: 210
-- Data for Name: pagamentos_vendas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamentos_vendas (id, id_vendas, id_pagamento) FROM stdin;
\.


--
-- TOC entry 2401 (class 0 OID 0)
-- Dependencies: 209
-- Name: pagamentos_vendas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamentos_vendas_id_seq', 1, false);


--
-- TOC entry 2329 (class 0 OID 26188)
-- Dependencies: 212
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id, tipo, unidade_entrada, unidade_saida, quantidade, preco, nome) FROM stdin;
\.


--
-- TOC entry 2402 (class 0 OID 0)
-- Dependencies: 211
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 1, false);


--
-- TOC entry 2331 (class 0 OID 26199)
-- Dependencies: 214
-- Data for Name: produtos_vendas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produtos_vendas (id, id_produtos, id_vendas) FROM stdin;
\.


--
-- TOC entry 2403 (class 0 OID 0)
-- Dependencies: 213
-- Name: produtos_vendas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produtos_vendas_id_seq', 1, false);


--
-- TOC entry 2305 (class 0 OID 25996)
-- Dependencies: 188
-- Data for Name: prontuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prontuario (id, data_exame, data_inicio, data_final, descricao_resultado, observacao) FROM stdin;
\.


--
-- TOC entry 2404 (class 0 OID 0)
-- Dependencies: 187
-- Name: prontuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prontuario_id_seq', 1, false);


--
-- TOC entry 2313 (class 0 OID 26062)
-- Dependencies: 196
-- Data for Name: receita; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.receita (id, observacoes, id_medicamentos, nome_clinica, id_medico) FROM stdin;
\.


--
-- TOC entry 2405 (class 0 OID 0)
-- Dependencies: 195
-- Name: receita_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.receita_id_seq', 1, false);


--
-- TOC entry 2335 (class 0 OID 26235)
-- Dependencies: 218
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.servico (id, valor, tipo, descricao) FROM stdin;
\.


--
-- TOC entry 2406 (class 0 OID 0)
-- Dependencies: 217
-- Name: servico_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.servico_id_seq', 1, false);


--
-- TOC entry 2336 (class 0 OID 26244)
-- Dependencies: 219
-- Data for Name: servicos_vendas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.servicos_vendas (id, id_vendas, id_servicos, id_produtos) FROM stdin;
\.


--
-- TOC entry 2323 (class 0 OID 26147)
-- Dependencies: 206
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venda (id, data, nota_fiscal, status, total, desconto, valor_recebido, troco, id_pacientes) FROM stdin;
\.


--
-- TOC entry 2407 (class 0 OID 0)
-- Dependencies: 205
-- Name: venda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venda_id_seq', 1, false);


--
-- TOC entry 2144 (class 2606 OID 26266)
-- Name: caixa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_pkey PRIMARY KEY (id);


--
-- TOC entry 2092 (class 2606 OID 25917)
-- Name: cnpj_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.clinica
    ADD CONSTRAINT cnpj_unique UNIQUE (cnpj);


--
-- TOC entry 2150 (class 2606 OID 26300)
-- Name: contas_pagar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.contas_pagar
    ADD CONSTRAINT contas_pagar_pkey PRIMARY KEY (id);


--
-- TOC entry 2146 (class 2606 OID 26274)
-- Name: contas_receber_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.contas_receber
    ADD CONSTRAINT contas_receber_pkey PRIMARY KEY (id);


--
-- TOC entry 2124 (class 2606 OID 26139)
-- Name: convenio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.convenio
    ADD CONSTRAINT convenio_pkey PRIMARY KEY (id);


--
-- TOC entry 2088 (class 2606 OID 25904)
-- Name: cpf_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT cpf_unique UNIQUE (cpf);


--
-- TOC entry 2096 (class 2606 OID 25934)
-- Name: cpf_unique_funcionarios; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT cpf_unique_funcionarios UNIQUE (cpf);


--
-- TOC entry 2148 (class 2606 OID 26292)
-- Name: despesa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.despesa
    ADD CONSTRAINT despesa_pkey PRIMARY KEY (id);


--
-- TOC entry 2102 (class 2606 OID 25958)
-- Name: endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- TOC entry 2138 (class 2606 OID 26222)
-- Name: estoque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (id);


--
-- TOC entry 2104 (class 2606 OID 25968)
-- Name: fornecedor_cnpj_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_cnpj_key UNIQUE (cnpj);


--
-- TOC entry 2106 (class 2606 OID 25966)
-- Name: fornecedor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id);


--
-- TOC entry 2122 (class 2606 OID 26123)
-- Name: id_pkey_cargos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT id_pkey_cargos PRIMARY KEY (id);


--
-- TOC entry 2094 (class 2606 OID 25915)
-- Name: id_pkey_clinicas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.clinica
    ADD CONSTRAINT id_pkey_clinicas PRIMARY KEY (id);


--
-- TOC entry 2110 (class 2606 OID 26017)
-- Name: id_pkey_consulta; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT id_pkey_consulta PRIMARY KEY (id);


--
-- TOC entry 2118 (class 2606 OID 26091)
-- Name: id_pkey_exames; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.exame
    ADD CONSTRAINT id_pkey_exames PRIMARY KEY (id);


--
-- TOC entry 2098 (class 2606 OID 25932)
-- Name: id_pkey_funcionarios; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_pkey_funcionarios PRIMARY KEY (id);


--
-- TOC entry 2112 (class 2606 OID 26038)
-- Name: id_pkey_laudo; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.laudo
    ADD CONSTRAINT id_pkey_laudo PRIMARY KEY (id);


--
-- TOC entry 2120 (class 2606 OID 26107)
-- Name: id_pkey_local_end; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.local_end
    ADD CONSTRAINT id_pkey_local_end PRIMARY KEY (id);


--
-- TOC entry 2100 (class 2606 OID 25947)
-- Name: id_pkey_log_acesso; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.log_acesso
    ADD CONSTRAINT id_pkey_log_acesso PRIMARY KEY (id);


--
-- TOC entry 2114 (class 2606 OID 26059)
-- Name: id_pkey_medicamentos; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.medicamento
    ADD CONSTRAINT id_pkey_medicamentos PRIMARY KEY (id);


--
-- TOC entry 2090 (class 2606 OID 25921)
-- Name: id_pkey_medico; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT id_pkey_medico PRIMARY KEY (id);


--
-- TOC entry 2084 (class 2606 OID 25919)
-- Name: id_pkey_paciente; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT id_pkey_paciente PRIMARY KEY (id);


--
-- TOC entry 2108 (class 2606 OID 26004)
-- Name: id_pkey_prontuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.prontuario
    ADD CONSTRAINT id_pkey_prontuario PRIMARY KEY (id);


--
-- TOC entry 2116 (class 2606 OID 26070)
-- Name: id_pkey_receita; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT id_pkey_receita PRIMARY KEY (id);


--
-- TOC entry 2086 (class 2606 OID 25891)
-- Name: paciente_cpf_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_cpf_key UNIQUE (cpf);


--
-- TOC entry 2130 (class 2606 OID 26167)
-- Name: pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (id);


--
-- TOC entry 2132 (class 2606 OID 26175)
-- Name: pagamentos_vendas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.pagamentos_vendas
    ADD CONSTRAINT pagamentos_vendas_pkey PRIMARY KEY (id);


--
-- TOC entry 2134 (class 2606 OID 26196)
-- Name: produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- TOC entry 2136 (class 2606 OID 26204)
-- Name: produtos_vendas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.produtos_vendas
    ADD CONSTRAINT produtos_vendas_pkey PRIMARY KEY (id);


--
-- TOC entry 2140 (class 2606 OID 26243)
-- Name: servico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (id);


--
-- TOC entry 2142 (class 2606 OID 26248)
-- Name: servicos_vendas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.servicos_vendas
    ADD CONSTRAINT servicos_vendas_pkey PRIMARY KEY (id);


--
-- TOC entry 2126 (class 2606 OID 26154)
-- Name: venda_nota_fiscal_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_nota_fiscal_key UNIQUE (nota_fiscal);


--
-- TOC entry 2128 (class 2606 OID 26152)
-- Name: venda_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id);


--
-- TOC entry 2177 (class 2606 OID 26275)
-- Name: id_caixas_fkey_contas_receber; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contas_receber
    ADD CONSTRAINT id_caixas_fkey_contas_receber FOREIGN KEY (id_caixas) REFERENCES public.caixa(id);


--
-- TOC entry 2179 (class 2606 OID 26301)
-- Name: id_caixas_fkey_contas_recebr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contas_pagar
    ADD CONSTRAINT id_caixas_fkey_contas_recebr FOREIGN KEY (id_caixas) REFERENCES public.caixa(id);


--
-- TOC entry 2158 (class 2606 OID 26124)
-- Name: id_cargos_fkey_funcionarios; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_cargos_fkey_funcionarios FOREIGN KEY (id_cargos) REFERENCES public.cargo(id);


--
-- TOC entry 2156 (class 2606 OID 25935)
-- Name: id_clinicas_fkey_funcionarios; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_clinicas_fkey_funcionarios FOREIGN KEY (id_clinicas) REFERENCES public.clinica(id);


--
-- TOC entry 2153 (class 2606 OID 26140)
-- Name: id_convenio_fkey_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT id_convenio_fkey_paciente FOREIGN KEY (id_convenio) REFERENCES public.convenio(id);


--
-- TOC entry 2180 (class 2606 OID 26306)
-- Name: id_dispesa_fkey_contas_receber; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contas_pagar
    ADD CONSTRAINT id_dispesa_fkey_contas_receber FOREIGN KEY (id_dispesas) REFERENCES public.despesa(id);


--
-- TOC entry 2155 (class 2606 OID 25984)
-- Name: id_endereco_fkey_clinica; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clinica
    ADD CONSTRAINT id_endereco_fkey_clinica FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2159 (class 2606 OID 25969)
-- Name: id_endereco_fkey_fornecedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT id_endereco_fkey_fornecedor FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2157 (class 2606 OID 25979)
-- Name: id_endereco_fkey_funcionario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT id_endereco_fkey_funcionario FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2154 (class 2606 OID 25989)
-- Name: id_endereco_fkey_medico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT id_endereco_fkey_medico FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2151 (class 2606 OID 25974)
-- Name: id_endereco_fkey_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT id_endereco_fkey_paciente FOREIGN KEY (id_endereco) REFERENCES public.endereco(id);


--
-- TOC entry 2167 (class 2606 OID 26108)
-- Name: id_exame_fkey_local_end; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.local_end
    ADD CONSTRAINT id_exame_fkey_local_end FOREIGN KEY (id_exame) REFERENCES public.exame(id);


--
-- TOC entry 2173 (class 2606 OID 26223)
-- Name: id_fornecedores_fkey_estoque; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT id_fornecedores_fkey_estoque FOREIGN KEY (id_fornecedores) REFERENCES public.fornecedor(id);


--
-- TOC entry 2165 (class 2606 OID 26076)
-- Name: id_medicamentos_pkey_receita; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT id_medicamentos_pkey_receita FOREIGN KEY (id_medicamentos) REFERENCES public.medicamento(id);


--
-- TOC entry 2161 (class 2606 OID 26023)
-- Name: id_medico_fkey_consulta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT id_medico_fkey_consulta FOREIGN KEY (id_medico) REFERENCES public.medico(id);


--
-- TOC entry 2163 (class 2606 OID 26044)
-- Name: id_medico_fkey_laudo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laudo
    ADD CONSTRAINT id_medico_fkey_laudo FOREIGN KEY (id_medico) REFERENCES public.medico(id);


--
-- TOC entry 2164 (class 2606 OID 26071)
-- Name: id_medico_fkey_receita; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT id_medico_fkey_receita FOREIGN KEY (id_medico) REFERENCES public.medico(id);


--
-- TOC entry 2160 (class 2606 OID 26018)
-- Name: id_paciente_fkey_consulta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT id_paciente_fkey_consulta FOREIGN KEY (id_paciente) REFERENCES public.paciente(id);


--
-- TOC entry 2162 (class 2606 OID 26039)
-- Name: id_paciente_fkey_laudo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laudo
    ADD CONSTRAINT id_paciente_fkey_laudo FOREIGN KEY (id_paciente) REFERENCES public.paciente(id);


--
-- TOC entry 2168 (class 2606 OID 26155)
-- Name: id_paciente_fkey_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venda
    ADD CONSTRAINT id_paciente_fkey_vendas FOREIGN KEY (id_pacientes) REFERENCES public.paciente(id);


--
-- TOC entry 2170 (class 2606 OID 26181)
-- Name: id_pagamento_fkey_pagamentos_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamentos_vendas
    ADD CONSTRAINT id_pagamento_fkey_pagamentos_vendas FOREIGN KEY (id_pagamento) REFERENCES public.pagamento(id);


--
-- TOC entry 2174 (class 2606 OID 26228)
-- Name: id_produtos_fkey_estoque; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT id_produtos_fkey_estoque FOREIGN KEY (id_produtos) REFERENCES public.produto(id);


--
-- TOC entry 2171 (class 2606 OID 26205)
-- Name: id_produtos_fkey_produtos_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos_vendas
    ADD CONSTRAINT id_produtos_fkey_produtos_vendas FOREIGN KEY (id_produtos) REFERENCES public.produto(id);


--
-- TOC entry 2176 (class 2606 OID 26254)
-- Name: id_produtos_fkey_servicos_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicos_vendas
    ADD CONSTRAINT id_produtos_fkey_servicos_vendas FOREIGN KEY (id_produtos) REFERENCES public.produto(id);


--
-- TOC entry 2152 (class 2606 OID 26005)
-- Name: id_prontuario_fkey_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT id_prontuario_fkey_paciente FOREIGN KEY (id_prontuario) REFERENCES public.prontuario(id);


--
-- TOC entry 2166 (class 2606 OID 26092)
-- Name: id_receita_fkey_exames; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exame
    ADD CONSTRAINT id_receita_fkey_exames FOREIGN KEY (id_receita) REFERENCES public.receita(id);


--
-- TOC entry 2178 (class 2606 OID 26280)
-- Name: id_vendas_fkey_contas_receber; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contas_receber
    ADD CONSTRAINT id_vendas_fkey_contas_receber FOREIGN KEY (id_vendas) REFERENCES public.venda(id);


--
-- TOC entry 2169 (class 2606 OID 26176)
-- Name: id_vendas_fkey_pagamento_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamentos_vendas
    ADD CONSTRAINT id_vendas_fkey_pagamento_vendas FOREIGN KEY (id_vendas) REFERENCES public.venda(id);


--
-- TOC entry 2172 (class 2606 OID 26210)
-- Name: id_vendas_fkey_produtos_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produtos_vendas
    ADD CONSTRAINT id_vendas_fkey_produtos_vendas FOREIGN KEY (id_vendas) REFERENCES public.venda(id);


--
-- TOC entry 2175 (class 2606 OID 26249)
-- Name: id_vendas_fkey_servicos_vendas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.servicos_vendas
    ADD CONSTRAINT id_vendas_fkey_servicos_vendas FOREIGN KEY (id_vendas) REFERENCES public.venda(id);


--
-- TOC entry 2352 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-07-17 21:29:40

--
-- PostgreSQL database dump complete
--

