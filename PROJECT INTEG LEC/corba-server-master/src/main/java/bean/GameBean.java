package bean;

public class GameBean {

    private int nomOfTry;
    private String randomWord;
    private int life = 2;
    private char[] guesses;

    public GameBean(String randomWord) {
        this.randomWord = randomWord;
        guesses = new char[randomWord.length()];
    }

    public int getNomOfTry() {
        return nomOfTry;
    }

    public void setNomOfTry(int nomOfTry) {
        this.nomOfTry = nomOfTry;
    }

    public String getRandomWord() {
        return randomWord;
    }

    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public char[] getGuesses() {
        return guesses;
    }

    public void setGuessChar(char guessChar) {

        for (int i = 0; i< guesses.length; i++) {
            if(randomWord.toCharArray()[i] == guessChar){
                guesses[i] = guessChar;
            }
        }
    }
}
