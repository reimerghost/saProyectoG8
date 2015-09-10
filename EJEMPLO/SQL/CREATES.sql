CREATE table "CLIENTE" (
    "IDCLIENTE"    NUMBER(20,0) NOT NULL,
    "NOMBRE"       VARCHAR2(30) NOT NULL,
    "APELLIDO"     VARCHAR2(30) NOT NULL,
    "DIRECCION"    VARCHAR2(60) NOT NULL,
    "TELEFONO"     VARCHAR2(10) NOT NULL,
    "USUARIO"      VARCHAR2(15) NOT NULL,
    "PASSWORD"     VARCHAR2(15) NOT NULL,
    "FECHA_CREADO" DATE NOT NULL,
    constraint  "CLIENTE_PK" primary key ("IDCLIENTE")
)
/

CREATE sequence "CLIENTE_SEQ" 
/

CREATE trigger "BI_CLIENTE"  
  before insert on "CLIENTE"              
  for each row 
begin  
  if :NEW."IDCLIENTE" is null then
    select "CLIENTE_SEQ".nextval into :NEW."IDCLIENTE" from dual;
  end if;
end;
/   


CREATE table "CUENTA" (
    "IDCUENTA"   NUMBER(20,0) NOT NULL,
    "SALDO"      NUMBER(20,2) NOT NULL,
    "IDCLIENTE"  NUMBER(20,0),
    constraint  "CUENTA_PK" primary key ("IDCUENTA")
)
/

CREATE sequence "CUENTA_SEQ" 
/

CREATE trigger "BI_CUENTA"  
  before insert on "CUENTA"              
  for each row 
begin  
  if :NEW."IDCUENTA" is null then
    select "CUENTA_SEQ".nextval into :NEW."IDCUENTA" from dual;
  end if;
end;
/   

ALTER TABLE "CUENTA" ADD CONSTRAINT "CUENTA_FK" 
FOREIGN KEY ("IDCLIENTE")
REFERENCES "CLIENTE" ("IDCLIENTE")
ON DELETE SET NULL

/

CREATE table "TRANSACCION" (
    "IDTRANSACCION" NUMBER(20,0) NOT NULL,
    "FECHA"         TIMESTAMP,
    "MONTO"         NUMBER(20,2) NOT NULL,
    "IDCUENTAO"     NUMBER(20,0) NOT NULL,
    "IDCUENTAD"     NUMBER(20,0) NOT NULL,
    constraint  "TRANSACCION_PK" primary key ("IDTRANSACCION")
)
/

CREATE sequence "TRANSACCION_SEQ" 
/

CREATE trigger "BI_TRANSACCION"  
  before insert on "TRANSACCION"              
  for each row 
begin  
  if :NEW."IDTRANSACCION" is null then
    select "TRANSACCION_SEQ".nextval into :NEW."IDTRANSACCION" from dual;
  end if;
end;
/   

ALTER TABLE "TRANSACCION" ADD CONSTRAINT "TRANSACCION_CO_FK" 
FOREIGN KEY ("IDCUENTAO")
REFERENCES "CUENTA" ("IDCUENTA")

/
ALTER TABLE "TRANSACCION" ADD CONSTRAINT "TRANSACCION_CD_FK" 
FOREIGN KEY ("IDCUENTAD")
REFERENCES "CUENTA" ("IDCUENTA")

/
CREATE table "PRESTAMO" (
    "IDPRESTAMO"      NUMBER(20,0) NOT NULL,
    "ESTADO"          VARCHAR2(30) NOT NULL,
    "MONTOPRESTAMO"   NUMBER(20,2) NOT NULL,
    "FECHAPRESTAMO"   TIMESTAMP NOT NULL,
    "CANTIDADCUOTAS"  NUMBER(4,0) NOT NULL,
    "CUOTASRESTANTES" NUMBER(4,0),
    "MESES"           NUMBER(4,0),
    "SALDORESTANTE"   NUMBER(20,2),
    "IDCLIENTE"       NUMBER(20,0) NOT NULL,
    constraint  "PRESTAMO_PK" primary key ("IDPRESTAMO")
)
/

CREATE sequence "PRESTAMO_SEQ" 
/

CREATE trigger "BI_PRESTAMO"  
  before insert on "PRESTAMO"              
  for each row 
begin  
  if :NEW."IDPRESTAMO" is null then
    select "PRESTAMO_SEQ".nextval into :NEW."IDPRESTAMO" from dual;
  end if;
end;
/   

ALTER TABLE "PRESTAMO" ADD CONSTRAINT "PRESTAMO_FK" 
FOREIGN KEY ("IDCLIENTE")
REFERENCES "CLIENTE" ("IDCLIENTE")

/
CREATE table "PAGOCUOTA" (
    "IDCUOTA"    NUMBER(20,0) NOT NULL,
    "FECHA"      TIMESTAMP NOT NULL,
    "MONTO"      NUMBER(20,2) NOT NULL,
    "IDCUENTA"   NUMBER(20,0) NOT NULL,
    constraint  "PAGOCUOTA_PK" primary key ("IDCUOTA")
)
/

CREATE sequence "PAGOCUOTA_SEQ" 
/

CREATE trigger "BI_PAGOCUOTA"  
  before insert on "PAGOCUOTA"              
  for each row 
begin  
  if :NEW."IDCUOTA" is null then
    select "PAGOCUOTA_SEQ".nextval into :NEW."IDCUOTA" from dual;
  end if;
end;
/   

ALTER TABLE "PAGOCUOTA" ADD CONSTRAINT "PAGOCUOTA_FK" 
FOREIGN KEY ("IDCUENTA")
REFERENCES "CUENTA" ("IDCUENTA")

/


