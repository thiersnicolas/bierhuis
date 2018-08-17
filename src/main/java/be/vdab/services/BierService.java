package be.vdab.services;

import java.util.Optional;
import java.util.Set;

import be.vdab.entities.Bier;

public interface BierService {
	long findAantalBieren();
	Optional<Bier> findById(long id);
	Iterable<Bier> findByIdIn(Set<Long> set);
}
