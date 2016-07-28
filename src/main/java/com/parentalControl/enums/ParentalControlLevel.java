package com.parentalControl.enums;

public enum ParentalControlLevel {
	UNIVERSAL("U", 0), PARENTAL_GUIDANCE("PG", 1), TWELVE("12", 2), FIFTEEN(
			"15", 3), EIGHTEEN("18", 4);

	private String level;
	private int value;

	ParentalControlLevel(String level, int value) {
		this.level = level;
		this.value = value;
	}

	public String getLevel() {
		return level;
	}

	public int getValue() {
		return value;
	}

	public static ParentalControlLevel findByLevel(String level) {
		if (level != null) {
			for(ParentalControlLevel p : values())
			if(p.getLevel().equals(level)){
				return p;
			}
		}
		return null;
	}
}
