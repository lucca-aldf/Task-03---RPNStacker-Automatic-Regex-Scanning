public class Regex {
	
	public static final String NUM_REGEX = "(\\d)+";
	public static final String OP_REGEX = "(\\+|-|\\|/)";
	public static final String PLUS_REGEX = "(\\+)";
	public static final String MINUS_REGEX = "(\\-)";
	public static final String SLASH_REGEX = "(/)";
	public static final String STAR_REGEX = "(\\*)";

	
	public static boolean isNum(String value) {
		return value.matches(NUM_REGEX);
	}
	
	public static boolean isOp(String value) {
		return value.matches(OP_REGEX);
	}

	public static boolean isPlus(String value) {
		return value.matches(PLUS_REGEX);
	}

	public static boolean isMinus(String value) {
		return value.matches(MINUS_REGEX);
	}

	public static boolean isSlash(String value) {
		return value.matches(SLASH_REGEX);
	}

	public static boolean isStar(String value) {
		return value.matches(STAR_REGEX);
	}

	public static TokenType getOPTokenType(String value) {
		
		if(isPlus(value)) {
			return TokenType.PLUS;
		}
		
		else if(isMinus(value)) {
			return TokenType.MINUS;
		}

		else if(isSlash(value)) {
			return TokenType.SLASH;
		}

		else if(isStar(value)) {
			return TokenType.STAR;
		}

		else {
			return null;
		}

	}
	
	public static TokenType getTokenType(String value) {
		if(isNum(value)) {
			return TokenType.NUM;
		}

		else if(isOp(value)) {
			return getOPTokenType(value);
		}

		else {
			throw new Error("Unexpected character: "+value);
		}

	}

}
