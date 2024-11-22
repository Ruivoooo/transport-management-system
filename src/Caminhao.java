import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caminhao {
    private String placa;
    private String modelo;
    private String capacDisponivel;

    Scanner scanner = new Scanner(System.in);
    List<Caminhao> caminhoesCadastrados = new ArrayList<>();

    public Caminhao(String placa, String modelo, String capacDisponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacDisponivel = capacDisponivel;
    }

    public Caminhao (){}

    public List<Caminhao> getCaminhoesCadastrados() {
        return caminhoesCadastrados;
    }

    public void cadastrarCaminhao(){
        System.out.println("Digite a placa do caminhão: ");
        placa = scanner.nextLine();

        System.out.println("Qual o modelo do caminhão: ");
        modelo = scanner.nextLine();

        System.out.println("Qual a capacidade disponivel do caminhão: ");
        capacDisponivel = scanner.nextLine();


        Caminhao caminhao = new Caminhao(placa,modelo,capacDisponivel);
        caminhoesCadastrados.add(caminhao);
    }

    public void listarCaminhoes(){
        for (Caminhao caminhao : caminhoesCadastrados){
            System.out.println(caminhao);
        }
    }

    public void removerCaminhao(){
        for (Caminhao caminhao : caminhoesCadastrados){
            System.out.println(caminhao);
        }
        System.out.println("Qual caminhão você vai remover ?");
        int remover = scanner.nextInt();
        caminhoesCadastrados.remove(remover - 1);
    }

    @Override
    public String toString() {
        return "Caminhao: " +
                "capacDisponivel: " + capacDisponivel +
                ", modelo: " + modelo +
                ", placa: " + placa
                ;
    }
}
