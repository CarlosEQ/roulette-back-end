package co.roulette.service;

import co.roulette.dto.BetDTO;
import co.roulette.dto.ResponseDTO;
import co.roulette.dto.ResultBetDTO;

/**
 * Interface with all operations over bets
 * @author Carlos Quiñones
 *
 */
public interface BetServiceInterface {
	public ResponseDTO newBet(BetDTO bet);
	public ResponseDTO saveBet(BetDTO bet);
	public boolean checkRouletteById(Long roulette_id);
	public ResultBetDTO closeBet(Long roulette_id);
}
