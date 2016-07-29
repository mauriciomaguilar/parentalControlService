package com.parentalControl.enums;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:52:04
 *
 */
public enum ParentalControlLevelEnum {
	UNIVERSAL("U", 0), PARENTAL_GUIDANCE("PG", 1), TWELVE("12", 2), FIFTEEN(
			"15", 3), EIGHTEEN("18", 4);

	private String level;
	private int value;

	ParentalControlLevelEnum(String level, int value) {
		this.level = level;
		this.value = value;
	}

	public String getLevel() {
		return level;
	}

	public int getValue() {
		return value;
	}

	public static ParentalControlLevelEnum findByLevel(String level) {
		if (level != null) {
			for (ParentalControlLevelEnum p : values())
				if (p.getLevel().equals(level)) {
					return p;
				}
		}
		return null;
	}
}
