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
Folio int(10) unique key, 
estado varchar(20) check(estado in("Activo", "Espera", "Cancelado")),
contrasena varchar(8),
monto double,
fecha date,
cuenta long,
idCuenta int(10),
foreign key (idCuenta) references Cuentas(idCuenta)
);

create table transferencias(
monto double,
destinatario long,
fechaDeTrasferencia varchar(10),
idCuenta int(10),
foreign key(idCuenta) references Cuentas(idCuenta)
);

select * from Cuentas where idCuenta=8;