package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Bier;

public interface BierService {
	long findAantalBieren();
	List<Bier> findByBrouwerIdOrderByNaam(long id);
	Optional<Bier> findById(long id);
}
