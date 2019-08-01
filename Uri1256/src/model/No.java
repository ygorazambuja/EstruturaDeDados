package model;

public class No {

    private Integer valor;
    private No proximo;

    public No(Integer valor) {
        setValor(valor);
        this.proximo = null;
    }

    Integer getValor() {
        return valor;
    }

    void setValor(Integer valor) {
        this.valor = valor;
    }

    No getProximo() {
        return proximo;
    }

    void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
