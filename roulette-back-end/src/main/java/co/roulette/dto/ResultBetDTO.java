package co.roulette.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * Data transer object to show winner list, winner number and winner color
 * @author Carlos Quiñones
 *
 */
public class ResultBetDTO extends ResponseDTO {
	private List<BetDTO> relatedBets;
	private List<WinnerDTO> winners;
	private String winnerColor;
	private Long winnerNumber;
	public ResultBetDTO() {
		winners = new ArrayList<>();
	}
	public List<BetDTO> getRelatedBets() {
		
		return relatedBets;
	}
	public void setRelatedBets(List<BetDTO> relatedBets) {
		this.relatedBets = relatedBets;
	}
	public List<WinnerDTO> getWinnersDTO() {
		
		return winners;
	}
	public void setWinnersDTO(List<WinnerDTO> winnersDTO) {
		this.winners = winnersDTO;
	}
	public String getWinnerColor() {
		
		return winnerColor;
	}
	public void setWinnerColor(String winnerColor) {
		this.winnerColor = winnerColor;
	}
	public Long getWinnerNumber() {
		
		return winnerNumber;
	}
	public void setWinnerNumber(Long winnernumber) {
		this.winnerNumber = winnernumber;
	}
	public void addWinner(WinnerDTO winner) {
		winners.add(winner);
	}
	
}
