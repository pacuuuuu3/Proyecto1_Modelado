package proyecto1.test;
import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import proyecto1.*;

/*Clase para probar el Clasificador*/
/**
 *Clase para probar la clase {@link Clasificador}
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */

public class TestClasificador{
    
    /**
     * Prueba unitaria para {@link Clasificador#dameLista}.
     */
    @Test public void testDameLista(){
	String parentesis = "()";
	LinkedList<Ficha> lista = Clasificador.dameLista(parentesis);
	Assert.assertTrue(lista.size() == 2);
	Assert.assertTrue(lista.get(0).getTipo() == Tipo.PARENTESISI);
	Assert.assertTrue(lista.get(1).getTipo() == Tipo.PARENTESISD);
	String izquierdo = "(";
	lista = Clasificador.dameLista(izquierdo);
	Assert.assertTrue(lista.size() == 1);
	Assert.assertTrue(lista.get(0).getTipo() == Tipo.PARENTESISI);
	String espaciado = "(+ x 2)";
	lista = Clasificador.dameLista(espaciado);
	Assert.assertTrue(lista.size() == 5);
	String derecho = ")";
	lista = Clasificador.dameLista(derecho);
	Assert.assertTrue(lista.size() == 1);
	Assert.assertTrue(lista.get(0).getTipo() == Tipo.PARENTESISD);
	String complicado = "(sin(cos(tan(cot(sec(csc(+(-(*(/(^ x 1)1)2)3)4)))))))";
	lista = Clasificador.dameLista(complicado);
		Assert.assertTrue(lista.size() == 39);
		Assert.assertTrue(lista.get(0).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(1).getTipo() == Tipo.SENO);
		Assert.assertTrue(lista.get(2).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(3).getTipo() == Tipo.COSENO);
		Assert.assertTrue(lista.get(4).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(5).getTipo() == Tipo.TANGENTE);
		Assert.assertTrue(lista.get(6).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(7).getTipo() == Tipo.COTANGENTE);
		Assert.assertTrue(lista.get(8).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(9).getTipo() == Tipo.SECANTE);
		Assert.assertTrue(lista.get(10).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(11).getTipo() == Tipo.COSECANTE);
		Assert.assertTrue(lista.get(12).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(13).getTipo() == Tipo.MAS);
		Assert.assertTrue(lista.get(14).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(15).getTipo() == Tipo.MENOS);
		Assert.assertTrue(lista.get(16).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(17).getTipo() == Tipo.POR);
		Assert.assertTrue(lista.get(18).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(19).getTipo() == Tipo.ENTRE);
		Assert.assertTrue(lista.get(20).getTipo() == Tipo.PARENTESISI);
		Assert.assertTrue(lista.get(21).getTipo() == Tipo.POTENCIA);
		Assert.assertTrue(lista.get(22).getTipo() == Tipo.VARIABLE && lista.get(22).getValor().equals("x"));
		Assert.assertTrue(lista.get(23).getTipo() == Tipo.NUMERO && lista.get(23).getValor().equals("1"));
		Assert.assertTrue(lista.get(24).getTipo() == Tipo.PARENTESISD);
		Assert.assertTrue(lista.get(25).getTipo() == Tipo.NUMERO && lista.get(25).getValor().equals("1"));
		Assert.assertTrue(lista.get(26).getTipo() == Tipo.PARENTESISD);
		Assert.assertTrue(lista.get(27).getTipo() == Tipo.NUMERO && lista.get(27).getValor().equals("2"));
		Assert.assertTrue(lista.get(28).getTipo() == Tipo.PARENTESISD);
		Assert.assertTrue(lista.get(29).getTipo() == Tipo.NUMERO && lista.get(29).getValor().equals("3"));
		Assert.assertTrue(lista.get(30).getTipo() == Tipo.PARENTESISD);
		Assert.assertTrue(lista.get(31).getTipo() == Tipo.NUMERO && lista.get(31).getValor().equals("4"));
		for(int i = 32; i <39; ++i)
		    Assert.assertTrue(lista.get(i).getTipo() == Tipo.PARENTESISD);
    }
    
    /**
     * Prueba unitaria para {@link Clasificador#listaValida}.
     */
    @Test public void testListaValida(){
	String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13;
	s1 = "(x + 2)(x + 4)";
	s2 = "(()))";
	s3 = "()";
	s4 = "(()";
	s5 = "+ 2 2";
	s6 = "sin x x";
	s7 = "(sin x 2)";
	s8 = "(+ x 3)";
	s9 = "(* 1 1)";
	s10 = "(sin 4)";
	s11 = "(0.2)";
	s12 = "(+ (* x 3) (^ -3.009 (/ 4 2)))";
	s13 = "(+(* x 3) +(^ -3.009 (/ 4 2)))";
	String s14 ="(sin(cos(tan(cot(sec(csc(+(-(*(/(^ x 1)1)2)3)4)))))))";
	LinkedList<Ficha> l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
	l1 = Clasificador.dameLista(s1);
	l2 = Clasificador.dameLista(s2);
	l3 = Clasificador.dameLista(s3);
	l4 = Clasificador.dameLista(s4);
	l5 = Clasificador.dameLista(s5);
	l6 = Clasificador.dameLista(s6);
	l7 = Clasificador.dameLista(s7);
	l8 = Clasificador.dameLista(s8);
	l9 = Clasificador.dameLista(s9);
	l10 = Clasificador.dameLista(s10);
	l11 = Clasificador.dameLista(s11);
	l12 = Clasificador.dameLista(s12);
	l13 = Clasificador.dameLista(s13);
	l14 = Clasificador.dameLista(s14);
	Assert.assertFalse(Clasificador.listaValida(l1).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l2).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l3).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l4).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l5).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l6).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l7).getBoolean());
	Assert.assertTrue(Clasificador.listaValida(l8).getBoolean());
	Assert.assertTrue(Clasificador.listaValida(l9).getBoolean());
	Assert.assertTrue(Clasificador.listaValida(l10).getBoolean());
	Assert.assertTrue(Clasificador.listaValida(l11).getBoolean());
	Assert.assertTrue(Clasificador.listaValida(l12).getBoolean());
	Assert.assertFalse(Clasificador.listaValida(l13).getBoolean());
	Assert.assertTrue(Clasificador.listaValida(l14).getBoolean());
    }

    /**
     *Prueba que el programa tire excepción con múltiples espacios
     */
    @Test (expected = ExcepcionSintaxisInvalida.class)
	public void testExcepciones1(){
	String s = "(+ x  x)";
	LinkedList<Ficha> l = Clasificador.dameLista(s);
    }

    /**
     *Prueba que el programa tire excepción con dos operadores seguidos
     */
    @Test (expected = ExcepcionSintaxisInvalida.class)
	public void testExcepciones2(){
	String s = "(++ x)";
	LinkedList<Ficha> l = Clasificador.dameLista(s);
    }

    /**
     *Prueba que el programa tire excepción con dos puntos
     */
    @Test (expected = ExcepcionSintaxisInvalida.class)
	public void testExcepciones3(){
	String s = "2..2";
	LinkedList<Ficha> l = Clasificador.dameLista(s);
    }

    /**
     *Prueba que el programa tire excepción con un número seguido de un espacio
     */
    @Test (expected = ExcepcionSintaxisInvalida.class)
	public void testExcepciones4(){
	String s = "(2 )";
	LinkedList<Ficha> l = Clasificador.dameLista(s);
    }

    /**
     *Prueba que el programa tire excepción si la expresión comienza en espacio
     */
    @Test (expected = ExcepcionSintaxisInvalida.class)
	public void testExcepciones5(){
	String s = " (+ x 2)";
	LinkedList<Ficha> l = Clasificador.dameLista(s);
    }

    /**
     *Prueba que el programa tire excepción si la expresión termina en espacio
     */
    @Test (expected = ExcepcionSintaxisInvalida.class)
	public void testExcepciones6(){
	String s = "(* x 3) ";
	LinkedList<Ficha> l = Clasificador.dameLista(s);
    }
}