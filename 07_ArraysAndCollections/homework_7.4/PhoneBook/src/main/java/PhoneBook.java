import java.util.*;

public class PhoneBook {

  private HashMap<String, String> phone2name = new HashMap<>();

  public void addContact(String phone, String name) {
    phone = checkOnCorrectPhoneNumber(phone);
    if (!phone.isEmpty() && name.matches("\\s*\\D+\\s*")) {
      phone2name.put(phone, name);
      System.out.println("Контакт сохранен!");
    } else {
      System.out.println("Неверный формат ввода");
    }
    // проверьте корректность формата имени и телефона
    // если такой номер уже есть в списке, то перезаписать имя абонента
  }

  public String checkOnCorrectPhoneNumber(String number) {
    if (number.matches("89\\d{9}")) {
      number = number.replaceFirst("8", "7");
      return number;
    }
    if (number.matches("79\\d{9}")) {
      return number;
    }
    if (number.matches("9\\d{9}")) {
      number = "7" + number;
      return number;
    }
    return "";
  }

  public boolean containName(String name) {
    return phone2name.containsValue(name);
  }

  public boolean containPhone(String phone) {
    return phone2name.containsKey(phone);
  }


  public String getNameByPhone(String phone) {
    return phone2name.get(phone) + " - " + phone;
    // формат одного контакта "Имя - Телефон"
    // если контакт не найдены - вернуть пустую строку
  }

  public Set<String> getPhonesByName(String name) {
    // формат одного контакта "Имя - Телефон"
    // если контакт не найден - вернуть пустой TreeSet
    Set<String> keys = new HashSet<>();
    String s = name + " - ";
    for (Map.Entry<String, String> entry : phone2name.entrySet()) {
      if (Objects.equals(name, entry.getValue())) {
        s = s + entry.getKey() + ", ";
      }
    }
    if (!(s.lastIndexOf(", ") == -1)) {
      s = s.substring(0, s.lastIndexOf(", "));
    }
    keys.add(s);
    return keys;
  }

  public Set<String> getAllContacts() {
    TreeSet<String> allNames = new TreeSet<>(getAllNames());
    TreeSet<String> contacts = new TreeSet<>();
    for (String name : allNames) {
      String phonesOfName = getPhonesByName(name).toString()
          .replace("[", "")
          .replace("]", "");
      contacts.add(phonesOfName);
    }
    // формат одного контакта "Имя - Телефон"
    // если контактов нет в телефонной книге - вернуть пустой TreeSet
    return contacts;
  }

  public Set<String> getAllNames() {
    TreeSet<String> names = new TreeSet<>();
    for (String key : phone2name.keySet()) {
      names.add(phone2name.get(key));
    }
    return names;
  }

}