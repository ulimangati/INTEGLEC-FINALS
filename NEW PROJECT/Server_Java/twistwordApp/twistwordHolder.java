package twistwordApp;

/**
* twistwordApp/twistwordHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ../IDL/twistwordApp.idl
* Monday, May 28, 2018 11:38:34 AM SGT
*/

public final class twistwordHolder implements org.omg.CORBA.portable.Streamable
{
  public twistwordApp.twistword value = null;

  public twistwordHolder ()
  {
  }

  public twistwordHolder (twistwordApp.twistword initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = twistwordApp.twistwordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    twistwordApp.twistwordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return twistwordApp.twistwordHelper.type ();
  }

}
