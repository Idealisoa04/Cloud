CREATE SEQUENCE "public".achat_idachat_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".carburant_idcarburant_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".categorie_idcategorie_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".climatisation_idclimatisation_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".favoris_id_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".marque_idmarque_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".model_idmarque_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".model_idmodel_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".moteur_idmoteur_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".utilisateur_idutilisateur_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".vitesse_idvitesse_seq START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".carburant ( 
	idcarburant          integer DEFAULT nextval('carburant_idcarburant_seq'::regclass) NOT NULL  ,
	nomcarburant         varchar    ,
	CONSTRAINT pk_carburant PRIMARY KEY ( idcarburant )
 );

CREATE  TABLE "public".categorie ( 
	idcategorie          integer DEFAULT nextval('categorie_idcategorie_seq'::regclass) NOT NULL  ,
	nomcategorie         varchar    ,
	CONSTRAINT pk_categorie PRIMARY KEY ( idcategorie )
 );

CREATE  TABLE "public".climatisation ( 
	idclimatisation      integer DEFAULT nextval('climatisation_idclimatisation_seq'::regclass) NOT NULL  ,
	nomclimatisation     varchar    ,
	CONSTRAINT pk_climatisation PRIMARY KEY ( idclimatisation )
 );

CREATE  TABLE "public".marque ( 
	idmarque             integer DEFAULT nextval('marque_idmarque_seq'::regclass) NOT NULL  ,
	nommarque            varchar    ,
	CONSTRAINT pk_marque PRIMARY KEY ( idmarque )
 );

CREATE  TABLE "public".moteur ( 
	idmoteur             integer DEFAULT nextval('moteur_idmoteur_seq'::regclass) NOT NULL  ,
	capacite             double precision    ,
	nom                  varchar    ,
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
	isadmin              varchar    ,
	CONSTRAINT pk_utilisateur PRIMARY KEY ( idutilisateur )
 );

CREATE  TABLE "public".vitesse ( 
	idvitesse            integer DEFAULT nextval('vitesse_idvitesse_seq'::regclass) NOT NULL  ,
	nomvitesse           varchar    ,
	CONSTRAINT pk_vitesse PRIMARY KEY ( idvitesse )
 );

CREATE  TABLE "public".achat ( 
	idachat              integer DEFAULT nextval('achat_idachat_seq'::regclass) NOT NULL  ,
	idannonce            integer    ,
	idclient             integer    ,
	etat                 integer    ,
	CONSTRAINT pk_achat PRIMARY KEY ( idachat ),
	CONSTRAINT fk_achat_utilisateur FOREIGN KEY ( idclient ) REFERENCES "public".utilisateur( idutilisateur )   
 );

CREATE  TABLE "public".favoris ( 
	id                   integer DEFAULT nextval('favoris_id_seq'::regclass) NOT NULL  ,
	idannonce            integer    ,
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
	nb_portes            integer    ,
	id_climatisation     integer    ,
	CONSTRAINT pk_model PRIMARY KEY ( idmodel ),
	CONSTRAINT fk_model_carburant FOREIGN KEY ( id_carburant ) REFERENCES "public".carburant( idcarburant )   ,
	CONSTRAINT fk_model_categorie FOREIGN KEY ( id_categorie ) REFERENCES "public".categorie( idcategorie )   ,
	CONSTRAINT fk_model_climatisation FOREIGN KEY ( id_climatisation ) REFERENCES "public".climatisation( idclimatisation )   ,
	CONSTRAINT fk_model_marque FOREIGN KEY ( id_marque ) REFERENCES "public".marque( idmarque )   ,
	CONSTRAINT fk_model_vitesse FOREIGN KEY ( id_vitesse ) REFERENCES "public".vitesse( idvitesse )   
 );
