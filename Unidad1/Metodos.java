package MetodosComputacionales.Unidad1;

import java.util.Scanner;


public class Metodos{
    public static void main(String[] args) {
        
      metodoTrapecios();
    }
    public static void MetodoBiseccion() {
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese el valor de a");
        double a=leer.nextDouble();
        System.out.println ("Ingrese el valor de b");
        double b=leer.nextDouble();
        System.out.println ("Ingrese el valor para el error");
        double error=leer.nextDouble();
        int i=1;
        if (f(a)*f(b)<0){
            double r;
            do{
                r=(a+b)/2;
                System.out.println ("Resultado de la raiz "+i+" es: "+r );
                System.out.println ("Valor de f en r es"+f(r));
                if (f(a)*f(r)<0){
                    b=r;
                }else{
                    a=r;
                }
                i++;
            }while (Math.abs(f(r))>error);  
            System.out.println ("Raiz aproximada: "+r);

        }

    }

    public static double f(double x) {
        double r;
        //r=Math.pow(x, 3)-2*x-1;
        // r= 2*Math.sin(x+1);
    
        r=Math.pow(Math.E, x);
        return r;
        
    }
    public static double fDerivada (double x){
       // double r= 2*Math.cos(x+1);
       double r=-160*Math.exp(-2*x)-10*Math.exp(-0.5*x);
        return r;
    }
    public static void metodoNewthonRaphson() {
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese el valor de x0");
        double a=leer.nextDouble();
        System.out.println ("Ingrese el valor del error");
        double error=leer.nextDouble();
        double r=0;
        int i=1;
        do{
            double d=fDerivada(a);
            if (d!=0){
                r= a-(f(a)/d);
                System.out.println ("Valor de la raiz x"+i+": " +r);
                a=r;
            }
           
            i++;
           
        }while (Math.abs(f(r))>error && i<25);
        System.out.println ("Valor de la raiz aproximada " +r);
       

    }
    public static void metodoTrapecios (){
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese el valor de a");
        double a= leer.nextDouble();
        System.out.println ("Ingrese el valor de b");
        double b= leer.nextDouble();
        System.out.println ("Ingrese la cantidad de puntos");
        int n=leer.nextInt();
        double h=(b-a)/n;
        System.out.println ("El valor de h es "+h);
        double fx0= f(a);
        double fxn=f(b);
        double sumatoria=0,xi=a+h;
        int i=1;
        while (i<=n-1){
            sumatoria+=f(xi);
            xi+=h;
            i++;
        }
        double resultado=h/2*(fx0+fxn+ 2*sumatoria);
        System.out.println ("Resultado aproximado de la integral "+resultado);

    }
    public static void metodoSimpson (){
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese el valor de a");
        double a= leer.nextDouble();
        System.out.println ("Ingrese el valor de b");
        double b= leer.nextDouble();
        System.out.println ("Ingrese la cantidad de puntos");
        int n=leer.nextInt();
        double h=(b-a)/n;
        System.out.println ("El valor de h es "+h);
        double fx0= f(a);
        double fxn=f(b);
        double sumatoriaImpar=0,sumatoriaPar=0,xi=a+h,xj=a+h+h;
        int i=1;
        while (i<=n-1){
            if (i%2!=0){              
                sumatoriaImpar+=f(xi);
            }
            xi+=h;
            i++;
        }
        int j=2;
        while (j<=n-2){
            if (j%2==0){
                sumatoriaPar+=f(xj);
            }
            xj+=h;
            j++;
        }
        double resultado= h/3*(fx0+fxn+4*sumatoriaImpar+2*sumatoriaPar);

        System.out.println ("Resultado aproximado de la integral "+resultado);
        
    }
}

  