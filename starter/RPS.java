/**
 * Name: Natalie Young
 * ID: A17237090
 * Email: nyoung@ucsd.edu
 * Sources used: none
 * 
 * Contains class RPS which extends abstract class RPSAbstract (which
 * implements RPSInterface) to facilitate player-game interaction.
 * Takes user input TODO: continued
 */

import java.util.Scanner;

/**
 * Extends RPSAbstract to facilitate player-game interaction TODO continued
 */
public class RPS extends RPSAbstract {
	
	/**
	 * Constructor; initializes possibleMoves, playerMoves, cpuMoves
	 */
	public RPS(String[] moves) {
		this.possibleMoves = moves;
		this.playerMoves = new String[MAX_GAMES];
		this.cpuMoves = new String[MAX_GAMES];
	}

	/**
	 * Takes the user move, the CPU move, and determines who wins.
	 * @param playerMove - move of the player
	 * @param cpuMove - move of the CPU
	 * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
	 */
	public int determineWinner(String playerMove, String cpuMove)
	{
		// Invalid move
		if (!isValidMove(playerMove) || !isValidMove(cpuMove))
		{
			return INVALID_INPUT_OUTCOME;
		}
		// Tie
		else if (playerMove.equals(cpuMove))
		{
			return TIE_OUTCOME;
		}
		// Compares move indices to get player win or cpu win
		for (int i = 0; i < possibleMoves.length; i++)
		{
			int nextIndex = (i + 1 < possibleMoves.length) ? (i + 1) : 0;

			if (possibleMoves[i].equals(playerMove) && possibleMoves[nextIndex].equals(cpuMove))
			{
				return PLAYER_WIN_OUTCOME;
			}
			else if (possibleMoves[i].equals(cpuMove) && possibleMoves[nextIndex].equals(playerMove))
			{
				return CPU_WIN_OUTCOME;
			}
		}

		return TIE_OUTCOME;
	}

	/**
	 * Main method that reads user input, generates cpu move, and plays game
	 * 
	 * @param args - arguments passed in from command line in String form
	 */
	public static void main(String[] args) {
		// If command line args are provided use those as the possible moves
		String[] moves = new String[args.length];
		if (args.length >= MIN_POSSIBLE_MOVES) {
			for (int i = 0; i < args.length; i++) {
				moves[i] = args[i];
			}
		} else {
			moves = RPS.DEFAULT_MOVES;
		}
		
		// Create new game and scanner
		RPS game = new RPS(moves);
		Scanner in = new Scanner(System.in);

		String playerMove;
		String cpuMove;
		
		// While user does not input "q", play game
		do {
			System.out.println(PROMPT_MOVE);
		
			playerMove = in.nextLine();
			cpuMove = game.genCPUMove();

			while (!game.isValidMove(playerMove) && !playerMove.equals("q"))
			{
				System.out.println(INVALID_INPUT);
				System.out.println(PROMPT_MOVE);
				playerMove = in.nextLine();
				cpuMove = game.genCPUMove();
			}
			

			if (!playerMove.equals("q") && game.isValidMove(playerMove))
			{
				game.play(playerMove, cpuMove);
			}
	
		} while (!playerMove.equals("q"));

//		System.out.println(THANKS);

		game.end();

		in.close();
	}
}
