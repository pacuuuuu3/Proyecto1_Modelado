package proyecto1;
/*Clase que representa una ficha con su tipo y valor, 
 *la cual será evaluada.*/
/**
 *Clase para representar una ficha con tipo y valor.
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class Ficha{
    private Tipo tipo;
    private String valor;
    
    /**
     *Construye una ficha a partir de un tipo y un valor
     *@param tipo El tipo de la ficha que se va a construir
     *@param valor El valor que contendra la ficha
     */
    public Ficha(Tipo tipo, String valor){
	this.valor = valor;
	this.tipo = tipo;
    }

    /**
     *Construye una ficha a partir de su tipo
     *@param tipo El tipo de la ficha a construir
     */
    public Ficha(Tipo tipo){
	this.tipo = tipo;
    }

    /**
     *Regresa el valor de una ficha
     *@return El valor de la ficha
     */
    public String getValor(){
	switch(this.tipo){
	case PARENTESISI:
	    return "(";
	case PARENTESISD:
	    return ")";
	case MAS:
	    return "+";
	case MENOS:
	    return "-";
	case POR:
	    return "*";
	case ENTRE:
	    return "/";
	case NUMERO:
	case VARIABLE:
	    return this.valor;
	case POTENCIA:
	    return "^";
	case SENO:
	    return "sin";
	case COSENO:
	    return "cos";
	case TANGENTE:
	    return "tan";
	case SECANTE:
	    return "sec";
	case COSECANTE:
	    return "csc";
	case COTANGENTE:
	    return "cot";	    
	}
	return null;
    }

    /**
     *Le pone un valor a una ficha
     *@param valor El valor a ponerle a la ficha
     */
    public void setValor(String valor){
	this.valor = valor;
    }
    
    /**
     *Le pone asigna tipo a una ficha
     *@param tipo El tipo a ponerle a la ficha
     */
    public void setTipo(Tipo tipo){
	this.tipo = tipo;
    }
    
    /**
     *Regresa el tipo de una ficha
     *@return El tipo de la ficha
     */
    public Tipo getTipo(){
	return this.tipo;
    }
    
    /**
     *Regresa el valor de la ficha
     *@return Un String con el valor de la ficha
     */
    @Override public String toString(){
	return this.getValor();
    }
}
