create database Banco;

use Banco;

create table Clientes(
idCliente int not null auto_increment primary key unique,
nombre varchar(20), 
apellidopaterno varchar(50), 
apellidomaterno varchar(50),
edad varchar(100),
fechaDeNacimiento varchar(10),
usr varchar(100),
contrasena varchar(100)
);

create table Cuentas( 
idCuenta int(10) primary key unique auto_increment,
fechaApertura varchar(10), 
monto double,
numeroDeCuenta long, 
estado varchar(10), check(estado in('Activo', 'cancelado')),
idcliente int(5), 
foreign key (idcliente) references Clientes(idCliente)
);

create table Domicilios(
idDomicilio int not null auto_increment primary key unique, 
colonia varchar(100), 
calle varchar(100), 
numero int, 
idcliente int, 
foreign key (idcliente) references Clientes(idCliente) 
);

create table retiroSinCuentea(
idRetiro int primary key auto_increment,
Folio BIGINT(10) unique, 
estado varchar(20) check(estado in("Activo", "Espera", "Cancelado")),
contrasena varchar(8),
monto double,
fecha datetime,
cuenta long,
idCuenta int,
foreign key (idCuenta) references Cuentas(idCuenta)
);

create table transferencias(
idTransferencia int(10) primary key,
monto double,
destinatario long,
fechaDeTrasferencia varchar(10),
idCuenta int(10),
foreign key(idCuenta) references Cuentas(idCuenta)
);

INSERT INTO retiroSinCuentea (Folio, estado, contrasena, monto, fecha, cuenta, idCuenta) 
VALUES (1, 'Activo', '12345678', 500.00, '2024-02-18', 1234567890, 1);

INSERT INTO Cuentas (fechaApertura, monto, numeroDeCuenta, estado, idcliente) 
VALUES ('2024-02-18', 1000.00, 1234567890, 'Activo', LAST_INSERT_ID());

INSERT INTO Clientes (nombre, apellidopaterno, apellidomaterno, edad, fechaDeNacimiento, usr, contrasena) 
VALUES ('Juan', 'Pérez', 'Gómez', '30', '1994-05-15', 'juanpgomez', 'contraseña123');



select * from Cuentas;
select * from Cuentas where idCuenta=1;
select * from retirosincuentea where folio = 1;
select * from retirosincuentea;