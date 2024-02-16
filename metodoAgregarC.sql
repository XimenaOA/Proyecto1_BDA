use Banco;
DELIMITER //
CREATE PROCEDURE agregaC(
    IN nom VARCHAR(30), IN AP VARCHAR(30), IN AM VARCHAR(30),
    IN fecha VARCHAR(10), IN edad VARCHAR(10), IN usu VARCHAR(100),
    IN contra VARCHAR(100), IN col VARCHAR(100), IN ca VARCHAR(100), IN num INT
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
