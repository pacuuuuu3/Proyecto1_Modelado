package proyecto1;
/*Enumeración para definir tipos permitidos por la gramática del proyecto.*/
/**
 *Enumeración que define tipos permitidos por la gramática de nuestro proyecto.
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public enum Tipo{
    PARENTESISI(Clasificacion.PARENTESIS), PARENTESISD(Clasificacion.PARENTESIS), MAS(Clasificacion.BINARIO), 
	MENOS(Clasificacion.BINARIO), POR(Clasificacion.BINARIO), ENTRE(Clasificacion.BINARIO),
	NUMERO(Clasificacion.OPERANDO),VARIABLE(Clasificacion.OPERANDO), POTENCIA(Clasificacion.BINARIO), 
	SENO(Clasificacion.UNARIO), COSENO(Clasificacion.UNARIO), TANGENTE(Clasificacion.UNARIO), 
	SECANTE(Clasificacion.UNARIO), COSECANTE(Clasificacion.UNARIO), COTANGENTE(Clasificacion.UNARIO);
	
    private Clasificacion clasificacion;
    
    /*Constructor que define la clasificación del tipo*/
    private Tipo(Clasificacion clas){
	this.clasificacion = clas;
    }
    
    /**
     *Regresa la clasficiación del tipo
     *@return La clasificación del tipo
     */
    public Clasificacion getClasificacion(){
	return this.clasificacion;
    }
}