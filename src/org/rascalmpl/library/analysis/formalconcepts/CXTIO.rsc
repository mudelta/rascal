module analysis::formalconcepts::CXTIO
import IO;
import String;
import List;
import Set;
import analysis::formalconcepts::FCA;

@doc{Read object attribute in .cxt format.}   
public FormalContext[str, str] readCxt(loc input)  {
    list[str] d = readFileLines(input);
    map[str, set[str]] vb1 = ();
    int nRows = toInt(d[2]);
    int nCols = toInt(d[3]);
    int theStart = 5+nRows+nCols;
    list[str] e = tail(d, size(d)-theStart);
    int idx = 5;
    map [str, set[str]] vb = ();
    for (str f <- e) {
         set[str] b = {d[5+nRows+i]|int i<-[0, 1..(size(f)-1)], charAt(f,i)==88};
         vb[d[idx]] = b;
         idx = idx+1;
         }
    return toFormalContext(vb);
    }
   