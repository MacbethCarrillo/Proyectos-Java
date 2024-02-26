/*
Ejercicios Metodos Recursivos
*/
package Unidad1;

public class metodosRecursivos {
	 
    public static void main(String[] args) {
 
        int base = 2;
        int potencia = 6;
        
        System.out.println("Potencia de "+base+" elevado a "+potencia+" = "+potencia(base, potencia)); System.out.println();
        
        System.out.println("Tabla de multiplicar"); System.out.println();
        multiplicar(7,10);
        
        System.out.println("Division");
        System.out.println(divisionRecursiva(12, 4)); System.out.println();
        
        System.out.println("Buscar un elemento de un arreglo");
        int[] array={1,2,3,4,5};
        int elementoBuscar=3;
        int posElementoEncontrado=posicionElementoRecursivo(array, elementoBuscar, 3);
        System.out.println(posElementoEncontrado); System.out.println();
        
        String nombre = "Hola mi nombre es el uriel";
		System.out.println(nombre);
		String nomIverso = inversor(nombre, nombre.length()-1);
		System.out.println(nomIverso);
        
    }
 
    public static double potencia(int base, int potencia) {
 
        if (potencia == 0) { 
            return 1; 
        } else if (potencia == 1) { 
            return base; 
        } else {
            return base * potencia(base, potencia - 1);
        }
    }
    
	public static void multiplicar(int numeroBase, int numeroMult){
		if (numeroMult>1) {
			multiplicar(numeroBase, numeroMult-1);
		}
		System.out.println(numeroBase+"x"+numeroMult+"="+numeroBase*numeroMult);	
	}	
	
	private static int divisionRecursiva(int dividendo, int divisor){
        if(divisor>dividendo){
            return 0;
        } else {
            return 1 + divisionRecursiva(dividendo-divisor, divisor);
        }
    }
    
	public static int posicionElementoRecursivo(int[] array, int elementoBuscar, int indice){
        
		if(indice==array.length || array[indice]==elementoBuscar){
			if(indice==array.length){
				return -1; 
			}else{
				return indice;
			}         
		}else{
			return posicionElementoRecursivo(array, elementoBuscar, indice+1);
		}
	         
	}
	
	static String inversor(String nombre, int index){
		if(index == 0){
			return nombre.charAt(0) + "";
		}
		char letra = nombre.charAt(index);
		return letra + inversor(nombre, index-1);
	}
	
}

