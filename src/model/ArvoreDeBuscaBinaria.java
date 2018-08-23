package model;

public class ArvoreDeBuscaBinaria<T extends Comparable> {

    private No raiz;

    public ArvoreDeBuscaBinaria() {
        this.raiz = null;
    }

    public ArvoreDeBuscaBinaria(No<Comparable> raiz) {
        this.raiz = raiz;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    private void inserir(No<Comparable> novo, No<Comparable> pai) {
        if (comparador(novo, pai) == 1) { // 1 -> argumento > comparado;
            if (pai.getFilhoDireito() == null) {
                pai.setFilhoDireito(novo);
            } else {
                pai = pai.getFilhoDireito();
                inserir(novo, pai);
            }
        } else if (comparador(novo, pai) == -1) { // -1 -> argumento < comparado
            if (pai.getFilhoEsquerdo() == null) {
                pai.setFilhoEsquerdo(novo);
            } else {
                pai = pai.getFilhoEsquerdo();
                inserir(novo, pai);
            }
        } else if (comparador(novo, pai) == 0) { // 1 -> argumento = comparado
            throw new IllegalArgumentException("Elemento ja existe na Árvore");
        }
    }

    public void inserir(No novo) {
        if (isVazia()) {
            this.raiz = novo;
        } else {
            inserir(novo, raiz);
        }
    }


    public void remove() {
        // TODO Implementar ...
    }

    public boolean busca(No alvo) {
        if (isVazia()) {
            return false;
        } else {
            return busca(this.raiz, alvo);
        }
    }

    private boolean busca(No<Comparable> pai, No<Comparable> alvo) {
        if (isVazia()) return false;
        if (comparador(alvo, pai) == 0) {
            return true;
        } else {
            if (comparador(alvo, pai) == -1) {
                if (pai.getFilhoEsquerdo() == null) {
                    return false;
                } else {
                    pai = pai.getFilhoEsquerdo();
                    return busca(pai, alvo);
                }
            } else if (comparador(alvo, pai) == 1) {
                if (pai.getFilhoDireito() == null) {
                    return false;
                } else {
                    pai = pai.getFilhoDireito();
                    return busca(pai, alvo);
                }
            }
            return false;
        }
    }

    private void posOrdem(No no) {
        if (no == null)
            return;
        posOrdem(no.getFilhoEsquerdo());
        posOrdem(no.getFilhoDireito());
        System.out.print(no.getData() + " - ");
    }

    public void posOrdem() {
        posOrdem(this.raiz);
    }

    private void inOrdem(No no) {
        if (no == null)
            return;
        inOrdem(no.getFilhoEsquerdo());
        System.out.print(no.getData() + " - ");
        inOrdem(no.getFilhoDireito());
    }

    public void inOrdem() {
        inOrdem(this.raiz);
    }

    private void preOrdem(No no) {
        if (no == null)
            return;
        System.out.print(no.getData() + " - ");
        preOrdem(no.getFilhoEsquerdo());
        preOrdem(no.getFilhoDireito());
    }

    public void preOrdem() {
        preOrdem(this.raiz);
    }

    private boolean isVazia() {
        return this.raiz == null;
    }

    private Integer comparador(No noUm, No noDois) {
        return noUm.getData().compareTo(noDois.getData());
    }

    public No remover(T valor) throws Exception {
        return remover(this.raiz, valor);
    }

    private No remover(No no, T valor) throws Exception {
        if (this.raiz == null) {
            throw new Exception("Árvore vazia");
        } else {
            if (valor.compareTo(no.getData()) == -1) {
                no.setFilhoEsquerdo(remover(no.getFilhoEsquerdo(), valor));
            } else if (valor.compareTo(no.getData()) == 1) {
                no.setFilhoDireito(remover(no.getFilhoDireito(), valor));
            } else if (no.getFilhoEsquerdo() != null && no.getFilhoDireito() != null) {
                /*2 filhos*/
                no.setData(encontraMinimo(no.getFilhoDireito()).getData());
                no.setFilhoDireito(removeMinimo(no.getFilhoDireito()));
            } else {
                no = (no.getFilhoEsquerdo() != null) ? no.getFilhoEsquerdo() : no.getFilhoDireito();
            }
            return no;
        }
    }

    private No removeMinimo(No node) {
        if (node == null) {
            throw new NullPointerException("Nó Nulo");
        } else if (node.getFilhoEsquerdo() != null) {
            node.setFilhoEsquerdo(removeMinimo(node.getFilhoEsquerdo()));
            return node;
        } else {
            return node.getFilhoDireito();
        }
    }

    private No encontraMinimo(No node) {
        if (node != null) {
            while (node.getFilhoEsquerdo() != null) {
                node = node.getFilhoEsquerdo();
            }
        }
        return node;
    }
}

