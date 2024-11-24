
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrega implements Rastreavel {

    private String enderecoDest;
    private String dataPrevista;
    private String status;

    Scanner scanner = new Scanner(System.in);


    public Entrega(String enderecoDest, String dataPrevista, String status) {
        this.enderecoDest = enderecoDest;
        this.dataPrevista = dataPrevista;
        this.status = status;
    }

    List<Entrega> entregasCadastradas = new ArrayList<>();

    public Entrega() {
    }

    private List<Motorista> motoristas;
    private List<Caminhao> caminhoes;

    public void cadastrarEntrega(List<Motorista> motoristas, List<Caminhao> caminhoes) {

        this.motoristas = motoristas;
        this.caminhoes = caminhoes;

        for (Motorista motorista : motoristas) {
            System.out.println(motorista);
        }
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista disponivel,cadastre motoristas antes de cadastrar uma entrega ");
            return;
        }
        System.out.println("Qual motorista você deseja ?");
        int motoristaEscolher = scanner.nextInt();

        if (motoristaEscolher > 0 && motoristaEscolher <= motoristas.size()) {
            System.out.println("Motorista escolhido foi: ");
            System.out.println(motoristas.get(motoristaEscolher - 1));
        } else {
            System.out.println("Escolha invalida");
        }


        for (Caminhao caminhao : caminhoes) {
            System.out.println(caminhao);
        }
        if (caminhoes.isEmpty()) {
            System.out.println("Nenhum caminhão disponivel,cadastre caminhões antes de cadastrar uma entrega ");
            return;
        }
        System.out.println("Qual caminhão você escolhe? ");
        int caminhaoEscolher = scanner.nextInt();
        scanner.nextLine();


        if (caminhaoEscolher > 0 && caminhaoEscolher <= caminhoes.size()) {
            System.out.println("Caminhão escolhido foi:");
            System.out.println(caminhoes.get(caminhaoEscolher - 1));
        } else {
            System.out.println("Escolha invalida.");
            return;
        }


        System.out.println("Informe o endereço de entrega: ");
        enderecoDest = scanner.nextLine();

        System.out.println("Qual a previsão de entrega: ");
        dataPrevista = scanner.nextLine();

        this.status = "Em preparo";

        Entrega entrega = new Entrega(enderecoDest, dataPrevista, status);
        entregasCadastradas.add(entrega);


        System.out.println("Entrega cadastrada com sucesso!");
        System.out.println("Detalhes da entrega: ");
        System.out.println(entrega);
        System.out.println("Motorista associado: " + motoristaEscolher);
        System.out.println("Caminhão associado: " + caminhaoEscolher);

    }

    public void listarEntregas() {
        if (entregasCadastradas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada. ");
        }
        for (int i = 0; i < entregasCadastradas.size(); i++) {

            System.out.println(i + 1 + " - " + entregasCadastradas.get(i));

        }
    }

    @Override
    public void iniciarEntrega(Entrega entrega){
        for (Entrega entrega1 : entregasCadastradas) {
            System.out.println(entrega1);
        }
            System.out.println("Qual dessas entregas irá começar ?");
            int iniciar = scanner.nextInt() - 1;
            if(iniciar >= 0 && iniciar < entregasCadastradas.size()){
                Entrega entregaSelecionada = entregasCadastradas.get(iniciar);
                entregaSelecionada.status = "Em transporte";
                System.out.println("Status da entrega atualizado com sucesso");

            }else{
                System.out.println("Escolha invalida. ");
            }
    }

   public void finalizarEntregas(Entrega entrega){
        for(Entrega entrega1 : entregasCadastradas) {
            if(entrega1.status == "Em transporte") {
                System.out.println(entrega1);
            }
        }
        System.out.println("Qual entrega você quer finalizar ? ");
                int finalizar = scanner.nextInt() - 1;
                if(finalizar >= 0 && finalizar < entregasCadastradas.size()){
                    Entrega entregaFinalizada = entregasCadastradas.get(finalizar);
                    entregaFinalizada.status = "Finalizado";
                }
            }

    @Override
    public String toString() {
        return
                "Endereço de entrega: " + enderecoDest +
                        ", Data prevista: " + dataPrevista +
                        ", Status pedido: " + status
                ;
    }
}


