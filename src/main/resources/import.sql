--tabla clientes

INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('Andres', 'Guzman', 'johanneira902@gmail.com','2018-01-01');
INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('Johan', 'lorenzo', 'alensio@gmail.com','2018-01-01');
INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('Andres', 'Escobar', 'adrew@gmail.com','2018-01-01');
INSERT INTO clientes (nombre,apellido,email,create_at) VALUES ('maria', 'lopez', 'maria@gmail.com','2018-01-01');



--Tabla de roles
INSERT INTO roles (nombre,create_at) VALUES ('Administrador',NOW());
INSERT INTO roles (nombre,create_at) VALUES ('Residente',NOW());


--Tabla de Conjuntos

INSERT INTO conjuntos (nombre,nit,create_at) VALUES ('Los olivos','231',NOW());
INSERT INTO conjuntos (nombre,nit,create_at) VALUES ('Alamos','2132',NOW());
INSERT INTO conjuntos (nombre,nit,create_at) VALUES ('Puerto bahia','21231',NOW());
INSERT INTO conjuntos (nombre,nit,create_at) VALUES ('El bosque','4343',NOW());




INSERT INTO usuarios (nombre,correo,contraseña,activo,telefono,create_at,cod_conjunto) VALUES ('Johan Neira','johanneira902@gmail.com','$2a$10$tAPrT5P/3.AmpUHKw3tgd.jvOgthGbPWMZgAhElLOW6yjrPU.lAIW',true,3002419837,NOW(),1)
--INSERT INTO usuarios (nombre,correo,contraseña,telefono,create_at,cod_conjunto,cod_rol) VALUES ('Pruebas','pruebas@gmail.com','66666',3002419837,NOW(),1,2)

INSERT INTO usuarios_roles (cod_usuario,cod_rol) VALUES (1,2);


