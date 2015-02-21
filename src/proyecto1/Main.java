import proyecto1.*;
import java.util.LinkedList;
/*Clase para ejecutar proyecto 1*/
/**
 *Clase para ejecutar proyecto 1
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */

public class Main{

    /*Mensaje de error para cuando se llame mal al programa*/
    private static void msjError(){
	System.err.println("\n¡Error al llamar al programa!\nDebe utilizar el siguiente formato para llamar al programa:\n" +
			   "java -jar graficador.jar -ancho <ancho> -alto <alto> -x1 <x1> -y1 <y1> -x2 <x2> -y2 <y2>\n" +
			   "-funcion \"<funcion>\"\n(Donde -funcion \"<funcion>\" debe ponerse tantas veces como funciones quiera graficar"+
			   " y dentro de < > va la información que usted elija\n"+
			   "Por ejemplo: \n"+
			   "java -jar graficador.jar -ancho 640 -alto 480 -x1 -6.4 -y1 -4.8 -x2 6.4 -y2 4.8\n" +
                           "-funcion \"(- (^ x 2) 3)\" -funcion \"(sin x)\" -funcion \"(* (* (- x 2) (+ x 2)) x)\"\n");
	System.exit(-1);
  }

    
    public static void main(String args[]){
	if(args.length < 14)
	    msjError();
	if(!args[0].equals("-ancho"))
	    msjError();
  	double ancho = Double.parseDouble(args[1]);
	if(!args[2].equals("-alto"))
	    msjError();
	double alto = Double.parseDouble(args[3]);
	if(!args[4].equals("-x1"))
	    msjError();
	double x1 = Double.parseDouble(args[5]);
	if(!args[6].equals("-y1"))
	    msjError();
	double y1 = Double.parseDouble(args[7]);
	if(!args[8].equals("-x2"))
	    msjError();
	double x2 = Double.parseDouble(args[9]);
	if(!args[10].equals("-y2"))
	    msjError();
	double y2 = Double.parseDouble(args[11]);
	LinkedList<Ficha> funcion;
	Nodo<Ficha> evaluado;
	LinkedList<Nodo<Ficha>> eval = new LinkedList<Nodo<Ficha>>();
	for(int i = 12; i < args.length; i++){
	    if((i & 1) == 0){
		if(!args[i].equals("-funcion"))
		    msjError();
	    }else{
		funcion = Clasificador.dameLista(args[i]);
		evaluado = Creador.dameArbol(funcion);
		eval.add(evaluado);
	    }
	}
	System.out.println(Graficador.generaSVG(eval, alto, ancho, x1, x2, y1, y2));
    }
}