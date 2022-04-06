public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextIntoWords("As it’s known people like their youth time.\n"
        + "In general living is better now. We live when there aren’t as many wars in the world as before. And\n"
        + "people live longer; the level of lifespan is higher than it was 40 years ago. People work less and they\n"
        + "can afford to go to the vacation and buy more things."));
  }

  public static String splitTextIntoWords(String text) {
    String[] words = text.split("[\\W+&&[^’]]|\\d+");
    StringBuilder result = new StringBuilder();
    for (String word : words) {
      if (!word.isEmpty()) {
        result.append(word + "\n");
      } else { continue; }
    }
    return (result.toString()).trim();
  }

}