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

  private static String[] createMovieArray(Scanner movieList) {

    String[] movieArray = new String[0];

    while (movieList.hasNextLine()) {
      String[] movieArrayTemp = new String[movieArray.length + 1];
      for (int i = 0; i < movieArray.length; i++) {
        movieArrayTemp[i] = movieArray[i];
      }
      movieArrayTemp[movieArrayTemp.length - 1] = movieList.nextLine();
      movieArray = movieArrayTemp;
    }

    return (movieArray);
  }

  private static String pickRandomMovie(String[] movieList) {
    int randomMovieChoice = (int) ((Math.random() * movieList.length) + 1);
    return (movieList[randomMovieChoice]);
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
