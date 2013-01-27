/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simenlazada;

/**
 *
 * @author LordOfWolvez
 */
class Lista{
	Nodo PrimerNodo;
	Nodo UltimoNodo;
	String Nombre;
        private int tamano ;

	public boolean VaciaLista(){
		return PrimerNodo ==null;
	}

	public Lista(String s){
		Nombre=s;
		PrimerNodo=UltimoNodo=null;
	}

	public Lista(){
		this ("Lista");
                this.tamano = 0;
	}
        
        public int getTamano(){
            return tamano;
        }
	
	//Imprime el contenido de la lista
	public String cadenaLista(){
           String imLista ="";
		if (VaciaLista()){
			imLista = "Lista Vacia.  ";
		}
		else{
			Nodo Actual=PrimerNodo;
			while(Actual != null){
				imLista = imLista + Actual.datos.toString() + " ;";
				Actual=Actual.siguiente;
			}
		}
                return imLista;
	}

	//Inserta un elemento al frente de la lista
	void insertaralInicio(Object ElemInser){
		if(VaciaLista())
		PrimerNodo=UltimoNodo=new Nodo(ElemInser);
		else
		PrimerNodo=new Nodo(ElemInser, PrimerNodo);
                
                this.tamano ++;
	}
	
	//Inserta al final de la lista
	public void insertaralFinal(Object ElemInser){
            if(VaciaLista()){
                PrimerNodo= UltimoNodo = new Nodo (ElemInser);
            }
            else{
            UltimoNodo=UltimoNodo.siguiente=new Nodo(ElemInser);
	    }
            this.tamano ++;
	}
	
	//Inserta elemento en posicion dada
	public void InsertaMedio(Object ElemInser,int Posicion){
            if(VaciaLista())
                PrimerNodo=UltimoNodo=new Nodo (ElemInser);
            else{
                if(Posicion<=1){
                    Nodo Nuevo=new Nodo(ElemInser);
                    Nuevo.siguiente=PrimerNodo;
                    PrimerNodo=Nuevo;
                }
		else{
                    Nodo Aux=PrimerNodo;
                    int i=2;
                    while((i != Posicion) & (Aux.siguiente != null)){
                        i++;
                        Aux=Aux.siguiente;
                        }
			Nodo Nuevo=new Nodo(ElemInser);
			Nuevo.siguiente=Aux.siguiente;
			Aux.siguiente=Nuevo;
                }
            }
            this.tamano ++;
	}

	
	//Elimina un elemento
	public void EliminaEle(Object ele){
		Nodo aux=PrimerNodo;
		Nodo p=PrimerNodo;
		Nodo ant=null;
		boolean enc=false;
		
		while((aux != null) && (enc==false)){
			if(ele.equals(aux.datos)) enc=true;
			else{
				ant=aux;
				aux=aux.siguiente;
			}
		}
		
		if(enc==true){
			if (aux.equals(PrimerNodo)){
				PrimerNodo=aux.siguiente;
			}
			else{
				if (aux.equals(UltimoNodo)){
					UltimoNodo=ant;
					ant.siguiente=null;
				}
				else{
					Nodo i=aux.siguiente;
					aux=ant;
					aux.siguiente=i;
					PrimerNodo=p;
				}
			}
                        tamano --;
		}
	}

        //Invierte la lista
	public void Invertir(){
		Nodo sig = PrimerNodo;
	  	Nodo anterior = null;
	  	while(!(VaciaLista())){
	    	sig = PrimerNodo.siguiente;
	    	PrimerNodo.siguiente = anterior;
	    	anterior = PrimerNodo;
	    	PrimerNodo = sig;
	  	}
	  	PrimerNodo= anterior;
	}
	
	public String busquedaSecuencial(Object ele){
            String res="No encontrado";
            boolean enc=false;
            int i = 0;
            Nodo aux=PrimerNodo;
            while((aux != null) && (enc==false)){
                if(ele.equals(aux.datos)){
                    enc=true;
                    res = "\nEncontrado!";
                }
		else{
                    aux=aux.siguiente;
		}
                i++;
            }
            
            return res = res +"\nMenos favorable : "+(tamano) +"\nMás favorable : "+"1"+"\n"+ "Pasadas : "+ i;
	}
        
        public String busquedaBinaria(Object ele,Comparar c, int direccion){
            /* 
             * Si direccion es igual a 0, buscamos de derecha a izquierda
             * Si direccion es igual a 1, buscamos de izquierda a derecha.
             */
            Nodo aux = PrimerNodo;
            String res = "No encontrado!";
            int izq = 0;
            int der = tamano;
            int cen;
            int contador = 0;
            int i = 1;
            boolean bandera = false;
            while(izq <= der && bandera == false){
                aux = PrimerNodo;
                cen = izq+der/2;
                while(i<=cen){
                   aux = aux.getnext();
                   i++;
                }
                System.out.println(aux.getObject());
                if(ele.equals(aux.datos)){
                    contador++;
                    bandera = true;
                    res = "\n Encontrado";
                }
                else{
                    contador++;
                    //if(c.Comparar(ele, aux) < 0){
                    int intEle = Integer.parseInt(ele.toString());
                    int intDatos = Integer.parseInt(aux.datos.toString());
                    if(direccion == 1){
                        if(intEle > intDatos){
                           izq = cen+1;
                        }
                        else{
                            der = cen-1;
                        }
                    }
                    else if(direccion == 0){
                        if(intEle < intDatos){
                           izq = cen+1;
                        }
                        else{
                            der = cen-1;
                        }
                    }
                    
                    
                }
            }
            return res+"\nComparaciones: "+contador;
        }

}