package proyecto1;
/*Clase que contiene un boolean y un mensaje de error*/
/**
 *Clase para representar un boolean con un mensaje de error
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class MsjBoolean{
    
    private boolean bool;
    private String mensaje;
    
    public MsjBoolean(){
	this.bool = true;
    }

    public MsjBoolean(String mensaje){
	this.bool = false;
	this.mensaje = mensaje;
    }

    public boolean getBoolean(){
	return this.bool;
    }

    public String getMensaje(){
	return this.mensaje;
    }
}