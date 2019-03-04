package ee.taltech.prindify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public
@Data
@NoArgsConstructor
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Type type;
    private String name;
    private String description;
    private String imageUrl;
    private float price;
}
