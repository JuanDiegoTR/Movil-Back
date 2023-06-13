CREATE TABLE descripcion(
    id_descripcion INT NOT NULL AUTO_INCREMENT,
    descripcion    varchar(255) DEFAULT NULL,
    tipo           INT DEFAULT NULL,
    PRIMARY KEY (id_descripcion)
);

CREATE TABLE imagen(
    id_imagen INT NOT NULL AUTO_INCREMENT,
    imagen    tinyblob DEFAULT NULL,
    PRIMARY KEY (id_imagen)
);

CREATE TABLE pantalla(
    id_pantalla INT NOT NULL AUTO_INCREMENT,
    pantalla    varchar(255) DEFAULT NULL,
    PRIMARY KEY (id_pantalla)
);

CREATE TABLE rol(
    id_rol INT NOT NULL AUTO_INCREMENT,
    rols   varchar(255) DEFAULT NULL,
    PRIMARY KEY (id_rol)
);

CREATE TABLE tipo(
    id_tipo INT NOT NULL AUTO_INCREMENT,
    tipo    varchar(255) DEFAULT NULL,
    PRIMARY KEY (id_tipo)
);

CREATE TABLE acceso(
    id_acceso   INT NOT NULL AUTO_INCREMENT,
    id_pantalla INT,
    id_rol      INT,
    PRIMARY KEY (id_acceso),
    CONSTRAINT FK1lu3o8p3pbo57knu9geayr98v FOREIGN KEY (id_rol) REFERENCES rol (id_rol),
    CONSTRAINT FKbak84asdpx4etqxmb371k2n24 FOREIGN KEY (id_pantalla) REFERENCES pantalla (id_pantalla)
);

CREATE INDEX idx_acceso_id_rol ON acceso (id_rol);
CREATE INDEX idx_acces_id_rol ON acceso (id_pantalla);

CREATE TABLE categoria(
    id_categoria INT NOT NULL AUTO_INCREMENT,
    categoria    varchar(255) DEFAULT NULL,
    id_tipo      INT DEFAULT NULL,
    id_imagen    INT DEFAULT NULL,
    PRIMARY KEY (id_categoria),
    CONSTRAINT FKqt5gutfm41owld01ev4iw6ajs FOREIGN KEY (id_imagen) REFERENCES imagen (id_imagen)
);

CREATE INDEX idx_aceso_id_rol ON categoria (id_imagen);

CREATE TABLE usuario(
    id_usuario INT NOT NULL AUTO_INCREMENT,
    contraseña varchar(255) DEFAULT NULL,
    correo     varchar(255) DEFAULT NULL,
    nombre     varchar(255) DEFAULT NULL,
    telefono   varchar(255) DEFAULT NULL,
    usuario    varchar(255) DEFAULT NULL,
    id_rol     INT DEFAULT NULL,
    PRIMARY KEY (id_usuario),
    CONSTRAINT FKmyv3138vvci6kaq3y5kt4cntu FOREIGN KEY (id_rol) REFERENCES rol (id_rol)
);
CREATE INDEX idx_aeso_id_rol ON usuario (id_rol);

CREATE TABLE contabilidad(
    id_contabilidad INT NOT NULL AUTO_INCREMENT,
    fecha           datetime(6) DEFAULT NULL,
    tipo            INT DEFAULT NULL,
    valor           INT DEFAULT NULL,
    id_categoria    INT DEFAULT NULL,
    id_descripcion  INT DEFAULT NULL,
    id_usuario      INT DEFAULT NULL,
    PRIMARY KEY (id_contabilidad),
    CONSTRAINT FKnb8na1cidajsq6p0d0j2bneys FOREIGN KEY (id_descripcion) REFERENCES descripcion (id_descripcion),
    CONSTRAINT FKoagxpbko8rde3k3fpjfklqpsw FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria),
    CONSTRAINT FKoonhnkx7dme7tyyiosmxj4jcg FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);
CREATE INDEX idx_aeso_i_rol ON contabilidad (id_descripcion);
CREATE INDEX idx_aeso_d_rol ON contabilidad (id_categoria);
CREATE INDEX idx_aes_id_rol ON contabilidad (id_usuario);

INSERT INTO pantalla (pantalla) VALUES('1');

INSERT INTO imagen (imagen) VALUES(NULL);

INSERT INTO descripcion (descripcion, tipo) VALUES('AAA', 1);
INSERT INTO descripcion (descripcion, tipo) VALUES('BBB', 2);
INSERT INTO descripcion (descripcion, tipo) VALUES('CCC', 1);
INSERT INTO descripcion (descripcion, tipo) VALUES('DDD', 1);
INSERT INTO descripcion (descripcion, tipo) VALUES('EEE', 2);
INSERT INTO descripcion (descripcion, tipo) VALUES('FFF', 2);

INSERT INTO tipo (tipo) VALUES('INGRESO');
INSERT INTO tipo (tipo) VALUES('GASTO');

INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Trabajo', 1, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Transporte', 2, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Pago', 1, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Comida', 2, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Salud', 2, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Compras', 2, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Gym', 2, 1);
INSERT INTO categoria (categoria, id_tipo, id_imagen) VALUES('Servicios', 2, 1);

INSERT INTO  rol (rols) VALUES('VIP');
INSERT INTO  rol (rols) VALUES('USER');

INSERT INTO acceso (id_pantalla, id_rol) VALUES(1, 1);

INSERT INTO usuario (contraseña, correo, nombre, telefono, usuario, id_rol) VALUES('MTIzNA==', 'usuario@gmail.com', 'Prueba usuario', '123456789', 'admin', 2);

INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 100000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 200000, 2, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 150000, 2, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 1000000, 4, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:57:17', 1, 25000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 250000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 19:24:15', 1, 50000, 3, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 80000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 550000, 7, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 19:22:58', 1, 105000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 10000, 7, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 58000, 4, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 99100, 5, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 205000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 28000, 5, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 25800, 5, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 95000, 6, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 12450, 6, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 2, 7900, 4, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 20500, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 10000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-03-28 20:59:03', 1, 59000, 1, 1, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 19:24:48', 1, 12000, 1, 3, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:10', 1, 120000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:10', 1, 1000000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:10', 1, 540000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:12', 1, 45000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:12', 1, 70000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:12', 1, 77000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:14', 1, 44000, 1, 4, 1);
INSERT INTO contabilidad (fecha, tipo, valor, id_categoria, id_descripcion, id_usuario) VALUES('2023-05-01 18:30:16', 1, 4000, 1, 4, 1);
