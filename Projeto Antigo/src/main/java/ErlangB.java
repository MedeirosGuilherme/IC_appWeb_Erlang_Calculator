

public class ErlangB {

    private double trafego;
    private double nCanais;
    private double probBlock;

    public ErlangB(double trafego, double nCanais, double probBlock) {

        this.trafego = trafego;
        this.nCanais = nCanais;
        this.probBlock = probBlock;

        MathUtil math = new MathUtil();

        if(this.trafego < 0){
            calcTraf();
        }

        else if(this.nCanais < 0){
            calcCanais();
        }

        else if(this.probBlock < 0){
            calcProbBlock();
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

    private double calcProbBlock(){

        this.probBlock = (Math.pow(trafego,nCanais)/MathUtil.fatorial(nCanais))/(MathUtil.somatorioErlangB(trafego,nCanais));

        System.out.println("Calculou probabilidade de bloqueio: ");
        System.out.println("ProbB = " +  this.probBlock);
        return this.probBlock;
    }
}
