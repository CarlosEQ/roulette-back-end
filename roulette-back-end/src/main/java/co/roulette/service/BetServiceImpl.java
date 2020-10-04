package co.roulette.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.roulette.dto.BetDTO;
import co.roulette.dto.ResponseDTO;
import co.roulette.dto.ResultBetDTO;
import co.roulette.dto.WinnerDTO;
import co.roulette.model.Bet;
import co.roulette.model.Roulette;
import co.roulette.repository.RouletteRepository;

/**
 * Allow bet's CRUD operations
 * 
 * @author Carlos Quiñones
 *
 */
@Service
public class BetServiceImpl implements BetServiceInterface {
	@Autowired
	RouletteRepository rouletteRepository;
	@Autowired
	HttpServletRequest requestUrl;
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public ResponseDTO newBet(BetDTO bet) {
		boolean rouletteStatus = checkRouletteById(bet.getRouletteId());
		ResponseDTO response = new ResponseDTO();
		bet.setUserId(requestUrl.getHeader("user"));
		if (rouletteStatus && bet.getBetAmount() != null && bet.getBetAmount() > 0 && bet.getBetAmount() <= 10000) {
			response = saveBet(bet);
			response.setResponseMessage("La apuesta ha sido creada con éxito");
			response.setResponseCode(200);
		} else {
			response.setResponseMessage("La apuesta no se puede realizar");
			response.setResponseCode(400);
		}

		return response;
	}
	@Override
	public ResponseDTO saveBet(BetDTO bet) {
		Roulette roulette = rouletteRepository.findById(bet.getRouletteId()).get();
		ResponseDTO response = new ResponseDTO();
		if (bet.getColorSelected() != null) {
			bet.setNumberSelected(null);
		} else {
			bet.setColorSelected(null);
		}
		Bet request = objectMapper.convertValue(bet, Bet.class);
		roulette.addBet(request);
		rouletteRepository.save(roulette);

		return response;
	}

	@Override
	public boolean checkRouletteById(Long rouletteId) {
		Optional<Roulette> roulette = rouletteRepository.findById(rouletteId);
		if (roulette.isPresent()) {
			if (roulette.get().isRouletteStatus()) {

				return true;
			}
		}

		return false;
	}
	@Override
	public ResultBetDTO closeBet(Long rouletteId) {
		Optional<Roulette> optionalRoulette = rouletteRepository.findById(rouletteId);
		ResultBetDTO response = new ResultBetDTO();
		if (optionalRoulette.isPresent()) {
			Roulette roulette = optionalRoulette.get();
			roulette.setRouletteStatus(false);
			rouletteRepository.save(roulette);
			List<BetDTO> betsDTO = objectMapper.convertValue(roulette.getBets(), new TypeReference<List<BetDTO>>() {
			});
			response = selectWinner(betsDTO);
			response.setResponseCode(200);
			response.setResponseMessage("Ruleta cerrada correctamente");
			response.setRelatedBets(betsDTO);
			
			return response;
		}
		response.setResponseCode(404);
		response.setResponseMessage("No se ha encontrado la ruleta seleccionada");
		
		return response;
	}

	public ResultBetDTO selectWinner(List<BetDTO> betsDTO) {
		Long randomNumber = (long) (Math.random() * 36);
		ResultBetDTO response = new ResultBetDTO();
		response.setWinnerNumber(randomNumber);
		WinnerDTO winnerDTO = null;
		for (int i = 0; i < betsDTO.size(); i++) {
			if (betsDTO.get(i).getNumberSelected() != null && betsDTO.get(i).getNumberSelected() == randomNumber) {
				winnerDTO = new WinnerDTO(betsDTO.get(i).getUserId(), betsDTO.get(i).getBetAmount() * 5);
				response.addWinner(winnerDTO);
			}
			if (betsDTO.get(i).getColorSelected() != null) {
				if (randomNumber % 2 == 0 && betsDTO.get(i).getColorSelected().equalsIgnoreCase("rojo")) {
					response.setWinnerColor("rojo");
					winnerDTO = new WinnerDTO(betsDTO.get(i).getUserId(), betsDTO.get(i).getBetAmount() * 1.8);
					response.addWinner(winnerDTO);
				} else if (randomNumber % 2 != 0 && betsDTO.get(i).getColorSelected().equalsIgnoreCase("negro")) {
					response.setWinnerColor("negro");
					winnerDTO = new WinnerDTO(betsDTO.get(i).getUserId(), betsDTO.get(i).getBetAmount() * 1.8);
					response.addWinner(winnerDTO);
				}
			}
		}
		
		return response;
	}
}
