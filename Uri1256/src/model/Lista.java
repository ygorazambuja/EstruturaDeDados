package model;


import java.io.PrintWriter;

public class Lista {


    private No inicio;

    public Lista() {
        this.inicio = null;
    }

    public void inserir(No novoNo) {
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No noTemporario;
            noTemporario = inicio;
            while (noTemporario.getProximo() != null) {
                noTemporario = noTemporario.getProximo();
            }
            noTemporario.setProximo(novoNo);
        }
    }

    public void listar() {
        if (inicio != null) {
            No noAuxiliar = inicio;
            while (noAuxiliar != null) {
                System.out.print(noAuxiliar.getValor() + " -> ");
                noAuxiliar = noAuxiliar.getProximo();
            }
            System.out.print("\\");
        } else {
            System.out.print("\\");
        }
    }
    

}
