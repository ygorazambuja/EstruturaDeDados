package app;


import model.HashTable;
import model.No;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {

        Integer casosDeTeste = Integer.parseInt(input.readLine());
        while (casosDeTeste-- > 0) {
            String[] segundaLinha = input.readLine().split("\\s");
            Integer tamanhoDaTabela = Integer.parseInt(segundaLinha[0]);
            Integer quantidadeDeEntradas = Integer.parseInt(segundaLinha[1]);
            String[] terceiraLinha = input.readLine().split("\\s");

            HashTable hashTable = new HashTable(tamanhoDaTabela);
            for (String string : terceiraLinha
                 ) {
                hashTable.adicionarNovoNo(new No(Integer.parseInt(string)));
            }
            hashTable.imprimirTudo();
        }

        out.close();
    }
}
