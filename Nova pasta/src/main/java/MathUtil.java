public class MathUtil {

    public static long fatorial(double n){
        long resultado = 1;

        for(int fator = 2; fator <= n; fator++){
            resultado *= fator;
        }

        return resultado;
    }

    public static double somatorioErlangB(double A, double N){
        double resultado = 0;
        int i = 0;
        while(i<=N){
            resultado += Math.pow(A,i)/fatorial(i);
            i++;
        }

        return resultado;
    }

    public static double somatorioErlangC(double A, double N){
        double resultado = 0;
        int i = 0;
        while(i<N){
            resultado += Math.pow(A,i)/fatorial(i);
            i++;
        }
        return resultado;
    }
}
