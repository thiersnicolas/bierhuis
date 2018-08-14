package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
	List<Brouwer> findAll();
	Optional<Brouwer> findById(long id);
}
