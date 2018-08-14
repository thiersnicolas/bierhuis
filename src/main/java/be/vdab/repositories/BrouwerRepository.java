package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Brouwer;

public interface BrouwerRepository extends JpaRepository<Brouwer, Long> {
	@EntityGraph("Brouwer.metAdres")
	List<Brouwer> findAll();
}
