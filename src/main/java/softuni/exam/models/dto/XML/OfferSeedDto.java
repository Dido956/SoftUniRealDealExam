package softuni.exam.models.dto.XML;

import lombok.Getter;
import lombok.Setter;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Seller;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class OfferSeedDto {
    @XmlElement
    @Size(min = 5)
    private String description;
    @XmlElement
    @Positive
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;
    @XmlElement
    private CarIdDto car;
    @XmlElement
    private SellerIdDto seller;
}
