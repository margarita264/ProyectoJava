insert into cliente (id,dni, telefono, nombre, email, domicilio) values (1,'40456789', '45678765679', 'lorena', 'lorena@gmail.com','belgrano 76' )
insert into cliente (id,dni, telefono, nombre, email, domicilio) values (2,'11223344', '12341234', 'Sansa', 'sansa@mail.com','north 76' )
insert into cliente (id,dni, telefono, nombre, email, domicilio) values (3,'11122233', '388-123456', 'Aria', 'aria@mail.com','north 767' )

insert into cuenta_bancaria (id, fecha_Creacion,numero_cuenta, saldo, cliente_id) values (100,'2021-10-17', 12341234, 50000, 1)
insert into cuenta_bancaria (id,fecha_Creacion, numero_cuenta, saldo, cliente_id) values (101,'2021-12-17', 11111111, 50001, 2)
insert into cuenta_bancaria (id, fecha_Creacion,numero_cuenta, saldo, cliente_id) values (102,'2021-6-17',22222222, 50002, 3)



insert into movimiento (importe,fecha,  tipo_movimiento, cuenta_bancaria_id) values (2000,'2021-6-8', "Extraccion", 100)
insert into movimiento (importe,fecha,  tipo_movimiento, cuenta_bancaria_id) values (5000, '2021-6-9',"Deposito", 100)
insert into movimiento (importe,fecha,  tipo_movimiento, cuenta_bancaria_id) values (6000, '2021-6-10',"Extraccion", 100)
insert into movimiento (importe,fecha,  tipo_movimiento, cuenta_bancaria_id) values (1000, '2021-6-11',"Deposito", 100)
insert into movimiento (importe, fecha, tipo_movimiento, cuenta_bancaria_id) values (3000, '2021-12-7',"Extraccion", 102)

