package es.usantatecla.tictactoe_v2.main.models;

public enum Message {

	TITLE("--- TIC TAC TOE ---"),
	HORIZONTAL_LINE("---------------"),
	VERTICAL_LINE(" | "),
	NULL_COLOR(" "),
	TURN("Turn: " + Message.$COLOR),
	ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
	COORDINATE_TO_PUT("Coordinate to put"),
	COORDINATE_TO_REMOVE("Origin coordinate to move"),
	COORDINATE_TO_MOVE("Target coordinate to move"),
	ROW("Row"),
	COLUMN("Column"),
	BOUNDED_INT_ERROR("Invalid number"),
	LIMITS("? " + Message.$CLOSED_INTERVAL + ": "),
	CLOSED_INTERVAL("[" + Message.$MIN + ", " + Message.$MAX + "]"),
	PLAYER_WIN(Message.$PLAYER + " player: You win!!! :-)"),
	RESUME("Do you want to continue"),
	YES_NO_SUFFIX("? (" + Message.AFFIRMATIVE + "/" + Message.NEGATIVE + "): "),
	YES_NO_ERROR("The value must be '" + Message.AFFIRMATIVE + "' or '" + Message.NEGATIVE + "'");
  
	public static final char AFFIRMATIVE = 'y';
	public static final char NEGATIVE = 'n';
	public static final String $COLOR = "#color";
	public static final String $PLAYER = "#player";
	public static final String $CLOSED_INTERVAL = "#closedInterval";
	public static final String $MIN = "#min";
	public static final String $MAX = "#max";

	private String message;

	private Message(String message) {
		assert message != null;
		
		this.message = message;
	}

	public String toString() {
		return message;
	}
}
