package proyecto1;
import java.util.LinkedList;
/*Clase que construye un árbol para evaluar expresiones*/
/**
 *Construye un árbol utilizado para evaluar expresiones.
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */

public class Creador{
    
    /**
     *Regresa un árbol para evaluar las expresiones dadas por la lista.
     *@param lista La lista de fichas con expresiones por evaluar.
     *@return El árbol sobre el que se evaluará la expresión
     */
    public static Nodo<Ficha> dameArbol(LinkedList<Ficha> lista)
	throws ExcepcionSintaxisInvalida{
	MsjBoolean bool = Clasificador.listaValida(lista);
	if(!bool.getBoolean())
	    throw new ExcepcionSintaxisInvalida(bool.getMensaje());
	Nodo<Ficha> anterior,raiz,nuevo, padre;
	anterior = raiz = nuevo = null;
	Tipo tipo;
	for(Ficha ficha: lista){
	    tipo = ficha.getTipo();
	    if(tipo.getClasificacion() == Clasificacion.PARENTESIS)
		continue;
	    else{
		if(anterior == null){
		    anterior = new Nodo<Ficha>(ficha);
		    raiz = anterior;
		}else{
		    tipo = anterior.getElemento().getTipo();
		    nuevo = new Nodo<Ficha>(ficha);
		    if(tipo.getClasificacion() == Clasificacion.OPERANDO){
			padre = anterior.getPadre();
			if(!padre.hayDerecho() && padre.getElemento().getTipo().getClasificacion() == Clasificacion.BINARIO){
			    padre.setDerecho(nuevo);
			    nuevo.setPadre(padre);
			}else{
			    while(padre.hayDerecho() || padre.getElemento().getTipo().getClasificacion() == Clasificacion.UNARIO)
				padre = padre.getPadre();
			    padre.setDerecho(nuevo);
			    nuevo.setPadre(padre);
			}
		    }else{
			anterior.setIzquierdo(nuevo);
			nuevo.setPadre(anterior);
		    }
		    anterior = nuevo;
		}    
	    }   
	}
	return raiz;
    }
}