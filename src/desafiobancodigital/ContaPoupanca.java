package desafiobancodigital;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String imprimirExtrato() {
	return "======== Extrato Conta Poupança ========\n" + super.imprimirInfosComuns();
    }
}
