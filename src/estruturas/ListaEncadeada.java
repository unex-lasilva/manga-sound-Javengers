package estruturas;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private int tamanho;

    public void append(T valor) {
        No<T> novo = new No<>(valor);


        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }




        tamanho++;
    }

    public void adicionar(T valor) {
        append(valor);
    }

    public void insertAt(int posicao, T valor) {
        if (posicao < 0 || posicao > tamanho) throw new IndexOutOfBoundsException();

        No<T> novo = new No<>(valor);
        if (posicao == 0) {
            novo.proximo = inicio;
            inicio = novo;
        } else {
            No<T> atual = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
        }
        tamanho++;
    }

    public void adicionarNaPosicao(T valor, int posicao) {
        insertAt(posicao, valor);
    }

    public T get(int index) {
        if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException();

        No<T> atual = inicio;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.dado;
    }

    public boolean contains(T valor) {
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.dado.equals(valor)) return true;
            atual = atual.proximo;
        }
        return false;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) throw new IndexOutOfBoundsException();

        if (index == 0) {
            inicio = inicio.proximo;
        } else {
            No<T> atual = inicio;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getInicio() {
        return inicio;
    }

}

