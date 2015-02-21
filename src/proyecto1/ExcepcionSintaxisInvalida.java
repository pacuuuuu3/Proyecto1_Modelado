package proyecto1;
/*Clase para excepciones de sintaxis*/
/**
 *Clase para excepciones en la sintaxis de nuestra gramática
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */

public class ExcepcionSintaxisInvalida extends IllegalArgumentException{

    /**
     *Constructor vacío
     */
    public ExcepcionSintaxisInvalida(){
	super();
    }

    /**
     *Construye la excepción con una mensaje para el usuario
     *@param msj El mensaje para el usuario
     */
    public ExcepcionSintaxisInvalida(String msj){
	super(msj);
    }

}