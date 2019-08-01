import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Main {

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
            if (i < casosDeTeste - 1) {
                out.println("\n");
            }
        }
        out.println();
        out.close();
        input.close();
    }
}

class Par {

    private Lista lista;
    private Integer chave;

    public Par(Lista lista, Integer chave) {
        this.lista = lista;
        this.chave = chave;
    }

    public Lista getLista() {
        return lista;
    }

    public Integer getChave() {
        return chave;
    }

    public void setChave(Integer chave) {
        this.chave = chave;
    }
}

class No {

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

class Lista {

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

class HashTable {

    private Integer tamanhoDaTabela;
    private Par[] pares;

    public HashTable(Integer tamanhoDaTabela) {
        this.tamanhoDaTabela = tamanhoDaTabela;
        pares = new Par[tamanhoDaTabela];
        instanciandoPares();
    }

    private Integer funcaoDeDispersao(No no) {
        return no.getValor() % tamanhoDaTabela;
    }

    public void adicionarNovoNo(No no) {
        Integer chave = funcaoDeDispersao(no);
        pares[chave].setChave(chave);
        pares[chave].getLista().inserir(no);
    }

    private void instanciandoPares() {
        for (int i = 0; i < tamanhoDaTabela; i++) {
            pares[i] = new Par(new Lista(), i);
        }
    }

    public StringBuilder imprimirTudo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pares.length; i++) {
            stringBuilder.append(i).append(" -> ").append(pares[i].getLista().listar());
            if (i < pares.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder;
    }
}
