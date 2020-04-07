import javax.persistence.*;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Sale")
public class SaleMenu extends Menu {

    private Integer sale;

    public SaleMenu(){}

    public SaleMenu(String name, Integer price, Integer height, Integer sale){
        super(name,price,height);
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "SaleMenu{" +
                "sale=" + sale +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", height=" + height +
                '}';
    }

    public void name(){

    }

    public Integer getSale() { return sale; }

    public void setSale(Integer sale) { this.sale = sale; }
}
