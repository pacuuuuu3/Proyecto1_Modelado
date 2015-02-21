package proyecto1.test;
import proyecto1.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
/*Clase para probar la clase Evaluador*/
/**
 *Clase para pruebas unitarias de la clase {@link Evaluador}.
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class TestEvaluador{
    
    private String s1,s2,s3,s4,s5,s6;
    
    /**
     *Construye varias funciones para probar
     */
    public TestEvaluador(){
	s1 = "x";
	s2 = "(sin x)";
	s3 = "2";
	s4 = "(tan x)";
	s5 = "(^ x 2)";
	s6 = "(^ x x)";
    }

    /**                                                                                                                                  
     * Prueba unitaria para {@link Evaluador#evalua}.                                                                                   
     */
    @Test public void testEvalua(){
	Nodo<Ficha> a1, a2, a3, a4, a5, a6;
	a1 = Creador.dameArbol(Clasificador.dameLista(s1));
	a2 = Creador.dameArbol(Clasificador.dameLista(s2));
	a3 = Creador.dameArbol(Clasificador.dameLista(s3));
	a4 = Creador.dameArbol(Clasificador.dameLista(s4));
	a5 = Creador.dameArbol(Clasificador.dameLista(s5));
	a6 = Creador.dameArbol(Clasificador.dameLista(s6));
	for(int i = -2000; i <2001; i++){
	    double x = 1000*Math.random();
	    Assert.assertTrue(Evaluador.evalua(x, a1) == x);
	    Assert.assertTrue(Evaluador.evalua(x, a2) == Math.sin(x));
	    Assert.assertTrue(Evaluador.evalua(x, a3) == 2);
	    Assert.assertTrue(Evaluador.evalua(x, a4) == Math.tan(x));
	    Assert.assertTrue(Evaluador.evalua(x, a5) == Math.pow(x, 2));
	    Assert.assertTrue(Evaluador.evalua(x, a6) == Math.pow(x,x));
	}
    }
}