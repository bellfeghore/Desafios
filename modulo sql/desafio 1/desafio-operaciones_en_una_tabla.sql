--PARTE 1 DEL DESAFIO


CREATE TABLE editoriales (codigo INT, nombre VARCHAR(100), PRIMARY KEY (codigo));
CREATE TABLE libros (codigo INT, titulo VARCHAR(100),editorial INT, PRIMARY KEY (codigo), FOREIGN KEY(editorial) REFERENCES editoriales(codigo));


INSERT INTO editoriales(codigo,nombre)values(001, 'Anaya');
INSERT INTO editoriales(codigo,nombre)values(002, 'Andina');
INSERT INTO editoriales(codigo,nombre)values(003, 'S.M.');



INSERT INTO libros(codigo,titulo,editorial)values(001, 'Don Quijote de la Mancha I',001);
INSERT INTO libros(codigo,titulo,editorial)values(002, 'El principito',002);
INSERT INTO libros(codigo,titulo,editorial)values(003, 'El principe',003);
INSERT INTO libros(codigo,titulo,editorial)values(004, 'Diplomacia',003);
INSERT INTO libros(codigo,titulo,editorial)values(005, 'Don Quijote de la Mancha II',001);


ALTER TABLE libros ADD autor varchar(100);


UPDATE libros set autor='Miguel de Cervantes' WHERE titulo = 'Don Quijote de la Mancha I';
UPDATE libros set autor='Miguel de Cervantes' WHERE titulo = 'Don Quijote de la Mancha II';
UPDATE libros set autor='Maquiavelo' WHERE titulo = 'El principe';
UPDATE libros set autor='Antoine SaintExupery' WHERE titulo = 'El principito';
UPDATE libros set autor='Henry Kissinger' WHERE titulo = 'Diplomacia';



INSERT INTO libros(codigo,titulo,editorial,autor)values(006, 'Harry Potter y la piedra filosofal',002,'J. K. Rowling');
INSERT INTO libros(codigo,titulo,editorial,autor)values(007, 'Harry Potter y el legado maldito',002,'J. K. Rowling');


DELETE FROM libros WHERE editorial=001;


UPDATE editoriales SET nombre='Iberlibro' WHERE codigo=002;


--PARTE 2 DEL DESAFIO


CREATE TABLE usuarios (codigo INT, nombre VARCHAR(100), apellido VARCHAR(100), telefono INT, PRIMARY KEY (codigo));


CREATE TABLE prestamos (codigo INT, codigoLibro INT, codigoUsuario INT, fecha_prestamo DATE, PRIMARY KEY (codigo), FOREIGN KEY (codigoLibro)REFERENCES libros(codigo), FOREIGN KEY(codigoUsuario)REFERENCES usuarios(codigo));



INSERT INTO usuarios(codigo,nombre,apellido,telefono)values(001, 'Jose','Soto',98347756);
INSERT INTO usuarios(codigo,nombre,apellido,telefono)values(002, 'Miguel','Gomez',94845537);
INSERT INTO usuarios(codigo,nombre,apellido,telefono)values(003, 'Sara','Avedaño',93345455);
INSERT INTO usuarios(codigo,nombre,apellido,telefono)values(004, 'Jaime','Carrasco',92223453);


INSERT INTO prestamos(codigo,codigoLibro,codigoUsuario,fecha_prestamo)values(001, 002, 001,'01-10-2019');
INSERT INTO prestamos(codigo,codigoLibro,codigoUsuario,fecha_prestamo)values(002, 004, 002,'02-10-2019');
INSERT INTO prestamos(codigo,codigoLibro,codigoUsuario,fecha_prestamo)values(003, 002, 003,'02-10-2019');
INSERT INTO prestamos(codigo,codigoLibro,codigoUsuario,fecha_prestamo)values(004, 001, 004,'10-10-2019');
INSERT INTO prestamos(codigo,codigoLibro,codigoUsuario,fecha_prestamo)values(005, 005, 004,'01-11-2019');
