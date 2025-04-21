import estruturas.ListaEncadeada;

public class TesteLista {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.append("Música 1");
        lista.append("Música 2");
        lista.insertAt(1, "Música Extra");
        System.out.println(lista.get(1)); // Música Extra
        System.out.println(lista.contains("Música 1")); // true
        lista.remove(0);
        System.out.println(lista.get(0)); // Música Extra
    }
}
