package MetodosComputacionales.Unidad4;
public class Test{
    public static void main(String[] args) {
    
        sumaDeRiemann();
    }
    public static double f(double x, double y) {
        double r;
        r=16-Math.pow(x,2) -2*Math.pow(y,2);
        return r;

    }
    public static void sumaDeRiemann(){
        double n,m,a,b,c,d, x, y;
        double i,j,suma=0, intI, intJ;
        System.out.println ("Ingrese el a");
        a=TecladoIn.readLineInt();
        System.out.println ("Ingrese el b");
        b=TecladoIn.readLineInt();
        System.out.println ("Ingrese el c");
        c=TecladoIn.readLineInt();
        System.out.println ("Ingrese el d");
        d=TecladoIn.readLineInt();

        
    
        System.out.println ("Ingrese el n");
        n=TecladoIn.readLineInt();
        System.out.println ("Ingrese el m");
        m=TecladoIn.readLineInt();
        x=b-a;
        y=d-c;
        intI=x/n;
        intJ=y/m;
        i=intI;
        j=intJ;
        while (i<=2){
            while (j<=2){
                suma+=f(i,j);
                j=j+intJ;
            }
            i=i+intI;
            j=intJ;
        }
        System.out.println ("Suma:" +suma*(intI*intJ));
       
    }
}
