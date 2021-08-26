--tabla clientes

INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('Andres', 'Guzman', 'johanneira902@gmail.com','2018-01-01');
INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('Johan', 'lorenzo', 'alensio@gmail.com','2018-01-01');
INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('Andres', 'Escobar', 'adrew@gmail.com','2018-01-01');
INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('maria', 'lopez', 'maria@gmail.com','2018-01-01');



--Tabla de roles
INSERT INTO rol (nombre,create_at) VALUES ('Administrador',NOW());
INSERT INTO rol (nombre,create_at) VALUES ('Residente',NOW());


--Tabla de Conjuntos

INSERT INTO conjunto (nombre,nit,create_at) VALUES ('Los olivos','231',NOW());
INSERT INTO conjunto (nombre,nit,create_at) VALUES ('Alamos','2132',NOW());
INSERT INTO conjunto (nombre,nit,create_at) VALUES ('Puerto bahia','21231',NOW());
INSERT INTO conjunto (nombre,nit,create_at) VALUES ('El bosque','4343',NOW());




INSERT INTO usuarios (nombre,correo,contraseña,telefono,create_at,cod_conjunto,cod_rol) VALUES ('Johan Neira','johanneira902@gmail.com','123456',3002419837,NOW(),1,2)
INSERT INTO usuarios (nombre,correo,contraseña,telefono,create_at,cod_conjunto,cod_rol) VALUES ('Pruebas','pruebas@gmail.com','66666',3002419837,NOW(),1,2)



