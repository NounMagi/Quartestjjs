package game;

public enum MoveType {
	INIT, //This type should only be allowed for the initial game state
	PLAYERA_GIVE,
	PLAYERA_PLACE,
	PLAYERB_GIVE,
	PLAYERB_PLACE,
	PLAYERA_VICTORY,
	PLAYERB_VICTORY;
}
