package softuni.exam.models.dto.XML;

import lombok.Getter;
import lombok.Setter;
import softuni.exam.models.entity.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class SellerSeedDto {
    @XmlElement(name = "first-name")
    @Size(min = 2, max = 19)
    private String firstName;
    @XmlElement(name = "last-name")
    @Size(min = 2, max = 19)
    private String lastName;
    @XmlElement
    @Email
    private String email;
    @XmlElement
    @NotNull
    private Rating rating;
    @XmlElement
    @NotBlank
    private String town;
}
