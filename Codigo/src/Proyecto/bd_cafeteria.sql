DROP DATABASE IF EXISTS cafeteria;
CREATE DATABASE cafeteria;
USE cafeteria;

/*Tabla que registrará a los usuarios y entrarán a la base de datos*/
CREATE TABLE IF NOT EXISTS USUARIO (
ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
NOMBRE_USER VARCHAR(30) NOT NULL,
APE_USER VARCHAR(30) NOT NULL,
APE2_USER VARCHAR(30),
EMAIL VARCHAR(30) NOT NULL,
PASS VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS bebidas (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    precio DECIMAL(5, 2) NOT NULL,
    cantidad INT NOT NULL
);

CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(5, 2) NOT NULL
);


/*Insert la tabla USUARIO porque como todas sus atributos
son 'NOT NULL' tendremos que hacer un insert primero para 
que no esté vacía y de error o no pase nada.*/
INSERT INTO USUARIO VALUES (0, 'Laura', 'Rodríguez', 'Castellano', 'laurargct@gmail.com', '1234');

/*Insert para bebidas y tener unas ya predefinidas*/
INSERT INTO bebidas VALUES(0, 'Bubble Tea Clásico', 'Bubble Tea', 4.50, 10);
INSERT INTO bebidas VALUES(0,'Bubble Tea de Taro', 'Bubble Tea', 5.00, 10);
INSERT INTO bebidas VALUES(0,'Bubble Tea de Matcha', 'Bubble Tea', 5.50, 10);
INSERT INTO bebidas VALUES(0,'Café Latte', 'Café', 3.75, 10);
INSERT INTO bebidas VALUES(0,'Té Verde', 'Té', 2.50, 10);
INSERT INTO bebidas VALUES(0,'Smoothie de Fresa', 'Smoothie', 4.00, 10);

/*Insert para librso disponibles y cantidad*/
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('Cien Años de Soledad', 'Gabriel García Márquez', 10, 12.99);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('Don Quijote de la Mancha', 'Miguel de Cervantes', 5, 15.50);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('La Sombra del Viento', 'Carlos Ruiz Zafón', 8, 9.99);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('El Amor en los Tiempos del Cólera', 'Gabriel García Márquez', 6, 11.50);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('La Casa de los Espíritus', 'Isabel Allende', 7, 10.75);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('Rayuela', 'Julio Cortázar', 12, 13.99);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('Crónica de una Muerte Anunciada', 'Gabriel García Márquez', 9, 8.50);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('El Aleph', 'Jorge Luis Borges', 4, 7.99);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('Ficciones', 'Jorge Luis Borges', 6, 9.50);
INSERT INTO libros (titulo, autor, cantidad, precio) VALUES ('Pedro Páramo', 'Juan Rulfo', 11, 6.99);

