package banco;
import java.util.ArrayList;
public class BancoList {
    private String nome;
    private String cnpj;
    public ArrayList<Conta> contas;

    public BancoList (String nome, String cnpj, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = contas;
    }
    public String toString() {
        String mensagem = String.format("Banco %s, de CNPJ: %s, e que tem %d contas.",
                this.nome, this.cnpj, this.contas.size());
        return mensagem;
    }//funciona
    //exemplo de como fazer o programa
    public double consultarSaldoDeConta(String conta, String agencia) {
        for (Conta c : contas) {
            System.out.println("Oi, tá entrando");
            if (c.getNumeroConta().equals(conta) && c.getNumeroAgencia().equals(agencia)) {
                 return c.getSaldo();
            }
        }
        return 0;
    }//funciona
    //to-do
    public void transferir(String numConta0, String numAg0, String numContaD, String numAgD, double valor) {
        //transferir dinheiro de uma conta para outra
        Conta conta0 = new Conta();
        Conta contaD = new Conta();
        for(Conta cliente: contas) {
            String conta = cliente.getNumeroConta();
            String agencia = cliente.getNumeroAgencia();
            if(conta.equals(numConta0) && agencia.equals(numAg0))
                conta0 = cliente;
            if(conta.equals(numContaD) && agencia.equals(numAgD))
                contaD = cliente;
        }
        if(conta0 != null && contaD != null) {
            conta0.debitar(valor);
            contaD.creditar(valor);
        }else{
            //tratamento de erro, faz isso depois
        }
    }//funciona
    public void abrirConta(String cfpTitular, String numConta, String numAgencia, double saldoInicial) {
        Conta novaConta = new Conta(cfpTitular, numConta, numAgencia, saldoInicial);
        contas.add(novaConta);
    }//funciona
    public ArrayList<Conta> pesquisarContasComSaldoNegativo() {
        ArrayList<Conta> contasNegativas = new ArrayList<Conta>();
        for (Conta c: contas) {
            if (c.getSaldo() < 0) {
                System.out.println(c.getNumeroConta());
                contasNegativas.add(c);
            }
        }
        return contasNegativas;
    }//funciona
    public double sacarDeConta (String numConta, String numAgencia, double sacar) {
        double saldoRestante = 0.0;
        for(Conta c : contas){
            String numerCont = c.getNumeroConta();
            String numeroAgencia = c.getNumeroAgencia();
            if(numerCont.equals(numConta) && numeroAgencia.equals(numAgencia)) {
                c.debitar(sacar);
                saldoRestante = c.getSaldo();
            }
        }
        return saldoRestante;
    }
    public double depositarEmConta (String numConta, String numAgencia, double valor) {
        double saldo = 0.0;
        for(Conta c : contas){
            String numerCont = c.getNumeroConta();
            String numeroAgencia = c.getNumeroAgencia();
            if(numerCont.equals(numerCont) && numeroAgencia.equals(numAgencia)) {
                c.setSaldo(c.getSaldo() + valor);
                saldo = c.getSaldo();
                break;
            }
        }
        return saldo;
    }//funciona
    public ArrayList<Conta> pesquisarContasDoCliente(String cpf) {
        ArrayList<Conta> contasDoCliente = new ArrayList<Conta>();
        for(Conta c : contas) {
            String cpfDaConta = c.getCpfTitular();
            if (cpfDaConta.equals(cpf)) {
                contasDoCliente.add(c);
            }
        }
        return contasDoCliente;
    }

}
