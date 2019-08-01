package model;

public class Par {
    
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
