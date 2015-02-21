package proyecto1;
import java.util.LinkedList;
import java.text.DecimalFormat;
/*Clase que grafica una función en SVG*/
/**
 *Clase para graficar una función en SVG
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class Graficador{
    
    /**
     *Genera un SVG con la gráfica de la función a graficar
     *@param eval Una lista de funciones a graficar
     *@param alto La altura de la ventana
     *@param ancho El ancho de la ventana
     *@param x1 El primer límite de abscisas
     *@param x2 El segundo límite de abscisas
     *@param y1 El primer límite de ordenadas
     *@param y2 El segundo límite de ordenadas
     */
    public static String generaSVG(LinkedList<Nodo<Ficha>> eval, double alto, double ancho, 
				   double x1, double x2, double y1, double y2){
	int i = 0;
	if(x2 <= x1 || y2 <= y1)
	    throw new IllegalArgumentException("La gráfica no puede estar en un intervalo de tamaño cero o negativo");
	String color;
	String[] colores = {"red", "blue", "green", "yellow", "purple", "pink", "orange", "black"};
	int j = 0;
	String svg = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<svg width=\""+ ancho + "\" height=\"" + alto + "\">\n"+
            "<g>\n"+
	    "<rect x=\"0\" y=\"0\" width=\""+ ancho+"\" height=\""+ alto+"\" fill=\"white\"/>\n";
	svg += dibujaEjes(alto, ancho, x1, x2, y1, y2);
	for(Nodo<Ficha> evaluado: eval){
	    if(j < colores.length)
		color = colores[j++];
	    else
		color = "rgb(" + ((Math.random() * (255))+1) + ","+
		    ((Math.random() * (255))+1)+","+((Math.random() * (255))+1)+")";
	    svg += grafica(x1, x2, y1, y2, alto, ancho, evaluado,color);
	}
	svg += "</g>\n"+
	    "</svg>";
	return svg; 
    }
    
    /*Dibuja los ejes coordenados en la gráfica*/
    private static String dibujaEjes(double alto, double ancho, double x1, double x2, double y1, double y2){
	String ejey, ejex;
	ejey= ejex = "";
	if(x1 <= 0 && x2 >= 0){
	    double x = (ancho*Math.abs(x1))/(x2-x1);
	        ejey = "<line x1=\"" + x + "\" y1=\""+0 + "\" x2=\""+x+ "\" y2=\""+alto +
		    "\" stroke=\"grey\" stroke-width=\"2\"/>\n";
	}
	if(y1 <= 0 && y2 >= 0){
	    double y = (alto*Math.abs(y1))/(y2-y1);
	        ejex = "<line x1=\"" + 0 + "\" y1=\""+ y + "\" x2=\""+ ancho+"\" y2=\""+y +
		    "\" stroke=\"grey\" stroke-width=\"2\"/>\n";
	}
	return ejey + ejex;
    }
    
    /**
     *Evalúa la función en varios puntos y genera la gráfica en SVG
     *@return El código SVG de la gráfica
     */
    public static String grafica(double x1, double x2, double y1, double y2, 
				 double alto, double ancho, Nodo<Ficha> eval, String stroke){
	String s = "";
	double cantidad = (x2-x1)/ancho;
	double r1, r2;
	double[] g1, g2;
	g1 = g2 = new double[2];
	double numero = x1; 
	r1 = Evaluador.evalua(numero, eval);
	g1 = Evaluador.convierte(r1, numero, ancho, alto, x1, x2, y1, y2);
	while(numero <= (x2-x1)){
	    numero += cantidad;
	    r2 = Evaluador.evalua(numero, eval);
	    g2 = Evaluador.convierte(r2, numero, ancho, alto, x1, x2, y1, y2);
	    if(Double.isNaN(r1) || Double.isNaN(r2)){
		r1 = r2;
		g1 = g2;
		continue;
	    }
	    if((r1> y2 && r2 > y2) || r1<y1 && r2< y2){
		r1 = r2;
		g1 = g2;
		continue;
	    }
	    s += dibujaLinea(g1[0], g1[1],g2[0], g2[1],stroke);
	    r1 = r2;
	    g1 = g2;
	}
	return s;
    }
    
    /*Dibuja una línea*/
    private static String dibujaLinea(double x1, double y1, double x2, double y2, String stroke){
	DecimalFormat nf = new DecimalFormat("#.######");
	    String s = "<line x1=\""+nf.format(x1)+"\" y1=\""+nf.format(y1)+"\" x2=\"" + nf.format(x2)+"\" y2=\""+
	    nf.format(y2)+"\" stroke=\""+ stroke+"\" stroke-width=\"2\" />\n";
	return s;
    }
}