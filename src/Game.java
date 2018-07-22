import java.util.Scanner;


public class Game {

    private char lastGuessedLetter;
    private int guessesLeft;
    private boolean lastGuessCorrect;
    private boolean hasWon;

    Game(){
        guessesLeft = 10;
    }

    public void playturn(String randomMovieTitle){

        this.setUserGuess();
        this.setLetterExists(randomMovieTitle, this.lastGuessedLetter);
        this.setGuessesLeft();

    }


    private void setUserGuess(){

        Scanner userInput = new Scanner(System.in);

        char guessedLetter = userInput.nextLine().toLowerCase().charAt(0);

        this.lastGuessedLetter = guessedLetter;

    }

    public char getLastGuessedLetter(){
        return this.lastGuessedLetter;
    }


    private void setLetterExists(String movieTitle, char guessedLetter){

        if(movieTitle.indexOf(guessedLetter) >= 0){
            this.lastGuessCorrect = true;
        } else {
            this.lastGuessCorrect = false;
        }
    }

    public boolean getLetterExists(){

        return this.lastGuessCorrect;
    }


    private void setGuessesLeft(){

        if(this.lastGuessCorrect){

            this.guessesLeft = this.guessesLeft;

        } else {

            this.guessesLeft = this.guessesLeft - 1;
        }
    }


    public int getGuessesLeft(){
        return this.guessesLeft;
    }



    public void updateHasWon(String randomMovieTitle, String revealedMovieTitle){

        if(randomMovieTitle.toLowerCase().equals(revealedMovieTitle.toLowerCase())){
            this.hasWon = true;
        } else {
            this.hasWon = false;
        }
    }


    public boolean isHasWon() {
        return hasWon;
    }


}
