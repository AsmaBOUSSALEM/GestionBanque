/*Créer User*/

create user asmae identified by pro;

/* Accorder tous les privileges */
grant all privileges to asmae ;

/* */
disconnect;
connect asmae/pro;

/*Création de la table client */
create table  client (
  matricule integer not null ,
  nom varchar(50),
  cin varchar(50) ,
  primary key(matricule));
 
  /*Création de la table compte */ 
   
   create table  compte
   (	code number not null , 
	    type_compte varchar2(300), 
	    matricule number, 
	    solde number, 
	    decouvert number, 
	    taux number, 
	     taux_operation number, 
	 constraint compte_pk primary key (code) enable, 
	constraint compte_fk foreign key (matricule) references  client (matricule) enable
   );
  
   
   /*remplir la table client*/
   
   insert into client values (1,'asma','J443290');
   insert into client values (2,'boussalem','J443290');
   insert into client values (3,'jamaa','J443890');
   
   /*remplir la table compte*/
   
   insert into compte values (1,'epargne',1,1000,50,10,5);
   insert into compte values (2,'bancaire',2,4000,60,20,7);
   insert into compte values (3,'Crediter',3,8000,80,90,9);

  select * from client;
  select * from compte;
  
  
   
  