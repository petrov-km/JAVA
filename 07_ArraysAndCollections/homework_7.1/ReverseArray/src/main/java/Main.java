public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] test = {"1","2","3","4","5","6","7"};
        ReverseArray.reverse(test);
        for (String s:test) {
            System.out.println(s);
        }
    }
}
