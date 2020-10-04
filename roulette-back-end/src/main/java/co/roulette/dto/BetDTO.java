package co.roulette.dto;
/**
 * Data transer object for Bet model
 * @author Carlos Quiñones
 *
 */
public class BetDTO{
	private Long rouletteId;
	private Long betAmount;
	private String userId;
	private String colorSelected;
	private Long numberSelected;
	
	public Long getRouletteId() {
		return rouletteId;
	}
	public void setRouletteId(Long rouletteId) {
		this.rouletteId = rouletteId;
	}
	public Long getBetAmount() {
		return betAmount;
	}
	public void setBetAmount(Long betAmount) {
		this.betAmount = betAmount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getColorSelected() {
		return colorSelected;
	}
	public void setColorSelected(String colorSelected) {
		this.colorSelected = colorSelected;
	}
	public Long getNumberSelected() {
		return numberSelected;
	}
	public void setNumberSelected(Long numberSelected) {
		this.numberSelected = numberSelected;
	}

}
