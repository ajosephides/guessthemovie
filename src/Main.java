import java.awt.*;

public class Main {

    public static void main(String [] args) throws Exception {


        Movie gameTime = new Movie();

        Game letsPlay = new Game();


        System.out.println("Roll up and good luck. Please make a guess.");
        System.out.println("You have " + letsPlay.getGuessesLeft() + " guesses left");
        System.out.println(gameTime.getRevealedMovieTitle());

        while(letsPlay.getGuessesLeft() > 0){

            letsPlay.playturn(gameTime.getRandomMovieTitle());

            gameTime.updateRevealedMovieTitle(letsPlay.getLastGuessedLetter(),letsPlay.getLetterExists());

            letsPlay.updateHasWon(gameTime.getRandomMovieTitle(),gameTime.getRevealedMovieTitle());


            if(letsPlay.getGuessesLeft()!=0){
                System.out.println("Please guess again you lovely person");
                System.out.println("You have " + letsPlay.getGuessesLeft() + " guesses left");
                System.out.println(gameTime.getRevealedMovieTitle());
            } else{
                System.out.println("Unlucky. Game Over.");
                System.out.println("Oh it was " + gameTime.getRandomMovieTitle() + ". Fool");
                break;
            }

            if(letsPlay.isHasWon()){
                System.out.println("You are amazing. You guessed the movie. What a clever bunny you are.");
                break;
}

        }

    }

}


