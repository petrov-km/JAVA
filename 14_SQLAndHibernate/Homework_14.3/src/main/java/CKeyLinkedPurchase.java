import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CKeyLinkedPurchase implements Serializable {
    @Column (name = "student_id")
    @Getter
    @Setter
    private int studentId;

    @Getter
    @Setter
    @Column (name = "course_id")
    private int courseId;

    public CKeyLinkedPurchase(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
    public CKeyLinkedPurchase() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CKeyLinkedPurchase cKey = (CKeyLinkedPurchase) o;
        return studentId == cKey.studentId && courseId == cKey.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

}
