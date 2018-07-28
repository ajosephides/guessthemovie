import java.util.Scanner;

public class Game {

  private char lastGuessedLetter;
  private int guessesLeft;
  private boolean lastGuessCorrect;
  private boolean hasWon;
  private boolean gameInPlay;
  private Movie movie;

  Game(Scanner movieList) {
    guessesLeft = 10;
    gameInPlay = true;
    hasWon = false;
    movie = new Movie(movieList);
  }

  public void playturn(Scanner userInput) {

    setUserGuess(userInput);
    setLetterExists();
    setGuessesLeft();
    movie.updateRevealedMovieTitle(lastGuessedLetter, lastGuessCorrect);
  }

  public int getGuessesLeft() {
    return this.guessesLeft;
  }

  public void updateHasWon() {

    if (movie.getMovieTitle().equalsIgnoreCase(movie.getRevealedMovieTitle())) {
      this.hasWon = true;
    } else {
      this.hasWon = false;
    }
  }

  public boolean isHasWon() {

    return hasWon;
  }

  public void updateGameInPlay() {
    if (!this.hasWon && this.guessesLeft != 0) {
      this.gameInPlay = true;
    } else {
      this.gameInPlay = false;
    }
  }

  public boolean isGameInPlay() {
    return gameInPlay;
  }

  public String getMovieTitle() {

    return movie.getMovieTitle();
  }

  public String getRevealedMovieTitle() {

    return movie.getRevealedMovieTitle();
  }

  private void setUserGuess(Scanner userInput) {

    char guessedLetter = userInput.nextLine().toLowerCase().charAt(0);

    this.lastGuessedLetter = guessedLetter;
  }

  private void setLetterExists() {

    if (movie.getMovieTitle().indexOf(this.lastGuessedLetter) >= 0) {
      this.lastGuessCorrect = true;
    } else {
      this.lastGuessCorrect = false;
    }
  }

  private void setGuessesLeft() {

    if (!this.lastGuessCorrect) {
      this.guessesLeft = this.guessesLeft - 1;
    }
  }
}
