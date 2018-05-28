package twistwordApp;


/**
* twistwordApp/twistwordPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../IDL/twistwordApp.idl
* Monday, May 28, 2018 11:38:05 AM SGT
*/

public abstract class twistwordPOA extends org.omg.PortableServer.Servant
 implements twistwordApp.twistwordOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("isAnswerCorrect", new java.lang.Integer (0));
    _methods.put ("isGameOver", new java.lang.Integer (1));
    _methods.put ("isLetterInString", new java.lang.Integer (2));
    _methods.put ("isLongestWord", new java.lang.Integer (3));
    _methods.put ("jumbleString", new java.lang.Integer (4));
    _methods.put ("getQuestion", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // twistwordApp/twistword/isAnswerCorrect
       {
         boolean $result = false;
         $result = this.isAnswerCorrect ();
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // twistwordApp/twistword/isGameOver
       {
         boolean $result = false;
         $result = this.isGameOver ();
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // twistwordApp/twistword/isLetterInString
       {
         char letter = in.read_char ();
         String str = in.read_string ();
         boolean $result = false;
         $result = this.isLetterInString (letter, str);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // twistwordApp/twistword/isLongestWord
       {
         String str = in.read_string ();
         boolean $result = false;
         $result = this.isLongestWord (str);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // twistwordApp/twistword/jumbleString
       {
         String str = in.read_string ();
         String $result = null;
         $result = this.jumbleString (str);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // twistwordApp/twistword/getQuestion
       {
         String $result = null;
         $result = this.getQuestion ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:twistwordApp/twistword:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public twistword _this() 
  {
    return twistwordHelper.narrow(
    super._this_object());
  }

  public twistword _this(org.omg.CORBA.ORB orb) 
  {
    return twistwordHelper.narrow(
    super._this_object(orb));
  }


} // class twistwordPOA