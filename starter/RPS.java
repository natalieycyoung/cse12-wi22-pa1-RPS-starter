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
		// TODO
		// Invalid move
		if (!isValidMove(playerMove))
		{
			return -1;
		}
		// Tie
		else if (playerMove.equals(cpuMove))
		{
			return 0;
		}
		
		for (int i = 0; i < possibleMoves.length; i ++)
		{
			if (possibleMoves[i].equals(playerMove) && possibleMoves[i + 1].equals(cpuMove))
			{
				return 1;
			}
		}

		return 10;
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

		// While user does not input "q", play game
		System.out.println("Game not yet implemented.");
		
		// TODO: Insert the code to play the game. 
		// See the writeup for an example of the game play.
		// Hint: call the methods we/you have already written 
		// to do most of the work!


		in.close();
	}
}
