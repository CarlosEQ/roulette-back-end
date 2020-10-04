package co.roulette.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.roulette.dto.BetDTO;
import co.roulette.dto.ResponseDTO;
import co.roulette.model.Bet;
import co.roulette.model.Roulette;
import co.roulette.repository.RouletteRepository;

/**
 * Bet service class for testing
 * 
 * @author Carlos Quiñones
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class BetServiceImplTest {	
	@MockBean
	RouletteRepository rouletteRepository;	
	@Autowired
	BetServiceImpl betService;
	@Test
	void testNewBet() {
		BetDTO bet = new BetDTO();
		bet.setRouletteId(14L);
		bet.setBetAmount(50L);
		bet.setColorSelected("negro");
		Roulette roulette = new Roulette(14L, true);
		ArrayList<Bet> bets = new ArrayList<Bet>();
		roulette.setBets(bets);
		Optional<Roulette> optionalRoulette = Optional.of(roulette);
		ResponseDTO response = new ResponseDTO();
		response.setResponseCode(200);
		Mockito.when(rouletteRepository.findById(14L)).thenReturn(optionalRoulette);
		Mockito.when(rouletteRepository.save(roulette)).thenReturn(roulette);
		assertEquals(betService.newBet(bet).getResponseCode(), response.getResponseCode());
		}
	@Test
	void testSaveBet() {
		BetDTO bet = new BetDTO();
		bet.setRouletteId(14L);
		bet.setBetAmount(50L);
		bet.setColorSelected("negro");
		Roulette roulette = new Roulette(14L, true);
		ArrayList<Bet> bets = new ArrayList<Bet>();
		roulette.setBets(bets);
		Optional<Roulette> optionalRoulette = Optional.of(roulette);
		ResponseDTO response = new ResponseDTO();
		response.setResponseMessage("Se ha realizado con éxito");
		response.setResponseCode(200);		
		Mockito.when(rouletteRepository.findById(14L)).thenReturn(optionalRoulette);
		Mockito.when(rouletteRepository.save(roulette)).thenReturn(roulette);
		assertNotNull(betService.saveBet(bet));		
	}
	@Test
	public void testCheckRouletteById() {
		Roulette roulette = new Roulette();
		roulette.setRouletteStatus(true);
		Optional<Roulette> optinalRoulette = Optional.of(roulette);		
		Mockito.when(rouletteRepository.findById(14L)).thenReturn(optinalRoulette);
		assertEquals(betService.checkRouletteById(14L), true);
	}
	@Test
	void testCloseBet() {
		Roulette roulette = new Roulette();
		roulette.setRouletteId(14L);
		Bet bet = new Bet();
		bet.setBetAmount(3000L);
		roulette.addBet(bet);
		Optional<Roulette> optinalRoulette = Optional.of(roulette);		
		Mockito.when(rouletteRepository.findById(14L)).thenReturn(optinalRoulette);
		assertEquals(betService.closeBet(14L).getResponseCode(), 200);
	}
	@Test
	void testSelectWinner() {
		List<BetDTO> betsDTO = new ArrayList<BetDTO>();
		BetDTO betDTO = new BetDTO();
		betDTO.setBetAmount(300L);
		betDTO.setColorSelected("negro");
		betDTO.setUserId("user");
		BetDTO betDTO2 = new BetDTO();
		betDTO2.setBetAmount(300L);
		betDTO2.setColorSelected("rojo");
		betDTO2.setUserId("user2");
		betsDTO.add(betDTO2);
		assertEquals(betService.selectWinner(betsDTO).getWinnersDTO().size(), 1);
	}
}
