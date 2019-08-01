package model;


import com.sun.org.apache.xpath.internal.operations.String;

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

    public StringBuilder listar() {
        StringBuilder stringBuilder = new StringBuilder();
        if (inicio != null) {
            No noPonteiro = inicio;
            while (noPonteiro != null) {
                stringBuilder.append(noPonteiro.getValor()).append(" -> ");
                noPonteiro = noPonteiro.getProximo();
            }
            stringBuilder.append("\\");
        } else {
            stringBuilder.append("\\");
        }
            

        return stringBuilder;
    }
}
