package be.vdab.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Bier;

public interface BierRepository extends JpaRepository<Bier, Long> {
	@EntityGraph("Bier.metBrouwerEnSoort")
	Iterable<Bier> findByIdIn(Set<Long> ids);
}
