import java.util.Scanner;

public class MangaSoundApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println("\n🔹 Opção 1: Adicionar Música ao Repositório (Em Desenvolvimento)");
                    break;
                case 2:
                    System.out.println("\n🔹 Opção 2: Criar Lista de Reprodução (Em Desenvolvimento)");
                    break;
                case 3:
                    System.out.println("\n🔹 Opção 3: Editar Lista de Reprodução (Em Desenvolvimento)");
                    break;
                case 4:
                    try {
                        System.out.println("Executando Lista de Reprodução...");

                        // Agora passamos o caminho do arquivo diretamente no construtor
                        player = new SimpleAudioPlayer("C:\\Users\\SeuUsuario\\Música\\teste.wav");
                        player.play();

                        Scanner sc = new Scanner(System.in);
                        while (true) {
                            System.out.println("\nControles de áudio:");
                            System.out.println("1. Pausar");
                            System.out.println("2. Continuar");
                            System.out.println("3. Reiniciar");
                            System.out.println("4. Parar");
                            System.out.println("5. Voltar ao Menu");
                            System.out.print("Escolha uma opção: ");

                            int escolha = sc.nextInt();
                            switch (escolha) {
                                case 1:
                                    player.pause();
                                    break;
                                case 2:
                                    player.resumeAudio();
                                    break;
                                case 3:
                                    player.restart();
                                    break;
                                case 4:
                                    player.stop();
                                    break;
                                case 5:
                                    System.out.println("Voltando ao menu principal...");
                                    player.stop();
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }

                            if (escolha == 5) break;
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao executar áudio!");
                        e.printStackTrace();
                    } break;
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
