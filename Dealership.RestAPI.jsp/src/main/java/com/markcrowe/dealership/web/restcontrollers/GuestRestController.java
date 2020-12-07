package com.markcrowe.dealership.web.restcontrollers;

import com.markcrowe.dealership.Guest;
import com.markcrowe.dealership.repositories.GuestRepository;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/guests")
public class GuestRestController
{
	public GuestRestController()
	{
		repository = new GuestRepository();
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Guest getGuestById(@PathVariable("id") int id)
	{
		return repository.getGuestById(id);
	}

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Guest> getGuests()
	{
		return repository.getGuests();
	}

	@GetMapping("/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public List<Guest> getGuestRange(@PathVariable("from") int from, @PathVariable("to") int to)
	{
		return repository.getGuests(from, to);
	}

	private final GuestRepository repository;
}
