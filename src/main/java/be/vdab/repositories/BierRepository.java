package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Bier;

public interface BierRepository extends JpaRepository<Bier, Long> {
	List<Bier> findByBrouwerIdOrderByNaam(long id);
}
