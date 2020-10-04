package co.roulette.service;

import java.util.List;

import co.roulette.dto.ResponseDTO;
import co.roulette.dto.RouletteDTO;
import co.roulette.model.Roulette;

/**
 * Interface with all operations over roulletes
 * 
 * @author Carlos Quiñones
 *
 */
public interface RouletteServiceInterface {
	public List<Roulette> findAllRoulettes();
	public Long saveRoulette();
	public Roulette findRouletteById(Long roulette_id);	
	public ResponseDTO enableRouletteById(Long roulette_id);
	public List<RouletteDTO> getAllRoulettes();

}
