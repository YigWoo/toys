package semantics.safety; /***
 * Excerpted from "Language Implementation Patterns",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book information.
***/
// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g 2009-09-23 17:37:51

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Def extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "METHOD_DECL", "ARG_DECL", "BLOCK", "VAR_DECL", "FIELD_DECL", "CALL", "ELIST", "EXPR", "UNARY_MINUS", "UNARY_NOT", "ASSIGN", "INDEX", "ID", "INT", "FLOAT", "CHAR", "LETTER", "WS", "SL_COMMENT", "'struct'", "'{'", "'}'", "';'", "'[]'", "'('", "')'", "','", "'float'", "'int'", "'char'", "'boolean'", "'void'", "'if'", "'else'", "'return'", "'!='", "'=='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'!'", "'['", "']'", "'.'", "'true'", "'false'"
    };
    public static final int INDEX=15;
    public static final int T__42=42;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int EXPR=11;
    public static final int T__51=51;
    public static final int T__47=47;
    public static final int FLOAT=18;
    public static final int T__50=50;
    public static final int FIELD_DECL=8;
    public static final int BLOCK=6;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int UNARY_MINUS=12;
    public static final int INT=17;
    public static final int UNARY_NOT=13;
    public static final int T__27=27;
    public static final int ASSIGN=14;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int METHOD_DECL=4;
    public static final int T__48=48;
    public static final int T__54=54;
    public static final int T__34=34;
    public static final int SL_COMMENT=22;
    public static final int ELIST=10;
    public static final int ID=16;
    public static final int LETTER=20;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int ARG_DECL=5;
    public static final int WS=21;
    public static final int CHAR=19;
    public static final int T__44=44;
    public static final int T__33=33;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__32=32;
    public static final int CALL=9;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int VAR_DECL=7;
    public static final int T__41=41;

    // delegates
    // delegators


        public Def(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public Def(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return Def.tokenNames; }
    public String getGrammarFileName() { return "/Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g"; }


        SymbolTable symtab;
        Scope currentScope;
        MethodSymbol currentMethod;
        public Def(TreeNodeStream input, SymbolTable symtab) {
            this(input);
            this.symtab = symtab;
            currentScope = symtab.globals;
        }



    // $ANTLR start "topdown"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:20:1: topdown : ( enterBlock | enterMethod | enterStruct | atoms | varDeclaration | ret );
    public final void topdown() throws RecognitionException {
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:21:5: ( enterBlock | enterMethod | enterStruct | atoms | varDeclaration | ret )
            int alt1=6;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt1=1;
                }
                break;
            case METHOD_DECL:
                {
                alt1=2;
                }
                break;
            case 23:
                {
                alt1=3;
                }
                break;
            case ID:
                {
                alt1=4;
                }
                break;
            case ARG_DECL:
            case VAR_DECL:
            case FIELD_DECL:
                {
                alt1=5;
                }
                break;
            case 38:
                {
                alt1=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:21:9: enterBlock
                    {
                    pushFollow(FOLLOW_enterBlock_in_topdown56);
                    enterBlock();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:22:9: enterMethod
                    {
                    pushFollow(FOLLOW_enterMethod_in_topdown66);
                    enterMethod();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:23:9: enterStruct
                    {
                    pushFollow(FOLLOW_enterStruct_in_topdown76);
                    enterStruct();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:24:9: atoms
                    {
                    pushFollow(FOLLOW_atoms_in_topdown86);
                    atoms();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:25:9: varDeclaration
                    {
                    pushFollow(FOLLOW_varDeclaration_in_topdown96);
                    varDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:26:9: ret
                    {
                    pushFollow(FOLLOW_ret_in_topdown106);
                    ret();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "topdown"


    // $ANTLR start "bottomup"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:29:1: bottomup : ( exitBlock | exitMethod | exitStruct );
    public final void bottomup() throws RecognitionException {
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:30:5: ( exitBlock | exitMethod | exitStruct )
            int alt2=3;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt2=1;
                }
                break;
            case METHOD_DECL:
                {
                alt2=2;
                }
                break;
            case 23:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:30:9: exitBlock
                    {
                    pushFollow(FOLLOW_exitBlock_in_bottomup125);
                    exitBlock();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:31:9: exitMethod
                    {
                    pushFollow(FOLLOW_exitMethod_in_bottomup135);
                    exitMethod();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:32:9: exitStruct
                    {
                    pushFollow(FOLLOW_exitStruct_in_bottomup145);
                    exitStruct();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bottomup"


    // $ANTLR start "enterBlock"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:37:1: enterBlock : BLOCK ;
    public final void enterBlock() throws RecognitionException {
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:38:5: ( BLOCK )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:38:9: BLOCK
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_enterBlock166); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              currentScope = new LocalScope(currentScope);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "enterBlock"


    // $ANTLR start "exitBlock"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:40:1: exitBlock : BLOCK ;
    public final void exitBlock() throws RecognitionException {
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:41:5: ( BLOCK )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:41:9: BLOCK
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_exitBlock187); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                      //System.out.println("locals: "+currentScope);
                      currentScope = currentScope.getEnclosingScope();    // pop scope
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exitBlock"


    // $ANTLR start "enterStruct"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:49:1: enterStruct : ^( 'struct' ID ( . )+ ) ;
    public final void enterStruct() throws RecognitionException {
        CymbolAST ID1=null;

        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:50:5: ( ^( 'struct' ID ( . )+ ) )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:50:9: ^( 'struct' ID ( . )+ )
            {
            match(input,23,FOLLOW_23_in_enterStruct218); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID1=(CymbolAST)match(input,ID,FOLLOW_ID_in_enterStruct220); if (state.failed) return ;
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:50:23: ( . )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=METHOD_DECL && LA3_0<=54)) ) {
                    alt3=1;
                }
                else if ( (LA3_0==UP) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:50:23: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                      //System.out.println("line "+ID1.getLine()+": def struct "+(ID1!=null?ID1.getText():null));
                      StructSymbol ss = new StructSymbol((ID1!=null?ID1.getText():null), currentScope);
                      ss.def = ID1;
                      ID1.symbol = ss;
                      currentScope.define(ss); // def struct in current scope
                      currentScope = ss;       // set current scope to struct scope
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "enterStruct"


    // $ANTLR start "exitStruct"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:60:1: exitStruct : 'struct' ;
    public final void exitStruct() throws RecognitionException {
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:61:5: ( 'struct' )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:61:9: 'struct'
            {
            match(input,23,FOLLOW_23_in_exitStruct252); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                      //System.out.println("fields: "+currentScope);
                      currentScope = currentScope.getEnclosingScope();    // pop scope
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exitStruct"


    // $ANTLR start "enterMethod"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:69:1: enterMethod : ^( METHOD_DECL type ID ( . )* ) ;
    public final void enterMethod() throws RecognitionException {
        CymbolAST ID2=null;
        Type type3 = null;


        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:70:5: ( ^( METHOD_DECL type ID ( . )* ) )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:70:9: ^( METHOD_DECL type ID ( . )* )
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_enterMethod283); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_type_in_enterMethod285);
            type3=type();

            state._fsp--;
            if (state.failed) return ;
            ID2=(CymbolAST)match(input,ID,FOLLOW_ID_in_enterMethod287); if (state.failed) return ;
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:70:31: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=METHOD_DECL && LA4_0<=54)) ) {
                    alt4=1;
                }
                else if ( (LA4_0==UP) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:70:31: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                      //System.out.println("line "+ID2.getLine()+": def method "+(ID2!=null?ID2.getText():null));
                      MethodSymbol ms = new MethodSymbol((ID2!=null?ID2.getText():null),type3,currentScope);
                      currentMethod = ms;
                      ms.def = ID2;            // track AST location of def's ID
                      ID2.symbol = ms;         // track in AST
                      currentScope.define(ms); // def method in globals
                      currentScope = ms;       // set current scope to method scope
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "enterMethod"

    public static class ret_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "ret"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:82:1: ret : ^( 'return' . ) ;
    public final ret_return ret() throws RecognitionException {
        ret_return retval = new ret_return();
        retval.start = input.LT(1);

        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:83:5: ( ^( 'return' . ) )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:83:9: ^( 'return' . )
            {
            match(input,38,FOLLOW_38_in_ret320); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            matchAny(input); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {
              ((CymbolAST)retval.start).symbol = currentMethod;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ret"


    // $ANTLR start "exitMethod"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:86:1: exitMethod : METHOD_DECL ;
    public final void exitMethod() throws RecognitionException {
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:87:5: ( METHOD_DECL )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:87:9: METHOD_DECL
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_exitMethod348); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                      currentScope = currentScope.getEnclosingScope();    // pop method scope
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exitMethod"


    // $ANTLR start "atoms"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:96:1: atoms : {...}? ID ;
    public final void atoms() throws RecognitionException {
        CymbolAST t = (CymbolAST)input.LT(1);
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:99:5: ({...}? ID )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:99:8: {...}? ID
            {
            if ( !((t.hasAncestor(EXPR)||t.hasAncestor(ASSIGN))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "atoms", "t.hasAncestor(EXPR)||t.hasAncestor(ASSIGN)");
            }
            match(input,ID,FOLLOW_ID_in_atoms388); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              t.scope = currentScope;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "atoms"


    // $ANTLR start "varDeclaration"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:105:1: varDeclaration : ^( ( FIELD_DECL | VAR_DECL | ARG_DECL ) type ID ( . )? ) ;
    public final void varDeclaration() throws RecognitionException {
        CymbolAST ID4=null;
        Type type5 = null;


        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:106:5: ( ^( ( FIELD_DECL | VAR_DECL | ARG_DECL ) type ID ( . )? ) )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:106:9: ^( ( FIELD_DECL | VAR_DECL | ARG_DECL ) type ID ( . )? )
            {
            if ( input.LA(1)==ARG_DECL||(input.LA(1)>=VAR_DECL && input.LA(1)<=FIELD_DECL) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_type_in_varDeclaration428);
            type5=type();

            state._fsp--;
            if (state.failed) return ;
            ID4=(CymbolAST)match(input,ID,FOLLOW_ID_in_varDeclaration430); if (state.failed) return ;
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:106:50: ( . )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=METHOD_DECL && LA5_0<=54)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:106:50: .
                    {
                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {

                      //System.out.println("line "+ID4.getLine()+": def "+(ID4!=null?ID4.getText():null));
                      VariableSymbol vs = new VariableSymbol((ID4!=null?ID4.getText():null),type5);
                      vs.def = ID4;            // track AST location of def's ID
                      ID4.symbol = vs;         // track in AST
                      currentScope.define(vs);
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varDeclaration"


    // $ANTLR start "type"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:117:1: type returns [Type type] : ( ^( '[]' typeElement ) | typeElement );
    public final Type type() throws RecognitionException {
        Type type = null;

        Type typeElement6 = null;

        Type typeElement7 = null;


        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:119:5: ( ^( '[]' typeElement ) | typeElement )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            else if ( (LA6_0==ID||(LA6_0>=31 && LA6_0<=35)) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:119:9: ^( '[]' typeElement )
                    {
                    match(input,27,FOLLOW_27_in_type471); if (state.failed) return type;

                    match(input, Token.DOWN, null); if (state.failed) return type;
                    pushFollow(FOLLOW_typeElement_in_type473);
                    typeElement6=typeElement();

                    state._fsp--;
                    if (state.failed) return type;

                    match(input, Token.UP, null); if (state.failed) return type;
                    if ( state.backtracking==1 ) {
                      type = new ArrayType(typeElement6);
                    }

                    }
                    break;
                case 2 :
                    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:120:9: typeElement
                    {
                    pushFollow(FOLLOW_typeElement_in_type486);
                    typeElement7=typeElement();

                    state._fsp--;
                    if (state.failed) return type;
                    if ( state.backtracking==1 ) {
                      type = typeElement7;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "type"


    // $ANTLR start "typeElement"
    // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:123:1: typeElement returns [Type type] : ( 'float' | 'int' | 'char' | 'boolean' | 'void' | ID );
    public final Type typeElement() throws RecognitionException {
        Type type = null;

        CymbolAST t = (CymbolAST)input.LT(1);
        try {
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:130:5: ( 'float' | 'int' | 'char' | 'boolean' | 'void' | ID )
            // /Users/parrt/research/book/TPDSL/Book/code/semantics/safety/Def.g:
            {
            if ( input.LA(1)==ID||(input.LA(1)>=31 && input.LA(1)<=35) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return type;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            if ( state.backtracking==1 ) {

                  t.symbol = currentScope.resolve(t.getText()); // return Type
                  t.scope = currentScope;
                  type = (Type)t.symbol;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "typeElement"

    // Delegated rules


 

    public static final BitSet FOLLOW_enterBlock_in_topdown56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enterMethod_in_topdown66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enterStruct_in_topdown76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atoms_in_topdown86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDeclaration_in_topdown96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ret_in_topdown106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitBlock_in_bottomup125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitMethod_in_bottomup135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitStruct_in_bottomup145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_enterBlock166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_exitBlock187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_enterStruct218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterStruct220 = new BitSet(new long[]{0x007FFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_23_in_exitStruct252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_DECL_in_enterMethod283 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_enterMethod285 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_enterMethod287 = new BitSet(new long[]{0x007FFFFFFFFFFFF8L});
    public static final BitSet FOLLOW_38_in_ret320 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_METHOD_DECL_in_exitMethod348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atoms388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varDeclaration420 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_varDeclaration428 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ID_in_varDeclaration430 = new BitSet(new long[]{0x007FFFFFFFFFFFF8L});
    public static final BitSet FOLLOW_27_in_type471 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_typeElement_in_type473 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_typeElement_in_type486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeElement0 = new BitSet(new long[]{0x0000000000000002L});

}
