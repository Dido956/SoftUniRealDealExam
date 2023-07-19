package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@Getter
@Setter
public class Offer extends BaseEntity{
    @Column
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private boolean hasGoldStatus;
    @Column
    private LocalDateTime addedOn;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Seller seller;
    @ManyToMany
    private Set<Picture> pictures;

}
