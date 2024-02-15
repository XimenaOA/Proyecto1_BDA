create database Banco;

use Banco;

create table Clientes(
idCliente int(5) not null auto_increment primary key unique,
nombre varchar(20), 
apellidopaterno varchar(50), 
apellidomaterno varchar(50),
edad varchar(2),
fechaDeNacimiento varchar(8)
);

create table Cuentas( 
idCuenta int(10) primary key unique,
fechaApertura varchar(10), 
monto double,
numeroDeCuenta varchar(10), 
estado varchar(10), check(estado in('Activo', 'cancelado')),
idcliente int(5), 
foreign key (idcliente) references Clientes(idCliente)
);

create table Domicilios(
idDomicilio int(5) not null auto_increment primary key unique, 
colonia varchar(100), calle varchar(100), 
numero int, idcliente int(5), 
foreign key (idcliente) references Clientes(idCliente) 
);

create table retiroSinCuentea(
Folio int(10) unique key, 
estado varchar(20) check(estado in("Activo", "Espera", "Cancelado")),
contrasena varchar(8),
monto double,
fecha varchar(8),
idCuenta int(10),
foreign key (idCuenta) references Cuentas(idCuenta)
);

create table transferencias(
concepto varchar(50),
destinatario varchar(20),
fechaDeTrasferencia varchar(8),
idCuenta int(10),
foreign key(idCuenta) references Cuentas(idCuenta)
);

-- insert into Clientes(nombre,apellidopaterno, apellidoMaterno) values("Jesus","Morales","Rojas");

-- insert into Cuentas(idCuenta,fechaApertura,saldo,idcliente) values(10,"20/02/2018", 500, 1);

-- insert into Movimientos(idMovimiento,estado, tipoMovimiento,saldo,fecha,idcuenta ) values(1,"Espera" ,"Retiro", 100, "28/03/2020", 10);

-- select * from Clientes; select * from Cuentas; select * from Movimientos where idMovimiento= 1; select * from Cuentas where idCuenta= 10;