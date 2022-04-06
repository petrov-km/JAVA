package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Book book=new Book("Приключения Тома Сойера", "Марк Твен", 54, 324643);
        System.out.println(book.getName()+"\n"+ book.getAuthor()+"\n"+
                book.getPagesCount()+"\n"+book.getIsbn());

        System.out.println("================================");
        Product product=new Product("Молоко",345685343467843l);
        product.setPrice(56);
        System.out.println(product.getName()+"\n"+product.getPrice()+"\n"+product.getBarCode());
    }

}
