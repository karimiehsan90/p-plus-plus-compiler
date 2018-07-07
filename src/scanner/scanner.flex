package scanner;
import java_cup.runtime.*;
import parsers.Sym;

%%


%cup
%line
%column
%unicode
%class LexerAnalyser
%public
%eofval{
    return symbol(parsers.Sym.EOF,"$");
%eofval}
%{
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
        System.out.println(Sym.terminalNames[type] + " : " + value);
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
begin = "begin"
bool = "bool"
break = "break"
case = "case"
char = "char"
const = "const"
continue = "continue"
default = "default"
double = "double"
else = "else"
end = "end"
extern = "extern"
false = "false"
function = "function"
float = "float"
for = "for"
if = "if"
int = "int"
long = "long"
return = "return"
record = "record"
sizeof = "sizeof"
string = "string"
switch = "switch"
true = "true"
foreach = "foreach"
of = "of"
in = "in"
repeat = "repeat"
until = "until"
minusMinus = \-\-
plusPlus = \+\+
IC = \d+
LC = {IC}L
RNumber = \.\d+|\d+\.\d*
ID = [a-zA-Z_][a-zA-Z_0-9]*
LineComment = ##[^\n]*
Equal = ==
NotEqual = \!=
LessEqual = <=
Less = <
Bigger = >
BiggerEqual = >=
Assign = =
Not = not
BitwiseNegative = \~
ArithmeticAnd = &
LogicalAnd = and
ArithmeticOr = \|
LogicalOr = or
Xor = \^
Production = \*
Add = \+
AdditionAssign = \+=
SubtractionAssign = \-=
MultiplicationAssign = \*=
DivisionAssign = \/=
SubAndUnaryMinus = \-
Div = \/
Mod = %
OpeningCurlyBrace = \{
ClosingCurlyBrace = \}
OpeningParenthesis = \(
ClosingParenthesis = \)
OpeningBrace = \[
ClosingBrace = \]
Dot = \.
Comma = ,
Colon = :
SemiColon = ;
WhiteSpace = \s+
HexNumber = 0[xX][0-9a-fA-F]+
Str = \"([^\\\"\n]|(\\.))*\"
ScienceNumber = ({RNumber}|{IC})[eE][-+]?{IC}
MultiLineComment = \/#([^#]|[\s]|(#+([^#/]|[\s])))*#+\/
Char = \'([^\\\']|\\.)\'

%%

{Char} {return symbol(Sym.char_const,yytext());}
{ScienceNumber} {
    String text = yytext();
    text = text.toUpperCase();
    String[] strs = text.split("E");
    if(strs[0].startsWith(".")){
        strs[0] = "0" + strs[0];
    }
    Double f = Double.valueOf(strs[0]);
    Integer i = Integer.valueOf(strs[1]);
    f = f * Math.pow(10,i);
    System.out.println(f);
    return symbol(Sym.real_const,String.valueOf(f));
}
{LC} { return symbol(Sym.long_const,yytext()); }
{until} { return symbol(Sym.until,yytext()); }
{repeat} {return symbol(Sym.repeat,yytext());}
{in} {return symbol(Sym.in,yytext());}
{IC} { return symbol(Sym.ic,yytext()); }
{RNumber} {
    String text = yytext();
    if(text.startsWith(".")){
        text = "0" + text;
    }
    return symbol(Sym.real_const,text);
}
{LineComment} {}
{Equal} { return symbol(Sym.eq,yytext()); }
{NotEqual} { return symbol(Sym.neq,yytext()); }
{LessEqual} { return symbol(Sym.lte,yytext()); }
{Less} { return symbol(Sym.lt,yytext()); }
{Bigger} { return symbol(Sym.gt,yytext()); }
{BiggerEqual} { return symbol(Sym.gte,yytext()); }
{Assign} { return symbol(Sym.assign,yytext()); }
{Not} { return symbol(Sym.notLog,yytext()); }
{BitwiseNegative} { return symbol(Sym.not,yytext()); }
{ArithmeticAnd} { return symbol(Sym.andArith,yytext()); }
{LogicalAnd} { return symbol(Sym.andLog,yytext()); }
{ArithmeticOr} { return symbol(Sym.orArith,yytext()); }
{LogicalOr} { return symbol(Sym.orLog,yytext()); }
{Xor} { return symbol(Sym.xor,yytext()); }
{of} { return symbol(Sym.of,yytext()); }
{Production} { return symbol(Sym.prod,yytext()); }
{Add} { return symbol(Sym.plus,yytext()); }
{AdditionAssign} { return symbol(Sym.addAssign,yytext()); }
{SubtractionAssign} { return symbol(Sym.subAssign,yytext()); }
{MultiplicationAssign} { return symbol(Sym.prodAssign,yytext()); }
{DivisionAssign} { return symbol(Sym.divAssign,yytext()); }
{SubAndUnaryMinus} { return symbol(Sym.minus,yytext()); }
{Div} { return symbol(Sym.div,yytext()); }
{Mod} { return symbol(Sym.mod,yytext()); }
{OpeningCurlyBrace} { return symbol(Sym.openCurly,yytext()); }
{ClosingCurlyBrace} { return symbol(Sym.closeCurly,yytext()); }
{OpeningParenthesis} { return symbol(Sym.openParen,yytext()); }
{ClosingParenthesis} { return symbol(Sym.closeParen,yytext()); }
{OpeningBrace} { return symbol(Sym.openBrace,yytext()); }
{ClosingBrace} { return symbol(Sym.closeBrace,yytext()); }
{Dot} { return symbol(Sym.dot,yytext()); }
{Comma} { return symbol(Sym.comma,yytext()); }
{Colon} { return symbol(Sym.colon,yytext()); }
{SemiColon} { return symbol(Sym.semiColon,yytext()); }
{WhiteSpace} {}
{HexNumber} {
    String text = yytext().toUpperCase();
    long l = Long.parseLong(text.substring(2), 16);
    return symbol(Sym.ic,l + "");
}
{string} { return symbol(Sym.string,yytext()); }
{MultiLineComment} {}
{begin} {return symbol(Sym.begin,yytext());}
{break} {return symbol(Sym.breakTer,yytext());}
{case} {return symbol(Sym.caseTer,yytext());}
{char} {return symbol(Sym.charTer,yytext());}
{const} {return symbol(Sym.constTer,yytext());}
{continue} {return symbol(Sym.continueTer,yytext());}
{default} {return symbol(Sym.defaultTer,yytext());}
{double} {return symbol(Sym.doubleTer,yytext());}
{else} {return symbol(Sym.elseTer,yytext());}
{end} {return symbol(Sym.end,yytext());}
{extern} {return symbol(Sym.extern,yytext());}
{false} {return symbol(Sym.bool_const,yytext());}
{function} {return symbol(Sym.function,yytext());}
{float} {return symbol(Sym.floatTer,yytext());}
{foreach} {return symbol(Sym.foreach,yytext());}
{for} {return symbol(Sym.forTer,yytext());}
{long} {return symbol(Sym.longTer,yytext());}
{if} {return symbol(Sym.ifTer,yytext());}
{int} {return symbol(Sym.intTer,yytext());}
{return} {return symbol(Sym.returnTer,yytext());}
{record} {return symbol(Sym.record,yytext());}
{sizeof} {return symbol(Sym.sizeof,yytext());}
{Str} {return symbol(Sym.string_const,yytext());}
{switch} {return symbol(Sym.switchTer,yytext());}
{true} {return symbol(Sym.bool_const,yytext());}
{minusMinus} { return symbol(Sym.MinusMinus,yytext());}
{plusPlus} { return symbol(Sym.PlusPlus,yytext());}
{ID} { return symbol(Sym.id,yytext()); }
