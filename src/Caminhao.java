import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Caminhao {
    private static int contador = 1;
    private String placa;
    private String modelo;
    private String capacDisponivel;
    private int id;

    Scanner scanner = new Scanner(System.in);
    List<Caminhao> caminhoesCadastrados = new ArrayList<>();

    public Caminhao(int id, String placa, String modelo, String capacDisponivel) {
        this.id = contador++;
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

        System.out.println("Caminhão cadastrado com sucesso. ");


        Caminhao caminhao = new Caminhao(id,placa,modelo,capacDisponivel);
        caminhoesCadastrados.add(caminhao);
    }

    public void listarCaminhoes(){
        for (Caminhao caminhao : caminhoesCadastrados){
            System.out.println("LISTA DE CAMINHÕES CADASTRADOS: ");
            System.out.println("-------------------------------------------------");
            System.out.println(caminhao);
            System.out.println("-------------------------------------------------");
        }
    }

    public void removerCaminhao(){
        for (Caminhao caminhao : caminhoesCadastrados){
            System.out.println(caminhao);
            System.out.println("-------------------------------------------------");
        }
        System.out.println("Qual caminhão você vai remover ?");
        int remover = scanner.nextInt();
        scanner.nextLine();
        caminhoesCadastrados.remove(remover - 1);
        System.out.println("Caminhão removido com sucesso. ");
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Capacidade " + capacDisponivel +
                ", modelo: " + modelo +
                ", placa: " + placa
                ;
    }
}
