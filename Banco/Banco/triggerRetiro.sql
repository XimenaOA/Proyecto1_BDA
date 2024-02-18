use banco;
DELIMITER //
create trigger retiro_sin_cuenta_2
before update on retirosincuentea
for each row
begin 
update retirosincuentea set estado = "Activo";
-- values (old.folio, old.estado, old.contrasena, old.monto, old.fecha, old.idCuenta);
end //
DELIMITER ;
