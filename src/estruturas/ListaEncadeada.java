package estruturas;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
    }

    public void adicionar(T dado) {
        No<T> novo = new No<>(dado);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void exibir() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }

    public No<T> getInicio() {
        return inicio;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public T get(int i) {
        return null;
    }

    public void adicionarNaPosicao(T musica, int posicao) {
    }

    public void remover(int i) {
    }
}
