import java.io.ObjectInputFilter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Entrega implements Rastreavel {

    private String enderecoDest;
    private String dataPrevista;
    private static int contador = 1;
    private int id;
    private StatusPedido statuss;


    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter custonFormat = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
    String dateTimeFormate = now.format(custonFormat);

    Scanner scanner = new Scanner(System.in);

    public Entrega(int id,String enderecoDest, String dataPrevista, StatusPedido statuss) {
        this.id = contador++;
        this.enderecoDest = enderecoDest;
        this.dataPrevista = dataPrevista;
        this.statuss = StatusPedido.EM_PREPARO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
            Motorista motoristaEscolhido = motoristas.get(motoristaEscolher - 1);
            System.out.println("Motorista escolhido foi: ");
            System.out.println(motoristaEscolhido.getNome());
            System.out.println("----------------------------------------");
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
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Escolha invalida.");
            return;
        }


        System.out.println("Informe o endereço de entrega: ");
        enderecoDest = scanner.nextLine();

        System.out.println("Qual a previsão de entrega: (formato dd/MM/yyyy) ");
        dataPrevista = scanner.nextLine();

        LocalDate prevista = LocalDate.parse(dataPrevista, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime dataPrevistaComHora = prevista.atStartOfDay();

        if(dataPrevistaComHora.isBefore(now)){
            System.out.println("Data fornecida, não pode ser menor que a atual.");
            return;

        }

        Entrega entrega = new Entrega(id,enderecoDest, dataPrevista, statuss);
        entregasCadastradas.add(entrega);

        System.out.println("Entrega cadastrada com sucesso!");
        System.out.println("Detalhes da entrega: ");
        System.out.println(entrega);
        Motorista motoristaNome = motoristas.get(motoristaEscolher - 1);
        System.out.println("Motorista associado: " + motoristaNome.getNome());
        System.out.println("Caminhão associado: " + caminhaoEscolher);
        System.out.println("----------------------------------------");
    }


    public void listarEntregas() {
        if (entregasCadastradas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada. ");
        }
        for (int i = 0; i < entregasCadastradas.size(); i++) {

            System.out.println(entregasCadastradas.get(i));
            System.out.println("----------------------------------------");

        }
    }

    @Override
    public void iniciarEntrega(Entrega entrega){
        if(entregasCadastradas.isEmpty()){
            System.out.println("Cadastre uma entrega antes de iniciar.");
            return;
        }
        for (Entrega entrega1 : entregasCadastradas) {
            if(entrega1.statuss == StatusPedido.EM_PREPARO) {
                System.out.println(entrega1);
                System.out.println("----------------------------------------");
                System.out.println("Qual dessas entregas irá começar ?");
            }else{
                System.out.println("Nenhuma entrega cadastrada. ");
                return;
            }
        }
        int iniciar = scanner.nextInt() - 1;
        if(iniciar >= 0 && iniciar < entregasCadastradas.size()){
            Entrega entregaSelecionada = entregasCadastradas.get(iniciar);
            entregaSelecionada.statuss = StatusPedido.EM_TRANSITO ;
            System.out.println("Status da entrega atualizado com sucesso");
        }else{
            System.out.println("Escolha invalida. ");
        }
    }

    public void finalizarEntregas(Entrega entrega){
        if(entregasCadastradas.isEmpty()){
            System.out.println("Nenhuma entrega em andamento.");
            return;
        }
        for(Entrega entrega1 : entregasCadastradas) {
            if(entrega1.statuss == StatusPedido.EM_TRANSITO ) {
                System.out.println(entrega1);
                System.out.println("-------------------------------------------------");
                System.out.println("Qual entrega você quer finalizar ? ");
            }else{
                System.out.println("Nenhum pedido para finalizar. ");
                return;
            }
        }

        int finalizar = scanner.nextInt() - 1;
        if(finalizar >= 0 && finalizar < entregasCadastradas.size()){
            Entrega entregaFinalizada = entregasCadastradas.get(finalizar);
            entregaFinalizada.statuss = StatusPedido.FINALIZADO;
            System.out.println("Entrega finalizada com sucesso. ");
        }
    }

    @Override
    public String toString() {
        return   "\nID: " + id +
                "\nEndereço de entrega: " + enderecoDest +
                "\nData prevista: " + dataPrevista +
                "\nStatus pedido: " + statuss +
                "\nHorario do pedido: " + dateTimeFormate;
    }
}