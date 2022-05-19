
package desafiobancodigital;

import java.util.ArrayList;

public class Banco {

    private String nome = "=======================================\n"
                        + "         Banco Digital Innovation         \n"
                        + "=======================================\n";
    private ArrayList<Conta> lstContas;

    public Banco() {
        lstContas = new ArrayList<>();
    }
    
    //GET AND SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conta> getLstContas() {
        return lstContas;
    }

    public void setLstContas(ArrayList<Conta> lstContas) {
        this.lstContas = lstContas;
    }
    
    //FUNCOES
    public void inserirConta(Conta conta){
    lstContas.add(conta);
    }
}
