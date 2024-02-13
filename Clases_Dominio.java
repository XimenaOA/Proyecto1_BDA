public class Cuentas {
    int numeroDeCuenta;
    String fechaApertura;
    double saldo;

    public Cuentas(int numeroDeCuenta, String fechaApertura, double saldo) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public Cuentas() {
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numeroDeCuenta;
        hash = 83 * hash + Objects.hashCode(this.fechaApertura);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
        return hash;
    }

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
        final Cuentas other = (Cuentas) obj;
        if (this.numeroDeCuenta != other.numeroDeCuenta) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        return Objects.equals(this.fechaApertura, other.fechaApertura);
    }

    @Override
    public String toString() {
        return "Cuentas{" + "numeroDeCuenta=" + numeroDeCuenta + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + '}';
    } 
}



public class Clientes {
    int id, edad;
    String nombre, apellidoPaterno, apellidoMaterno, fehcadenacimiento, domicilio;

    public Clientes() {
    }

    public Clientes(int id, int edad, String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento, String domicilio) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
        this.domicilio = domicilio;
    }

    public Clientes(int edad, String nombre, String apellidoPaterno, String apellidoMaterno, String fehcadenacimiento, String domicilio) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fehcadenacimiento = fehcadenacimiento;
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFehcadenacimiento() {
        return fehcadenacimiento;
    }

    public void setFehcadenacimiento(String fehcadenacimiento) {
        this.fehcadenacimiento = fehcadenacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + this.edad;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellidoPaterno);
        hash = 41 * hash + Objects.hashCode(this.apellidoMaterno);
        hash = 41 * hash + Objects.hashCode(this.fehcadenacimiento);
        hash = 41 * hash + Objects.hashCode(this.domicilio);
        return hash;
    }

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
        final Clientes other = (Clientes) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.fehcadenacimiento, other.fehcadenacimiento)) {
            return false;
        }
        return Objects.equals(this.domicilio, other.domicilio);
    }

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fehcadenacimiento=" + fehcadenacimiento + ", domicilio=" + domicilio + '}';
    }    
}


public class Transferencias {
    String concepto, destinatario, fechaDeTransferenciam;
    double saldoTransferido;
    int idCliente;

    public Transferencias() {
    }

    public Transferencias(String concepto, String destinatario, String fechaDeTransferenciam, double saldoTransferido) {
        this.concepto = concepto;
        this.destinatario = destinatario;
        this.fechaDeTransferenciam = fechaDeTransferenciam;
        this.saldoTransferido = saldoTransferido;
    }

    public Transferencias(String concepto, String destinatario, String fechaDeTransferenciam, double saldoTransferido, int idCliente) {
        this.concepto = concepto;
        this.destinatario = destinatario;
        this.fechaDeTransferenciam = fechaDeTransferenciam;
        this.saldoTransferido = saldoTransferido;
        this.idCliente = idCliente;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getFechaDeTransferenciam() {
        return fechaDeTransferenciam;
    }

    public void setFechaDeTransferenciam(String fechaDeTransferenciam) {
        this.fechaDeTransferenciam = fechaDeTransferenciam;
    }

    public double getSaldoTransferido() {
        return saldoTransferido;
    }

    public void setSaldoTransferido(double saldoTransferido) {
        this.saldoTransferido = saldoTransferido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.concepto);
        hash = 23 * hash + Objects.hashCode(this.destinatario);
        hash = 23 * hash + Objects.hashCode(this.fechaDeTransferenciam);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.saldoTransferido) ^ (Double.doubleToLongBits(this.saldoTransferido) >>> 32));
        hash = 23 * hash + this.idCliente;
        return hash;
    }

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
        final Transferencias other = (Transferencias) obj;
        if (Double.doubleToLongBits(this.saldoTransferido) != Double.doubleToLongBits(other.saldoTransferido)) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.concepto, other.concepto)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        return Objects.equals(this.fechaDeTransferenciam, other.fechaDeTransferenciam);
    }

    @Override
    public String toString() {
        return "Transferencias{" + "concepto=" + concepto + ", destinatario=" + destinatario + ", fechaDeTransferenciam=" + fechaDeTransferenciam + ", saldoTransferido=" + saldoTransferido + ", idCliente=" + idCliente + '}';
    }   
}


public class RetiroSinCuenta {
    int idCliente, folio;
    String contraseña;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(int idCliente, int folio, String contraseña) {
        this.idCliente = idCliente;
        this.folio = folio;
        this.contraseña = contraseña;
    }

    public RetiroSinCuenta(int folio, String contraseña) {
        this.folio = folio;
        this.contraseña = contraseña;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idCliente;
        hash = 97 * hash + this.folio;
        hash = 97 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.folio != other.folio) {
            return false;
        }
        return Objects.equals(this.contraseña, other.contraseña);
    }

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "idCliente=" + idCliente + ", folio=" + folio + ", contrase\u00f1a=" + contraseña + '}';
    }    
}


public class Domicilio {
    int idDomicilio, numero, idCliente;
    String calle, codigoPostal;

    public Domicilio(int idDomicilio, int numero, int idCliente, String calle, String codigoPostal) {
        this.idDomicilio = idDomicilio;
        this.numero = numero;
        this.idCliente = idCliente;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
    }

    public Domicilio() {
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idDomicilio;
        hash = 97 * hash + this.numero;
        hash = 97 * hash + this.idCliente;
        hash = 97 * hash + Objects.hashCode(this.calle);
        hash = 97 * hash + Objects.hashCode(this.codigoPostal);
        return hash;
    }

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
        final Domicilio other = (Domicilio) obj;
        if (this.idDomicilio != other.idDomicilio) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        return Objects.equals(this.codigoPostal, other.codigoPostal);
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", numero=" + numero + ", idCliente=" + idCliente + ", calle=" + calle + ", codigoPostal=" + codigoPostal + '}';
    }    
}
