public class Hospital {

  public static float[] generatePatientsTemperatures(int patientsCount) {
    float[] temperatures = new float[patientsCount];
    for (int i = 0; i < temperatures.length; i++) {
      temperatures[i] = 32 + (float) Math.round(Math.random() * 80) / 10;
    }
    return temperatures;
  }

  public static String getReport(float[] temperatureData) {
    StringBuilder report = new StringBuilder("Температуры пациентов: ");
    double average = 0;
    int healthyCount = 0;
    for (int i = 0; i < temperatureData.length; i++) {
      report.append(temperatureData[i]).append(" ");
      average += temperatureData[i];
      if (temperatureData[i]>=36.2f&&temperatureData[i]<=36.9f) {
        healthyCount++;
      }
    }
    report.deleteCharAt(report.length()-1);
    average = average
        / (double) temperatureData.length;
    report.append("\nСредняя температура: ").append((double) Math.round(average * 100) / 100);
    report.append("\nКоличество здоровых: ").append(healthyCount);
    return report.toString();
  }
}
