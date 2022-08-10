package modelo;

/**
 *
 * @author Nathaly
 */
public class CuentaBancaria {
    private Integer id_cuenta;
    private String banco;
    private String tipocuenta;
    private String Nrocuenta;

    public CuentaBancaria() {
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getNrocuenta() {
        return Nrocuenta;
    }

    public void setNrocuenta(String Nrocuenta) {
        this.Nrocuenta = Nrocuenta;
    }

    public CuentaBancaria(Integer id_cuenta, String banco, String tipocuenta, String Nrocuenta) {
        this.id_cuenta = id_cuenta;
        this.banco = banco;
        this.tipocuenta = tipocuenta;
        this.Nrocuenta = Nrocuenta;
    }
    
}
