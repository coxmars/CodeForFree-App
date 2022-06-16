/* drop database db_proyecto_progra; */

create schema db_proyecto_progra;
use db_proyecto_progra;

/*Se crea la tabla de clientes llamada customer como en la clase de Java */
CREATE TABLE db_proyecto_progra.clientes (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  passwd TEXT(50) NOT NULL,
  roles VARCHAR(45),
  PRIMARY KEY (`id`))
;

SELECT * FROM db_proyecto_progra.clientes;