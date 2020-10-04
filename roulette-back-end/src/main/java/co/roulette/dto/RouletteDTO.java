package co.roulette.dto;

import java.util.ArrayList;
/**
 * Data transfer object for Roulette model
 * @author Carlos Quiñones
 *
 */
public class RouletteDTO extends ResponseDTO{
	private Long rouletteId;
	private ArrayList<BetDTO> bets;
	private boolean rouletteStatus;
	
	public RouletteDTO() {
		bets = new ArrayList<>();
	}
	public RouletteDTO(Long rouletteId, boolean rouletteStatus) {
		this.rouletteId = rouletteId;
		this.rouletteStatus = rouletteStatus;
	}
	public Long getRouletteId() {
		
		return rouletteId;
	}
	public void setRouletteId(Long rouletteId) {
		this.rouletteId = rouletteId;
	}	
	public ArrayList<BetDTO> getBets() {
		
		return bets;
	}
	public void setBets(ArrayList<BetDTO> bets) {
		this.bets = bets;
	}
	public boolean isRouletteStatus() {
		
		return rouletteStatus;
	}
	public void setRouletteStatus(boolean rouletteStatus) {
		this.rouletteStatus = rouletteStatus;
	}
	public void addBet(BetDTO bet) {
		this.bets.add(bet);
	}
}
