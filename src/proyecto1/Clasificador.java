package proyecto1;
import java.util.LinkedList;
/*Clase para clasificar partes de una cadena en fichas*/
/**
 *Clasifica partes de una cadena en fichas(según su tipo)
 *@author Víctor Zamora Gutiérrez
 *@version 1.0
 */
public class Clasificador{
    
    /**
     *Método que clasifica las partes de una cadena y las
     *pone en una lista de fichas
     *@param s Es la cadena que se quiere analizar
     *@return Una lista de Fichas
     *@throws ExcepcionSintaxisInvalida Si el formato de la cadena es incorrecto
     */
    public static LinkedList<Ficha> dameLista(String s)
	throws ExcepcionSintaxisInvalida{
	char actual, siguiente, siguiente2, siguiente3;
	String numero;
	boolean punto, cuenta_espacios;
	cuenta_espacios = false;
	LinkedList<Ficha> lista = new LinkedList<Ficha>();
	int longitud = s.length();
	for(int i = 0; i < longitud; i++){
	    actual = s.charAt(i);
	    if(esEspacio(actual)){
		if(i == 0)
		    throw new ExcepcionSintaxisInvalida("La expresión no debe empezar con un espacio");
		if(i +1 == longitud)
		    throw new ExcepcionSintaxisInvalida("Las expresiones no pueden terminar en espacio");
		siguiente = s.charAt(i+1);
		if(siguiente == ')')
		    throw new ExcepcionSintaxisInvalida("Los espacios no pueden estar seguidos por ')'");
		    if(cuenta_espacios)
			throw new ExcepcionSintaxisInvalida("No puede tener dos o más espacios seguidos");
		cuenta_espacios = true;
		continue;
	    }
	    cuenta_espacios = false;
	    switch (actual){
	    case '+': 
		if(i +1 != longitud){
		    siguiente = s.charAt(i+1);
		    if(siguiente == '(' ||  esEspacio(siguiente))
			lista.add(new Ficha(Tipo.MAS));
		    else
			throw new ExcepcionSintaxisInvalida("El símbolo '+' está junto al caracter '"+ siguiente+"', lo cual es inválido");
		}else
		    throw new ExcepcionSintaxisInvalida("La expresión no puede terminar en un operador");
		break;
	    case '*': 
		if(i +1 != longitud){
		    siguiente = s.charAt(i+1);
		    if(siguiente == '(' || esEspacio(siguiente))
			lista.add(new Ficha(Tipo.POR));
		    else
			throw new ExcepcionSintaxisInvalida("El símbolo '*' está junto al caracter '"+ siguiente+"', lo cual es inválido");
		}else
		    throw new ExcepcionSintaxisInvalida("La expresión no puede terminar en un operador");
		break;
	    case '/':
		if(i +1 != longitud){
		    siguiente = s.charAt(i+1);
		    if(siguiente == '(' || esEspacio(siguiente))
			lista.add(new Ficha(Tipo.ENTRE));
		    else
			throw new ExcepcionSintaxisInvalida("El símbolo '/' está junto al caracter '"+ siguiente+"', lo cual es inválido");
		}else
		    throw new ExcepcionSintaxisInvalida("La expresión no puede terminar en un operador");
		break;
	    case '^': 
		if(i +1 != longitud){
		    siguiente = s.charAt(i+1);
		    if(siguiente == '(' || esEspacio(siguiente))
			lista.add(new Ficha(Tipo.POTENCIA));
		    else
			throw new ExcepcionSintaxisInvalida("El símbolo '^' está junto al caracter '"+ siguiente+"', lo cual es inválido");
		}else
		    throw new ExcepcionSintaxisInvalida("La expresión no puede terminar en un operador");
		break;
	    case '(': 
		lista.add(new Ficha(Tipo.PARENTESISI));
		break;
	    case ')': 
		lista.add(new Ficha(Tipo.PARENTESISD));
		break;
	    case '.':
		punto = true;
	    case '0':
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
		numero = casoNumero(s, i, false);
		i += numero.length()-1;
		lista.add(new Ficha(Tipo.NUMERO, numero));
		break;
	    case 'x':
		lista.add(new Ficha(Tipo.VARIABLE, "x"));
		break;
	    case '-':
		if(i +1 != longitud){
		    siguiente = s.charAt(i+1);
		    if(siguiente == 'x'){
			lista.add(new Ficha(Tipo.VARIABLE, "-x"));
			++i;
		    }
		    else if((48 <= siguiente) && (siguiente <= 57)){//Es un número
			numero = casoNumero(s, i+1, false);
			i += numero.length();
			lista.add(new Ficha(Tipo.NUMERO, "-".concat(numero)));
		    }
		    else if(siguiente == '(' || esEspacio(siguiente))
			lista.add(new Ficha(Tipo.MENOS));
		    else
			throw new ExcepcionSintaxisInvalida("El operador '-' está junto al caracter '"+ siguiente+"', lo cual es inválido");	  }
		else
		    throw new ExcepcionSintaxisInvalida("La entrada no puede terminar en un operador");
		break;
	    case 's':
		if(i +3 < longitud){
		    siguiente = s.charAt(i+1);
		    siguiente2 = s.charAt(i+2);
		    siguiente3 = s.charAt(i+3);
		    if(!(siguiente3 == '(' || esEspacio(siguiente3)))
			throw new ExcepcionSintaxisInvalida("Formato incorrecto; Función inválida que comienza con 's'"); 
		    switch(siguiente){
		    case 'i':
			if(siguiente2 == 'n'){
			    lista.add(new Ficha(Tipo.SENO));
			    i+=2;
			}
			else
			    throw new ExcepcionSintaxisInvalida("Formato incorrecto; La función 'si" + siguiente2+ "' no existe");
			break;
		    case 'e':
			if(siguiente2 == 'c'){
			    lista.add(new Ficha(Tipo.SECANTE));
			    i+=2;
			}
			else
			    throw new ExcepcionSintaxisInvalida("Formato incorrecto; La función 'se" + siguiente2 + "' no existe");
			break;
		    default:
			throw new ExcepcionSintaxisInvalida("Formato incorrecto; La 's' no puede estar seguida de '"+ siguiente + "'");
		    }
		}else
		    throw new ExcepcionSintaxisInvalida("Formato incorrecto; Función inválida que comienza en 's'");
		break;
	    case 'c':
		if(i +3 < longitud){
		    siguiente = s.charAt(i+1);
		    siguiente2 = s.charAt(i+2);
		    siguiente3 = s.charAt(i+3);
		    if(!(siguiente3 == '(' || esEspacio(siguiente3)))
			throw new ExcepcionSintaxisInvalida("Formato incorrecto; Función inválida que comienza con 'c'");
		    switch(siguiente){
		    case 'o':
			if(siguiente2 == 's'){
			    lista.add(new Ficha(Tipo.COSENO));
			    i+=2;
			}else if(siguiente2 == 't'){
			    lista.add(new Ficha(Tipo.COTANGENTE));
			    i += 2;
			}
			else
			    throw new ExcepcionSintaxisInvalida("Formato incorrecto; La función 'co" + siguiente2 + "' no existe");
			break;
		    case 's':
			if(siguiente2 == 'c'){
			    lista.add(new Ficha(Tipo.COSECANTE));
			    i+=2;
			}
			else
			    throw new ExcepcionSintaxisInvalida("Formato incorrecto; La función 'cs"+ siguiente2 + "' no existe");
			break;	
		    default:
			throw new ExcepcionSintaxisInvalida("Formato incorrecto; La 'c' no puede estar seguida de '" + siguiente +"'");
		    }
		}
		else
		    throw new ExcepcionSintaxisInvalida("Formato incorrecto; Función inválida que comienza en 'c'");
		break;
	    case 't':
		if(i +2 < longitud){
		    siguiente = s.charAt(i+1);
		    siguiente2 = s.charAt(i+2);
		    siguiente3 = s.charAt(i+3);
		    if(!((siguiente3 == '(') || esEspacio(siguiente3)))
			throw new ExcepcionSintaxisInvalida("Formato incorrecto; Función inválida que comienza con 't'");
		    if(siguiente == 'a' && siguiente2 == 'n'){
			lista.add(new Ficha(Tipo.TANGENTE));
			i+=2;
		    }
		    else
			throw new ExcepcionSintaxisInvalida("Formato incorrecto; La única función que comienza con 't' es 'tan'"); 
		}else
		    throw new ExcepcionSintaxisInvalida("Formato incorrecto; Función inválida que comienza en 't'");
		break;
	    default : 
		throw new ExcepcionSintaxisInvalida("Formato incorrecto; Funcion inválida que comienza en '" + actual + "'");
	    }
	}
	return lista;
    }

    /*Nos dice si un caracter es espacio*/
    private static boolean esEspacio(char c){
	return (c==' ')||(c=='\n')||(c=='\r')||(c=='\t');
    }
    
    /**
     *Nos dice si la lista creada es válida de acuerdo a nuestra gramática
     *@param lista_final La lista que se quiere verificar si es válida
     *@return Un MsjBoolean con valor de verdad si la lista es válida y con valor falso y un mensaje de error si no lo es
     */
    public static MsjBoolean listaValida(LinkedList<Ficha> lista_final){
	LinkedList<Ficha> lista = new LinkedList<Ficha>(lista_final);
	if(lista.size() == 0)
	    return new MsjBoolean("La expresión no puede ser vacía");
	if(lista.size() == 1){
	    if(lista.getFirst().getTipo().getClasificacion()  == Clasificacion.OPERANDO)
		return new MsjBoolean();
	    return new MsjBoolean("Las expresiones de tamaño 1 sólo pueden ser números o variables");
	}else if(lista.peekFirst().getTipo() == Tipo.PARENTESISI && lista.peekLast().getTipo() == Tipo.PARENTESISD){
	    Ficha inicial;
	    inicial = lista.removeFirst();
	    inicial = lista.removeLast();
	    if(lista.peekFirst() == null)
		return new MsjBoolean("La expresión dentro de los paréntesis no puede ser vacía");
	    else if(lista.peekFirst().getTipo().getClasificacion() == Clasificacion.UNARIO){
		inicial = lista.removeFirst();
		return listaValida(lista);
	    }else if(lista.peekFirst().getTipo().getClasificacion() == Clasificacion.BINARIO){
		inicial = lista.removeFirst();
		LinkedList<Ficha> lista1, lista2;
		lista1 = new LinkedList<Ficha>();
		boolean exp1_terminada = false;
		Ficha actual;
		int cuenta_parentesis = 0;
		while(!exp1_terminada && lista.size() > 0){
		    actual = lista.removeFirst();
		    if(cuenta_parentesis == 0){
			if(actual.getTipo().getClasificacion() == Clasificacion.OPERANDO){
			    exp1_terminada = true;
			    lista1.add(actual);
			}else if(actual.getTipo() == Tipo.PARENTESISI){
			    lista1.add(actual);
			    cuenta_parentesis++;
			}else
			    return new MsjBoolean("Las expresiones válidas no pueden empezar con algo que no sea un número, "+
						  "un paréntesis izquierdo, o una variable");
		    }else{
			lista1.add(actual);
			if(actual.getTipo() == Tipo.PARENTESISI)
			    cuenta_parentesis++;
			if(actual.getTipo() == Tipo.PARENTESISD){
			    cuenta_parentesis--;
			    if(cuenta_parentesis == 0)
				exp1_terminada = true;
			    else if(cuenta_parentesis < 0)
				return new MsjBoolean("Los paréntesis de la expresión están desbalanceados");
			}
		    }
		}
		if(cuenta_parentesis != 0)
		    return new MsjBoolean("Los paréntesis de la expresión están desbalanceados");
		lista2 = lista;
		if(listaValida(lista1).getBoolean() == true && listaValida(lista2).getBoolean() == true)
		    return new MsjBoolean();
		else{
		    return new MsjBoolean("El operador binario '" +inicial.getValor() + "' debe estar seguido por dos expresiones válidas");
		}
	    }else
		return listaValida(lista);
	}else
	    return new MsjBoolean("La expresión debe estar rodeada por paréntesis, a menos que sea un número o una variable");
    }
    
    /*Método para del switch en el que el carácter es un número*/
    private static String casoNumero(String s, int index, boolean punto)
	throws ExcepcionSintaxisInvalida{
	String numero = String.valueOf(s.charAt(index));
	while(index < s.length()-1){
	    index++;
	    char actual = s.charAt(index);
	    if(actual == '.')
		if(punto == true)
		    throw new ExcepcionSintaxisInvalida
			("Uno de los números contiene más de un punto");
		else{
		    punto = true;
		    numero += actual;
		    continue;
		}
	    if((48 <= actual) && (actual <= 57)){ //Es un número
		numero += actual;
		continue;
	    }
	    if(esEspacio(actual) || actual == '(' || actual == ')')
		break;
	    throw new ExcepcionSintaxisInvalida
		("Uno de los números contiene el caracter "+ actual + ", lo cual no es válido");
	}
	return numero;
    }
}