package be.vdab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@Service
@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
public class DefaultBrouwerService implements BrouwerService {
	private BrouwerRepository brouwerRepository;
	
	public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll();
	}

	@Override
	public Optional<Brouwer> findById(long id) {
		return Optional.ofNullable(brouwerRepository.findOne(id));
	}

}
