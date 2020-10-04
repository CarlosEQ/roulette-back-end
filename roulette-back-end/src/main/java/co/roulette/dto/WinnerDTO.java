package co.roulette.dto;
/**
 * Data transfer object to show amount earned and user id
 * @author Carlos Quiñones
 *
 */
public class WinnerDTO {
	private double amountEarned;
	private String userId;
	public WinnerDTO() {
		
	}
	public WinnerDTO(String userId, double amountEarned) {
		this.userId = userId;
		this.amountEarned = amountEarned;
	}
	public double getAmountEarned() {
		
		return amountEarned;
	}
	public void setAmountEarned(double amountEarned) {
		this.amountEarned = amountEarned;
	}
	public String getUserId() {
		
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
}
