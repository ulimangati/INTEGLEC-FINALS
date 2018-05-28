import twistwordApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.*;
import java.io.*;
import java.lang.*;
public class twistwordClient {
	private String questionsFilename;
	private String question;
	private int totalTriesAllowed;
	private int numberOfQuestionsAnswered;
	private int numberOfTries;
	private int numberOfQuestions;
	private int score;
	private String triedLetters;
	private String validChars;
	private ArrayList<String> questions;
	private ArrayList<String> possibleAnswers;
	private ArrayList<String> answers;
	private ArrayList<Integer> questionNumbers;
	private TextFile textFile;
	static Scanner kb = new Scanner (System.in);
	static Twist twist;

	public static void main(String args[]) {
		twistword twistwordImpl;
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// get the root naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			
			// Use NamingContextExt instead of
            // NamingContext. This is part of the
            // Interoperable naming Service.  
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
            // resolve the Object Reference in Naming
            String name = "twistword";
            twistwordImpl = twistwordHelper.narrow(ncRef.resolve_str(name));
			System.out.println("Obtained a handle on server object: " + twistwordImpl);
			char choice = ' ';

		while (choice != '0'){
			System.out.println("\nWEBTECH GAME PROJECT");
			System.out.println("---------------------");
			System.out.println("1. Start the game ");
			System.out.println("0. Exit ");
			System.out.println("---------------------");
			System.out.print("Enter your choice: ");
			choice = kb.next().charAt(0);
			switch (choice){
				case '1':
					twist= new Twist("words.txt");
					twist.starter();
					break;
				case '0':
					System.out.println("Thank you for playing.");
					break;
				default:
					System.out.println("Invalid choice. ");
			}
		}



            
		} catch (Exception e) {
            System.out.println("ERROR : " + e) ;
	        e.printStackTrace(System.out);
	    }
	}
}


