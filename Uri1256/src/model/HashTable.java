package model;

public class HashTable {

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
