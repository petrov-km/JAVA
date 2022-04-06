import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PurchaseList")
public class Purchase {

    @EmbeddedId
    private CKeyPurchase id;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Column(name = "price", insertable = false, updatable = false)
    private int price;

    @Column(name = "subscription_date", insertable = false, updatable = false)
    private Date subscriptionDate;

    public CKeyPurchase getId() { return id; }

    public void setId(CKeyPurchase id) { this.id = id; }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
