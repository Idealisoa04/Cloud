CREATE SEQUENCE "public".achat_idachat_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".carburant_idcarburant_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".categorie_idcategorie_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".climatisation_idclimatisation_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".favoris_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".jante_idjante_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".marque_idmarque_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".model_idmarque_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".model_idmodel_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".moteur_idmoteur_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".utilisateur_idutilisateur_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".vitesse_idvitesse_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".carburant ( 
	idcarburant          integer DEFAULT nextval('carburant_idcarburant_seq'::regclass) NOT NULL  ,
	nomcarburant         varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_carburant PRIMARY KEY ( idcarburant )
 );

CREATE  TABLE "public".categorie ( 
	idcategorie          integer DEFAULT nextval('categorie_idcategorie_seq'::regclass) NOT NULL  ,
	nomcategorie         varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_categorie PRIMARY KEY ( idcategorie )
 );

CREATE  TABLE "public".climatisation ( 
	idclimatisation      integer DEFAULT nextval('climatisation_idclimatisation_seq'::regclass) NOT NULL  ,
	nomclimatisation     varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_climatisation PRIMARY KEY ( idclimatisation )
 );

CREATE  TABLE "public".jante ( 
	idjante              integer DEFAULT nextval('jante_idjante_seq'::regclass) NOT NULL  ,
	nomjante             varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_jante PRIMARY KEY ( idjante )
 );

CREATE  TABLE "public".marque ( 
	idmarque             integer DEFAULT nextval('marque_idmarque_seq'::regclass) NOT NULL  ,
	nommarque            varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_marque PRIMARY KEY ( idmarque )
 );

CREATE  TABLE "public".moteur ( 
	idmoteur             integer DEFAULT nextval('moteur_idmoteur_seq'::regclass) NOT NULL  ,
	capacite             double precision    ,
	nom                  varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_moteur PRIMARY KEY ( idmoteur )
 );

CREATE  TABLE "public".utilisateur ( 
	idutilisateur        integer DEFAULT nextval('utilisateur_idutilisateur_seq'::regclass) NOT NULL  ,
	nom                  varchar    ,
	prenom               varchar    ,
	date_naissance       date    ,
	sexe                 integer    ,
	email                varchar    ,
	mdp                  varchar    ,
	isadmin              integer DEFAULT 0   ,
	CONSTRAINT pk_utilisateur PRIMARY KEY ( idutilisateur )
 );

CREATE  TABLE "public".vitesse ( 
	idvitesse            integer DEFAULT nextval('vitesse_idvitesse_seq'::regclass) NOT NULL  ,
	nomvitesse           varchar    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_vitesse PRIMARY KEY ( idvitesse )
 );

CREATE  TABLE "public".achat ( 
	idachat              integer DEFAULT nextval('achat_idachat_seq'::regclass) NOT NULL  ,
	idannonce            varchar    ,
	idclient             integer    ,
	etat                 integer    ,
	CONSTRAINT pk_achat PRIMARY KEY ( idachat ),
	CONSTRAINT fk_achat_utilisateur FOREIGN KEY ( idclient ) REFERENCES "public".utilisateur( idutilisateur )   
 );

CREATE  TABLE "public".favoris ( 
	id                   integer DEFAULT nextval('favoris_id_seq'::regclass) NOT NULL  ,
	idannonce            varchar    ,
	id_utilisateur       integer    ,
	etat                 integer    ,
	CONSTRAINT pk_favoris PRIMARY KEY ( id ),
	CONSTRAINT fk_favoris_utilisateur FOREIGN KEY ( id_utilisateur ) REFERENCES "public".utilisateur( idutilisateur )   
 );

CREATE  TABLE "public".model ( 
	idmodel              integer DEFAULT nextval('model_idmodel_seq'::regclass) NOT NULL  ,
	nommodel             varchar    ,
	id_categorie         integer    ,
	id_marque            integer DEFAULT nextval('model_idmarque_seq'::regclass) NOT NULL  ,
	id_carburant         integer    ,
	id_vitesse           integer    ,
	id_climatisation     integer    ,
	etat                 integer DEFAULT 1   ,
	CONSTRAINT pk_model PRIMARY KEY ( idmodel ),
	CONSTRAINT fk_model_carburant FOREIGN KEY ( id_carburant ) REFERENCES "public".carburant( idcarburant )   ,
	CONSTRAINT fk_model_categorie FOREIGN KEY ( id_categorie ) REFERENCES "public".categorie( idcategorie )   ,
	CONSTRAINT fk_model_climatisation FOREIGN KEY ( id_climatisation ) REFERENCES "public".climatisation( idclimatisation )   ,
	CONSTRAINT fk_model_marque FOREIGN KEY ( id_marque ) REFERENCES "public".marque( idmarque )   ,
	CONSTRAINT fk_model_vitesse FOREIGN KEY ( id_vitesse ) REFERENCES "public".vitesse( idvitesse )   
 );

CREATE VIEW "public".v_model AS  SELECT model.idmodel,
    model.nommodel,
    model.etat,
    model.id_categorie,
    categorie.nomcategorie,
    model.id_marque,
    marque.nommarque,
    model.id_climatisation,
    climatisation.nomclimatisation,
    model.id_carburant,
    carburant.nomcarburant,
    model.id_vitesse,
    vitesse.nomvitesse
   FROM (((((model
     JOIN categorie ON ((model.id_categorie = categorie.idcategorie)))
     JOIN marque ON ((model.id_marque = marque.idmarque)))
     JOIN climatisation ON ((model.id_climatisation = climatisation.idclimatisation)))
     JOIN carburant ON ((model.id_carburant = carburant.idcarburant)))
     JOIN vitesse ON ((model.id_vitesse = vitesse.idvitesse)));
