/******************************************************/

CREATE TABLE "Contrato"
(
   "Numero" bigint, 
   "DataInicio" timestamp without time zone, 
   "DataTermino" timestamp without time zone, 
   "ValorHora" numeric(6,2), 
    PRIMARY KEY ("Numero")
) 
WITH (
  OIDS = FALSE
)

TABLESPACE pg_default;
ALTER TABLE "Contrato" OWNER TO grupo50;

CREATE TABLE "Profissional"
(
   "NumeroControle" bigint, 
   "DataNasc" timestamp without time zone, 
   "Nome" character varying(100), 
   "Endereco" character varying(100), 
   "Numero_Contrato" bigint, 
    PRIMARY KEY ("NumeroControle"), 
    FOREIGN KEY ("NumeroControle") REFERENCES "Contrato" ("Numero") ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE "Profissional" OWNER TO grupo50;


/******************************************************/