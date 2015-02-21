package proyecto1;
import java.util.LinkedList;
/*Clase para evaluar las operaciones de un árbol en distintos valores*/
/**
 *Evalúa las operaciones de un árbol en distintos valores
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class Evaluador{
    
    /**
     *Evalúa las operaciones de un árbol dado en un punto
     *@param punto El punto sobre el cual se evalua
     *@param arbol El árbol que contiene las operaciones a evaluar
     *@return El resultado de la evaluación
     */
    public static double evalua(double punto, Nodo<Ficha> arbol){
	Ficha raiz = arbol.getElemento();
	Tipo tipo = raiz.getTipo();
	if(tipo == Tipo.VARIABLE){
	    if(raiz.getValor().equals("-x"))
		return (punto) * (-1);
	    else
		return punto;
	}
	else if(tipo == Tipo.NUMERO)
	    return Double.parseDouble(raiz.getValor());
	else{
	    switch (tipo){
	    case MAS:
		return evalua(punto, arbol.getIzquierdo()) + evalua(punto, arbol.getDerecho());
	    case MENOS:
		return evalua(punto, arbol.getIzquierdo()) - evalua(punto, arbol.getDerecho());
	    case POR:
		return evalua(punto, arbol.getIzquierdo()) * evalua(punto, arbol.getDerecho());
	    case ENTRE:
		return evalua(punto, arbol.getIzquierdo()) / evalua(punto, arbol.getDerecho());
	    case POTENCIA:
		double x1 = evalua(punto, arbol.getIzquierdo());
		double x2 = evalua(punto, arbol.getDerecho());
		if(x1 < 0){
		    if(x2 == Math.floor(x2))
			return Math.pow(x1, x2);
		    else
			return Double.NaN;
		}
		return Math.pow(x1, x2);
	    case SENO:
		return Math.sin(evalua(punto, arbol.getIzquierdo()));
	    case COSENO:
		return Math.cos(evalua(punto, arbol.getIzquierdo()));
	    case TANGENTE:
		return Math.tan(evalua(punto, arbol.getIzquierdo()));
	    case SECANTE:
		return 1/Math.cos(evalua(punto, arbol.getIzquierdo()));
	    case COSECANTE:
		return 1/Math.sin(evalua(punto, arbol.getIzquierdo()));
	    case COTANGENTE:
		return 1/Math.tan(evalua(punto, arbol.getIzquierdo()));
	    }
	}
	return 0;
    }
    
    /**
     *Convierte la evaluación de un punto a lo que tiene que ser en la escala de nuestra gráfica
     *@param resultado El resultado de la evaluación previamente realizada
     *@param x El punto que se evaluó
     *@param x1 El primer límite de las abscisas
     *@param x2 El segundo límite de las abscisas
     *@param y1 El primer límite de las ordenadas
     *@param y2 El segundo límite de las ordenadas
     *@param alto La altura de la ventana
     *@param ancho El ancho de la ventana
     *@return Las coordenadas que se van a graficar
     */
    public static double[] convierte(double resultado, double x, double ancho, double alto, 
				     double x1, double x2, double y1, double y2){
	double[] regreso = new double[2];
	double coordenada_x = ((x+ Math.abs(x1)) * ancho)/(x2-x1);
	double coordenada_y = ((Math.abs(y1)-resultado) * alto)/ (y2-y1);
	regreso[0] = coordenada_x;
	regreso[1] = coordenada_y;
	return regreso;
    }
}