package proyecto1.test;
import proyecto1.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
/*Clase para probar la clase Creador*/
/**
 *Clase para pruebas unitarias de la clase {@link Creador}.
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class TestCreador{
    
    /**                                                                                                                                       
     * Prueba unitaria para {@link Creador#dameArbol}.                                                                                   
     */
    @Test public void testDameArbol(){
	String prueba ="(sin(cos(tan(cot(sec(csc(+(-(*(/(^ x 1)1)2)3)4)))))))";
	LinkedList<Ficha> lista = Clasificador.dameLista(prueba);
	Nodo<Ficha> raiz = Creador.dameArbol(lista);
	Assert.assertTrue(verificaParentesis(raiz) == true); 
 	String trigo = "(+ (tan x) 2)";
	lista = Clasificador.dameLista(trigo);
	raiz = Creador.dameArbol(lista);
	Assert.assertTrue(raiz.getElemento().getTipo() == Tipo.MAS);
	Assert.assertTrue(raiz.getIzquierdo().getElemento().getTipo() == Tipo.TANGENTE);
	Assert.assertTrue(raiz.getDerecho().getElemento().getValor().equals("2"));
    }
    
    /*Método auxiliar para verificar si el árbol tiene paréntesis*/
    private static boolean verificaParentesis(Nodo<Ficha> raiz){
	boolean no_hay_parentesis = false;
	boolean iz = true;
	boolean der = true;
	Tipo tipo = raiz.getElemento().getTipo();
	if(tipo != Tipo.PARENTESISI && tipo != Tipo.PARENTESISD)
	    no_hay_parentesis = true;
	if(raiz.hayIzquierdo())
	    iz = verificaParentesis(raiz.getIzquierdo());
	if(raiz.hayDerecho())
	    der = verificaParentesis(raiz.getDerecho());
	return no_hay_parentesis && iz && der;
    }
    
}