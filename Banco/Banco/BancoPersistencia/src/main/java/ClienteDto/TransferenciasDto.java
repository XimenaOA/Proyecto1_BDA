/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteDto;

import java.util.Objects;

/**
 *
 * @author Ximena Oliva Andrade - 247563, Jesús Alberto Morales Rojas - 245335
 */
public class TransferenciasDto {

    //Atributos de la clase
    private String tipo;
    private Double concepto;
    private long remitente;
    private long destinatario;
    private String fechaDeTransferencia;
    private int idCuenta;

    /**
     * Constructor vacío de la clase TransferenciasDto.
     */
    public TransferenciasDto() {
    }

    /**
     * Constructor de la clase TransferenciasDto con parámetros.
     *
     * @param tipo El tipo de transferencia.
     * @param concepto El monto de la transferencia.
     * @param remitente El número de cuenta del remitente.
     * @param destinatario El número de cuenta del destinatario.
     * @param fechaDeTransferencia La fecha de la transferencia.
     * @param idCuenta El ID de la cuenta asociada.
     */
    public TransferenciasDto(String tipo, Double concepto, long remitente, long destinatario, String fechaDeTransferencia, int idCuenta) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fechaDeTransferencia = fechaDeTransferencia;
        this.idCuenta = idCuenta;
    }

    /**
     * Método getter para obtener el tipo de transferencia.
     *
     * @return El tipo de transferencia.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método setter para establecer el tipo de transferencia.
     *
     * @param tipo El tipo de transferencia a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método getter para obtener el monto de la transferencia.
     *
     * @return El monto de la transferencia.
     */
    public Double getConcepto() {
        return concepto;
    }

    /**
     * Método setter para establecer el monto de la transferencia.
     *
     * @param concepto El monto de la transferencia a establecer.
     */
    public void setConcepto(Double concepto) {
        this.concepto = concepto;
    }

    /**
     * Método getter para obtener el número de cuenta del remitente.
     *
     * @return El número de cuenta del remitente.
     */
    public long getRemitente() {
        return remitente;
    }

    /**
     * Método setter para establecer el número de cuenta del remitente.
     *
     * @param remitente El número de cuenta del remitente a establecer.
     */
    public void setRemitente(long remitente) {
        this.remitente = remitente;
    }

    /**
     * Método getter para obtener el número de cuenta del destinatario.
     *
     * @return El número de cuenta del destinatario.
     */
    public long getDestinatario() {
        return destinatario;
    }

    /**
     * Método setter para establecer el número de cuenta del destinatario.
     *
     * @param destinatario El número de cuenta del destinatario a establecer.
     */
    public void setDestinatario(long destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Método getter para obtener la fecha de la transferencia.
     *
     * @return La fecha de la transferencia.
     */
    public String getFechaDeTransferencia() {
        return fechaDeTransferencia;
    }

    /**
     * Método setter para establecer la fecha de la transferencia.
     *
     * @param fechaDeTransferencia La fecha de la transferencia a establecer.
     */
    public void setFechaDeTransferencia(String fechaDeTransferencia) {
        this.fechaDeTransferencia = fechaDeTransferencia;
    }

    /**
     * Método getter para obtener el ID de la cuenta asociada.
     *
     * @return El ID de la cuenta asociada.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Método setter para establecer el ID de la cuenta asociada.
     *
     * @param idCuenta El ID de la cuenta asociada a establecer.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Método hashCode para calcular el código hash de la instancia de
     * TransferenciasDto.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + Objects.hashCode(this.concepto);
        hash = 59 * hash + (int) (this.remitente ^ (this.remitente >>> 32));
        hash = 59 * hash + (int) (this.destinatario ^ (this.destinatario >>> 32));
        hash = 59 * hash + Objects.hashCode(this.fechaDeTransferencia);
        hash = 59 * hash + this.idCuenta;
        return hash;
    }

    /**
     * Método equals para comparar dos instancias de TransferenciasDto.
     *
     * @param obj El objeto a comparar.
     * @return true si las instancias son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransferenciasDto other = (TransferenciasDto) obj;
        if (this.remitente != other.remitente) {
            return false;
        }
        if (this.destinatario != other.destinatario) {
            return false;
        }
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.fechaDeTransferencia, other.fechaDeTransferencia)) {
            return false;
        }
        return Objects.equals(this.concepto, other.concepto);
    }

}
