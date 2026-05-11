package Trabalho_01;

import java.util.Scanner;

public class Transito {
    static int totalTempoEsperaDecolagem = 0;
    static int totalTempoEsperaPouso = 0;
    static int totalDecolagens = 0;
    static int totalPousos = 0;
    static int totalEmergencias = 0;
    
    public static void InicarSimulação(){
        Scanner scanner = new Scanner(System.in);
        FilaAvioes filaDecolagem1 = new FilaAvioes();
        FilaAvioes filaDecolagem2 = new FilaAvioes();
        FilaAvioes filaPouso1 = new FilaAvioes();
        FilaAvioes filaPouso2 = new FilaAvioes();
        FilaAvioes filaSelecionada1 = null;
        FilaAvioes filaSelecionada2 = null;
        int turno = 0;
        String continuar = "s";
        
        while (continuar.equalsIgnoreCase("s")) {
            turno++;
            System.out.println("====================================");
            System.out.println("TURNO: " + turno + "\n");

            ManusearEmergencia(filaPouso1);
            ManusearEmergencia(filaPouso2);
            ManusearEmergencia(filaDecolagem1);
            ManusearEmergencia(filaDecolagem2);
            
            filaSelecionada1 = EscolherPista(filaPouso1, filaDecolagem1);
            filaSelecionada2 = EscolherPista(filaPouso2, filaDecolagem2);

            System.out.print("Informações da pista 1:");
            mostrarInformações(filaSelecionada1);
            System.out.print("\nInformações da pista 2:");
            mostrarInformações(filaSelecionada2);

            filaSelecionada1.removerInicio();
            filaSelecionada2.removerInicio();

            filaDecolagem1.passarTurno();
            filaDecolagem2.passarTurno();
            filaPouso1.passarTurno();
            filaPouso2.passarTurno();

            int qtdDecolagem1 = AviaoGenerator.radomInt();
            int qtdDecolagem2 = AviaoGenerator.radomInt();
            int qtdPouso1 = AviaoGenerator.radomInt();
            int qtdPouso2 = AviaoGenerator.radomInt();

            for (int i = 0; i < qtdDecolagem1; i++) {
                totalDecolagens++;
                if (filaDecolagem1.size() <= filaDecolagem2.size()) {
                    filaDecolagem1.inserirFinal(AviaoGenerator.gerarAviaoDecolagem());
                } else {
                    filaDecolagem2.inserirFinal(AviaoGenerator.gerarAviaoDecolagem());
                }
            }
            for (int i = 0; i < qtdPouso1; i++) {
                totalPousos++;
                if (filaPouso1.size() <= filaPouso2.size()) {
                    filaPouso1.inserirFinal(AviaoGenerator.gerarAviaoPouso());
                } else {
                    filaPouso2.inserirFinal(AviaoGenerator.gerarAviaoPouso());
                }
            }
            for (int i = 0; i < qtdDecolagem2; i++) {
                totalDecolagens++;
                if (filaDecolagem2.size() < filaDecolagem1.size()) {
                    filaDecolagem2.inserirFinal(AviaoGenerator.gerarAviaoDecolagem());
                } else {
                    filaDecolagem1.inserirFinal(AviaoGenerator.gerarAviaoDecolagem());
                }
            }
            for (int i = 0; i < qtdPouso2; i++) {
                totalPousos++;
                if (filaPouso2.size() < filaPouso1.size()) {
                    filaPouso2.inserirFinal(AviaoGenerator.gerarAviaoPouso());
                } else {
                    filaPouso1.inserirFinal(AviaoGenerator.gerarAviaoPouso());
                }
            }

            System.out.println("\n\n"+ "Fila de Decolagem1:");
            filaDecolagem1.mostrarLista();
            System.out.println("\n"+ "Fila de Pouso1:");
            filaPouso1.mostrarLista();
            System.out.println("\n"+ "Fila de Decolagem2:");
            filaDecolagem2.mostrarLista();
            System.out.println("\n"+ "Fila de Pouso2:");
            filaPouso2.mostrarLista();

            System.out.println("\n\nTotal de pousos de Emergência: " + totalEmergencias);
            System.out.println("O tempo médio de espera para aterrissagem: " + (totalTempoEsperaPouso / (double)totalPousos));
            System.out.println("O tempo médio de espera para decolagem: " + (totalTempoEsperaDecolagem / (double)totalDecolagens));


            System.out.print("\n-> Deseja continuar? (s/n): ");
            continuar = scanner.nextLine();
        }
        scanner.close();
    }

    public static void ManusearEmergencia(FilaAvioes fila) {

        if (!fila.vazia()) {
            Nodo aux = fila.getInicio();
            while (aux != null) {
                Aviao aviao = aux.getDado();
                if (aviao.estaEmEmergencia()) {
                    System.out.println("Avião em emergência encontrado na fila de pouso: " + aviao.getId());
                    fila.moverValorParaInicio(aviao); 
                    break;
                }
                aux = aux.getProx();
            }
        }
    }
    public static boolean VerificarEmergencia(FilaAvioes fila) {

        if (!fila.vazia()) {
            Nodo aux = fila.getInicio();
            while (aux != null) {
                Aviao aviao = aux.getDado();
                if (aviao.estaEmEmergencia()) {
                    totalEmergencias++;
                    return true;
                }
                aux = aux.getProx();
            }
        }
        return false;
    }
    public static FilaAvioes EscolherPista(FilaAvioes filaPouso, FilaAvioes filaDecolagem) {
        FilaAvioes selecionado;

        if (filaPouso.size() >= filaDecolagem.size() || VerificarEmergencia(filaPouso)) {
            selecionado = filaPouso;
        } else if (filaDecolagem.size() > filaPouso.size() ) {
            selecionado = filaDecolagem;
        } else {
            return null; 
        }

         return selecionado;
    }
    public static void mostrarInformações(FilaAvioes Fila) {

        Fila.mostrarInicio();

        if (Fila.vazia()) {
            // System.out.print(" Nenhuma movimentação registrada");
            return;
        }

        if (Fila.getInicio().getDado().isDecolagem()) {
            System.out.print(" Decolou");
        } else {
            System.out.print(" Pousou");
        }

    }
    

}
