public interface Hardware {
    String pegarNumeroDaContaCartao() throws ErroNumeroContaException;
    void entregarDinheiro() throws ErroEntregarDinheiroException;
    void lerEnvelope() throws ErroLerEnvelopeException;
}
