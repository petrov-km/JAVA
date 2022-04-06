import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    private CKeyLinkedPurchase id;

    public CKeyLinkedPurchase getId() {
        return id;
    }
    public void setId(CKeyLinkedPurchase id) {
        this.id = id;
    }
}
