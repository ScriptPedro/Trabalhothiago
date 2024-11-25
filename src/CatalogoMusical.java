import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoMusical {
    private static DiscoRepositorio discoRepo = new DiscoRepositorio();
    private static List<Artista> artistas = new ArrayList<>();
    private static List<Genero> generos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Adicionar Disco");
            System.out.println("2. Adicionar Artista");
            System.out.println("3. Adicionar GÊNERO");
            System.out.println("4. Listar Discos");
            System.out.println("5. Remover Disco");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarDisco(scanner);
                    break;
                case 2:
                    adicionarArtista(scanner);
                    break;
                case 3:
                    adicionarGenero(scanner);
                    break;
                case 4:
                    listarDiscos();
                    break;
                case 5:
                    removerDisco(scanner);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void adicionarArtista(Scanner scanner) {
        System.out.print("Digite o nome do artista: ");
        String nome = scanner.nextLine();
        System.out.println("Escolha o gênero musical:");
        for (int i = 0; i < generos.size(); i++) {
            System.out.println(i + ". " + generos.get(i).getNome());
        }
        int generoIndex = scanner.nextInt();
        scanner.nextLine(); 

        if (generoIndex >= 0 && generoIndex < generos.size()) {
            Genero genero = generos.get(generoIndex);
            Artista artista = new Artista(nome, genero);
            artistas.add(artista);
            System.out.println("Artista adicionado com sucesso!");
        } else {
            System.out.println("Gênero inválido.");
        }
    }

    private static void adicionarGenero(Scanner scanner) {
        System.out.print("Digite o nome do gênero musical: ");
        String nome = scanner.nextLine();
        Genero genero = new Genero(nome);
        generos.add(genero);
        System.out.println("Gênero adicionado com sucesso!");
    }

    private static void adicionarDisco(Scanner scanner) {
        System.out.print("Digite o título do disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o ano de lançamento: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Digite o número de faixas:");
        int numFaixas = scanner.nextInt();
        scanner.nextLine(); 

        List<String> faixas = new ArrayList<>();
        for (int i = 0; i < numFaixas; i++) {
            System.out.print("Digite o nome da faixa " + (i + 1) + ": ");
            String faixa = scanner.nextLine();
            faixas.add(faixa);
        }

        System.out.println("Escolha o artista para o disco:");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println(i + ". " + artistas.get(i).getNome());
        }
        int artistaIndex = scanner.nextInt();
        scanner.nextLine(); 

        if (artistaIndex >= 0 && artistaIndex < artistas.size()) {
            Artista artista = artistas.get(artistaIndex);
            Disco disco = new Disco(titulo, anoLancamento, faixas, artista);
            discoRepo.adicionar(disco);
            System.out.println("Disco adicionado com sucesso!");
        } else {
            System.out.println("Artista inválido.");
        }
    }

    private static void listarDiscos() {
        List<Disco> discos = discoRepo.listar();
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            for (Disco disco : discos) {
                System.out.println(disco);
            }
        }
    }

    private static void removerDisco(Scanner scanner) {
        System.out.println("Escolha o disco a ser removido:");
        List<Disco> discos = discoRepo.listar();
        for (int i = 0; i < discos.size(); i++) {
            System.out.println(i + ". " + discos.get(i).getTitulo());
        }
        int index = scanner.nextInt();
        scanner.nextLine(); 

        if (index >= 0 && index < discos.size()) {
            Disco disco = discos.get(index);
            discoRepo.remover(disco);
            System.out.println("Disco removido com sucesso!");
        } else {
            System.out.println("Disco inválido.");
        }
    }
}

