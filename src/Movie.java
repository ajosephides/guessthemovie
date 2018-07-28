import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

  private String movieTitle;
  private String hiddenMovieTitle;
  private String revealedMovieTitle;

  Movie(Scanner movieList) {

    movieTitle = pickRandomMovie(createMovieArray(movieList)).toLowerCase();
    hiddenMovieTitle = hideLetters(movieTitle);
    revealedMovieTitle = hiddenMovieTitle;
  }

  public String getMovieTitle() {

    return this.movieTitle;
  }

  public String getRevealedMovieTitle() {

    return this.revealedMovieTitle;
  }

  public void updateRevealedMovieTitle(char guessedLetter, boolean letterExists) {

    this.revealedMovieTitle =
        replaceLetters(movieTitle, revealedMovieTitle, guessedLetter, letterExists);
  }

  private ArrayList<String> createMovieArray(Scanner movieList) {

    ArrayList<String> moviesArray = new ArrayList();

    while (movieList.hasNextLine()) {
      moviesArray.add(movieList.nextLine());
    }
    return (moviesArray);
  }

  private static String pickRandomMovie(ArrayList<String> movies) {
    int randomMovieChoice = (int) ((Math.random() * movies.size()) + 1);
    return (movies.get(randomMovieChoice));
  }

  private static String hideLetters(String movieTitle) {

    String hiddenMovie = "";
    for (int i = 0; i < movieTitle.length(); i++) {

      char letter = movieTitle.charAt(i);
      if (letter == ' ') {
        hiddenMovie = hiddenMovie + " ";
      } else {
        hiddenMovie = hiddenMovie + "-";
      }
    }
    return hiddenMovie;
  }

  private static String replaceLetters(
      String movieTitle, String guessSoFar, char guessedLetter, boolean letterExists) {

    char[] stringOfChar = guessSoFar.toCharArray();
    if (letterExists) {

      for (int i = 0; i < movieTitle.length(); i++) {

        char letter = movieTitle.charAt(i);
        if (letter == guessedLetter) {

          stringOfChar[i] = letter;
        }
      }
    }

    guessSoFar = String.valueOf(stringOfChar);

    return guessSoFar;
  }
}
