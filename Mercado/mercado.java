/*
 * -PROGRAMACION ORIENTADA A OBJETOS-
 * 
 * ALUMNO: MACBETH ADOLFO CARRILLO IBARRA
 * 
 * NO.CONTROL: 19170557
 * 
 * SEMESTRE: 5
 * 
 * PROFESOR: ALDO URIARTE PORTILLO
 * 
 */
package Semestre5;
import java.util.*;
public class mercado {

	Producto [] prod;   //Atributo de instancia
    public static void main (String args[]) {
        //Declarar y llenar un arreglo tipo Producto
        mercado sm = new mercado();//Objeto instancia
        sm.prod= new Producto[] {
            new Producto(1,15.90f, "Abarrotes", "Sabritas"),
            new Producto(2, 35.50f, "Abarrotes", "Coca Cola 2L"),
            new Producto(3, 17f, "Alimentos", "Atun "),
            new Producto(4, 35.0f, "Alimentos", "Kilo de tomate"),
            new Producto(5, 19.99f, "Alimentos", "Frijoles"),
            new Producto(6, 46.50f, "Abarrotes", "Cereal Zucaritas"),
            new Producto(7, 12.0f, "Alimentos", "Garrafon Agua"),
            new Producto(8, 14.50f, "Abarrotes", "Donitas Bimbo"),
            new Producto(9, 17.0f, "Abarrotes", "Galletas Maria"),
            new Producto(10, 22.0f, "Alimentos", "Leche Yaqui 1L")
        };
    
        System.out.println("El total a pagar es: "+sm.comprar(sm.prod));

    }
    public float comprar(Producto [] pr) {
        Scanner Entrada = new Scanner(System.in);
        float sub=0, iva=0, imp=0;
        int cant=0;
        for(int i=0; i<pr.length; i++) {
            System.out.println("Cantidad de: "+pr[i].getProducto()+": ");
            cant = Entrada.nextInt();
            if(pr[i].getTipoProducto().equalsIgnoreCase("Abarrotes")) {
                iva=0.16f;
            }else {
                iva=0f;
            }
            imp = cant * (pr[i].getPrecio() + (pr[i].getPrecio()*iva));
            sub += imp;
        }
        return sub;
    }
}
