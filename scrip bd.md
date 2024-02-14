create database Banco;

use Banco;

create table  Clientes (
    idCliente int(5) not null auto_increment primary key unique,
    nombre varchar(10),
    apellidopaterno varchar(10),
    apellidomaterno varchar(10)
);

create table Movimientos (
	idMovimiento varchar(10) primary key unique,
    tipoMovimiento varchar(20) check( tipoMovimiento in("Transferencia","Retiro")),
    saldo int(10),
    fecha varchar(10),
    idcliente int(5),
    foreign key (idcliente) references Clientes(idCliente)
);

create table Cuentas (
    idCuenta varchar(10) primary key unique,
    fechaApertura varchar(10),
    saldo decimal(50),
    idcliente int(5),
    foreign key (idcliente) references Clientes(idCliente)
);

create table Domicilios (
    idDomicilio int(5) not null auto_increment primary key unique,
    calle varchar(15),
    codigopostal int(5),
    numero varchar(4),
    idcliente int(5),
    foreign key (idcliente) references Clientes(idCliente)
);
