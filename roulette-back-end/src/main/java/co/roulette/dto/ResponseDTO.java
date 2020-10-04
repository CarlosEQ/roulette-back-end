package co.roulette.dto;
/**
 * Data transer object for an answer
 * @author Carlos Quiñones
 *
 */
public class ResponseDTO {
	private int responseCode;
	private String responseMessage;
	public int getResponseCode() {
		
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
