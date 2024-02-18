use banco;
DELIMITER //
create trigger retiro_sin_cuenta_2
before update on retirosincuentea
for each row
begin
declare fechat datetime;
declare ahora datetime; 
declare periodo datetime;
set fechat = NEW.fecha;
set ahora = now();
set periodo = timestampdiff(minute, fechat, ahora);
if periodo>10 then 
if new.estado = "Espera" then
set new.estado = "Cancelado";
end if;
end if;
end //
DELIMITER ;


