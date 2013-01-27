/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simenlazada;

/**
 *
 * @author LordOfWolvez
 */
public class CompararCadenas implements Comparar{
    public int Comparar(Object obj1, Object obj2){
        return obj1.toString().compareTo(obj2.toString());
    }
}
