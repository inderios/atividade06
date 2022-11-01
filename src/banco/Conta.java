package banco;

public class Conta {
    private String cpfTitular;
    private String numeroConta;
    private String numeroAgencia;
    private double saldo;

    public Conta(String cpf, String numC, String numAg, double saldo) {
        this.cpfTitular = cpf;
        this.numeroConta = numC;
        this.numeroAgencia = numAg;
        this.saldo = saldo;
    }
    public Conta() {
        this("", "", "", 0.0);
    }
    //get
    public String getCpfTitular() {
        return this.cpfTitular;
    }
    public String getNumeroConta() {
        return this.numeroConta;
    }
    public String getNumeroAgencia() {
        return this.numeroAgencia;
    }
    public double getSaldo() {
        return this.saldo;
    }
    //set
    public void setCpfTitular(String cpf) {
        this.cpfTitular = cpf;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public void setNumeroAgencia(String numeroAg) {
        this.numeroAgencia = numeroAg;
    }
    public void setSaldo(double sal) {
        this.saldo = sal;
    }
    //TO-DO
    //toString
    public String toString() {
        String mensagem = String.format("Conta número %s do cliente de CPF %s",
                this.numeroConta, this.cpfTitular);
        return mensagem;
    }
    public double creditar(double credito) {
        this.saldo += credito;
        return this.saldo;
    }
    public double debitar(double debito) {
        this.saldo -= debito;
        return this.saldo;
    }
}
