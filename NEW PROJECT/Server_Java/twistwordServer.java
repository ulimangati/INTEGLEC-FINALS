import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import twistwordApp.*;
import java.util.*;
import java.io.*;

/**
* This is the Server program it allows client to connect to
* the twistword implementation
*
* @author Steven Mangati
*/

public class twistwordServer {

    public static void main(String args[]) {
       try {
          // create and initialize the ORB
          ORB orb = ORB.init(args, null);
          // get reference to rootpoa &
          // activate the POAManager
          POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
          rootpoa.the_POAManager().activate();
          
	        // create servant and register it 
	        // with the ORB
	        twistwordImpl twistwordImpl = new twistwordImpl();
	
	        // get object reference from the servant
	        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(twistwordImpl);
	        twistword href = twistwordHelper.narrow(ref);
	
			    // get the root naming context
	        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

          // Use NamingContextExt which is 
          // part of the Interoperable
          // Naming Service (INS) specification.
          NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		      // bind the Object Reference in Naming
          String name = "twistword";
          NameComponent path[] = ncRef.to_name(name);
          ncRef.rebind(path, href);

          System.out.println("twistword server ready and waiting ...");

          // wait for invocations from clients
          orb.run();

      } catch (Exception e) {
           System.err.println("ERROR: " + e);
           e.printStackTrace(System.out);
      }
      	  
        System.out.println("twistwordServer Exiting...");
   }
}


