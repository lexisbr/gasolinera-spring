CREATE SCHEMA gasolineras;
USE gasolineras;

CREATE TABLE empleado (
	id_empleado INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_empleado)
);

CREATE TABLE cliente (
	id_cliente INT AUTO_INCREMENT NOT NULL,
    nit VARCHAR(100) NULL,
    nombre VARCHAR(100) NOT NULL,
    puntos INT NOT NULL,
    PRIMARY KEY(id_cliente)
);

CREATE TABLE estacion (
	id_estacion INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_estacion)
);

CREATE TABLE tanque (
	id_tanque INT AUTO_INCREMENT,
    id_estacion INT NOT NULL,
    capacididad_galones DOUBLE NOT NULL,
    nivel_actual_galones DOUBLE NOT NULL,
    tipo_gasolina VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_tanque),
    FOREIGN KEY (id_estacion) REFERENCES estacion(id_estacion)
);

CREATE TABLE transacciones (
	id_transaccion INT AUTO_INCREMENT NOT NULL,
	id_tanque INT NOT NULL,
    id_cliente INT NOT NULL,
    galones_servidos DOUBLE NOT NULL,
    tipo_pago VARCHAR(100) NOT NULL,
    precio_por_galon DOUBLE NOT NULL,
    fecha_transaccion DATETIME NOT NULL,
    id_empleado INT NOT NULL,
    total_pagar DOUBLE NOT NULL,
    PRIMARY KEY(id_transaccion),
    FOREIGN KEY(id_tanque) REFERENCES tanque(id_tanque),
    FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);

CREATE TABLE transaccion_no_detallada (
	id_transaccion INT AUTO_INCREMENT NOT NULL,
	id_tanque INT NOT NULL,
    id_cliente INT NOT NULL,
    tipo_pago VARCHAR(100) NOT NULL,
    galones_servidos DOUBLE NOT NULL,
    fecha_transaccion DATETIME NOT NULL,
    PRIMARY KEY(id_transaccion),
    FOREIGN KEY(id_tanque) REFERENCES tanque(id_tanque),
    FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)
);

INSERT INTO cliente VALUES (1, "11111", "Alejandro Barrios", 0);
INSERT INTO empleado (nombre) VALUES ('Juan Perez');
INSERT INTO empleado (nombre) VALUES ('María López');
INSERT INTO empleado (nombre) VALUES ('Pedro Sánchez');
INSERT INTO cliente (nit, nombre, puntos) VALUES ('123456789', 'Cliente A', 100);
INSERT INTO cliente (nit, nombre, puntos) VALUES ('987654321', 'Cliente B', 50);
INSERT INTO cliente (nit, nombre, puntos) VALUES ('555555555', 'Cliente C', 200);
INSERT INTO estacion (nombre) VALUES ('Estación 1');
INSERT INTO estacion (nombre) VALUES ('Estación 2');
INSERT INTO estacion (nombre) VALUES ('Estación 3');
INSERT INTO tanque (id_estacion, capacidad_galones, nivel_actual_galones, tipo_gasolina)
VALUES (1, 1000.0, 500.0, 'Gasolina Regular');

INSERT INTO tanque (id_estacion, capacidad_galones, nivel_actual_galones, tipo_gasolina)
VALUES (1, 800.0, 400.0, 'Gasolina Premium');

INSERT INTO tanque (id_estacion, capacidad_galones, nivel_actual_galones, tipo_gasolina)
VALUES (2, 1200.0, 600.0, 'Diesel');

SELECT * FROM transacciones;
SELECT * FROM transaccion_no_detallada;
SELECT * FROM tanque;
SELECT * FROM cliente;

