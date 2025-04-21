import java.util.Scanner;
import estruturas.ListaEncadeada;

public class MangaSoundApplication {

    static ListaEncadeada<Musica> repositorioMusicas = new ListaEncadeada<>();
    static ListaEncadeada<String> artistas = new ListaEncadeada<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ListaEncadeada<ListaReproducao> listasReproducao = new ListaEncadeada<>();
        ReprodutorLista reprodutorLista = new ReprodutorLista();

        SimpleAudioPlayer player = null;

        System.out.println("=====================================");
        System.out.println("  Seja Bem-Vindo ao MangaSound!  ");
        System.out.println("=====================================");

        int opcao = 0;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println(" 1. Adicionar Música ao Repositório");
            System.out.println(" 2. Criar Lista de Reprodução");
            System.out.println(" 3. Editar Lista de Reprodução");
            System.out.println(" 4. Executar Lista de Reprodução");
            System.out.println(" 5. Sair");
            System.out.print("\nDigite sua opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\n⚠ ERRO! Digite um número válido.");
                scanner.next();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o artista: ");
                    String artista = scanner.nextLine();

                    System.out.print("Digite o caminho do arquivo .wav: ");
                    String path = scanner.nextLine();

                    Musica nova = new Musica(titulo, artista, path);
                    repositorioMusicas.adicionar(nova);
                    artistas.adicionar(artista);

                    System.out.println("✅ Música adicionada ao repositório!");
                    break;
                case 2:

                    System.out.print("Digite o nome da nova lista de reprodução: ");
                    String nomeLista = scanner.nextLine();

                    ListaReproducao novaListaReproducao = new ListaReproducao(nomeLista);

                    System.out.println("Músicas disponíveis no repositório:");
                    for (int i = 0; i < repositorioMusicas.getTamanho(); i++) {
                        System.out.println(i + " - " + repositorioMusicas.get(i));
                    }

                    String continuar;
                    do {
                        System.out.print("Digite o número da música que deseja adicionar à lista: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine();

                        if (indice >= 0 && indice < repositorioMusicas.getTamanho()) {
                            Musica musicaSelecionada = repositorioMusicas.get(indice);
                            novaListaReproducao.adicionarMusica(musicaSelecionada);
                            System.out.println("✅ Música adicionada à lista!");
                        } else {
                            System.out.println("❌ Índice inválido.");
                        }

                        System.out.print("Deseja adicionar mais músicas? (s/n): ");
                        continuar = scanner.nextLine();
                    } while (continuar.equalsIgnoreCase("s"));

                    listasReproducao.adicionar(novaListaReproducao);
                    System.out.println("🎵 Lista '" + nomeLista + "' criada com sucesso!");
                    break;

                case 3:
                    System.out.println("\nListas de reprodução disponíveis:");
                    for (int i = 0; i < listasReproducao.getTamanho(); i++) {
                        System.out.println(i + " - " + listasReproducao.get(i).getTitulo());
                    }
                    System.out.print("Digite o número da lista que deseja editar: ");
                    int escolhaEditar = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaEditar >= 0 && escolhaEditar < listasReproducao.getTamanho()) {
                        ListaReproducao listaParaEditar = listasReproducao.get(escolhaEditar);
                        EditorListaEncadeada editor = new EditorListaEncadeada(listaParaEditar, scanner);
                        editor.editar(); // Inicia o editor
                        System.out.println("✅ Alterações salvas na lista: " + listaParaEditar.getTitulo());
                    } else {
                        System.out.println("❌ Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.println("\nListas de reprodução disponíveis:");
                    for (int i = 0; i < listasReproducao.getTamanho(); i++) {
                        System.out.println(i + " - " + listasReproducao.get(i).getTitulo());
                    }
                    System.out.print("Digite o número da lista que deseja reproduzir: ");
                    int escolhaLista = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaLista >= 0 && escolhaLista < listasReproducao.getTamanho()) {
                        ListaReproducao listaSelecionada = listasReproducao.get(escolhaLista);
                        reprodutorLista.reproduzirLista(listaSelecionada);
                    } else {
                        System.out.println("❌ Lista inválida.");
                    }
                    break;


                case 5:
                    System.out.println("\n✅ Fim! Obrigado por usar o MangaSound.");
                    break;
                default:
                    System.out.println("\n⚠ ERRO! Digite um número válido.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
