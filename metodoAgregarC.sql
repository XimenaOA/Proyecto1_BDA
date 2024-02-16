use Banco;
DELIMITER //
CREATE PROCEDURE agregaC(
    IN nom VARCHAR(20), IN AP VARCHAR(30), IN AM VARCHAR(30),
    IN fecha VARCHAR(10), IN edad VARCHAR(10), IN usu VARCHAR(10),
    IN contra VARCHAR(10), IN col VARCHAR(10), IN ca VARCHAR(10), IN num INT
)
BEGIN 
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        ROLLBACK;
    
    START TRANSACTION;
    
    SET AUTOCOMMIT=0;
    
    INSERT INTO Clientes(nombre, apellidopaterno, apellidomaterno, edad, fechaDeNacimiento, usr, contrasena)
    VALUES (nom, AP, AM, edad, fecha, usu, contra);
    
    SET @idC = LAST_INSERT_ID();
    
    INSERT INTO Domicilios(idcliente, colonia, calle, numero)
    VALUES (@idC, col, ca, num);
    
    COMMIT;
END //
DELIMITER ;
