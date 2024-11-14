import java.util.Scanner;

// Classe principal Animal com todas as propriedades e métodos do bichinho virtual
class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int forca;

    // Construtor para inicializar o animal
    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    // Método para "nascer" o animal
    public void nascer() {
        System.out.println(nome + " nasceu! Classe: " + classe + ", Família: " + familia);
    }

    // Método para "morrer" o animal
    public void morrer() {
        if (vivo) {
            forca = 0;
            vivo = false;
            System.out.println(nome + " morreu.");
        } else {
            System.out.println(nome + " já está morto.");
        }
    }

    // Método para o animal comer
    public void comer() {
        if (vivo && caloria < 100) {
            caloria = Math.min(caloria + 10, 100);
            forca = Math.max(forca - 2, 0);
            System.out.println(nome + " comeu. Caloria: " + caloria + ", Força: " + forca);
        } else if (!vivo) {
            System.out.println(nome + " está morto e não pode comer.");
        } else {
            System.out.println(nome + " está cheio e não pode comer mais.");
        }
    }

    // Método para o animal correr
    public void correr() {
        if (vivo && caloria > 0) {
            forca = Math.max(forca - 5, 0);
            caloria = Math.max(caloria - 5, 0);
            System.out.println(nome + " correu. Caloria: " + caloria + ", Força: " + forca);
        } else if (!vivo) {
            System.out.println(nome + " está morto e não pode correr.");
        } else {
            System.out.println(nome + " está exausto e não pode correr.");
        }
    }

    // Método para o animal dormir
    public void dormir() {
        if (vivo) {
            forca = Math.min(forca + 10, 100);
            caloria = Math.max(caloria - 2, 0);
            System.out.println(nome + " dormiu. Caloria: " + caloria + ", Força: " + forca);
        } else {
            System.out.println(nome + " está morto e não pode dormir.");
        }
    }

    // Verifica se o animal está vivo
    public boolean estaVivo() {
        return vivo;
    }
}

// Classe de controle do jogo
class Jogo {
    private Animal animal;

    // Inicializa o jogo e cria um novo animal com as características informadas pelo usuário
    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do animal: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a classe do animal: ");
        String classe = scanner.nextLine();
        System.out.print("Digite a família do animal: ");
        String familia = scanner.nextLine();

        animal = new Animal(nome, classe, familia);
        animal.nascer();

        while (animal.estaVivo()) {
            exibirMenu(scanner);
        }

        System.out.println("O jogo terminou.");
        scanner.close();
    }

    // Exibe o menu de ações e executa a ação escolhida
    private void exibirMenu(Scanner scanner) {
        System.out.println("\nEscolha uma ação: ");
        System.out.println("1 - Comer");
        System.out.println("2 - Correr");
        System.out.println("3 - Dormir");
        System.out.println("4 - Morrer");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                animal.comer();
                break;
            case 2:
                animal.correr();
                break;
            case 3:
                animal.dormir();
                break;
            case 4:
                animal.morrer();
                break;
            default:
                System.out.println("Ação inválida!");
        }
    }
}

// Classe Main para iniciar o jogo
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}
