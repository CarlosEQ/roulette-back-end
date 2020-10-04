package co.roulette.util;

import co.roulette.dto.BetDTO;

/**
 * Allows to verify the roulette's validity
 * 
 * @author Carlos Quiñones
 * @version 1.0
 */
public class RouletteValidator {
	private RouletteValidator() {
		super();
	}

	public static boolean validateBet(BetDTO request) {
		if (request.getColorSelected() != null && (request.getColorSelected().equalsIgnoreCase("negro")
				|| request.getColorSelected().equalsIgnoreCase("rojo"))) {

			return true;
		}
		if (request.getNumberSelected() != null && request.getNumberSelected() >= 0
				&& request.getNumberSelected() <= 36) {

			return true;
		}

		return false;
	}
}
