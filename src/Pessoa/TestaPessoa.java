package Pessoa;

import javax.swing.JOptionPane;
import java.util.ArrayList;
public class TestaPessoa {
    public static void main(String [] args){
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        int index = 0;
        while(index < 2 ) {
            String nome = JOptionPane.showInputDialog("Nome da pessoa");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade da pessoa"));
            Pessoa k = new Pessoa(nome, idade);
            pessoas.add(k);
            index++;
        }
        for(Pessoa p: pessoas){

            String ehDeMaior = " é de menor";

            if (p.DeMaior()) {
                ehDeMaior = " não é de menor";
            }
            String mensagem = p.getNome() + ehDeMaior;
            JOptionPane.showMessageDialog(null,mensagem);
        }
    }
}