public class ErlangC {

    private double trafego;
    private double nCanais;
    private double probEspera;

    public ErlangC(double trafego, double nCanais, double probEspera) {
        this.trafego = trafego;
        this.nCanais = nCanais;
        this.probEspera  = probEspera;

        if(this.trafego < 0){
            calcTraf();
        }

        else if(this.nCanais < 0){
            calcCanais();
        }

        else if(this.probEspera < 0){
            calcProbEspera();
        }
    }

    private double calcTraf(){

        System.out.println("Calculou tráfego");
        return this.trafego;
    }

    private double calcCanais(){

        System.out.println("Calculou Canais");
        return this.nCanais;
    }

    private double calcProbEspera(){

        this.probEspera = ((Math.pow(trafego, nCanais)/MathUtil.fatorial(nCanais))*(nCanais/nCanais-trafego))/(MathUtil.somatorioErlangC(trafego,nCanais) + (Math.pow(trafego, nCanais)/MathUtil.fatorial(nCanais))*(nCanais/nCanais-trafego));

        System.out.println("Calculou probabilidade de espera: ");
        System.out.println("ProbW = " + this.probEspera);

        return this.probEspera;
    }
}
