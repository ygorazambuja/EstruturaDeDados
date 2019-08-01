package app;

import model.ArvoreDeBuscaBinaria;
import model.No;

public class TesteArvoreBuscaBinaria {


    public static void main(String[] args) {

        ArvoreDeBuscaBinaria arvoreDeBuscaBinaria = new ArvoreDeBuscaBinaria<>();
        arvoreDeBuscaBinaria.inserir(new No<>(5));
        arvoreDeBuscaBinaria.inserir(new No<>(2));
        arvoreDeBuscaBinaria.inserir(new No<>(1));
        arvoreDeBuscaBinaria.inserir(new No<>(6));
        arvoreDeBuscaBinaria.inserir(new No<>(4));
        arvoreDeBuscaBinaria.inserir(new No<>(3));
        arvoreDeBuscaBinaria.inserir(new No<>(9));
        arvoreDeBuscaBinaria.inserir(new No<>(7));
        arvoreDeBuscaBinaria.inserir(new No<>(8));

        arvoreDeBuscaBinaria.inOrdem();

        try {
            arvoreDeBuscaBinaria.remover(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        arvoreDeBuscaBinaria.inOrdem();
        System.out.println("\n" + arvoreDeBuscaBinaria.getRaiz().getData());
    }


}
