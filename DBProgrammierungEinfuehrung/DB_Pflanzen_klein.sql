/* IM SQL-Prompt mit @....... starten, z.B.:  */
/*START U:\Schueler\BKI\I31\$Gemein\ST\DBProgrammierungEinführung\DB_Pflanzen_klein.sql;*/
drop table Schema;
create table Schema (KATEGORIE VARCHAR(10),HOEHE1  NUMBER(5),
                     HOEHE2  NUMBER(5),ABSTAND  NUMBER(5) )
storage (initial 2 K
         next 2K);
Insert into Schema values (	'BAEUME',301,4000,400	);
Insert into Schema values (	'HINTEN-H',101,150,60	);
Insert into Schema values (	'HINTEN-N',61,100,45	);
Insert into Schema values (	'MITTEL',16,60,30	);
Insert into Schema values (	'NIEDRIG',5,15,20	);
Insert into Schema values (	'TRENNUNG',151,300,60	);
/************************************************/
drop table Pflanzen; 
create table Pflanzen (ART_CODE CHARacter(3),PFLANZENNAME VARCHAR2(16),SORTE VARCHAR2(7),
                      FARBE VARCHAR2(7),HOEHE NUMBER(10),BL_B NUMBER(5),BL_E NUMBER(5),PREIS NUMBER(7,2),
                      HOHEM NUMBER(6,3)
                     )
storage (initial 2 K
         next 2K);
Insert into Pflanzen values ('074','GOLDLACK','2-JAHR','BRAUN',50,4,5,+00001.80,+000.050);
Insert into Pflanzen values ('102','SILBERBLATT','2-JAHR','LILA',70,5,7,+00001.00,+000.070);
Insert into Pflanzen values ('380','KLATSCHMOHN','2-JAHR','BUNT',40,6,6,+00001.00,+000.040);	
Insert into Pflanzen values ('455','SCHLUESSELBLUME','2-JAHR','BUNT',25,4,5,+00002.00,+000.025);
Insert into Pflanzen values ('095','LEVKOJE','1-JAHR','BUNT',60,6,8,+00001.00,+000.060);


/***********************************************************/
drop table LIEFERANTEN;
create table  LIEFERANTEN (LFR_CODE CHARacter(3),LFR_NAME VARCHAR(20),
                            ADRESSE VARCHAR(25),WOHNORT VARCHAR(15)
                          )
storage (initial 2 K
         next 2K);
Insert into Lieferanten values (	'003','MAYER','TALSTRASSE 13','München');
Insert into Lieferanten values (	'004','HOVEN G.H.'   ,'SANDWEG 50'    ,'LINZ'	);


/****************************************************************************/
drop table Bestellungen;
create table Bestellungen (BESTELLNR  NUMBER(10),LFR_CODE CHARacter(3),B_DATUM CHARacter(6),
                           L_DATUM CHARacter(6),BETRAG  NUMBER(7,2)                
	                  )
storage (initial 2 K
         next 2K);
INSERT INTO Bestellungen  values (	174,'003','030225','030304',+00117.50	);
INSERT INTO Bestellungen  values (	175,'004','030227','030306',+00395.51	);
INSERT INTO Bestellungen  values (	201,'004','030326','030402',+00221.25	);
commit;
drop table Bestelldaten; 
create table Bestelldaten (BESTELLNR  NUMBER(10),ART_CODE_LFR VARCHAR(5),ANZAHL  NUMBER(10),
                           BESTELLPREIS  NUMBER(7,2) 
                          )
storage (initial 2 K
         next 2K);


Insert into Bestelldaten values(	174,'A421',50,+00001.35);
Insert into Bestelldaten values(	174,'B148',25,+00000.65);
Insert into Bestelldaten values(	174,'B331',25,+00000.70);

Insert into Bestelldaten values(	175,'B331',10,+00000.45);
Insert into Bestelldaten values(	175,'B337',100,+00000.70);

Insert into Bestelldaten values(	201,'A385',25,+00000.70);


commit;
/*****************************************************************************************/
drop table Angebote;
create table Angebote (LFR_CODE CHARacter(3),ART_CODE_LFR CHARacter(5),ART_CODE CHAR(3),
                       LFR_ZEIT  NUMBER(5),ANG_PREIS  NUMBER(7,2)
                      )
storage (initial 2 K
         next 2K);
Insert into Angebote values('004','A421 ','455',7,+00001.20);
Insert into Angebote values('004','B148 ','380',7,+00000.60);
Insert into Angebote values('004','B331 ','102',7,+00000.60);
Insert into Angebote values('004','B337 ','074',7,+00001.10);
Insert into Angebote values('004','A385 ','095',7,+00000.60);


commit;	