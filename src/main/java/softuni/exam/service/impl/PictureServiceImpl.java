package softuni.exam.service.impl;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.JSON.PictureSeedDTO;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";

    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.
                readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readPicturesFromFile(), PictureSeedDTO[].class))
                .filter(pictureSeedDTO -> {
                    boolean isValid = validationUtil.isValid(pictureSeedDTO);

                    sb
                            .append(isValid
                                    ? String.format("Successfully import picture %s",
                                    pictureSeedDTO.getName())
                                    : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(pictureSeedDTO -> {
                    Picture picture = modelMapper.map(pictureSeedDTO, Picture.class);
                    picture.setCar(carService.findById(pictureSeedDTO.getCar()));

                    return picture;
                })
                .forEach(pictureRepository::save);

        return sb.toString();
    }
}
