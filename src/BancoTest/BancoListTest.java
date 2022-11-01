package BancoTest;
import banco.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
public class BancoListTest {
    private BancoList meuBanco = new BancoList("Ayla's Bank", "123/321", new ArrayList<Conta>());
    private String cpf = "111.111.111-11";
    private String numeConta = "222-2";
    private String numeroAgencia = "333-3";
    private double saldo = 1000;
    @Test
    public void seContaFoiAdd(){
        meuBanco.abrirConta(cpf, numeConta, numeroAgencia, saldo);
        meuBanco.abrirConta(cpf, numeConta, numeroAgencia, saldo);
        meuBanco.abrirConta(cpf, numeConta, numeroAgencia, saldo);
        meuBanco.abrirConta(cpf, numeConta, numeroAgencia, saldo);
        assertEquals(4, meuBanco.contas.size());
    }
    @Test
    public void testaConsultarSaldoDeConta(){
        meuBanco.abrirConta(cpf, numeConta, numeroAgencia, saldo);
        assertEquals(saldo, meuBanco.consultarSaldoDeConta(numeConta, numeroAgencia));
    }
    @Test
    public void testaTransferir(){
        meuBanco.abrirConta("111.111.111-11", "222-2", "333-3", 100);
        meuBanco.abrirConta("333.333.333-33", "111-1", "555-5", 100);
        assertEquals(100, meuBanco.consultarSaldoDeConta("222-2", "333-3"));
        assertEquals(100, meuBanco.consultarSaldoDeConta("111-1", "555-5"));
        meuBanco.transferir("222-2","333-3","111-1","555-5",30);
        assertEquals(70, meuBanco.consultarSaldoDeConta("222-2", "333-3"));
        assertEquals(130, meuBanco.consultarSaldoDeConta("111-1", "555-5"));
    }
    @Test
    public void testaToString(){
        meuBanco.abrirConta("123", "456", "467", 50);
        assertEquals(true, meuBanco.toString().startsWith("Banco Ayla's Bank, de CNPJ: 123/321, e que tem 1 contas."));
    }
    @Test
    public void testarDepositarEmConta(){
        BancoList meuBanco = new BancoList("Ayla's Bank", "123/321", new ArrayList<Conta>());
        meuBanco.abrirConta("111.111.111-11", "222-2", "333-3", 100);
        assertEquals(100, meuBanco.consultarSaldoDeConta("222-2", "333-3"));
        meuBanco.depositarEmConta("222-2","333-3", 300);
        assertEquals(400, meuBanco.consultarSaldoDeConta("222-2", "333-3"));
    }
    @Test
    public void testaContasComSaldoNegativo(){
        meuBanco.abrirConta("111.111.111-11", "222-2", "333-3", 100);/////
        meuBanco.abrirConta("111.111.111-11", "555-5", "333-3", 1000);
        meuBanco.abrirConta("888.888.888-88", "444-4", "333-3", 10);/////
        assertEquals(100, meuBanco.consultarSaldoDeConta("222-2", "333-3"));
        meuBanco.sacarDeConta("444-4", "333-3", 100.0);
        meuBanco.sacarDeConta("222-2", "333-3", 102.0);
        ArrayList<Conta> contasNeg = meuBanco.pesquisarContasComSaldoNegativo();
        assertEquals(2, contasNeg.size());
        assertEquals(-2, meuBanco.consultarSaldoDeConta("222-2", "333-3"));
        assertEquals(-90, meuBanco.consultarSaldoDeConta("444-4", "333-3"));

    }
    @Test
    public void testarSacarDeConta(){
        meuBanco.abrirConta(cpf, numeConta,numeroAgencia, saldo);
        meuBanco.sacarDeConta(numeConta, numeroAgencia, 300);
        assertEquals(700, meuBanco.consultarSaldoDeConta(numeConta, numeroAgencia));
    }
    @Test
    public void testarPesquisarContasDoCliente(){
        meuBanco.abrirConta(cpf, numeConta,numeroAgencia, saldo);
        meuBanco.abrirConta(cpf, "675-4", "645",800);
        int quantContasDoCliente = meuBanco.pesquisarContasDoCliente(cpf).size();
        assertEquals(2, quantContasDoCliente);
    }
}