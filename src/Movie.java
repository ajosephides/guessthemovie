import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Movie {

private String randomMovieTitle;
private String hiddenMovieTitle;
private String revealedMovieTitle;


Movie() throws FileNotFoundException{

    randomMovieTitle = randomMovie(createMovieArray("movies.txt")).toLowerCase();
    hiddenMovieTitle = hideLetters(randomMovieTitle);
    revealedMovieTitle = hiddenMovieTitle;

}


public String getRandomMovieTitle(){

    return this.randomMovieTitle;
}

public String getHiddenMovieTitle(){

    return this.hiddenMovieTitle;
}

public String getRevealedMovieTitle(){

    return this.revealedMovieTitle;
}


    private static String[] createMovieArray(String fileLocation) throws FileNotFoundException {

        File file = new File(fileLocation);
        Scanner movieList = new Scanner(file);
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



    private static String randomMovie(String[] movieList) {

        int randomMovieChoice = (int) ((Math.random() * movieList.length) + 1);
        return (movieList[randomMovieChoice]);

    }


    private static String hideLetters(String randomMovie) {

        String hiddenRandomMovie = "";
        for (int i = 0; i < randomMovie.length(); i++) {

            char letter = randomMovie.charAt(i);
            if (letter == ' ') {
                hiddenRandomMovie = hiddenRandomMovie + " ";
            } else {
                hiddenRandomMovie = hiddenRandomMovie + "-";
            }
        }
        return hiddenRandomMovie;
    }


    private static String replaceLetters(String randomMovie, String guessSoFar, char guessedLetter, boolean letterExists){

        char[] stringOfChar = guessSoFar.toCharArray();

        if(letterExists){

            for(int i = 0; i < randomMovie.length(); i++){

                char letter = randomMovie.charAt(i);
                if (letter == guessedLetter) {

                    stringOfChar[i] = letter;
                }
            }
        }

        guessSoFar = String.valueOf(stringOfChar);

        return guessSoFar;
    }


    public void updateRevealedMovieTitle(char guessedLetter, boolean letterExists){

    this.revealedMovieTitle = replaceLetters(randomMovieTitle, revealedMovieTitle,guessedLetter,letterExists);

    }

}
