package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.entity.Car;

import javax.persistence.criteria.Order;
import java.util.List;

public interface  CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c FROM Car c ORDER BY size(c.pictures) DESC, c.make")
    List<Car> findCarByOrderByPicturesCountThenByMake();
}
