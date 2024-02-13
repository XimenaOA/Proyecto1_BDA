create database Banco;

use Banco;

create table Clientes ( 
idCliente int(5) not null auto_increment primary key unique, 
nombre varchar(10), 
apellidopaterno varchar(10), 
apellidomaterno varchar(10)
);

create table Transferencias ( idTransferencia varchar(10) primary key unique,
concepto varchar(120), saldoTransferido int(10),
destinatario varchar(100), fecha varchar(10),
idcliente int(5), 
foreign key (idcliente) references Clientes(idCliente) 
);

create table Cuentas ( idCuenta varchar(10) primary key unique, 
fechaApertura varchar(10), saldo decimal(50), 
idcliente int(5), 
saldo double,
foreign key (idcliente) references Clientes(idCliente) );

create table if not exists Domicilios ( 
idDomicilio int(5) not null auto_increment primary key unique, 
calle varchar(15), 
codigopostal int(5), 
numero varchar(4), 
idcliente int(5), 
foreign key (idcliente) references Clientes(idCliente) 
);

create table if not exists RetiroSinTarjeta(
	folio int primary key not null, 
    contraseña varchar(8) not null, 
    estado varchar(10) CHECK (estado in ("Activo", "Cancelado")),
    idcliente int,
    foreign key (idcliente) references Clientes(idCliente)
);
