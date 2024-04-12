-- Contacto basico
INSERT INTO system.contactos (nombre, num_telefono) VALUES ('Jesus', '1234567890');
INSERT INTO system.contactos (nombre, num_telefono) VALUES ('Miguel', '9876543210');
INSERT INTO system.contactos (nombre, num_telefono) VALUES ('Ian', '4567890123');
-- Contacto con informacion adicional
INSERT INTO system.contactos (correo, codigo_postal, colonia, num_externo, num_interno, primera_calle, segunda_calle, alias, apellido, fecha_cumpleanhos, nombre, num_telefono) VALUES ('otro1@email.com', '13579', 'Otro Colonia', '111', 'A', 'Calle Otro 1', 'Calle Otro 2', 'Otro1', 'Martínez', TO_DATE('1992-08-20','YYYY-MM-DD'), 'Pedro', '3216549870');
INSERT INTO system.contactos (correo, codigo_postal, colonia, num_externo, num_interno, primera_calle, segunda_calle, alias, apellido, fecha_cumpleanhos, nombre, num_telefono) VALUES ('otro2@email.com', '98765', 'Otra Colonia', '999', 'B', 'Calle Nuevo 1', 'Calle Nuevo 2', 'Otro2', 'Hernández', TO_DATE('1980-04-10','YYYY-MM-DD'), 'Luis', '7894561230');
INSERT INTO system.contactos (correo, codigo_postal, colonia, num_externo, num_interno, primera_calle, segunda_calle, alias, apellido, fecha_cumpleanhos, nombre, num_telefono) VALUES ('otro3@email.com', '24680', 'Colonia Nueva', '222', 'C', 'Calle Vieja 1', 'Calle Vieja 2', 'Otro3', 'Sánchez', TO_DATE('1975-06-30','YYYY-MM-DD'), 'Marcela', '1593578520');
-- Contacto sin informacion de direccion
INSERT INTO system.contactos (correo, alias, apellido, fecha_cumpleanhos, nombre, num_telefono) VALUES ('sininfo1@email.com', 'SinInfo1', 'García', TO_DATE('1976-03-15','YYYY-MM-DD'), 'Laura', '5559876543');
INSERT INTO system.contactos (correo, alias, apellido, fecha_cumpleanhos, nombre, num_telefono) VALUES ('sininfo2@email.com', 'SinInfo2', 'Díaz', TO_DATE('1983-11-20','YYYY-MM-DD'), 'Roberto', '5557418529');
INSERT INTO system.contactos (correo, alias, apellido, fecha_cumpleanhos, nombre, num_telefono) VALUES ('sininfo3@email.com', 'SinInfo3', 'Fernández', TO_DATE('1995-09-05','YYYY-MM-DD'), 'Carla', '5553691478');
