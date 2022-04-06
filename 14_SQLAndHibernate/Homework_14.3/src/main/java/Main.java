import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        /*Purchase purchase = session.get(Purchase.class, 1);
        System.out.println( purchase.getCourseName());*/

        Teacher teacher = session.get(Teacher.class, 1);
        List<Course> courseList = teacher.getCourses();
        for (Course course: courseList) {
            System.out.println(course.getName());
        }
        System.out.println("=================================================");
        Student student = session.get(Student.class,3);
        System.out.println("колво курсов " + student.getCourseList().size());
        List<Subscription> subscriptionsList = student.getSubscriptions();
        System.out.println("Подписки студента: ");
        for (Subscription subscription: subscriptionsList) {
            System.out.println(subscription.getSubscriptionDate());
        }
        System.out.println("учителя:");
        for (Teacher teacher1: student.getTeachers()) {
            System.out.println(teacher1.getName());
        }
        System.out.println("======================================================");



        Course course = session.get(Course.class, 1);
        Course course1 = session.get(Course.class, 4);
        System.out.println(course.getStudents().size());
        System.out.println(course.getName()+"; количество студентов  " + course.getStudentsCount());
        System.out.println(course1.getId()+ " + " + course1.getPrice());
        List<Subscription> subscriptions = course.getSubscriptions();
        System.out.println("подписки курса: ");
        for (Subscription subscription: subscriptions) {
            System.out.println(subscription.getSubscriptionDate());
        }
        System.out.println("----------------");

        System.out.println("===============================================================");
        Subscription subscription = session.get(Subscription.class, new CKeySubscription(1,2));
        System.out.println(subscription.getStudent().getId() + "  " + subscription.getStudent().getName() +
                "____" + subscription.getSubscriptionDate()+"    " + subscription.getCourse().getName());

        System.out.println("===============================================================");

        Purchase purchase = session.get(Purchase.class, new CKeyPurchase(subscription.getStudent().getName(),
                subscription.getCourse().getName(), 138000, subscription.getSubscriptionDate()));
        System.out.println(purchase.getCourseName());
        System.out.println("===============================================================");
        System.out.println("имя учителя: "+ teacher.getName());
        for (Student student1: teacher.getStudents() ) {
            System.out.println(student1.getName());
        }
        System.out.println("подписки учителя:");
        for (Subscription subscription1: teacher.getSubscriptions()) {
            System.out.println(subscription.getSubscriptionDate());
        }

        List<CKeyLinkedPurchase> cKeyLinkedPurchaseList = new ArrayList<>();
        //String hql = "From " + Purchase.class.getSimpleName();
        List<Purchase> purchaseList = session.createQuery("From Purchase").getResultList();
        for (Purchase purchase1 : purchaseList ) {
           /* String hql2 = "SELECT new CKeyLinkedPurchase(s.id, c.id) " +
                    "from Student s, Course c " +
                    "where s.name = "+ "'" + purchase1.getStudentName() + "'" +
                    " and c.name = " + "'" + purchase1.getCourseName() +"'";*/
            String hql = "SELECT new CKeyLinkedPurchase(sub.student.id, sub.course.id) " +
                    "from Subscription sub " +
                   // "where sub.subscriptionDate = " + "'" + purchase1.getSubscriptionDate() + "'" +
                    " where sub.student.name = "+ "'" + purchase1.getStudentName() + "'" +
                    " and sub.course.price = " + "'" + purchase1.getPrice() + "'" +
                    " and sub.course.name = " + "'" + purchase1.getCourseName() + "'";
            cKeyLinkedPurchaseList.add((CKeyLinkedPurchase) session.createQuery(hql).getResultList().get(0));
        }
        Session session1 = sessionFactory.getCurrentSession();
        Transaction transaction1 = session1.beginTransaction();
        sessionFactory.getCurrentSession().createQuery("delete from LinkedPurchaseList").executeUpdate();
        transaction1.commit();

        Transaction transaction = session.beginTransaction();
        for (CKeyLinkedPurchase cKeyLinkedPurchase: cKeyLinkedPurchaseList ) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(cKeyLinkedPurchase);
            session.save(linkedPurchaseList);
        }
        transaction.commit();
        sessionFactory.close();
    }
}
