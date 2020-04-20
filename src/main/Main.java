
package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer escolha = null;
        
        ArrayList<Canal> lista = new ArrayList<Canal>();

        SmartTV t = new SmartTV(lista, 5.5, LG340);

        Scanner teclado = new Scanner(System.in);

        do {

            System.out.println("1: Alterar Volume ");
            System.out.println("2: Verificar se Canal Existe ");
            System.out.println("3: Sintonize o canal ");
            System.out.println("4: Alterar Canal ");
            System.out.println("5: Informar Dados ");
            System.out.println("6: Informar Grade de Canais ");
            escolha = teclado.nextInt();


            switch(escolha) {
                case 1:
                    System.out.println("Digite 'aumentar' ou 'diminuir' para alterar o volume: ");
                    String alterar = teclado.next();

                    t.alterarVolume(alterar);
                    break;
                case 2:
                    System.out.println("Digite o Número do Canal: ");
                    Integer num = teclado.nextInt();
                    System.out.println("Digite o Nome do Canal: ");
                    String nome = teclado.next();
                    System.out.println("Digite se o Canal é HD: ");
                    Boolean hd = teclado.nextBoolean();

                    Canal c = new Canal(num, nome, hd);

                    if(t.verificarCanalExistente(c)) {
                        System.out.println("O Canal Existe!");
                    } else {
                        System.out.println("O Canal não Existe!");
                    }
                    break;
                case 3:
                    System.out.println("Digite o Número do Canal: ");
                    Integer num1 = teclado.nextInt();

                    t.sintonizar(num1);
                    break;
                case 4:
                    System.out.println("Digite 'próximo' ou 'anterior' para mudar de canal: ");
                    String mudar = teclado.next();

                    t.alterarCanal(mudar);
                    break;
                case 5:
                    t.informarDados();
                    break;
                case 6:
                    t.mostrarGrade();
                    break;
            }

        } while (escolha != 10);
    }  
}
