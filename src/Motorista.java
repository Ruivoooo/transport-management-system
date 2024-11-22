
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Motorista {
    private String nome;
    private String cnh;
    private double telefone;

    Scanner scanner = new Scanner(System.in);
    List<Motorista> cadastroMotorista = new ArrayList<>();

    public Motorista(String nome, String cnh, double telefone) {
        this.nome = nome;
        this.cnh = cnh;
        this.telefone = telefone;
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

        Motorista motorista = new Motorista(nome,cnh,telefone);
        cadastroMotorista.add(motorista);
    }

    public void VisualizarMotoristas() {
        for (Motorista motor : cadastroMotorista) {
            System.out.println(motor);
        }
    }
        public void RemoverMotorista() {

                for (Motorista motoristas : cadastroMotorista) {
                    System.out.println(motoristas);
                }
            System.out.println("Qual motorista você quer remover: ");
            int remover = scanner.nextInt();
            cadastroMotorista.remove(remover - 1);
        }



    @Override
    public String toString() {
        return "Motorista: " +
                "Nome: " + nome +
                ", Cnh: " + cnh +
                ", Telefone: " + telefone
               ;
    }
}
