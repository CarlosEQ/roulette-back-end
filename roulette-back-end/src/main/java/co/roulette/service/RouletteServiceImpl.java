package co.roulette.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.roulette.dto.ResponseDTO;
import co.roulette.dto.RouletteDTO;
import co.roulette.model.Roulette;
import co.roulette.repository.RouletteRepository;

/**
 * Allow roulette's CRUD operations
 * 
 * @author Carlos Quiñones
 *
 */
@Service
public class RouletteServiceImpl implements RouletteServiceInterface {
	@Autowired
	private RouletteRepository rouletteRepository;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	@Transactional(readOnly = true)
	public List<Roulette> findAllRoulettes() {
		List<Roulette> result = new ArrayList<>();
		rouletteRepository.findAll().forEach(result::add);

		return result;
	}
	@Override
	public Long saveRoulette() {
		Roulette request = new Roulette(null, false);
		Roulette response = rouletteRepository.save(request);

		return response.getRouletteId();
	}
	@Override
	@Transactional(readOnly = true)
	public Roulette findRouletteById(Long id) {

		return rouletteRepository.findById(id).orElse(null);
	}
	@Override
	public ResponseDTO enableRouletteById(Long roulleteId) {
		Optional<Roulette> roulette = rouletteRepository.findById(roulleteId);
		ResponseDTO response = new ResponseDTO();
		if (roulette.isPresent()) {
			Roulette request = roulette.get();
			if (!request.isRouletteStatus()) {
				request.setBets(null);
			}
			request.setRouletteStatus(true);
			rouletteRepository.save(request);
			response.setResponseMessage("La ruleta ha sido activada con éxito");
			response.setResponseCode(200);
		} else {
			response.setResponseMessage("La apuesta no es correcta");
			response.setResponseCode(400);
		}
		
		return response;
	}

	@Override
	public List<RouletteDTO> getAllRoulettes() {
		ArrayList<Roulette> result = new ArrayList<>();
		rouletteRepository.findAll().forEach(result::add);
		List<RouletteDTO> response = objectMapper.convertValue(result, new TypeReference<List<RouletteDTO>>() {
		});

		return response;
	}
}
