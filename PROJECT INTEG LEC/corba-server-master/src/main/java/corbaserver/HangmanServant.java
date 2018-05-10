package corbaserver;

import bean.GameBean;
import mainfiles.HangmanPOA;
import org.omg.CORBA.ORB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static corbaserver.HangmanServant.Status.*;

public class HangmanServant extends HangmanPOA {


    public enum Status {
        NOT_REGISTERED((short) 1),
        GUESSED_CORRECTLY((short) 2),
        GUESSED_WRONGLY((short)3),
        GAME_OVER((short) 4),
        WON_THE_GAME((short) 5);

        private short code;

        private Status(short code) {
            this.code = code;
        }

        public short getCode() {
            return code;
        }
    }

    private ORB orb;
    private static Map<String, GameBean> registeredStudent = new HashMap<String, GameBean>();
    private static Random random = new Random();
    public static final int NUM_OF_TRY = 5;

    private boolean isUserRegistered(String name) {
        return registeredStudent.keySet().contains(name);
    }

    public void createORB(ORB orb) {
        this.orb = orb;
    }


    public boolean start(String name) {
        String word = randWord();
        if (isUserRegistered(name)) {
            registeredStudent.remove(name);
            registeredStudent.put(name, new GameBean(word));
        }else{
            registeredStudent.put(name, new GameBean(word));
        }

        System.out.println(String.format("Magic word for %s is [ %s ]", name, word));
        return true;
    }

    public String guessedWord(String name) {
        if (!isUserRegistered(name)) {
            return null;
        }

        GameBean bean = registeredStudent.get(name);
        char[] guesses = bean.getGuesses();
        return String.valueOf(guesses);
    }

    /**
     * @param name
     * @param guess
     * @return -1 means that the user is not yet registered ~
     * 5 means that you win the game
     */
    public short play(String name, char guess) {
        if (!isUserRegistered(name)) {
            return -1;
        }

        GameBean bean = registeredStudent.get(name);
        String assignedRandomWord = bean.getRandomWord();
        int life = bean.getLife();
        String format = "New Magic Word for %s is [ %s ]";
        if (assignedRandomWord.contains(String.valueOf(guess))) {
            bean.setGuessChar(guess);
            String guessed = String.valueOf(bean.getGuesses());
            if (assignedRandomWord.equals(guessed)) {
                bean.setLife(life + 1);
                bean.setNomOfTry(0);
                String newRandWord = randWord();
                System.out.println(String.format(format, name, newRandWord));
                bean.setRandomWord(newRandWord);
                String message = "Congratulations! You guessed the magic word.";
                String lifeStr = "Your remaining life is " + bean.getLife();
                System.out.println(message + "\n" + lifeStr);
                return WON_THE_GAME.getCode();
            } else {
                return GUESSED_CORRECTLY.getCode();
            }
        }

        if (bean.getNomOfTry() + 1 == NUM_OF_TRY) {
            String message = "Sorry, you exceeded the number of tries to guess the word is reached. magic word was: " + String.valueOf(assignedRandomWord);
            String lifeStr = "Your remaining life is " + bean.getLife();
            bean.setLife(life - 1);
            bean.setNomOfTry(0);
            String newRandWord = randWord();
            System.out.println(String.format(format, name, newRandWord));
            bean.setRandomWord(newRandWord);
            System.out.println(message + "\n" + lifeStr);
            return GAME_OVER.getCode();

        }

        int numberOfTries = bean.getNomOfTry() + 1;
        bean.setNomOfTry(numberOfTries);
        return GUESSED_WRONGLY.getCode();
    }

    public boolean inPlay(String name) {
        if (!isUserRegistered(name)) {
            return false;
        }

        GameBean bean = registeredStudent.get(name);
        return !(bean.getLife() == 0);
    }


    public void shutdown() {
    }


    public short length(String name) {
        if (!isUserRegistered(name)) {
            return -1;
        }

        GameBean bean = registeredStudent.get(name);
        return (short) bean.getRandomWord().length();
    }


    public String randWord() {
        List<String> allLines = Launcher.allLines;
        int randomNum = randInt(0, allLines.size());
        return allLines.get(randomNum);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
