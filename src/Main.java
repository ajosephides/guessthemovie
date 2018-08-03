import java.io.File;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {

    File file = new File("movies.txt");

    Scanner movieList = new Scanner(file);

    Game letsPlay = new Game(movieList);

    System.out.println("Roll up and good luck. Please make a guess.");
    System.out.println("You have " + letsPlay.getGuessesLeft() + " guesses left");
    System.out.println(letsPlay.getRevealedMovieTitle());

    while (!letsPlay.isHasWon() && !letsPlay.isLastGuess()) {

      Scanner userInput = new Scanner(System.in);

      letsPlay.playturn(userInput);

      if (letsPlay.isLastGuessCorrect() && !letsPlay.isHasWon()) {
        System.out.println("Correct guess.");
        System.out.println("You have " + letsPlay.getGuessesLeft() + " guesses left");
        System.out.println("Please guess again.");
        System.out.println(letsPlay.getRevealedMovieTitle());
      }

      if (!letsPlay.isLastGuessCorrect() && !letsPlay.isLastGuess()) {
        System.out.println("Incorrect guess");
        System.out.println("You have " + letsPlay.getGuessesLeft() + " guesses left");
        System.out.println("Please guess again.");
        System.out.println(letsPlay.getRevealedMovieTitle());
      }
    }

    if (letsPlay.isHasWon()) {
      System.out.println(letsPlay.getMovieTitle());
      System.out.println("Congratulations. You guessed the movie! What a clever bunny you are.");
    } else {
      System.out.println("Unlucky. Game Over.");
      System.out.println("The correct answer is " + letsPlay.getMovieTitle());
    }
  }
}
