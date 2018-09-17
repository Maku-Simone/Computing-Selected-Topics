#drop database noditos_guapos;
create database noditos_guapos;
use noditos_guapos;

create table reglas(
idRegla int primary key NOT NULL AUTO_INCREMENT,
numRegla int NOT NULL
);

create table nodos(
idNodo int NOT NULL primary key AUTO_INCREMENT,
valor long NOT NULL
);

create table padres(
idhijo int NOT NULL,
idpapi int NOT NULL, primary key (idhijo, idpapi), foreign key (idhijo) references nodos (idNodo) on delete
cascade on update cascade
);

create table reglaNodo(
idRegla int not null,
idNodo int not null, 
primary key (idRegla, idNodo), foreign key (idRegla) references reglas (idRegla) on delete
cascade on update cascade, 
foreign key (idNodo) references nodos (idNodo) on delete
cascade on update cascade 
);

DELIMITER //
CREATE PROCEDURE add_regla(IN numRegla int)
BEGIN
  insert into reglas values (numRegla);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_nodo(IN nodo long)
BEGIN
  insert into nodos values (nodo);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_padre(IN padre long, IN hijo long)
BEGIN
  insert into padres values (
   (select idNodo from nodos where valor = padre),
   (select idNodo from nodos where valor = hijo)
  );
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE existe_Nodo(IN nodo long)
BEGIN
  select count(*) from nodos where valor = nodo;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE existe_Regla(IN regla int)
BEGIN
  select count(*) from reglas where numRegla = regla;
END //
DELIMITER ;

