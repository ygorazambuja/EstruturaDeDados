package model;

public class No<T extends Comparable> {

    private T data;
    private No filhoEsquerdo;
    private No filhoDireito;

    public No(T data) {
        this.data = data;
        this.filhoDireito = null;
        this.filhoDireito = null;
    }

    public No(T data, No filhoEsquerdo, No filhoDireito) {
        this.data = data;
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public No getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(No filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public No getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(No filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
}
