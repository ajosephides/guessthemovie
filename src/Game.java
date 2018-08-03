import java.util.Scanner;

public class Game {

  private char lastGuessedLetter;
  private int guessesLeft;
  private boolean lastGuessCorrect;
  private boolean lastGuess;
  private boolean hasWon;
  private Movie movie;

  Game(Scanner movieList) {
    guessesLeft = 10;
    hasWon = false;
    lastGuess = false;
    movie = new Movie(movieList);
  }

  public void playturn(Scanner userInput) {

    setUserGuess(userInput);
    setLetterExists();
    setGuessesLeft();
    movie.updateRevealedMovieTitle(lastGuessedLetter, lastGuessCorrect);
    updateHasWon();
    setLastGuess();
  }

  public int getGuessesLeft() {
    return this.guessesLeft;
  }

  public boolean isLastGuessCorrect() {
    return this.lastGuessCorrect;
  }

  public boolean isLastGuess() {

    return this.lastGuess;
  }

  public boolean isHasWon() {

    return hasWon;
  }

  public String getMovieTitle() {

    return movie.getMovieTitle();
  }

  public String getRevealedMovieTitle() {

    return movie.getRevealedMovieTitle();
  }

  private void updateHasWon() {

    if (movie.getMovieTitle().equalsIgnoreCase(movie.getRevealedMovieTitle())) {
      this.hasWon = true;
    } else {
      this.hasWon = false;
    }
  }

  private void setLastGuess() {
    if (this.guessesLeft != 0) {
      this.lastGuess = false;
    } else {
      this.lastGuess = true;
    }
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
