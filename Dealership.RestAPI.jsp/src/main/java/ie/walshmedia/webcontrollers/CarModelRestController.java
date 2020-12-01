package ie.walshmedia.webcontrollers;

import ie.walshmedia.dealership.CarModel;
import ie.walshmedia.dealership.repositories.CarModelRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carmodels")
public class CarModelRestController
{
    public CarModelRestController()
    {
	repository = new CarModelRepository();
    }

    @GetMapping("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public CarModel getCarModelById(@PathVariable("id") int id)
    {
	return repository.getCarModelById(id);
    }

    @GetMapping
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<CarModel> getCarModels()
    {
	return repository.getCarModels();
    }
    
    @GetMapping("/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<CarModel> getCarModelRange(@PathVariable("from") int from, @PathVariable("to") int to)
    {
	int[] range = new int[]{from, to};
	return repository.getCarModelRange(range);
    }

    private final CarModelRepository repository;
}
