package mainfiles;

/**
* mainfiles/HangmanHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from mainfiles.idl
* Wednesday, May 9, 2018 2:42:35 PM SGT
*/

public final class HangmanHolder implements org.omg.CORBA.portable.Streamable
{
  public mainfiles.Hangman value = null;

  public HangmanHolder ()
  {
  }

  public HangmanHolder (mainfiles.Hangman initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = mainfiles.HangmanHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    mainfiles.HangmanHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return mainfiles.HangmanHelper.type ();
  }

}
