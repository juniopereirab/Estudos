public interface ServicoRemoto {
    ContaCorrente recuperarConta(String numConta);
    void persistirConta(String numConta, double saldo);
}
