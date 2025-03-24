package InheritanceMapping.InheritanceMapping.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) -> used for table per class strategy
//@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING) -> it is used only for Single_Table strategy in inheritance mapping
public abstract class Payment {

    @Id
    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
