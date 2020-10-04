package co.roulette.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import co.roulette.dto.BetDTO;
import co.roulette.dto.ResponseDTO;
import co.roulette.dto.ResultBetDTO;
import co.roulette.dto.RouletteDTO;
import co.roulette.service.BetServiceImpl;
import co.roulette.service.RouletteServiceImpl;

/**
 * Roulette controller class for testing
 * @author ceq93
 *
 */
@SpringBootTest
public class RouletteControllerTest {
	@MockBean
	private RouletteServiceImpl rouletteService;
	@MockBean
	private BetServiceImpl betService;
	@Autowired
	private RouletteController rouletteController;
	@Test
	public void testCreateRoulette() {
		Mockito.when(rouletteService.saveRoulette()).thenReturn(14L);
		assertEquals(rouletteController.createRoulette(), 14L);
	}
	@Test
	public void testEnableRoluette() {
		ResponseDTO response = new ResponseDTO();
		Mockito.when(rouletteService.enableRouletteById(14L)).thenReturn(response);
		assertNotNull(rouletteController.enableRoluette(14L));
	}
	@Test
	public void testSelectRoulette() {
		ResponseDTO response = new ResponseDTO();
		response.setResponseCode(400);
		BetDTO bet = new BetDTO();
		bet.setColorSelected("negro");
		bet.setBetAmount(500L);
		Mockito.when(betService.newBet(bet)).thenReturn(response);
		assertNotNull(rouletteController.selectRoulette(bet));
	}
	@Test
	public void testCloseRulette() {
		Mockito.when(betService.closeBet(14L)).thenReturn(new ResultBetDTO());
		assertNotNull(rouletteController.closeRulette(14L));
	}
	@Test
	public void getRoulettes() {
		Mockito.when(rouletteService.getAllRoulettes()).thenReturn(new ArrayList<RouletteDTO>());
		assertEquals(rouletteController.getRoulettes().size(), 0);
	}
}
