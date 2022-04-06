public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket(500);
        basket1.add("Milk", 400, 2, 3.0);
        basket1.add("Хлеб", 30, 0.2);
        basket1.add("Жвачка", 25);
        basket1.add("Хлеб", 23, 5.0);

        Basket basket2 = new Basket("Канцтовары", 3000);
        Basket basket3 = new Basket();
        basket3.add("Хлеб", 20, 0.2);
        basket3.add("Жвачка", 25);
        basket3.clear();
        basket3.add("Хлеб", 20, 0.2);
        basket3.add("Жвачка", 25);

        basket1.print("Корзина №1");
        System.out.println("Общий вес корзины- " + basket1.getTotalWeight() + "кг");
        System.out.println("Стоимость корзины - "+basket1.getTotalPrice());
        basket2.print("Корзина №2");
        System.out.println("Общий вес корзины- " + basket2.getTotalWeight() + "кг");
        System.out.println("Стоимость корзины - "+basket2.getTotalPrice());
        basket1.print("Корзина №3");
        System.out.println("Общий вес корзины- " + basket3.getTotalWeight() + "кг");
        System.out.println("Стоимость корзины - "+basket3.getTotalPrice());
        System.out.println("==============================");
        System.out.println("Количество корзин - "+ Basket.getBasketsCount()+"\n"
                +"Количество товаров во всех корзинах - "+ Basket.getTotalProductCound() + "\n"+
                "Общая стоимость товаров во всех корзинах - " + Basket.getAllBasketsPrice());
        System.out.println("Средняя цена товара - "+calculateAveragePrice());
        System.out.println("Средняя стоимость корзины - "+calculateAveragePriceOfBasket());
    }
        public static double calculateAveragePrice(){
            return (double) Basket.getAllBasketsPrice()/Basket.getTotalProductCound();
        }
        public static double calculateAveragePriceOfBasket(){
        return (double) Basket.getAllBasketsPrice()/Basket.getBasketsCount();
        }



        /*System.out.println("=========================================================");
        System.out.println("Задание №2");
        System.out.println("Введите 2 числа:");
        Scanner scanner=new Scanner(System.in);
        int n1= scanner.nextInt();
        int n2= scanner.nextInt();
        System.out.println("Арифметические операции:");
        Arithmetic operation = new Arithmetic(n1, n2);
        System.out.println("Сумма чисел = "+operation.summ());
        System.out.println("Разность чисел = "+operation.diff());
        System.out.println("Произведение чисел = "+ operation.mult());
        System.out.println("Среднее значение чисел = "+ operation.mean());
        System.out.println("Результат деления= "+(double)(operation.div()));
        System.out.println("Меньшее число: "+operation.min());
        System.out.println("Большее число: "+operation.max());

        System.out.println("=======================================================================");
        System.out.println("Задание №3");

        Printer printer = new Printer();
        printer.append("\"текст сказки1\"", "Сказка1", 10);
        printer.append("\"текст сказки2\"", "Сказка2", 5);
        printer.append("\"текст сказки3\"" );

        System.out.println("Количество страниц в очереди печати: "+printer.getPagesCount());
        System.out.println("Количество документов в очереди печати: "+printer.getDocumentsCount());

        printer.print();
        printer.append("\"текст сказки4\"", "Сказка4");

        printer.clear();
        printer.append("\"текст сказки5\"", "Сказка5", 2);
        printer.append("\"текст сказки6\"");
        System.out.println();
        System.out.println("Количество страниц в очереди печати: "+printer.getPagesCount());
        System.out.println("Количество документов в очереди печати: "+printer.getDocumentsCount());
        System.out.println("-----------------------------------------------------------");
        System.out.println(printer.getTotalPagesAndDocumentCount());
    }*/
}
