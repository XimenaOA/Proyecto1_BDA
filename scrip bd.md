create database Banco;

use Banco;

create table  Clientes (
    idCliente int(5) not null auto_increment primary key unique,
    nombre varchar(10),
    apellidopaterno varchar(100),
    apellidomaterno varchar(100)
);

create table Cuentas (
    idCuenta int(10) primary key unique,
    fechaApertura varchar(10),
    saldo double,
    idcliente int(5),
    foreign key (idcliente) references Clientes(idCliente)
);

create table Movimientos (
	idMovimiento int(10) primary key unique,
    estado varchar(20) check(estado in("Activo", "Espera", "Cancelado")) not null,
    tipoMovimiento varchar(20) check( tipoMovimiento in("Transferencia","Retiro")),
    saldo double,
    fecha varchar(10),
    idcuenta int(10),
    foreign key (idcuenta) references Cuentas(idCuenta)
);

create table Domicilios (
    idDomicilio int(5) not null auto_increment primary key unique,
    colonia varchar(100),
    calle varchar(100),
    numero int,
    idcliente int(5),
    foreign key (idcliente) references Clientes(idCliente)
);

insert into Clientes(nombre,apellidopaterno, apellidoMaterno) values("Jesus","Morales","Rojas");

insert into Cuentas(idCuenta,fechaApertura,saldo,idcliente) values(10,"20/02/2018", 500, 1);

insert into Movimientos(idMovimiento,estado, tipoMovimiento,saldo,fecha,idcuenta ) values(1,"Espera" ,"Retiro", 100, "28/03/2020", 10);

select * from Clientes;
select * from Cuentas;
select * from Movimientos where idMovimiento= 1;
select * from Cuentas where idCuenta= 10;
