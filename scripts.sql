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
/******************************************************/