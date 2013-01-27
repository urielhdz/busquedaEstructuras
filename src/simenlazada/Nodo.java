/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simenlazada;

/**
 *
 * @author LordOfWolvez
 */
class Nodo{
	//datos amigables para que la clase lista tenga un acceso directo
	Object datos;
	Nodo siguiente;
	//Constructor crea un nodo de tipo Object
	Nodo(Object valor){
		datos=valor;
		siguiente=null;
	}
	//Constructor Crea un nodo de tipo Object y al siguiente nodo de la lista
	Nodo (Object valor,Nodo signodo){
		datos=valor;
		siguiente=signodo; //siguiente se refiere al siguiente nodo
	}
	//Retorna el dato que se encuentra en ese nodo
	Object getObject(){
		return datos;
	}
	//Retorna el siguiente nodo
	Nodo getnext(){
		return siguiente;
	}
}