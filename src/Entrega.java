import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.util.List;
import java.util.Scanner;

public class Entrega{

    private String enderecoDest;
    private String dataPrevista;
    private String status;

    Scanner scanner = new Scanner(System.in);

    public Entrega(String enderecoDest, String dataPrevista, String status) {
        this.enderecoDest = enderecoDest;
        this.dataPrevista = dataPrevista;
        this.status = status;
    }

    public Entrega(){}

    private List<Motorista> motoristas;
    private List<Caminhao> caminhoes;

    public void cadastrarEntrega(List<Motorista> motoristas){
        this.motoristas = motoristas;

        for (Motorista motorista : motoristas){
            System.out.println(motorista);
        }System.out.println("Qual destes motoristas disponiveis você deseja ? ");


        if(motoristas.isEmpty()){
            System.out.println("Nenhum motorista disponivel");
        }

    }
}
