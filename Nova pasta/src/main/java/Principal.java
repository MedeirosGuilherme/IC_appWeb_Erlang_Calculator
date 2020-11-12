import java.util.Scanner;

import static java.sql.Types.NULL;

public class Principal {



    public static void main(String[] args) {

        double Au = -1;      // Tráfego por usuário
        double A = -1;       // Tráfego médio
        double Ac = -1;      // Tráfego médio por canal
        int lambda = -1;    // Número médio de chamadas
        double H = -1;       // Duração média de chamadas
        int C = -1;         // Número de canais disponíveis
        int U = -1;         // Número de usuários
        double prB = -1;     // Probabilidade de bloqueio Erlang B
        double prC = -1;     // Probabilidade de atraso > 0 Erlang C
        double prCT = -1;    // Probabilidade atraso > t Erlang C
        double D = -1;       // Atraso médio

        System.out.println("Bem vindo à calculadora Erlang");
        Scanner input = new Scanner(System.in);
        int in = 0;
        double inD = 0;
        long inL = 0;

        while(true){
            System.out.println("O que deseja fazer? \n");
            System.out.println("1. Entrar com variáveis");
            System.out.println("2. Calcular: \n");
            System.out.println("Valor atual das variáveis: ");
            System.out.println("Tráfego médio por usuário (Au): " + Au);
            System.out.println("Tráfego médio: (A)" + A);
            System.out.println("Tráfego médio por canal: (Ac)" + Ac);
            System.out.println("Número médio de chamadas: (lambda)" + lambda);
            System.out.println("Duração média da chamada: (H)" + H);
            System.out.println("Número de canais: (C): " + C);
            System.out.println("Número de usuários: (U): " + U);
            System.out.println("Atraso médio: (D): " + D);
            System.out.println("Probabilidade de Bloqueio (Erlang B): " + prB);
            System.out.println("Probabilidade de atraso > 0 (Erlang C): " + prC);
            System.out.println("Probabilidade de atraso > t (Erlang C): " + prCT);

            in = input.nextInt();

            if(in == 1){
                System.out.println("Qual variável que quer preencher?");
                System.out.println("1. Tráfego médio por usuário: ");
                System.out.println("2. Tráfego médio: ");
                System.out.println("3. Tráfego médio por canal: ");
                System.out.println("4. Número médio de chamadas: ");
                System.out.println("5. Duração média da chamada: ");
                System.out.println("6. Número de canais: ");
                System.out.println("7. Número de usuários: ");
                System.out.println("8. Atraso médio: ");
                System.out.println("9. Probabilidade de bloqueio");
                System.out.println("10. Probabilidade de atraso > 0");
                System.out.println("11. Probabilidade de atraso > t");

                in = input.nextInt();

                if (in == 1){
                    System.out.println("Digite o tráfego médio por usuário: ");
                    Au = input.nextDouble();
                }

                else if(in == 2){
                    System.out.println("Digite o tráfego médio: ");
                    A = input.nextDouble();
                }

                else if(in == 3){
                    System.out.println("Digite o tráfego médio por canal: ");
                    Ac = input.nextDouble();
                }

                else if(in == 4){
                    System.out.println("Digite o número médio de chamadas: ");
                    lambda = input.nextInt();
                }

                else if(in == 5){
                    System.out.println("Digite a duração média de chamada: ");
                    H = input.nextDouble();
                }

                else if(in == 6){
                    System.out.println("Digite o número de canais: ");
                    C = input.nextInt();
                }

                else if(in == 7){
                    System.out.println("Digite o número de usuários: ");
                    U = input.nextInt();
                }

                else if(in == 8){
                    System.out.println("Digite o atraso médio: ");
                    D = input.nextDouble();
                }

                else if(in == 9){
                    System.out.println("Digite o valor da probabilidade de bloqueio (Erlang B): ");
                    prB = input.nextDouble();
                }

                else if(in == 10){
                    System.out.println("Digite o valor da probabilidade de atraso > 0 (Erlang C): ");
                    prC = input.nextDouble();
                }

                else if(in == 11){
                    System.out.println("Digite o valor da probabilidade de atraso > t (Erlang C): ");
                    prCT = input.nextDouble();
                }

                else{
                    System.out.println("Entrada inválida, entre com uma das opções deferidas!");
                }

            }

            else if(in == 2){
                System.out.println("Digite o que deseja calcular, considerando que é necessário ter as variáveis preenchidas previamente:");
                System.out.println("1. Tráfego médio por usuário: ");
                System.out.println("    Au = lambda*H \n");

                System.out.println("2. Tráfego médio: ");
                System.out.println("    A = U*Au \n");

                System.out.println("3. Tráfego médio por canal: ");
                System.out.println("    Ac = (U*Au)/C + \n");

                System.out.println("4. Número médio de chamadas: ");
                System.out.println("    lambda = Au/H + \n");

                System.out.println("5. Duração média da chamada: ");
                System.out.println("    H = Au/lambda + \n");

                System.out.println("6. Número de canais: ");
                System.out.println("    C = (U*Au)/Ac + \n");

                System.out.println("7. Número de usuários: ");
                System.out.println("    U = A/Au + \n");

                System.out.println("8. Atraso médio: ");
                System.out.println("    D = P[atraso>0]*H/(C-A)");

                System.out.println("9. Probabilidade de bloqueio (Erlang B): ");
                System.out.println("    PrB = ((A^C)/C!)/(sum((A^k)/K!)");

                System.out.println("10. Probabilidade de atraso > 0 (Erlang C): ");
                System.out.println("    PrA>0 = (A^C)/(A^C + C!*(1-(A/C))*sum((A^K)/K!) ou D*((C-A)/H)");

                System.out.println("11. Probabilidade de atraso > t (Erlang C: ");
                System.out.println("    PrA>t = PrA*exp((-(C-A)*t)/H)");

                in = input.nextInt();

                if(in == 1){
                    if((lambda <= 0) || (H <= 0)){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        Au = lambda*H;
                        System.out.println("Resultado: Au = " + Au);
                    }
                }

                if(in == 2){
                    if(U <= 0 || Au <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        A = U*Au;
                        System.out.println("Resultado: A = " + A);
                    }
                }

                if(in == 3){
                    if(U <= 0 || Au <= 0 || C <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        Ac = (U*Au)/C;
                        System.out.println("Resultado: Ac = " + Ac);
                    }
                }

                if(in == 4){
                    if(Au <= 0 || H <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        lambda = (new Double(Au/H).intValue());
                        System.out.println("Resultado: lambda = " + lambda);
                    }
                }

                if(in == 5){
                    if(Au <= 0 || lambda <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        H = Au/lambda;
                        System.out.println("Resultado: H = " + H);
                    }
                }

                if(in == 6){
                    if(U <= 0 || Au <= 0 || Ac <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        C = (new Double((U*Au)/Ac).intValue());
                        System.out.println("Resultado: C = " + C);
                    }
                }

                if(in == 7){
                    if(A <= 0 || Au <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");                    }
                    else{
                        U = (new Double(A/Au).intValue());
                        System.out.println("Resultado: U = " + U);
                    }
                }

                if(in == 8) {
                    if (prC <= 0 || H <= 0 || C <= 0 || A <= 0) {
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        D = prC*(H/(C-A));
                        System.out.println("Resultado: D = " + D);
                    }
                }

                if(in == 9){
                    if(A <= 0 || C <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        prB = ((Math.pow(A,C))/MathUtil.fatorial(C))/(MathUtil.somatorioErlangB(A, C));
                        System.out.println("Resultado: Prb = " + prB);
                    }
                }

                if(in == 10){
                    if(A <= 0 || C <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        prC = Math.pow(A,C)/(Math.pow(A,C)+MathUtil.fatorial(C)*(1-(A/C))*MathUtil.somatorioErlangC(A,C));
                        System.out.println("Resultado: Pr[atraso>0] = " + prC);
                    }
                }

                if(in == 11){
                    if(prC <= 0 || C <= 0 || A <= 0 || H <= 0){
                        System.out.println("Variáveis insuficientes para completar operação, reveja as variáveis e as preencha previamente");
                    }
                    else{
                        System.out.println("Digite o tempo t para calcular a probabilidade de atraso: ");
                        double t = input.nextDouble();

                        prCT = prC*Math.exp(-1*((C-A)*t)/H);
                        System.out.println("Resultado: Pr[atraso > " + t + " ] = " + prCT);
                    }
                }
            }

            else{
                System.out.println("Entrada inválida, digite um dos números das opções descritas.");
            }
        }
    }
}
