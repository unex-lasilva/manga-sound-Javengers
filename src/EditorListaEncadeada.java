import java.util.Scanner;

public class EditorListaEncadeada {
    private ListaReproducao listaReproducao; // Alterado para ListaReproducao
    private Scanner scanner;

    // Construtor corrigido para receber ListaReproducao
    public EditorListaEncadeada(ListaReproducao listaReproducao, Scanner scanner) {
        this.listaReproducao = listaReproducao;
        this.scanner = scanner;
    }

    public void editar() {
        while (true) {
            System.out.println("\nOpções de edição para a Lista: " + listaReproducao.getTitulo());
            System.out.println("1. Adicionar música");
            System.out.println("2. Remover música");
            System.out.println("3. Mover música");
            System.out.println("4. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarMusica();
                    break;
                case 2:
                    removerMusica();
                    break;
                case 3:
                    moverMusica();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarMusica() {
        System.out.print("Título da música: ");
        String titulo = scanner.nextLine();
        System.out.print("Caminho do arquivo de áudio: ");
        String path = scanner.nextLine();
        Musica novaMusica = new Musica(titulo, "Artista Desconhecido", path); // Assume artista padrão
        listaReproducao.adicionarMusica(novaMusica);
        System.out.println("Música adicionada com sucesso.");
    }

    public void removerMusica() {
        if (listaReproducao.getMusicas().getTamanho() == 0) {
            System.out.println("A playlist está vazia.");
            return;
        }
        System.out.println("Músicas na playlist:");
        for (int i = 0; i < listaReproducao.getMusicas().getTamanho(); i++) {
            System.out.println((i + 1) + ". " + listaReproducao.getMusicas().get(i).getTitulo());
        }
        System.out.print("Escolha o número da música para remover: ");
        int removeIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (removeIndex >= 0 && removeIndex < listaReproducao.getMusicas().getTamanho()) {
            listaReproducao.removerMusicaPorPosicao(removeIndex); // Chamada corrigida
            System.out.println("Música removida com sucesso.");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private void moverMusica() {
        if (listaReproducao.getMusicas().getTamanho() == 0) {
            System.out.println("A lista está vazia.");
            return;
        }
        System.out.println("Músicas na lista:");
        for (int i = 0; i < listaReproducao.getMusicas().getTamanho(); i++) {
            System.out.println((i + 1) + ". " + listaReproducao.getMusicas().get(i).getTitulo());
        }
        System.out.print("Escolha o número da música para mover: ");
        int fromIndex = scanner.nextInt() - 1;
        System.out.print("Escolha a nova posição: ");
        int toIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (fromIndex >= 0 && fromIndex < listaReproducao.getMusicas().getTamanho() &&
                toIndex >= 0 && toIndex < listaReproducao.getMusicas().getTamanho()) {
            moverMusica(fromIndex, toIndex); // Chama o método implementado
            System.out.println("Música movida com sucesso.");
        } else {
            System.out.println("Números inválidos.");
        }
    }

    private void moverMusica(int fromIndex, int toIndex) {
        Musica musica = listaReproducao.getMusicas().get(fromIndex);
        listaReproducao.removerMusicaPorPosicao(fromIndex);
        listaReproducao.adicionarMusicaEmPosicao(musica, toIndex);
    }
}