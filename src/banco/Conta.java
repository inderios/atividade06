package banco;

public class Conta {
    private String cpfTitular;
    private String numeroConta;
    private String numeroAgencia;
    private double saldo;

    public Conta() {
        this("", "", "", 0.0);
    }
    public Conta(String cpf, String numC, String numAg, double saldo) {
        this.cpfTitular = cpf;
        this.numeroConta = numC;
        this.numeroAgencia = numAg;
        this.saldo = saldo;
    }
    //get
    public String getCpfTitular() {
        return this.cpfTitular;
    }
    public String getNumeroConta() {
        return this.cpfTitular;
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
        String mensagem = String.format("A conta com o CPF:%s, e com o numero da conta:%s; agencia:%s ; o saldo é:%d",
                this.cpfTitular, this.numeroConta, this.numeroAgencia, this.saldo);
        return mensagem;
    }
    public void creditar(double credito) {
        this.saldo += credito;
    }public void debitar(double debito) {
        this.saldo = saldo - debito;
    }
}
