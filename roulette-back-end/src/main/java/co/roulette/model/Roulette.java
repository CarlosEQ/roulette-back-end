package co.roulette.model;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


/**
 * Model class for the roulette's body
 * 
 * @author Carlos Quiñones
 *
 */
@RedisHash("Roulette")
public class Roulette {

	@Id
	private Long rouletteId;
	private ArrayList<Bet> bets;
	private boolean rouletteStatus;
	
	public Roulette() {
		bets = new ArrayList<>();
	}

	public Roulette(Long rouletteId, boolean rouletteStatus) {
		this.rouletteId = rouletteId;
		this.rouletteStatus = rouletteStatus;
	}

	public Long getRouletteId() {
		return rouletteId;
	}

	public void setRouletteId(Long rouletteId) {
		this.rouletteId = rouletteId;
	}

	public ArrayList<Bet> getBets() {
		return bets;
	}

	public void setBets(ArrayList<Bet> bets) {
		this.bets = bets;
	}

	public boolean isRouletteStatus() {
		return rouletteStatus;
	}

	public void setRouletteStatus(boolean rouletteStatus) {
		this.rouletteStatus = rouletteStatus;
	}
	
	public void addBet(Bet bet) {
		this.bets.add(bet);
	}
}

