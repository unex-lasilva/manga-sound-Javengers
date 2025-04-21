package estruturas;

public class No<T> {
    public T dado;
    public No<T> proximo;

    public Object valor;


    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
}
