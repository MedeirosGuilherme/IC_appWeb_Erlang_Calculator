import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        loop: while(true) {
            System.out.println("Escolha o que deseja calcular:");
            System.out.println("1. Erlang B");
            System.out.println("2. Erlang C");
            System.out.println("3. Sair" + "\n");
            System.out.println("Ao escolher, digite os dados pedidos, digite '-1' para o dado que deseja ter como resultado");


            Scanner input = new Scanner(System.in);
            Scanner inTrafic = new Scanner(System.in);
            Scanner inChannel = new Scanner(System.in);
            Scanner inProb = new Scanner(System.in);
            double trafic;
            double channel;
            double prob;

            try {
                int inputInt = input.nextInt();

                switch (inputInt){
                    case 1:
                        System.out.println("Escolheu Erlang B");//chamar classe erlang B
                        System.out.println("Digite o  tráfego médio: ");
                        trafic = inTrafic.nextDouble();

                        System.out.println("Digite o número de canais: ");
                        channel = inChannel.nextDouble();

                        System.out.println("Digite a probabilidade de bloqueio: ");
                        prob = inProb.nextDouble();


                        if(!validaDados(trafic,channel,prob)){
                            System.out.println("Dados digitados de forma incorreta");
                            break;
                        }

                        System.out.println("Dados digitados corretamente, calculando...");
                        ErlangB calcB = new ErlangB(trafic,channel,prob);

                        break;

                    case 2:
                        System.out.println("Escolheu Erlang C");//Chamar classe erlang C

                        System.out.println("Digite o  tráfego médio: ");
                        trafic = inTrafic.nextDouble();

                        System.out.println("Digite o número de canais: ");
                        channel = inChannel.nextDouble();

                        System.out.println("Digite a probabilidade de bloqueio: ");
                        prob = inProb.nextDouble();

                        if(!validaDados(trafic,channel,prob)){
                            System.out.println("Dados digitados de forma incorreta");
                            break;
                        }

                        System.out.println("Dados digitados corretamente, calculando...");

                        ErlangC calcC = new ErlangC(trafic,channel,prob);

                        break;

                    case 3:

                        break loop;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida, digite novamente.");
            }
        }
    }

    public static boolean validaDados(double traf, double chan, double prob){

        if(traf < 0 && chan < 0){
            return false;
        }

        else if(traf < 0 && prob < 0){
            return false;
        }

        else if(prob < 0 && chan < 0){
            return false;
        }

        else if(prob > 0 && chan > 0 && traf > 0){
            return false;
        }

        else{
            return true;
        }
    }
}
