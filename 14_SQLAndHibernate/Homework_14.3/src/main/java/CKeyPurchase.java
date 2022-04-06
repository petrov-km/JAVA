import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class CKeyPurchase implements Serializable {
    @Getter
    @Setter
    @Column(name = "student_name")
    private String studentName;

    @Getter
    @Setter
    @Column(name = "course_name")
    private String courseName;

    @Getter
    @Setter
    private  int price;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public CKeyPurchase(String studentName, String courseName, int price, Date subscriptionDate) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }
    public CKeyPurchase() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CKeyPurchase that = (CKeyPurchase) o;
        return price == that.price && Objects.equals(studentName, that.studentName) && Objects.equals(courseName, that.courseName) && Objects.equals(subscriptionDate, that.subscriptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName, price, subscriptionDate);
    }
}
