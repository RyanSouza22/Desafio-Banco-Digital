package desafiobancodigital;

public class ContaCorrente extends Conta{

    public ContaCorrente(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String imprimirExtrato() {
	return "======== Extrato Conta Corrente ========\n" + super.imprimirInfosComuns();
    }
}
