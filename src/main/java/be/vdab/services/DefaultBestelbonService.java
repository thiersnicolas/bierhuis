package be.vdab.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.entities.Bestelbon;
import be.vdab.repositories.BestelbonRepository;

@Service
@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
public class DefaultBestelbonService implements BestelbonService {
	private BestelbonRepository bestelbonRepository;
	
	public DefaultBestelbonService(BestelbonRepository bestelbonRepository) {
		this.bestelbonRepository = bestelbonRepository;
	}
	
	@Transactional(readOnly=false, isolation=Isolation.READ_COMMITTED)
	@Override
	public void create(Bestelbon bestelbon) {
		bestelbonRepository.save(bestelbon);
	}

}
