--------------------------------------------------------
--  File created - csütörtök-március-17-2016   
--------------------------------------------------------
DROP TABLE "AHA"."AIRPLANES";
DROP TABLE "AHA"."AIRPORTS";
DROP TABLE "AHA"."BOOKINGS";
DROP TABLE "AHA"."FLIGHTS";
DROP TABLE "AHA"."PASSENGERS";
DROP TABLE "AHA"."SEATS";
DROP SYNONYM "SYSTEM"."CATALOG";
DROP SYNONYM "SYSTEM"."COL";
DROP SYNONYM "SYSTEM"."PRODUCT_USER_PROFILE";
DROP SYNONYM "SYSTEM"."PUBLICSYN";
DROP SYNONYM "SYSTEM"."SYSCATALOG";
DROP SYNONYM "SYSTEM"."SYSFILES";
DROP SYNONYM "SYSTEM"."TAB";
DROP SYNONYM "SYSTEM"."TABQUOTAS";
DROP SEQUENCE "SYSTEM"."LOGMNR_EVOLVE_SEQ$";
DROP SEQUENCE "SYSTEM"."LOGMNR_SEQ$";
DROP SEQUENCE "SYSTEM"."LOGMNR_UIDS$";
DROP SEQUENCE "SYSTEM"."MVIEW$_ADVSEQ_GENERIC";
DROP SEQUENCE "SYSTEM"."MVIEW$_ADVSEQ_ID";
DROP SEQUENCE "SYSTEM"."REPCAT$_EXCEPTIONS_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_FLAVOR_NAME_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_FLAVORS_S";
DROP SEQUENCE "SYSTEM"."REPCAT_LOG_SEQUENCE";
DROP SEQUENCE "SYSTEM"."REPCAT$_REFRESH_TEMPLATES_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_REPPROP_KEY";
DROP SEQUENCE "SYSTEM"."REPCAT$_RUNTIME_PARMS_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_TEMPLATE_OBJECTS_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_TEMPLATE_PARMS_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_TEMPLATE_REFGROUPS_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_TEMPLATE_SITES_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_TEMP_OUTPUT_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_USER_AUTHORIZATIONS_S";
DROP SEQUENCE "SYSTEM"."REPCAT$_USER_PARM_VALUES_S";
DROP SEQUENCE "SYSTEM"."TEMPLATE$_TARGETS_S";
DROP VIEW "SYSTEM"."AQ$DEF$_AQCALL";
DROP VIEW "SYSTEM"."AQ$_DEF$_AQCALL_F";
DROP VIEW "SYSTEM"."AQ$DEF$_AQERROR";
DROP VIEW "SYSTEM"."AQ$_DEF$_AQERROR_F";
DROP VIEW "SYSTEM"."MVIEW_EVALUATIONS";
DROP VIEW "SYSTEM"."MVIEW_EXCEPTIONS";
DROP VIEW "SYSTEM"."MVIEW_FILTER";
DROP VIEW "SYSTEM"."MVIEW_FILTERINSTANCE";
DROP VIEW "SYSTEM"."MVIEW_LOG";
DROP VIEW "SYSTEM"."MVIEW_RECOMMENDATIONS";
DROP VIEW "SYSTEM"."MVIEW_WORKLOAD";
DROP VIEW "SYSTEM"."PRODUCT_PRIVS";
DROP PACKAGE "SYSTEM"."DBMS_REPCAT_AUTH";
DROP PACKAGE BODY "SYSTEM"."DBMS_REPCAT_AUTH";
DROP PROCEDURE "SYSTEM"."ORA$_SYS_REP_AUTH";
begin
DBMS_AQADM.DROP_QUEUE(queue_name=>'DEF$_AQERROR', auto_commit=>TRUE);
end;
/
begin
DBMS_AQADM.DROP_QUEUE(queue_name=>'DEF$_AQCALL', auto_commit=>TRUE);
end;
/
begin
DBMS_AQADM.DROP_QUEUE_TABLE(queue_table=>'DEF$_AQCALL', force=>TRUE);
end;
/
begin
DBMS_AQADM.DROP_QUEUE_TABLE(queue_table=>'DEF$_AQERROR', force=>TRUE);
end;
/
DROP TYPE "SYSTEM"."REPCAT$_OBJECT_NULL_VECTOR";
--------------------------------------------------------
--  DDL for Type REPCAT$_OBJECT_NULL_VECTOR
--------------------------------------------------------

  CREATE OR REPLACE TYPE "SYSTEM"."REPCAT$_OBJECT_NULL_VECTOR" AS OBJECT
(
  -- type owner, name, hashcode for the type represented by null_vector
  type_owner      VARCHAR2(30),
  type_name       VARCHAR2(30),
  type_hashcode   RAW(17),
  -- null_vector for a particular object instance
  -- ROBJ REVISIT: should only contain the null image, and not version#
  null_vector     RAW(2000)
)

/
--------------------------------------------------------
--  DDL for Sequence LOGMNR_EVOLVE_SEQ$
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."LOGMNR_EVOLVE_SEQ$"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOGMNR_SEQ$
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."LOGMNR_SEQ$"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence LOGMNR_UIDS$
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."LOGMNR_UIDS$"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 100 NOCACHE  ORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MVIEW$_ADVSEQ_GENERIC
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."MVIEW$_ADVSEQ_GENERIC"  MINVALUE 1 MAXVALUE 4294967295 INCREMENT BY 1 START WITH 1 CACHE 50 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MVIEW$_ADVSEQ_ID
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."MVIEW$_ADVSEQ_ID"  MINVALUE 1 MAXVALUE 4294967295 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_EXCEPTIONS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_EXCEPTIONS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_FLAVOR_NAME_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_FLAVOR_NAME_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_FLAVORS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_FLAVORS_S"  MINVALUE -2147483647 MAXVALUE 2147483647 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT_LOG_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT_LOG_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_REFRESH_TEMPLATES_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_REFRESH_TEMPLATES_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_REPPROP_KEY
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_REPPROP_KEY"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_RUNTIME_PARMS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_RUNTIME_PARMS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_TEMPLATE_OBJECTS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_TEMPLATE_OBJECTS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_TEMPLATE_PARMS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_TEMPLATE_PARMS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_TEMPLATE_REFGROUPS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_TEMPLATE_REFGROUPS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_TEMPLATE_SITES_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_TEMPLATE_SITES_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_TEMP_OUTPUT_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_TEMP_OUTPUT_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_USER_AUTHORIZATIONS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_USER_AUTHORIZATIONS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence REPCAT$_USER_PARM_VALUES_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."REPCAT$_USER_PARM_VALUES_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence TEMPLATE$_TARGETS_S
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."TEMPLATE$_TARGETS_S"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table AIRPLANES
--------------------------------------------------------

  CREATE TABLE "AHA"."AIRPLANES" 
   (	"ID" NUMBER, 
	"MAXDISTANCE" NUMBER DEFAULT 10000, 
	"MODEL" VARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table AIRPORTS
--------------------------------------------------------

  CREATE TABLE "AHA"."AIRPORTS" 
   (	"CODE" CHAR(3), 
	"CITY" VARCHAR2(30)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BOOKINGS
--------------------------------------------------------

  CREATE TABLE "AHA"."BOOKINGS" 
   (	"BOOKINGREFERENCE" VARCHAR2(10), 
	"SEATID" NUMBER, 
	"FLIGHTID" VARCHAR2(10), 
	"PASSANGERID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table FLIGHTS
--------------------------------------------------------

  CREATE TABLE "AHA"."FLIGHTS" 
   (	"ID" NUMBER, 
	"FLIGHTNUMBER" NUMBER, 
	"DEPARTURE" DATE, 
	"FLIGHTDURATION" NUMBER, 
	"FROMID" CHAR(3), 
	"TOID" CHAR(3), 
	"AIRPLANEID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

   COMMENT ON COLUMN "AHA"."FLIGHTS"."FLIGHTDURATION" IS 'Duration of flight in minutes';
--------------------------------------------------------
--  DDL for Table PASSENGERS
--------------------------------------------------------

  CREATE TABLE "AHA"."PASSENGERS" 
   (	"ID" NUMBER, 
	"NAME" CHAR(40), 
	"EMAIL" VARCHAR2(50)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SEATS
--------------------------------------------------------

  CREATE TABLE "AHA"."SEATS" 
   (	"ID" NUMBER, 
	"AIRPLANEID" NUMBER, 
	"ROWNUMBER" NUMBER, 
	"COLUMNLETTER" CHAR(1)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View AQ$DEF$_AQCALL
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."AQ$DEF$_AQCALL" ("QUEUE", "MSG_ID", "CORR_ID", "MSG_PRIORITY", "MSG_STATE", "DELAY", "DELAY_TIMESTAMP", "EXPIRATION", "ENQ_TIME", "ENQ_TIMESTAMP", "ENQ_USER_ID", "ENQ_TXN_ID", "DEQ_TIME", "DEQ_TIMESTAMP", "DEQ_USER_ID", "DEQ_TXN_ID", "RETRY_COUNT", "EXCEPTION_QUEUE_OWNER", "EXCEPTION_QUEUE", "USER_DATA", "ORIGINAL_QUEUE_NAME", "ORIGINAL_QUEUE_OWNER", "EXPIRATION_REASON") AS 
  SELECT q_name QUEUE, msgid MSG_ID, corrid CORR_ID, priority MSG_PRIORITY, decode(state, 0,   'READY',
                                1,   'WAIT',
                                2,   'PROCESSED',
                                3,   'EXPIRED',
                                10,  'BUFFERED_EXPIRED') MSG_STATE, cast(FROM_TZ(delay, '00:00')
                  at time zone sessiontimezone as date) DELAY, cast(FROM_TZ(delay, '00:00')
               at time zone sessiontimezone as timestamp) DELAY_TIMESTAMP, expiration, cast(FROM_TZ(enq_time, '00:00')
                  at time zone sessiontimezone as date) ENQ_TIME, cast(FROM_TZ(enq_time, '00:00')
                  at time zone sessiontimezone as timestamp) 
                  ENQ_TIMESTAMP, enq_uid ENQ_USER_ID, enq_tid ENQ_TXN_ID, cast(FROM_TZ(deq_time, '00:00')
                  at time zone sessiontimezone as date) DEQ_TIME, cast(FROM_TZ(deq_time, '00:00')
                  at time zone sessiontimezone as timestamp) 
                  DEQ_TIMESTAMP, deq_uid DEQ_USER_ID, deq_tid DEQ_TXN_ID, retry_count,  decode (state, 0, exception_qschema, 
                                  1, exception_qschema, 
                                  2, exception_qschema,  
                                  NULL) EXCEPTION_QUEUE_OWNER,  decode (state, 0, exception_queue, 
                                  1, exception_queue, 
                                  2, exception_queue,  
                                  NULL) EXCEPTION_QUEUE,  user_data,  decode (state, 3, 
                     decode (deq_tid, 'INVALID_TRANSACTION', NULL, 
                             exception_queue), NULL)
                                ORIGINAL_QUEUE_NAME,  decode (state, 3, 
                     decode (deq_tid, 'INVALID_TRANSACTION', NULL, 
                             exception_qschema), NULL)
                                ORIGINAL_QUEUE_OWNER,  decode(state, 3, 
                     decode(deq_time, NULL, 
                       decode(deq_tid, NULL,
                       decode (expiration , NULL , 'MAX_RETRY_EXCEEDED',
                            'TIME_EXPIRATION'),
                              'INVALID_TRANSACTION', NULL,
                              'MAX_RETRY_EXCEEDED'), NULL), NULL) 
                             EXPIRATION_REASON  FROM "DEF$_AQCALL" WHERE state != 7 AND   state != 9 WITH READ ONLY;
--------------------------------------------------------
--  DDL for View AQ$_DEF$_AQCALL_F
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."AQ$_DEF$_AQCALL_F" ("Q_NAME", "ROW_ID", "MSGID", "CORRID", "PRIORITY", "STATE", "DELAY", "EXPIRATION", "ENQ_TIME", "ENQ_UID", "ENQ_TID", "DEQ_TIME", "DEQ_UID", "DEQ_TID", "RETRY_COUNT", "EXCEPTION_QSCHEMA", "EXCEPTION_QUEUE", "CSCN", "DSCN", "CHAIN_NO", "LOCAL_ORDER_NO", "TIME_MANAGER_INFO", "STEP_NO", "USER_DATA", "QUEUE_ID") AS 
  SELECT  /*+ NO_MERGE (qo) USE_NL(qt) */ qt.q_name Q_NAME, qt.rowid ROW_ID, qt.msgid MSGID, qt.corrid CORRID, qt.priority PRIORITY, qt.state STATE, cast(FROM_TZ(qt.delay, '00:00') at time zone sessiontimezone as timestamp) DELAY, qt.expiration EXPIRATION, cast(FROM_TZ(qt.enq_time, '00:00') at time zone sessiontimezone as timestamp) ENQ_TIME, qt.enq_uid ENQ_UID, qt.enq_tid ENQ_TID, cast(FROM_TZ(qt.deq_time, '00:00') at time zone sessiontimezone as timestamp) DEQ_TIME, qt.deq_uid DEQ_UID, qt.deq_tid DEQ_TID, qt.retry_count RETRY_COUNT, qt.exception_qschema EXCEPTION_QSCHEMA, qt.exception_queue EXCEPTION_QUEUE, qt.cscn CSCN, qt.dscn DSCN, qt.chain_no CHAIN_NO, qt.local_order_no LOCAL_ORDER_NO, cast(FROM_TZ(qt.time_manager_info, '00:00') at time zone sessiontimezone as timestamp)   TIME_MANAGER_INFO, qt.step_no STEP_NO, qt.user_data USER_DATA , qo.qid QUEUE_ID  FROM "DEF$_AQCALL" qt, SYS.ALL_INT_DEQUEUE_QUEUES  qo  WHERE qt.q_name = qo.name AND qo.owner = 'SYSTEM' WITH READ ONLY;
--------------------------------------------------------
--  DDL for View AQ$DEF$_AQERROR
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."AQ$DEF$_AQERROR" ("QUEUE", "MSG_ID", "CORR_ID", "MSG_PRIORITY", "MSG_STATE", "DELAY", "DELAY_TIMESTAMP", "EXPIRATION", "ENQ_TIME", "ENQ_TIMESTAMP", "ENQ_USER_ID", "ENQ_TXN_ID", "DEQ_TIME", "DEQ_TIMESTAMP", "DEQ_USER_ID", "DEQ_TXN_ID", "RETRY_COUNT", "EXCEPTION_QUEUE_OWNER", "EXCEPTION_QUEUE", "USER_DATA", "ORIGINAL_QUEUE_NAME", "ORIGINAL_QUEUE_OWNER", "EXPIRATION_REASON") AS 
  SELECT q_name QUEUE, msgid MSG_ID, corrid CORR_ID, priority MSG_PRIORITY, decode(state, 0,   'READY',
                                1,   'WAIT',
                                2,   'PROCESSED',
                                3,   'EXPIRED',
                                10,  'BUFFERED_EXPIRED') MSG_STATE, cast(FROM_TZ(delay, '00:00')
                  at time zone sessiontimezone as date) DELAY, cast(FROM_TZ(delay, '00:00')
               at time zone sessiontimezone as timestamp) DELAY_TIMESTAMP, expiration, cast(FROM_TZ(enq_time, '00:00')
                  at time zone sessiontimezone as date) ENQ_TIME, cast(FROM_TZ(enq_time, '00:00')
                  at time zone sessiontimezone as timestamp) 
                  ENQ_TIMESTAMP, enq_uid ENQ_USER_ID, enq_tid ENQ_TXN_ID, cast(FROM_TZ(deq_time, '00:00')
                  at time zone sessiontimezone as date) DEQ_TIME, cast(FROM_TZ(deq_time, '00:00')
                  at time zone sessiontimezone as timestamp) 
                  DEQ_TIMESTAMP, deq_uid DEQ_USER_ID, deq_tid DEQ_TXN_ID, retry_count,  decode (state, 0, exception_qschema, 
                                  1, exception_qschema, 
                                  2, exception_qschema,  
                                  NULL) EXCEPTION_QUEUE_OWNER,  decode (state, 0, exception_queue, 
                                  1, exception_queue, 
                                  2, exception_queue,  
                                  NULL) EXCEPTION_QUEUE,  user_data,  decode (state, 3, 
                     decode (deq_tid, 'INVALID_TRANSACTION', NULL, 
                             exception_queue), NULL)
                                ORIGINAL_QUEUE_NAME,  decode (state, 3, 
                     decode (deq_tid, 'INVALID_TRANSACTION', NULL, 
                             exception_qschema), NULL)
                                ORIGINAL_QUEUE_OWNER,  decode(state, 3, 
                     decode(deq_time, NULL, 
                       decode(deq_tid, NULL,
                       decode (expiration , NULL , 'MAX_RETRY_EXCEEDED',
                            'TIME_EXPIRATION'),
                              'INVALID_TRANSACTION', NULL,
                              'MAX_RETRY_EXCEEDED'), NULL), NULL) 
                             EXPIRATION_REASON  FROM "DEF$_AQERROR" WHERE state != 7 AND   state != 9 WITH READ ONLY;
--------------------------------------------------------
--  DDL for View AQ$_DEF$_AQERROR_F
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."AQ$_DEF$_AQERROR_F" ("Q_NAME", "ROW_ID", "MSGID", "CORRID", "PRIORITY", "STATE", "DELAY", "EXPIRATION", "ENQ_TIME", "ENQ_UID", "ENQ_TID", "DEQ_TIME", "DEQ_UID", "DEQ_TID", "RETRY_COUNT", "EXCEPTION_QSCHEMA", "EXCEPTION_QUEUE", "CSCN", "DSCN", "CHAIN_NO", "LOCAL_ORDER_NO", "TIME_MANAGER_INFO", "STEP_NO", "USER_DATA", "QUEUE_ID") AS 
  SELECT  /*+ NO_MERGE (qo) USE_NL(qt) */ qt.q_name Q_NAME, qt.rowid ROW_ID, qt.msgid MSGID, qt.corrid CORRID, qt.priority PRIORITY, qt.state STATE, cast(FROM_TZ(qt.delay, '00:00') at time zone sessiontimezone as timestamp) DELAY, qt.expiration EXPIRATION, cast(FROM_TZ(qt.enq_time, '00:00') at time zone sessiontimezone as timestamp) ENQ_TIME, qt.enq_uid ENQ_UID, qt.enq_tid ENQ_TID, cast(FROM_TZ(qt.deq_time, '00:00') at time zone sessiontimezone as timestamp) DEQ_TIME, qt.deq_uid DEQ_UID, qt.deq_tid DEQ_TID, qt.retry_count RETRY_COUNT, qt.exception_qschema EXCEPTION_QSCHEMA, qt.exception_queue EXCEPTION_QUEUE, qt.cscn CSCN, qt.dscn DSCN, qt.chain_no CHAIN_NO, qt.local_order_no LOCAL_ORDER_NO, cast(FROM_TZ(qt.time_manager_info, '00:00') at time zone sessiontimezone as timestamp)   TIME_MANAGER_INFO, qt.step_no STEP_NO, qt.user_data USER_DATA , qo.qid QUEUE_ID  FROM "DEF$_AQERROR" qt, SYS.ALL_INT_DEQUEUE_QUEUES  qo  WHERE qt.q_name = qo.name AND qo.owner = 'SYSTEM' WITH READ ONLY;
--------------------------------------------------------
--  DDL for View MVIEW_EVALUATIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_EVALUATIONS" ("RUNID", "MVIEW_OWNER", "MVIEW_NAME", "RANK", "STORAGE_IN_BYTES", "FREQUENCY", "CUMULATIVE_BENEFIT", "BENEFIT_TO_COST_RATIO") AS 
  select
  t1.runid# as runid,
  summary_owner AS mview_owner,
  summary_name AS mview_name,
  rank# as rank,
  storage_in_bytes,
  frequency,
  cumulative_benefit,
  benefit_to_cost_ratio
from SYSTEM.MVIEW$_ADV_OUTPUT t1, SYSTEM.MVIEW$_ADV_LOG t2, ALL_USERS u
where
  t1.runid# = t2.runid# and
  u.username = t2.uname and
  u.user_id = userenv('SCHEMAID') and
  t1.output_type = 1
order by t1.rank#;

   COMMENT ON TABLE "SYSTEM"."MVIEW_EVALUATIONS"  IS 'This view gives DBA access to summary evaluation output';
--------------------------------------------------------
--  DDL for View MVIEW_EXCEPTIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_EXCEPTIONS" ("RUNID", "OWNER", "TABLE_NAME", "DIMENSION_NAME", "RELATIONSHIP", "BAD_ROWID") AS 
  select
  t1.runid# as runid,
  owner,
  table_name,
  dimension_name,
  relationship,
  bad_rowid
from SYSTEM.MVIEW$_ADV_EXCEPTIONS t1, SYSTEM.MVIEW$_ADV_LOG t2, ALL_USERS u
where
  t1.runid# = t2.runid# and
  u.username = t2.uname and
  u.user_id = userenv('SCHEMAID');

   COMMENT ON TABLE "SYSTEM"."MVIEW_EXCEPTIONS"  IS 'This view gives DBA access to dimension validation results';
--------------------------------------------------------
--  DDL for View MVIEW_FILTER
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_FILTER" ("FILTERID", "SUBFILTERNUM", "SUBFILTERTYPE", "STR_VALUE", "NUM_VALUE1", "NUM_VALUE2", "DATE_VALUE1", "DATE_VALUE2") AS 
  select
      a.filterid# as filterid,
      a.subfilternum# as subfilternum,
      decode(a.subfiltertype,1,'APPLICATION',2,'CARDINALITY',3,'LASTUSE',
                             4,'FREQUENCY',5,'USER',6,'PRIORITY',7,'BASETABLE',
                             8,'RESPONSETIME',9,'COLLECTIONID',10,'TRACENAME',
                             11,'SCHEMA','UNKNOWN') AS subfiltertype,
      a.str_value,
      to_number(decode(a.num_value1,-999,NULL,a.num_value1)) AS num_value1,
      to_number(decode(a.num_value2,-999,NULL,a.num_value2)) AS num_value2,
      a.date_value1,
      a.date_value2
   from system.mview$_adv_filter a, system.mview$_adv_log b, ALL_USERS u
   WHERE a.filterid# = b.runid#
   AND b.uname = u.username
   AND u.user_id = userenv('SCHEMAID');

   COMMENT ON TABLE "SYSTEM"."MVIEW_FILTER"  IS 'Workload filter records';
--------------------------------------------------------
--  DDL for View MVIEW_FILTERINSTANCE
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_FILTERINSTANCE" ("RUNID", "FILTERID", "SUBFILTERNUM", "SUBFILTERTYPE", "STR_VALUE", "NUM_VALUE1", "NUM_VALUE2", "DATE_VALUE1", "DATE_VALUE2") AS 
  select
      a.runid# as runid,
      a.filterid# as filterid,
      a.subfilternum# as subfilternum,
      decode(a.subfiltertype,1,'APPLICATION',2,'CARDINALITY',3,'LASTUSE',
                             4,'FREQUENCY',5,'USER',6,'PRIORITY',7,'BASETABLE',
                             8,'RESPONSETIME',9,'COLLECTIONID',10,'TRACENAME',
                             11,'SCHEMA','UNKNOWN') AS subfiltertype,
      a.str_value,
      to_number(decode(a.num_value1,-999,NULL,a.num_value1)) AS num_value1,
      to_number(decode(a.num_value2,-999,NULL,a.num_value2)) AS num_value2,
      a.date_value1,
      a.date_value2
   from system.mview$_adv_filterinstance a;

   COMMENT ON TABLE "SYSTEM"."MVIEW_FILTERINSTANCE"  IS 'Workload filter instance records';
--------------------------------------------------------
--  DDL for View MVIEW_LOG
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_LOG" ("ID", "FILTERID", "RUN_BEGIN", "RUN_END", "TYPE", "STATUS", "MESSAGE", "COMPLETED", "TOTAL", "ERROR_CODE") AS 
  select
      m.runid# as id,
      m.filterid# as filterid,
      m.run_begin,
      m.run_end,
      decode(m.run_type,1,'EVALUATE',2,'EVALUATE_W',3,'RECOMMEND',
                      4,'RECOMMEND_W',5,'VALIDATE',6,'WORKLOAD',
                      7,'FILTER','UNKNOWN') AS type,
      decode(m.status,0,'UNUSED',1,'CANCELLED',2,'IN_PROGRESS',3,'COMPLETED',
                    4,'ERROR','UNKNOWN') AS status,
      m.message,
      m.completed,
      m.total,
      m.error_code
   from system.mview$_adv_log m, all_users u
   where m.uname = u.username
   and   u.user_id = userenv('SCHEMAID');

   COMMENT ON TABLE "SYSTEM"."MVIEW_LOG"  IS 'Advisor session log';
--------------------------------------------------------
--  DDL for View MVIEW_RECOMMENDATIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_RECOMMENDATIONS" ("RUNID", "ALL_TABLES", "FACT_TABLES", "GROUPING_LEVELS", "QUERY_TEXT", "RECOMMENDATION_NUMBER", "RECOMMENDED_ACTION", "MVIEW_OWNER", "MVIEW_NAME", "STORAGE_IN_BYTES", "PCT_PERFORMANCE_GAIN", "BENEFIT_TO_COST_RATIO") AS 
  select
  t1.runid# as runid,
  t1.from_clause as all_tables,
  fact_tables,
  grouping_levels,
  query_text,
  rank# as recommendation_number,
  action_type as recommended_action,
  summary_owner as mview_owner,
  summary_name as mview_name,
  storage_in_bytes,
  pct_performance_gain,
  benefit_to_cost_ratio
from SYSTEM.MVIEW$_ADV_OUTPUT t1, SYSTEM.MVIEW$_ADV_LOG t2, ALL_USERS u
where
  t1.runid# = t2.runid# and
  u.username = t2.uname and
  u.user_id = userenv('SCHEMAID') and
  t1.output_type = 0
order by t1.rank#;

   COMMENT ON TABLE "SYSTEM"."MVIEW_RECOMMENDATIONS"  IS 'This view gives DBA access to summary recommendations';
--------------------------------------------------------
--  DDL for View MVIEW_WORKLOAD
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."MVIEW_WORKLOAD" ("WORKLOADID", "IMPORT_TIME", "QUERYID", "APPLICATION", "CARDINALITY", "RESULTSIZE", "LASTUSE", "FREQUENCY", "OWNER", "PRIORITY", "QUERY", "RESPONSETIME") AS 
  select
  a.collectionid# as workloadid,
  a.collecttime as import_time,
  a.queryid# as queryid,
  a.application,
  a.cardinality,
  a.resultsize,
  a.qdate as lastuse,
  a.frequency,
  a.uname as owner,
  a.priority,
  a.sql_text as query,
  a.exec_time as responsetime
from SYSTEM.MVIEW$_ADV_WORKLOAD A, SYSTEM.MVIEW$_ADV_LOG B, ALL_USERS D
WHERE a.collectionid# = b.runid#
AND b.uname = d.username
AND d.user_id = userenv('SCHEMAID');

   COMMENT ON TABLE "SYSTEM"."MVIEW_WORKLOAD"  IS 'This view gives DBA access to shared workload';
--------------------------------------------------------
--  DDL for View PRODUCT_PRIVS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "SYSTEM"."PRODUCT_PRIVS" ("PRODUCT", "USERID", "ATTRIBUTE", "SCOPE", "NUMERIC_VALUE", "CHAR_VALUE", "DATE_VALUE", "LONG_VALUE") AS 
  SELECT PRODUCT, USERID, ATTRIBUTE, SCOPE,
         NUMERIC_VALUE, CHAR_VALUE, DATE_VALUE, LONG_VALUE
  FROM SQLPLUS_PRODUCT_PROFILE
  WHERE USERID = 'PUBLIC' OR USER LIKE USERID;
  GRANT SELECT ON "SYSTEM"."PRODUCT_PRIVS" TO PUBLIC;
REM INSERTING into AHA.AIRPLANES
SET DEFINE OFF;
Insert into AHA.AIRPLANES (ID,MAXDISTANCE,MODEL) values ('1','5000','Boeing747');
Insert into AHA.AIRPLANES (ID,MAXDISTANCE,MODEL) values ('2','10000','Airbus A320');
Insert into AHA.AIRPLANES (ID,MAXDISTANCE,MODEL) values ('3','100000000','Milleneum Falcon');
REM INSERTING into AHA.AIRPORTS
SET DEFINE OFF;
Insert into AHA.AIRPORTS (CODE,CITY) values ('BUD','Budapest');
Insert into AHA.AIRPORTS (CODE,CITY) values ('DUB','Dublin');
Insert into AHA.AIRPORTS (CODE,CITY) values ('NAN','Nantes');
Insert into AHA.AIRPORTS (CODE,CITY) values ('LHR','London');
Insert into AHA.AIRPORTS (CODE,CITY) values ('IAD','Washington');
Insert into AHA.AIRPORTS (CODE,CITY) values ('NRT','Tokyo');
Insert into AHA.AIRPORTS (CODE,CITY) values ('BCN','Barcelona');
Insert into AHA.AIRPORTS (CODE,CITY) values ('MAD','Madrid');
Insert into AHA.AIRPORTS (CODE,CITY) values ('CRL','Brüsszel');
Insert into AHA.AIRPORTS (CODE,CITY) values ('BER','Berlin');
REM INSERTING into AHA.BOOKINGS
SET DEFINE OFF;
REM INSERTING into AHA.FLIGHTS
SET DEFINE OFF;
REM INSERTING into AHA.PASSENGERS
SET DEFINE OFF;
Insert into AHA.PASSENGERS (ID,NAME,EMAIL) values ('1','Mimi Rogers                             ','mimi@mimi.com');
Insert into AHA.PASSENGERS (ID,NAME,EMAIL) values ('2','Han Solo                                ','solo@han.com');
Insert into AHA.PASSENGERS (ID,NAME,EMAIL) values ('3','Chew Bakka                              ','Bakka@chew.com');
Insert into AHA.PASSENGERS (ID,NAME,EMAIL) values ('4','Willy Wonka                             ','wonka@willy.com');
Insert into AHA.PASSENGERS (ID,NAME,EMAIL) values ('5','Master Shifu                            ','shifu@master.com');
REM INSERTING into AHA.SEATS
SET DEFINE OFF;
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('1','1','1','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('2','1','1','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('3','1','1','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('4','1','1','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('5','1','1','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('6','1','1','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('7','1','2','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('8','1','2','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('9','1','2','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('10','1','2','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('11','1','2','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('12','1','2','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('13','1','3','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('14','1','3','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('15','1','3','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('16','1','3','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('17','1','3','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('18','1','3','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('19','1','4','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('20','1','4','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('21','1','4','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('22','1','4','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('23','1','4','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('24','1','4','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('25','1','5','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('26','1','5','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('27','1','5','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('28','1','5','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('29','1','5','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('30','1','5','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('31','1','6','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('32','1','6','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('33','1','6','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('34','1','6','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('35','1','6','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('36','1','6','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('37','1','7','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('38','1','7','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('39','1','7','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('40','1','7','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('41','1','7','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('42','1','7','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('43','1','8','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('44','1','8','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('45','1','8','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('46','1','8','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('47','1','8','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('48','1','8','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('49','1','9','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('50','1','9','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('51','1','9','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('52','1','9','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('53','1','9','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('54','1','9','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('55','1','10','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('56','1','10','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('57','1','10','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('58','1','10','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('59','1','10','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('60','1','10','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('61','1','11','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('62','1','11','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('63','1','11','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('64','1','11','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('65','1','11','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('66','1','11','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('67','1','12','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('68','1','12','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('69','1','12','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('70','1','12','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('71','1','12','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('72','1','12','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('73','1','13','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('74','1','13','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('75','1','13','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('76','1','13','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('77','1','13','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('78','1','13','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('79','1','14','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('80','1','14','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('81','1','14','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('82','1','14','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('83','1','14','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('84','1','14','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('85','1','15','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('86','1','15','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('87','1','15','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('88','1','15','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('89','1','15','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('90','1','15','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('91','2','1','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('92','2','1','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('93','2','1','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('94','2','1','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('95','2','1','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('96','2','1','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('97','2','2','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('98','2','2','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('99','2','2','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('100','2','2','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('101','2','2','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('102','2','2','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('103','2','3','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('104','2','3','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('105','2','3','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('106','2','3','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('107','2','3','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('108','2','3','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('109','2','4','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('110','2','4','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('111','2','4','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('112','2','4','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('113','2','4','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('114','2','4','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('115','2','5','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('116','2','5','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('117','2','5','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('118','2','5','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('119','2','5','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('120','2','5','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('121','2','6','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('122','2','6','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('123','2','6','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('124','2','6','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('125','2','6','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('126','2','6','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('127','2','7','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('128','2','7','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('129','2','7','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('130','2','7','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('131','2','7','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('132','2','7','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('133','2','8','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('134','2','8','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('135','2','8','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('136','2','8','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('137','2','8','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('138','2','8','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('139','2','9','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('140','2','9','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('141','2','9','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('142','2','9','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('143','2','9','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('144','2','9','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('145','2','10','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('146','2','10','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('147','2','10','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('148','2','10','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('149','2','10','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('150','2','10','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('151','3','1','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('152','3','1','B');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('153','3','1','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('154','3','1','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('155','3','1','E');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('156','3','1','F');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('157','3','2','A');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('158','3','2','C');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('159','3','2','D');
Insert into AHA.SEATS (ID,AIRPLANEID,ROWNUMBER,COLUMNLETTER) values ('160','3','2','F');
--------------------------------------------------------
--  DDL for Index AIRPLANE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."AIRPLANE_PK" ON "AHA"."AIRPLANES" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index AIRPORTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."AIRPORTS_PK" ON "AHA"."AIRPORTS" ("CODE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index BOOKINGS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."BOOKINGS_PK" ON "AHA"."BOOKINGS" ("BOOKINGREFERENCE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index FLIGHTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."FLIGHTS_PK" ON "AHA"."FLIGHTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PASSENGER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."PASSENGER_PK" ON "AHA"."PASSENGERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SEAT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."SEAT_PK" ON "AHA"."SEATS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SEAT_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "AHA"."SEAT_UK1" ON "AHA"."SEATS" ("AIRPLANEID", "ROWNUMBER", "COLUMNLETTER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table AIRPLANES
--------------------------------------------------------

  ALTER TABLE "AHA"."AIRPLANES" ADD CONSTRAINT "AIRPLANE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."AIRPLANES" MODIFY ("MODEL" NOT NULL ENABLE);
  ALTER TABLE "AHA"."AIRPLANES" MODIFY ("MAXDISTANCE" NOT NULL ENABLE);
  ALTER TABLE "AHA"."AIRPLANES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AIRPORTS
--------------------------------------------------------

  ALTER TABLE "AHA"."AIRPORTS" ADD CONSTRAINT "AIRPORTS_PK" PRIMARY KEY ("CODE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."AIRPORTS" MODIFY ("CITY" NOT NULL ENABLE);
  ALTER TABLE "AHA"."AIRPORTS" MODIFY ("CODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOOKINGS
--------------------------------------------------------

  ALTER TABLE "AHA"."BOOKINGS" ADD CONSTRAINT "BOOKINGS_PK" PRIMARY KEY ("BOOKINGREFERENCE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."BOOKINGS" MODIFY ("PASSANGERID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."BOOKINGS" MODIFY ("FLIGHTID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."BOOKINGS" MODIFY ("SEATID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."BOOKINGS" MODIFY ("BOOKINGREFERENCE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FLIGHTS
--------------------------------------------------------

  ALTER TABLE "AHA"."FLIGHTS" ADD CONSTRAINT "FLIGHTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("AIRPLANEID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("TOID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("FROMID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("FLIGHTDURATION" NOT NULL ENABLE);
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("DEPARTURE" NOT NULL ENABLE);
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("FLIGHTNUMBER" NOT NULL ENABLE);
  ALTER TABLE "AHA"."FLIGHTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PASSENGERS
--------------------------------------------------------

  ALTER TABLE "AHA"."PASSENGERS" ADD CONSTRAINT "PASSENGER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."PASSENGERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "AHA"."PASSENGERS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "AHA"."PASSENGERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SEATS
--------------------------------------------------------

  ALTER TABLE "AHA"."SEATS" ADD CONSTRAINT "SEAT_UK1" UNIQUE ("AIRPLANEID", "ROWNUMBER", "COLUMNLETTER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."SEATS" ADD CONSTRAINT "SEAT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "AHA"."SEATS" MODIFY ("COLUMNLETTER" NOT NULL ENABLE);
  ALTER TABLE "AHA"."SEATS" MODIFY ("ROWNUMBER" NOT NULL ENABLE);
  ALTER TABLE "AHA"."SEATS" MODIFY ("AIRPLANEID" NOT NULL ENABLE);
  ALTER TABLE "AHA"."SEATS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BOOKINGS
--------------------------------------------------------

  ALTER TABLE "AHA"."BOOKINGS" ADD CONSTRAINT "BOOKINGS_FK1" FOREIGN KEY ("SEATID")
	  REFERENCES "AHA"."SEATS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "AHA"."BOOKINGS" ADD CONSTRAINT "BOOKINGS_FK2" FOREIGN KEY ("SEATID")
	  REFERENCES "AHA"."FLIGHTS" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "AHA"."BOOKINGS" ADD CONSTRAINT "BOOKINGS_FK3" FOREIGN KEY ("PASSANGERID")
	  REFERENCES "AHA"."PASSENGERS" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FLIGHTS
--------------------------------------------------------

  ALTER TABLE "AHA"."FLIGHTS" ADD CONSTRAINT "FLIGHTS_FK1" FOREIGN KEY ("AIRPLANEID")
	  REFERENCES "AHA"."AIRPLANES" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "AHA"."FLIGHTS" ADD CONSTRAINT "FLIGHTS_FK2" FOREIGN KEY ("FROMID")
	  REFERENCES "AHA"."AIRPORTS" ("CODE") ENABLE;
  ALTER TABLE "AHA"."FLIGHTS" ADD CONSTRAINT "FLIGHTS_FK3" FOREIGN KEY ("TOID")
	  REFERENCES "AHA"."AIRPORTS" ("CODE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SEATS
--------------------------------------------------------

  ALTER TABLE "AHA"."SEATS" ADD CONSTRAINT "SEAT_FK1" FOREIGN KEY ("AIRPLANEID")
	  REFERENCES "AHA"."AIRPLANES" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  DDL for Package DBMS_REPCAT_AUTH
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SYSTEM"."DBMS_REPCAT_AUTH" wrapped
a000000
1
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
9
bf d6
0cfc6e4Sm6mfaMYwsbW2JygBepcwg/BKmJ4VZy/pO06UXsVUMejsissTcGWYR4qeK4TPqfDK
q7UPH+SmKP6nW9zmxMZnuK1VDzM0Iv9O4E4SvvsnHWn+EPF9hR+oBFe3fEro6RQ5R5Ejd1nr
e+fAK010dExf76gg/c6ZB3YxGPHDOqkGI4lV6HNsd57gKLwTd0bxan5UwJriIpt7Vjc=

/
--------------------------------------------------------
--  DDL for Package Body DBMS_REPCAT_AUTH
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "SYSTEM"."DBMS_REPCAT_AUTH" wrapped
a000000
1
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
abcd
b
b9d 39c
PBMGkNCh5NDAdLezCHsLvZaVi/swg5UrNSCDfI4Zvp0VB6GpRld+By6E2nVdlFHT2g2kK9zM
8jSnsuee7mkmJD+W3Mo36HQvUfOe7jH5vP7tu1i0jDykzR0pUhJZUcY6xVrSwNPoNVPcT72N
eHhGwyRBj2+0vKbgTmcZKBMJzETRfOl2YGDDVB3FvKBSixMMqfWSX8uh3wPGOi8W9vOASC3z
0UvPqL7KR78SykUEoBCxpMGmE8pgElC/dagmVpIIt7QA6sneMlNb2OO/1zTN44ACRsm+2JAo
zD41TcuGaNUqDYNDRbPEKzeRZeXxrx1UvOWsYTNaO6icaV/NrtZbmXpDuGA/sqnz4jnKFK8S
0VC+Yjh2iJEV5edD2+8pyMgx44NVDiAQ+sjjDkpGc0IxXrm/v52yduhnj/xnkualIm/RyAv0
Q/YzRAHy7NvyavbajIvCFoZWpbO3Jw8NwkoU25ysfgvXZJrw4vPjh4hHR4Mpto6jFMM+dZPW
3N9HL971bTBgyAL0BjASEFXe83D+IoBYX0VQVk5+t7p7iUsmfyK5t+cECNpNOL6UaACcsAYB
Le+yLOAqFHSvCXlWcECxG7wXjAA2/XmBwvKBNLcggXKVp3i9cNzab0Mq9qSAcIYgRFxRdAOe
sTDZNOx6HkJTbCRKCMiJzgjQQW476DlOZD+9Gwh+AA/Y3PIDOfyhlvXT6HsjW33mASJUuORB
la5Jb3rB4syO6QO2a5vSHu26Gwib2EflS8bqC1hZhpHsvM+mAaWJ2x72JyrPe8V7Ohjbre49
gRsjAtspIYfP5958sSnHdkz32nGAXnrEY95lEHGwkuXLlj9y6I21aAyd3/lJkuEAEBxzZVnm
IaNJBwl8u33+SqGLZzILy1QxmA+pF8yUaQ+yRU/5+3n1mY4=

/
--------------------------------------------------------
--  DDL for Procedure ORA$_SYS_REP_AUTH
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SYSTEM"."ORA$_SYS_REP_AUTH" as
begin
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.repcat$_repschema TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.repcat$_repprop TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_aqcall TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_calldest TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_error TO SYS ' ||
                 'WITH GRANT OPTION';
  EXECUTE IMMEDIATE 'GRANT SELECT ON SYSTEM.def$_destination TO SYS ' ||
                 'WITH GRANT OPTION';
end;

/
--------------------------------------------------------
--  DDL for Synonymn CATALOG
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."CATALOG" FOR "SYS"."CATALOG";
--------------------------------------------------------
--  DDL for Synonymn COL
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."COL" FOR "SYS"."COL";
--------------------------------------------------------
--  DDL for Synonymn PRODUCT_USER_PROFILE
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."PRODUCT_USER_PROFILE" FOR "SYSTEM"."SQLPLUS_PRODUCT_PROFILE";
--------------------------------------------------------
--  DDL for Synonymn PUBLICSYN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."PUBLICSYN" FOR "SYS"."PUBLICSYN";
--------------------------------------------------------
--  DDL for Synonymn SYSCATALOG
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."SYSCATALOG" FOR "SYS"."SYSCATALOG";
--------------------------------------------------------
--  DDL for Synonymn SYSFILES
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."SYSFILES" FOR "SYS"."SYSFILES";
--------------------------------------------------------
--  DDL for Synonymn TAB
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."TAB" FOR "SYS"."TAB";
--------------------------------------------------------
--  DDL for Synonymn TABQUOTAS
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "SYSTEM"."TABQUOTAS" FOR "SYS"."TABQUOTAS";
--------------------------------------------------------
--  DDL for Queue DEF$_AQERROR
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE(
     Queue_name          => 'SYSTEM.DEF$_AQERROR',
     Queue_table         => 'SYSTEM.DEF$_AQERROR',
     Queue_type          =>  0,
     Max_retries         =>  5,
     Retry_delay         =>  0,
     dependency_tracking =>  TRUE,
     comment             => 'Error Queue for Deferred RPCs');
  END;
/
--------------------------------------------------------
--  DDL for Queue DEF$_AQCALL
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE(
     Queue_name          => 'SYSTEM.DEF$_AQCALL',
     Queue_table         => 'SYSTEM.DEF$_AQCALL',
     Queue_type          =>  0,
     Max_retries         =>  5,
     Retry_delay         =>  0,
     dependency_tracking =>  TRUE,
     comment             => 'Deferred RPC Queue');
  END;
/

  GRANT SELECT ON "SYSTEM"."DEF$_AQCALL" TO "SYS" WITH GRANT OPTION;
--------------------------------------------------------
--  DDL for Queue Table DEF$_AQCALL
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE_TABLE(
     Queue_table        => '"SYSTEM"."DEF$_AQCALL"',
     Queue_payload_type => 'VARIANT',
     storage_clause     => 'PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 TABLESPACE SYSTEM',
     Sort_list          => 'ENQ_TIME',
     Compatible         => '8.0.3');
  END;
/

  GRANT SELECT ON "SYSTEM"."DEF$_AQCALL" TO "SYS" WITH GRANT OPTION;
--------------------------------------------------------
--  DDL for Queue Table DEF$_AQERROR
--------------------------------------------------------

   BEGIN DBMS_AQADM.CREATE_QUEUE_TABLE(
     Queue_table        => '"SYSTEM"."DEF$_AQERROR"',
     Queue_payload_type => 'VARIANT',
     storage_clause     => 'PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 TABLESPACE SYSTEM',
     Sort_list          => 'ENQ_TIME',
     Compatible         => '8.0.3');
  END;
/
