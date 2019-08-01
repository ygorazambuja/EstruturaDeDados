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

        for (int i = 0; i < casosDeTeste; i++) {
            String[] segundaLinha = input.readLine().split("\\s");
            int tamanhoDaTabela = Integer.parseInt(segundaLinha[0]);
            int quantidadeDeEntradas = Integer.parseInt(segundaLinha[1]);
            String[] terceiraLinha = input.readLine().split("\\s");

            HashTable hashTable = new HashTable(tamanhoDaTabela);
            for (int j = 0; j < quantidadeDeEntradas; j++) {
                hashTable.adicionarNovoNo(new No(Integer.parseInt(terceiraLinha[j])));
            }
            out.print(hashTable.imprimirTudo());
            if(i < casosDeTeste -1 ){
                out.println("\n");
            }
        }
        out.println();
        out.close();
        input.close();
    }
}
