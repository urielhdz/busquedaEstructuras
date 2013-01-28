/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simenlazada;

import java.util.HashMap;
import java.util.Hashtable;


/**
 *
 * @author Uriel
 */
public class TransformadaCls {
    Hashtable tabla= new Hashtable();
    int opcion = 1;
    String current = "";
    Lista list;
    public TransformadaCls(Lista l){
        this.list = l;
    }
    public void modulo(){
            tabla = new Hashtable();
            Nodo aux = list.PrimerNodo;
            int size = list.getTamano();
            
                while(aux != null){
                    int dato = Integer.parseInt(aux.datos.toString());
                    int posicion = (dato % size) + 1;
                    
                    if(tabla.containsKey(posicion)){
                        int nuevaPosicion = resolverColision(posicion,size);
                        tabla.put(nuevaPosicion,aux);
                    }
                    else{
                       tabla.put(posicion, aux);
                    }
                    aux = aux.getnext();
                    this.current = "modulo";
                }
            System.out.println(tabla.toString());
            
    }
    
    /*****************Metodo de truncamiento**********************/
    public int truncamiento(int clave){
        int digitos = 0;
        int pos = 0;
        int copia = clave;
        while(clave > 1){
            digitos++;
            copia /=10;
        }
        if(digitos ==2){
            pos = clave +1;
        }
        if(digitos == 3){
            int cent= clave/100;
            int dec = (clave - cent*100)/10;
            pos = (cent*10)+dec+1;
        }
        if(digitos == 4){
            int mil= clave/1000;
            int cent = (clave - mil*1000)/100;
            int dec = (clave -(mil*1000 + cent * 100))/10;
            pos = (mil*10)+dec+1;
        }
        return pos;
    }
    public Nodo getByModule(int valor){
        if(!this.current.equals("modulo")) this.modulo();
        int posicion = valor % this.list.getTamano() + 1;
        Nodo resultado = (Nodo) tabla.get(posicion);
        if(Integer.parseInt(resultado.datos.toString()) == valor) return resultado;
        else{
            int res = Integer.parseInt(resultado.datos.toString());
            int vueltas = 0;
            while(res != valor && vueltas < 2){
                if(posicion == this.list.getTamano()){
                    posicion = 0;
                    vueltas++;
                }
                posicion++;
                resultado = (Nodo)tabla.get(posicion);
                res = Integer.parseInt(resultado.datos.toString());;
            }
            if(res==valor){
                return resultado;
            }
            return null;
        }
    }
    
    private int  resolverColision(int valor,int size){
        int retorno = -1;
        switch(this.opcion){
            /*
             * Caso 1, resolver por Reasignacion
             * Caso 2, resolver por Arreglos Anidados
             * Caso 3, resolver por Encadenamiento
             */
            case 1:
                retorno = reasignacion(valor,size);
                break;
            case 2:
                
        }
        return retorno;
    }
    private int reasignacion(int valor,int size){
        int vueltas = 0;
        while(tabla.containsKey(valor)&&vueltas<2){
            if(valor == size){
                valor = 0;
                vueltas++;
            }
            valor++;
        }
        return valor;
    }
}
