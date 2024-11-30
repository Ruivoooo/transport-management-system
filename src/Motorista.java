
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Motorista {
    private static int contador = 1;
    private int id;
    private String nome;
    private String cnh;
    private double telefone;

    Scanner scanner = new Scanner(System.in);
    List<Motorista> cadastroMotorista = new ArrayList<>();

    public Motorista(int id,String nome, String cnh, double telefone) {
        this.id = contador++;
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Motorista (){}

    public List<Motorista> getMotoristasCadastrados() {
        return cadastroMotorista;
    }

    public void CadastroMotoristas(){
        System.out.println("Qual o nome do motorista ? ");
        nome = scanner.nextLine();
        System.out.println("Informe sua cnh: ");
        cnh = scanner.nextLine();
        System.out.println("Digite seu numero de telefone: ");
        telefone = scanner.nextDouble();
        scanner.nextLine();


        Motorista motorista = new Motorista(id,nome,cnh,telefone);
        cadastroMotorista.add(motorista);
        System.out.println("Motorista cadastrado com sucesso. ");
    }

    public void VisualizarMotoristas() {
        System.out.println("LISTA DE MOTORISTAS CADASTRADOS:");
        for (Motorista motor : cadastroMotorista) {
            System.out.println(motor);
            System.out.println("-------------------------------------------------");
        }
    }
        public void RemoverMotorista() {

                for (Motorista motoristas : cadastroMotorista) {
                    System.out.println(motoristas);
                    System.out.println("-------------------------------------------------");
                }
            System.out.println("Qual motorista você quer remover: ");
            int remover = scanner.nextInt();
            scanner.nextLine();
            cadastroMotorista.remove(remover - 1);
            System.out.println("Motorista removido com sucesso.");
        }



    @Override
    public String toString() {
        return "ID: " + id +
                ", Nome: " + nome +
                ", Cnh: " + cnh +
                ", Telefone: " + telefone
               ;
    }
}
