package estructura;

public class Cola {
    private int Principio, Fin;
    private int[]num;
    public int Dat;

    public Cola() {
        Principio=Fin=-1;
        Dat=0;
        num=new int[5];
    }

    public boolean Insertar(int Dato) {
        if(Llena()) return false;
        Fin++;
        num[Fin]=Dato;
        if(Principio==-1) Principio=0;
        return true;
    }

    public void Mostrar() {
        System.out.println("Datos en la cola: ");
        for(int i=0;i<num.length;i++) {
            System.out.print(num[i]+" ");
            }
        System.out.println();
    }

    public boolean Llena() {
        return Fin == 5-1;
    }

    public boolean Vacia() {
        return Principio == -1;
    }

    public void Invertir() {
        int[]aux1 = new int[num.length];
        int j = num.length;
        for (int i = 0; i < num.length; i++) { 
            aux1[j - 1] = num[i]; 
            j--;
        }
        for (int k = 0; k < num.length; k++) { 
            num[k]=aux1[k]; 
        }
        System.out.println("Se ha invertido la cola");
    }

}