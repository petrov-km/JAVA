public class Arithmetic {
    private int n1 = 0;
    private int n2 = 0;

    public Arithmetic(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int summ() { return n1 + n2; }
    public int diff() { return n1-n2; }
    public int mult() { return n1*n2; }
    public double div() { return (double) n1/n2; }
    public double mean() { return  ((double)(n1+n2)/2);}
    public int min() { return Math.min(n1,n2); }
    public int max() { return Math.max(n1,n2); }

}
