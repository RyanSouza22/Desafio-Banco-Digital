
package desafiobancodigital;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        String opt = "";
        String nome, cpf;
        String optConta;
        double valor = 0;
        Conta conta;
        
        while(!opt.equals("6")){
            opt = JOptionPane.showInputDialog("1 - Criar uma Conta"+
                                            "\n2 - Sacar"+
                                            "\n3 - Depositar"+
                                            "\n4 - Transferir"+
                                            "\n5 - Mostrar Extrato"+
                                            "\n6 - Sair");
            if(opt == null){
                System.exit(0);
            }
            
            try{
                switch (opt){
                case "1": //Criar uma Conta
                    nome = JOptionPane.showInputDialog("Nome: ");
                    cpf = JOptionPane.showInputDialog("CPF: ");
                    optConta = JOptionPane.showInputDialog("Tipo de Conta: \n 1 = Corrente \n 2 = Poupança");
                    switch (optConta){
                        case "1":
                            Conta corrente = new ContaCorrente(nome, cpf);
                            JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso!");
                            banco.inserirConta(corrente);
                            break;
                        case "2":
                            Conta poupanca = new ContaPoupanca(nome, cpf);
                            JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso!");
                            banco.inserirConta(poupanca);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente.");
                            break;
                    }
                    break;
                case "2": //Sacar
                    conta = procuraCpf(banco);
                    if(conta != null)
                        conta.sacar(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a sacar: ")));
                    break;
                case "3": //Depositar
                    conta = procuraCpf(banco);
                    if(conta != null)
                        conta.depositar(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar: ")));
                    break;
                case "4": //Transferir
                    conta = procuraCpf(banco);
                    Conta conta2 = procuraCpfDestino(banco);
                    if(conta != null && conta2 != null){
                        valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a depositar: "));
                        conta.transferir(valor, conta2);
                    }
                    break;
                case "5": //Mostrar Extrato
                    conta = procuraCpf(banco);
                    if(conta != null)
                        JOptionPane.showMessageDialog(null, banco.getNome() + conta.imprimirExtrato());
                    break;
                case "6": //Sair
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Invalida! Tente novamente.");
                    break;
            }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada somente de Numeros!!" + e.getMessage());
            }
        }
    }
    
    public static Conta procuraCpf(Banco banco){
        String cpf = JOptionPane.showInputDialog("Insira CPF do Titular da conta: ");
            for (Conta conta : banco.getLstContas()){
                if(conta.cliente.getCpf().equals(cpf)){
                    return conta;
                }
            }
        JOptionPane.showMessageDialog(null, "Conta nao encontrada!!");
        return null;
    }
    public static Conta procuraCpfDestino(Banco banco){
        String cpf = JOptionPane.showInputDialog("CPF do Titular da conta Destino : ");
            for (Conta conta : banco.getLstContas()){
                if(conta.cliente.getCpf().equals(cpf)){
                    return conta;
                }
            }
        JOptionPane.showMessageDialog(null, "Conta nao encontrada!!");
        return null;
    }
}
