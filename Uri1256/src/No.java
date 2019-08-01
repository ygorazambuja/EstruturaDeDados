public class No {

    private No proximo;
    private Integer valor;

    public Integer getValor() {
        return this.valor;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}