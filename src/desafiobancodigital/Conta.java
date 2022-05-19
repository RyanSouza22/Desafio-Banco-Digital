
package desafiobancodigital;

import javax.swing.JOptionPane;

public abstract class Conta implements IConta{
    
    private static final int AGENCIA_PADRAO = 1;  
    private static int SEQUENCIAL = 1;
        
    protected int agencia;
    protected int numConta;
    protected double saldo;
    protected Cliente cliente;
    //------------------------------------------------------------------------//
    //CONSTRUTOR
    public Conta(String nome, String cpf) {
        this.agencia = AGENCIA_PADRAO;
        this.numConta = SEQUENCIAL++;
        cliente = new Cliente(nome, cpf);
    }
    //------------------------------------------------------------------------//
    //GET AND SETTER
    
    public int getAgencia() {
        return agencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    /*public Cliente getCliente() {
        return cliente;
    }*/
    //------------------------------------------------------------------------//
    //FUNCOES
    @Override
    public void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            JOptionPane.showMessageDialog(null, "Saque Realizado!!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo INSUFICIENTE para realizar saque!!");
        }
    }
	
    @Override
    public void depositar(double valor){
        saldo += valor;
        JOptionPane.showMessageDialog(null, "Deposito Realizado!!");
    }
	
    @Override
    public void transferir(double valor, IConta contaDestino){
        if(saldo >= valor){
            saldo -= valor;
            contaDestino.depositar(valor);
            JOptionPane.showMessageDialog(null, "Tranferencia Realizada com Sucesso!!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo INSUFICIENTE para realizar transferencia!!");
        }
    }
    
    public String imprimirInfosComuns(){
        return "\nTitular: "           +cliente.getNome()+
               "\nCPF do Titular: "    +cliente.getCpf()+
               "\nAgencia: "            +agencia+
               "\nConta: "              +numConta+
               "\nSaldo: "              +saldo+
               "\n=======================================";
    }
}
