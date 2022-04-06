public class Main {

    public static void main(String[] args) {

      System.out.println(searchAndReplaceDiamonds("Номер<< кредитной <<к <ар>ты 89<1>2", "***"));
    }
    /*public static String searchAndReplaceDiamonds(String text, String placeholder) {
        while ( !(text.indexOf('<')==-1) && !(text.lastIndexOf('>')==-1) && (text.lastIndexOf('>')>text.indexOf('<'))) {
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == '<') {
                    String currentString = text.substring(i);
                    index2 = i + currentString.indexOf('>');
                    currentString = currentString.substring(0,currentString.indexOf('>'));
                    index1 = i + currentString.lastIndexOf('<');
                    break;
                }
            }
            text = String.join(placeholder, text.substring(0, index1), text.substring(index2 + 1));
        }
        return text;
    }*/
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        while ( !(text.indexOf('<')==-1) && !(text.lastIndexOf('>')==-1) && (text.lastIndexOf('>')>text.indexOf('<'))) {
            int index1 = text.indexOf('<');
            int index2 = text.indexOf('>');
            text = String.join(placeholder, text.substring(0, index1), text.substring(index2 + 1));
        }
        return text;
    }

}