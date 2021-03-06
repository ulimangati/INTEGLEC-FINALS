# Python stubs generated by omniidl from mainfiles.idl

import omniORB, _omnipy
from omniORB import CORBA, PortableServer
_0_CORBA = CORBA

_omnipy.checkVersion(3,0, __file__)


#
# Start of module "mainfiles"
#
__name__ = "mainfiles"
_0_mainfiles = omniORB.openModule("mainfiles", r"mainfiles.idl")
_0_mainfiles__POA = omniORB.openModule("mainfiles__POA", r"mainfiles.idl")


# interface Hangman
_0_mainfiles._d_Hangman = (omniORB.tcInternal.tv_objref, "IDL:mainfiles/Hangman:1.0", "Hangman")
omniORB.typeMapping["IDL:mainfiles/Hangman:1.0"] = _0_mainfiles._d_Hangman
_0_mainfiles.Hangman = omniORB.newEmptyClass()
class Hangman :
    _NP_RepositoryId = _0_mainfiles._d_Hangman[1]

    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")

    _nil = CORBA.Object._nil


_0_mainfiles.Hangman = Hangman
_0_mainfiles._tc_Hangman = omniORB.tcInternal.createTypeCode(_0_mainfiles._d_Hangman)
omniORB.registerType(Hangman._NP_RepositoryId, _0_mainfiles._d_Hangman, _0_mainfiles._tc_Hangman)

# Hangman operations and attributes
Hangman._d_start = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_boolean, ), None)
Hangman._d_guessedWord = (((omniORB.tcInternal.tv_string,0), ), ((omniORB.tcInternal.tv_string,0), ), None)
Hangman._d_play = (((omniORB.tcInternal.tv_string,0), omniORB.tcInternal.tv_char), (omniORB.tcInternal.tv_short, ), None)
Hangman._d_inPlay = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_boolean, ), None)
Hangman._d_shutdown = ((), None, None)
Hangman._d_length = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_short, ), None)

# Hangman object reference
class _objref_Hangman (CORBA.Object):
    _NP_RepositoryId = Hangman._NP_RepositoryId

    def __init__(self):
        CORBA.Object.__init__(self)

    def start(self, *args):
        return _omnipy.invoke(self, "start", _0_mainfiles.Hangman._d_start, args)

    def guessedWord(self, *args):
        return _omnipy.invoke(self, "guessedWord", _0_mainfiles.Hangman._d_guessedWord, args)

    def play(self, *args):
        return _omnipy.invoke(self, "play", _0_mainfiles.Hangman._d_play, args)

    def inPlay(self, *args):
        return _omnipy.invoke(self, "inPlay", _0_mainfiles.Hangman._d_inPlay, args)

    def shutdown(self, *args):
        return _omnipy.invoke(self, "shutdown", _0_mainfiles.Hangman._d_shutdown, args)

    def length(self, *args):
        return _omnipy.invoke(self, "length", _0_mainfiles.Hangman._d_length, args)

    __methods__ = ["start", "guessedWord", "play", "inPlay", "shutdown", "length"] + CORBA.Object.__methods__

omniORB.registerObjref(Hangman._NP_RepositoryId, _objref_Hangman)
_0_mainfiles._objref_Hangman = _objref_Hangman
del Hangman, _objref_Hangman

# Hangman skeleton
__name__ = "mainfiles__POA"
class Hangman (PortableServer.Servant):
    _NP_RepositoryId = _0_mainfiles.Hangman._NP_RepositoryId


    _omni_op_d = {"start": _0_mainfiles.Hangman._d_start, "guessedWord": _0_mainfiles.Hangman._d_guessedWord, "play": _0_mainfiles.Hangman._d_play, "inPlay": _0_mainfiles.Hangman._d_inPlay, "shutdown": _0_mainfiles.Hangman._d_shutdown, "length": _0_mainfiles.Hangman._d_length}

Hangman._omni_skeleton = Hangman
_0_mainfiles__POA.Hangman = Hangman
omniORB.registerSkeleton(Hangman._NP_RepositoryId, Hangman)
del Hangman
__name__ = "mainfiles"

#
# End of module "mainfiles"
#
__name__ = "mainfiles_idl"

_exported_modules = ( "mainfiles", )

# The end.
