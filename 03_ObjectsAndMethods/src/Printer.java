public class Printer {
    String queue = "";
    int documentsCount = 0;
    int pagesCount = 0;
    int pagesTotalCount = 0;
    int documentsTotalCount = 0;

    public void append(String text, String name, int pageCount) {
        documentsCount++;
        pagesCount += pageCount;
        queue += "\n"+text + " Имя: " + name + " - " + pageCount + " стр.";
    }
    public void append(String text, String name) { append(text, name, 1); }
    public void append(String text) { append(text, "без имени", 1); }

    public void print() {
        if (queue.isEmpty()) {
            System.out.println("Нет документов в очереди на печать");
        } else {
            System.out.println(queue);
            pagesTotalCount+=pagesCount;
            documentsTotalCount+=documentsCount;
            queue="";
            pagesCount = 0;
            documentsCount = 0;
        }
    }
    public void clear(){
        queue="";
        pagesCount = 0;
        documentsCount = 0;
    }
    public int getPagesCount() { return pagesCount; }
    public int getDocumentsCount() { return documentsCount; }
    public String getTotalPagesAndDocumentCount(){return "Общее количество распечатанныхстраниц - "+ pagesTotalCount+"\n"+
            "Общее количество распечатанных документов - "+documentsTotalCount;}
}