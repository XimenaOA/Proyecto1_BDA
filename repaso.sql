CREATE DATABASE EJEMPLOEMPLEADOS;

USE EJEMPLOEMPLEADOS;



CREATE TABLE DEPARTAMENTOS(

id_departamento int primary key auto_increment,

nombre_departamento varchar(50)

);



CREATE TABLE EMPLEADOS(

id_empleado int primary key auto_increment,

nombre varchar(100),

apellido_paterno varchar(100),

apellido_materno varchar(100),

salario decimal(18,2),

incentivo_semanal decimal(18,2),

fecha_inicio date,

id_departamento int,

FOREIGN KEY (id_departamento) REFERENCES DEPARTAMENTOS(id_departamento)

);



CREATE TABLE EMPLEADOS_DESPEDIDOS(

id int primary key auto_increment,

id_empleado int,

nombre varchar(100),

apellido_paterno varchar(100),

apellido_materno varchar(100),

salario decimal(18,2),

fecha_inicio date,

fecha_despido date,

id_departamento int 

);





-- Insertar datos en la tabla DEPARTAMENTOS

INSERT INTO DEPARTAMENTOS (nombre_departamento) VALUES ('Ventas');

INSERT INTO DEPARTAMENTOS (nombre_departamento) VALUES ('Marketing');

INSERT INTO DEPARTAMENTOS (nombre_departamento) VALUES ('Recursos Humanos');

select * from departamentos;

-- Insertar datos en la tabla EMPLEADOS

INSERT INTO EMPLEADOS (nombre, apellido_paterno, apellido_materno, salario, incentivo_semanal, fecha_inicio, id_departamento) 

VALUES ('Juan', 'García', 'López', 2500.00, 100.00, '2023-01-15', 1);



INSERT INTO EMPLEADOS (nombre, apellido_paterno, apellido_materno, salario, incentivo_semanal, fecha_inicio, id_departamento) 

VALUES ('María', 'Martínez', 'Rodríguez', 2800.00, 120.00, '2022-1-1', 2);

-- Transacciones
start transaction;
set autocommit = 0;
-- Insetar departamento nuevo
insert into departamentos(nombre_departamento) values ("NUEVO");

-- Variables en MYSQL a traves de un script normal o tipico
set id_ultimo = last_insert_id();
-- agregar un empleado a ese departamento
insert into empleados (nombre, apellido_paterno, apellido_materno, salario, incentivo_semanal, fecha_inicio, id_departamento) values ("Pablo", "Juan", "abc", 1500, 50, now(), @id_ultimo);

commit;
-- rollback;

DELIMITER #
create procedure sp_ejemplo_transaccion()
begin 
-- Manejo de excepticones desde mysql para el rollback
declare exit handler for sqlexception
	rollback;
    end;
   start transaction;
set autocommit = 0;
-- Insetar departamento nuevo
insert into departamentos(nombre_departamento) values ("NUEVO");

-- Variables en MYSQL a traves de un script normal o tipico
set id_ultimo = last_insert_id();
-- agregar un empleado a ese departamento
insert into empleados (nombre, apellido_paterno, apellido_materno, salario, incentivo_semanal, fecha_inicio, id_departamento) values ("Juan", "Pablo", 8000, 500, now(), @id_ultimo, 8);
end #
DELIMITER ;

call sp_ejemplo_transaccion();

-- Procedimiento con parámetros de entrada 
DELIMITER // 
create procedure sp_mostrar_informacion_empleado(
in id_empleado int)
begin 
	select * from empleados where id_empleado = empleado_buscado;
    END //
    DELIMITER ;
-- call  sp_mostrar_informacion_empleado(3);

DELIMITER $$
create procedure sp_calcular_salario_total(in empleado_buscar int, salario_total decimal(18, 2))
begin 
	declare salario_empleado decimal(18, 2);
    declare incentivo_empleado decimal(18, 2);
	select salario into salario_empleado from empleados where id_empleado = empleado_buscar;
    -- guardamos el incentivo del empleado en su variable 
    select incentivo_empleado into incetivo_empleado from empleados where id_departamento = empleado_buscado;
    -- asignamos el resultado del calculo al salario total
    set salario_total = salario_empleado + (incentivo_empleado*4);
    end $$
    DELIMITER ;
    
    -- call sp_calcular_salario_total(1, @saldo_total);
    
    -- TRIGGER
-- HISTORIAL DE OPERACIONES, EN ESTE CASO UN HISTORIAL DE LOS EMPLEADOS DESPEDIDOS

-- ACTUALIZA Y AELIMINAR, NEW / OLD NEW.NOMBRE
DELIMITER //
create trigger empleado_despedido
-- 1. SELECCIONAR SI ES ANTES O DESPUES DE LA ACCIÓN
-- 2. SELECCIONAR LA ACCIÓN OSBRE LA CUAÑL SE EJECUTARA
-- 3. DECIR SOBRE QUE TABLA VA A ESTAR ESCUCHANDO
AFTER DELETE ON empleados
-- CUANDO Y SOBRE CUANTOS REGISTROS SE HARA LA ACCION
FOR EACH ROW
BEGIN
	INSERT INTO EMPLEADOS_DESPEDIDOS(ID_EMPLEADO, NOMBRE, apellido_paterno, apellido_materno, salario, fecha_inicio, fecha_despido, id_departamento)
    VALUES (old.id_empleado, old.NOMBRE, old.apellido_paterno, old.apellido_materno, old.salario, old.fecha_inicio, now(), old.id_departamento);
    end //
    DELIMITER ;

DELETE FROM EMPLEADOS where ID_EMPLEADO = 2;