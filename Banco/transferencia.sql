DELIMITER //

CREATE PROCEDURE Transferencia(
    IN p_numero_origen long,
    IN p_numero_destino long,
    IN p_monto_transferencia DOUBLE
)
BEGIN
    DECLARE saldo_origen DOUBLE;
    DECLARE saldo_destino DOUBLE;
    
    IF NOT EXISTS (SELECT * FROM Cuentas WHERE numeroDeCuenta = p_numero_origen) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cuenta de origen no existe';
    END IF;
    
    IF NOT EXISTS (SELECT * FROM Cuentas WHERE numeroDeCuenta = p_numero_destino) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cuenta de destino no existe';
    END IF;
    
    SELECT monto INTO saldo_origen FROM Cuentas WHERE numeroDeCuenta = p_numero_origen;
    IF saldo_origen < p_monto_transferencia THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La cuenta de origen no tiene suficiente dinero';
    END IF;
    
    START TRANSACTION;
    
    UPDATE Cuentas SET monto = monto - p_monto_transferencia WHERE numeroDeCuenta = p_numero_origen;
    UPDATE Cuentas SET monto = monto + p_monto_transferencia WHERE numeroDeCuenta = p_numero_destino;
    
    

    INSERT INTO transferencias (monto, destinatario, fechaDeTrasferencia, idCuenta) 
    VALUES (p_monto_transferencia, p_numero_destino, CURDATE(), (SELECT idCuenta FROM Cuentas WHERE numeroDeCuenta = p_numero_origen));
    
    COMMIT;
END //

DELIMITER ;
