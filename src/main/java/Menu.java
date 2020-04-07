import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Menu")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value = "Regular")
public class Menu {
    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public Integer price;

    @Column(nullable = false)
    public Integer height;

    public Menu() {}


    public Menu(String name, Integer price, Integer height) {
        this.name = name;
        this.price = price;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", height=" + height +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
