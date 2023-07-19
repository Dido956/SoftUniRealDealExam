package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car extends BaseEntity{
    @Column(length = 20)
    private String make;
    @Column(length = 20)
    private String model;
    @Column
    private Integer kilometers;
    @Column(name = "registered_on")
    private LocalDate registeredOn;
    @OneToMany(mappedBy = "car",fetch = FetchType.EAGER)
    private Set<Picture> pictures;
}
