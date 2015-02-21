package proyecto1;
/*Clase para representar un árbol binario genérico*/
/**
 *Clase que representa un árbol binario genérico
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class Nodo<T>{

    private T elemento;
    private Nodo<T> izquierdo;
    private Nodo<T> derecho;
    private Nodo<T> padre;

    /**
     *Construye un nodo a partir de su elemento.
     *@param elemento El elemento del nodo
     */
    public Nodo(T elemento){
	this.elemento = elemento;
    }

    /**
     *Define el nodo izquierdo de nuestro nodo
     *@param izquierdo El nodo izquierdo de nuestro nodo.
     */
    public void setIzquierdo(Nodo<T> izquierdo){
	this.izquierdo = izquierdo;
    }
    
    /**
     *Define el nodo derecho de nuestro nodo
     *@param derecho El nodo derecho de nuestro nodo.
     */
    public void setDerecho(Nodo<T> derecho){
	this.derecho = derecho;
    }
    
    /**
     *Define el nodo padre de nuestro nodo
     *@param padre El nodo padre de nuestro nodo.
     */
    public void setPadre(Nodo<T> padre){
	this.padre = padre;
    }

    /**
     *Regresa el nodo padre
     *@return El nodo padre
     */
    public Nodo<T> getPadre(){
	return this.padre;
    }

    /**
     *Regresa el nodo izquierdo
     *@return El nodo izquierdo
     */
    public Nodo<T> getIzquierdo(){
	return this.izquierdo;
    }
    
    /**
     *Regresa el nodo derecho
     *@return El nodo derecho
     */
    public Nodo<T> getDerecho(){
	return this.derecho;
    }

    /** 
     *Regresa el elemento de nuestro nodo
     *@return El elemento de nuestro nodo
     */
    public T getElemento(){
	return this.elemento;
    }

    /**
     *Nos dice si nuestro nodo tiene nodo izquierdo
     *@return Si hay o no nodo izquierdo
     */
    public boolean hayIzquierdo(){
	return this.izquierdo != null;
    }

    /**
     *Nos dice si nuestro nodo tiene nodo derecho
     *@return Si hay o no nodo derecho
     */
    public boolean hayDerecho(){
	return this.derecho != null;
    }

    /**
     *Nos dice si nuestro nodo tiene padre
     *@return Si el nodo tiene padre
     */
    public boolean hayPadre(){
	return this.padre != null;
    }
    
    /**
     *Convierte el Nodo a un String que representa a su elemento
     *@return Un String representante del elemento del nodo;
     */
    @Override public String toString(){
       return this.getElemento().toString();
   }
}