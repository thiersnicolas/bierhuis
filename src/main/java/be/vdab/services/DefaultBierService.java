package be.vdab.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.entities.Bier;
import be.vdab.repositories.BierRepository;

@Service
@Transactional(readOnly=true, isolation = Isolation.READ_COMMITTED)
public class DefaultBierService implements BierService {
	private BierRepository bierRepository;
	
	public DefaultBierService(BierRepository bierRepository) {
		this.bierRepository = bierRepository;
	}

	@Override
	public long findAantalBieren() {
		return bierRepository.count();
	}

	@Override
	public Optional<Bier> findById(long id) {
		return Optional.ofNullable(bierRepository.findOne(id));
	}
	
	@Override
	public Iterable<Bier> findByIdIn(Set<Long> ids){
		return bierRepository.findByIdIn(ids);
	}

}
