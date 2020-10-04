package co.roulette.model;

import org.springframework.data.redis.core.index.Indexed;

/**
 * Model class for the bet's body
 * 
 * @author Carlos Quiñones
 *
 */
public class Bet {

	@Indexed
	private Long betId;
	private Long rouletteId;
	private Long betAmount;
	private String userId;
	private String colorSelected;
	private Long numberSelected;

	public Long getBetId() {
		return betId;
	}

	public void setBetId(Long betId) {
		this.betId = betId;
	}

	public Long getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(Long betsMoney) {
		this.betAmount = betsMoney;
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

	public Long getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(Long rouletteId) {
		this.rouletteId = rouletteId;
	}
}
