public class Main {

    public static void main(String[] args) {
        String text = "wwwwww<ww6ww>w3w!w5w<www>www<kkkk>w";
        System.out.println(searchAndReplaceDiamonds(text," * "));
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        //return text.replaceAll("<[^<>]+>",placeholder);     - еще вариант
       return text.replaceAll("<.+?>",placeholder);
    }

}