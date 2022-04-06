import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String boxes = scanner.nextLine();
    final int CONTAINER_CAPACITY = 27;
    final int TRUCK_CAPACITY = 12;
    int boxesCount = Integer.parseInt(boxes);
    int containersCount = (int) Math.ceil((double) boxesCount / CONTAINER_CAPACITY);
    int trucksCount = (int) Math.ceil((double) containersCount / TRUCK_CAPACITY);
    int boxAmoundInLastConteiner = boxesCount % CONTAINER_CAPACITY;
    int containerAmoundInLastTruck = containersCount % TRUCK_CAPACITY;

    String result = "";
    int containerNumber = 0;
    int boxNumber = 0;

    for (int i = 1; i <= trucksCount; i++) {
      result = result + "\nГрузовик: " + i;
      int containersAmoundInCurrentTruck =
          (i == trucksCount) && !(containerAmoundInLastTruck == 0) ? containerAmoundInLastTruck
              : TRUCK_CAPACITY;
      for (int j = 1; j <= containersAmoundInCurrentTruck; j++) {
        containerNumber++;
        int boxesAmoundInCurrentContainer =
            (j == containersAmoundInCurrentTruck) && (i == trucksCount) && !(
                boxAmoundInLastConteiner == 0) ? boxAmoundInLastConteiner
                : CONTAINER_CAPACITY;
        result += "\n\tКонтейнер: " + containerNumber;
        for (int k = 1; k <= boxesAmoundInCurrentContainer; k++) {
          boxNumber++;
          result += "\n\t\tЯщик: " + boxNumber;
        }
      }
    }
    System.out.println(result);
    System.out.println("Необходимо:" + "\n" +
        "грузовиков - " + trucksCount + " шт.\n" +
        "контейнеров - " + containersCount + " шт.\n");

  }

}
