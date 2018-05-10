package corbaserver;

import mainfiles.Hangman;
import mainfiles.HangmanHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Launcher {

    public static List<String> allLines;

    public static void main(String[] args) {
        try {
            if (args.length != 5) {
                System.err.println("Usage: java Launcher <-ORBInitialPort> <PORT NUMBER> <-ORBInitialHost> <HOST/IP> <FILE PATH>");
                System.exit(1);
            }

            allLines = getAllLines(args[args.length - 1]);
            System.out.println(allLines.size());
            //create and initiate the ORB //// get reference to rootpoa &amp; activate the POAManager
            ORB orb = ORB.init(Arrays.copyOfRange(args, 0, args.length - 1), null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            //create servant and register it with ORB
            HangmanServant servant = new HangmanServant();
            servant.createORB(orb);


            //get object reference from the servant
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(servant);
            Hangman href = HangmanHelper.narrow(ref);

            // get the root naming context
            // NameService invokes the name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // Use NamingContextExt which is part of the Interoperable
            // Naming Service (INS) specification.
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // bind the Object Reference in Naming
            String name = "HangmanGame";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Hello Server ready and waiting ...!");

            orb.run();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        System.out.println("HelloServer Exiting ...");
    }

    private static List<String> getAllLines(String path) {
        if (!new File(path).exists()) {
            throw new IllegalArgumentException("The path is wrong!");
        }

        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
