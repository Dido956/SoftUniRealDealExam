package softuni.exam.models.dto.JSON;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CarSeedDTO {

    @Expose
    @Size(min = 2, max = 19)
    private String make;
    @Expose
    @Size(min = 2, max = 19)
    private String model;
    @Expose
    @Positive
    private Integer kilometers;
    @Expose
    private String registeredOn;
}
