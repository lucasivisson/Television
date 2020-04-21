
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer escolha = null;
        
        Canal globo = new Canal(10, "Globo", true);
        Canal record = new Canal(8, "Record", true);
        Canal sbt = new Canal(12, "SBT", true);
        Canal redetv = new Canal(2, "Rede Tv", false);
        Canal band = new Canal(27, "Band", false);
        
        ArrayList<Canal> listaDeCanais = new ArrayList<Canal>();
        
        listaDeCanais.add(globo);
        listaDeCanais.add(record);
        listaDeCanais.add(sbt);
        listaDeCanais.add(redetv);
        listaDeCanais.add(band);
        
        Televisao smart = new SmartTV(listaDeCanais, 6.2, "LG340");
        Televisao tvhd = new TVHD(listaDeCanais, "Plasma", "Samsung");
        
        smart.cadastrarCanais();
        tvhd.cadastrarCanais();
        
        ArrayList<Televisao> listaDeTv = new ArrayList<Televisao>();
        listaDeTv.add(smart);
        listaDeTv.add(tvhd);

        ControleRemoto controle = new ControleRemoto(listaDeTv);
        controle.adicionarTv(smart);
        controle.adicionarTv(tvhd);
        
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("Controle Universal");
            System.out.println("Digite um número:");
            System.out.println("");
            
            System.out.println("1: Alterar volume ");
            System.out.println("2: Verificar se canal existe ");
            System.out.println("3: Sintonizar o canal ");
            System.out.println("4: Alterar canal ");
            System.out.println("5: Informar dados do canal atual");
            System.out.println("6: Informar grade de canais ");
            System.out.println("7: Informar tv's disponíveis");
            System.out.println("8: Sair");
            escolha = teclado.nextInt();

            switch(escolha) {
                case 1:              
                    controle.mostrarTvsDisponiveis();
                    System.out.println("Digite a identidade da Tv que vc quer aumentar o volume:");
                    String tvId = teclado.next();
                    System.out.println("Digite 'aumentar' ou 'diminuir' para alterar o volume: ");
                    String alterar = teclado.next();

                    controle.alterarVolume(tvId, alterar);
                    break;
                case 2:
                    controle.mostrarTvsDisponiveis();
                    System.out.println("Digite a identidade da Tv que vc quer buscar algum canal:");
                    String tviden = teclado.next();
                    System.out.println("Digite os dados de um canal para saber se ele está disponível na tv:");
                    System.out.println("Numero do canal: ");
                    int numeroDoCanal = teclado.nextInt();
                    System.out.println("Nome do canal: ");
                    String nomeDoCanal = teclado.next();
                    System.out.println("O canal é HD: ");
                    System.out.println("Digite 'true' para sim e 'false' para não");
                    boolean ehHd = teclado.nextBoolean();
                    
                    controle.verificarCanalExistente(tviden, numeroDoCanal, nomeDoCanal, ehHd);
                    break;
                case 3:
                    controle.mostrarTvsDisponiveis();
                    System.out.println("Digite a identidade da Tv que vc quer buscar algum canal:");
                    String tvidenti = teclado.next();
                    System.out.println("Digite o número do canal que vc quer sintonizar:");
                    int numeroSintonizar = teclado.nextInt();
                    
                    controle.sintonizar(tvidenti, numeroSintonizar);
                    
                    break;
                case 4:
                    controle.mostrarTvsDisponiveis();
                    System.out.println("Digite a identidade da Tv que vc quer buscar algum canal:");
                    String tvIdentidade = teclado.next();
                    System.out.println("Digite 'anterior' ou 'proximo' para mudar de canal");
                    String escolhaCanal = teclado.next();
                    controle.alterarCanal(tvIdentidade, escolhaCanal);
                    
                    break;
                case 5:
                    controle.mostrarTvsDisponiveis();
                    System.out.println("Digite a identidade da Tv que vc quer buscar algum canal:");
                    String tvIdentida = teclado.next();
                    controle.informarDados(tvIdentida);
                    
                    break;
                case 6:
                    controle.mostrarTvsDisponiveis();
                    System.out.println("Digite a identidade da Tv que vc quer ver a grade de canais:");
                    String tvident = teclado.next();
                    controle.mostrarGrade(tvident);
                    
                    break;
                case 7:
                    controle.mostrarTvsDisponiveis();
                    break;
            }

        } while (escolha != 8);
    }  
}
