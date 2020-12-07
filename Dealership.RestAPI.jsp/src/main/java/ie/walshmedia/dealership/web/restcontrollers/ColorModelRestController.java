package ie.walshmedia.dealership.web.restcontrollers;

import ie.walshmedia.dealership.Color;
import ie.walshmedia.dealership.repositories.ColorRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/colors")
public class ColorModelRestController
{
	public ColorModelRestController()
	{
		repository = new ColorRepository();
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Color getColorById(@PathVariable("id") int id)
	{
		return repository.getColorById(id);
	}

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Color> getColors()
	{
		return repository.getColors();
	}

	@GetMapping("/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Color> getColorRange(@PathVariable("from") int from, @PathVariable("to") int to)
	{
		return repository.getColors(from, to);
	}

	private final ColorRepository repository;
}
