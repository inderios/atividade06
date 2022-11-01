package BancoTest;
import banco.Conta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ContaTest {
    private String cpf = "111.111.111-11";
    private String numeConta = "222-2";
    private String numeroAgencia = "333-3";
    private double saldo = 1000;
    private Conta c = new Conta(cpf, numeConta, numeroAgencia, saldo);
    @Test
    public void testeTodosOsSetsEGets() {
        String cpf = "111.111.111-22";
        String numeConta = "222-3";
        String numeroAgencia = "333-4";
        double saldo = 500;
        c.setCpfTitular(cpf);
        c.setNumeroConta(numeConta);
        c.setNumeroAgencia(numeroAgencia);
        c.setSaldo(saldo);
        assertEquals(cpf, c.getCpfTitular());
        assertEquals(numeConta, c.getNumeroConta());
        assertEquals(numeroAgencia, c.getNumeroAgencia());
        assertEquals(saldo, c.getSaldo());
    }
    @Test
    public void testeGetSetCpfTitular() {
        assertEquals(cpf, c.getCpfTitular());
        String novoCpf = "777.777.777-77";
        c.setCpfTitular(novoCpf);
        assertEquals(novoCpf, c.getCpfTitular());
    }
    @Test
    public void testaToString() {
        String mensagemEsperada = "Conta número " +this.numeConta+ " do cliente de CPF " + this.cpf;
        assertEquals(mensagemEsperada, c.toString());
    }
    @Test
    public void testaCreditarEGetSaldo(){
        assertEquals(1000, c.getSaldo());
        c.setSaldo(c.getSaldo()+100);
        assertEquals(1100, c.getSaldo());
    }
    @Test
    public void testaDebitarEGetSaldo(){
        assertEquals(1000,c.getSaldo());
        double novoSaldo = c.debitar(600);
        assertEquals(400, novoSaldo);
        assertEquals(400, c.getSaldo());
    }
}
