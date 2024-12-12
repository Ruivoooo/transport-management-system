import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        Motorista motorista = new Motorista();
        Caminhao caminhao = new Caminhao();
        Entrega entrega = new Entrega();

            while (continuar) {

                System.out.println("""
                        1 - Cadastro motorista  
                        2 - Visualizar motoristas cadastrados
                        3 - Remover motorista
                        4 - Cadastrar caminhão
                        5 - Visualizar caminhões cadastrados
                        6 - Remover caminhão
                        7 - Cadastrar entrega
                        8 - Listar entregas
                        9 - Iniciar entrega 
                        10- Finalizar entrega
                        """);
                try{
                int menu = scanner.nextInt();



                        if (menu == 1) {
                            motorista.CadastroMotoristas();
                        }
                        if (menu == 2) {
                            motorista.VisualizarMotoristas();
                        }
                        if (menu == 3) {
                            motorista.RemoverMotorista();
                        }
                        if (menu == 4) {
                            caminhao.cadastrarCaminhao();
                        }
                        if (menu == 5) {
                            caminhao.listarCaminhoes();
                        }
                        if (menu == 6) {
                            caminhao.removerCaminhao();
                        }
                        if (menu == 7) {
                            entrega.cadastrarEntrega(motorista.getMotoristasCadastrados(), caminhao.getCaminhoesCadastrados());
                        }
                        if (menu == 8) {
                            entrega.listarEntregas();
                        }
                        if (menu == 9) {
                            entrega.iniciarEntrega(entrega);
                        }
                        if (menu == 10) {
                            entrega.finalizarEntregas(entrega);
                        }
                    }catch (InputMismatchException e){
                    System.out.println("Não é permitido letras, digite um numero. ");
                    scanner.nextLine();
                    e.printStackTrace();
                }

           }
       }
}
