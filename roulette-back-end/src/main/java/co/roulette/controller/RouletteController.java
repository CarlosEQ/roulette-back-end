package co.roulette.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.roulette.dto.BetDTO;
import co.roulette.dto.ResponseDTO;
import co.roulette.dto.ResultBetDTO;
import co.roulette.dto.RouletteDTO;
import co.roulette.service.BetServiceImpl;
import co.roulette.service.RouletteServiceImpl;
import co.roulette.util.RouletteValidator;

/**
 * Allow to make http requests
 * 
 * @author Carlos Quiñones
 * @version 1.0
 */

@RestController
public class RouletteController {
	@Autowired
	private RouletteServiceImpl rouletteService;
	@Autowired
	private BetServiceImpl betService;	
	@GetMapping("/new_roulette")
	public Long createRoulette() {

		return rouletteService.saveRoulette();
	}

	@PutMapping("/open_roulette/")
	public ResponseDTO enableRoluette(@RequestParam("id") Long id) {
		
		return rouletteService.enableRouletteById(id);
	}
	@PostMapping("/new_bet")
	public ResponseDTO selectRoulette(@RequestBody BetDTO bet) {
		boolean isValidRoulette = RouletteValidator.validateBet(bet);
		ResponseDTO output = new ResponseDTO();
		if (isValidRoulette) {
			output = betService.newBet(bet);
		}else {
			output.setResponseCode(400);
		}
		
		return output;
	}	
	@GetMapping("/close_roulette")
	public ResultBetDTO closeRulette(@RequestParam("roulette") Long roulettId) {
		
		return betService.closeBet(roulettId);
	}
	@GetMapping("/all_roulettes")
	public List<RouletteDTO> getRoulettes(){
		
		return rouletteService.getAllRoulettes();
	}
}
