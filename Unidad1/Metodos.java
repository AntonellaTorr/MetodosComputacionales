package MetodosComputacionales.Unidad1;




public class Metodos{
    public static void main(String[] args) {
        metodoSimpson();
    
    }
    public static void MetodoBiseccion() {
        System.out.println ("Ingrese el valor de a");
        double a=TecladoIn.readDouble();
        System.out.println ("Ingrese el valor de b");
        double b=TecladoIn.readDouble();
        System.out.println ("Ingrese el valor para el error");
        double error=TecladoIn.readDouble();
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
    
        r=Math.pow(x,2);
        return r;
        
    }
    public static double fDerivada (double x){
       double r=3*Math.pow(x,2)+4*x+10;
        return r;
    }
    public static void metodoNewthonRaphson() {
       
        System.out.println ("Ingrese el valor de x0");
        double a=TecladoIn.readDouble();
        System.out.println ("Ingrese el valor del error");
        double error=TecladoIn.readDouble();
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
           
        }while (Math.abs(f(r))>=error && i<25);
        System.out.println ("Valor de la raiz aproximada " +r);
       

    }
    public static void metodoTrapecios (){
       
        System.out.println ("Ingrese el valor de a");
        double a=TecladoIn.readDouble();
        System.out.println ("Ingrese el valor de b");
        double b=TecladoIn.readDouble();
        System.out.println ("Ingrese la cantidad de puntos");
        int n=TecladoIn.readLineInt();
        double h=(b-a)/n;
        System.out.println ("El valor de h es "+h);
        double f[]= new double [n+1];

        System.out.println ("Desea trabajar con valores tabulados?Si/No");
        String res=TecladoIn.readLine();
        
        if (res.equalsIgnoreCase("Si")){
            f= llenarArregloManualmente(f);
        }
        else{
            f=llenarArregloConLaFuncion(f, h, a);
        }
        
        double fx0= f[0];
        double fxn=f[n];
        double sumatoria=0;
        int i=1;
        while (i<=n-1){
            sumatoria+=f[i];
            i++;
        }
        double resultado=h/2*(fx0+fxn+ 2*sumatoria);
        System.out.println ("Resultado aproximado de la integral "+resultado);

    }
    public static void metodoSimpson (){
      
        System.out.println ("Ingrese el valor de a");
        double a=TecladoIn.readLineDouble();
        System.out.println ("Ingrese el valor de b");
        double b= TecladoIn.readLineDouble();
        System.out.println ("Ingrese la cantidad de puntos");
        int n=TecladoIn.readLineInt();
        double h=(b-a)/n;
        System.out.println ("El valor de h es "+h);
        double f[]= new double [n+1];

        System.out.println ("Desea trabajar con valores tabulados?Si/No");
        String res=TecladoIn.readLine();
        
        if (res.equalsIgnoreCase("Si")){
            f= llenarArregloManualmente(f);
        }
        else{
            f=llenarArregloConLaFuncion(f, h, a);
        }
        
        double fx0= f[0];
        double fxn=f[n];
        double sumatoriaImpar=0,sumatoriaPar=0;
        int i=1;
        while (i<=n-1){
            if (i%2!=0){              
                sumatoriaImpar+=f[i];
            }
            
            i++;
        }
        int j=2;
        while (j<=n-2){
            if (j%2==0){
                sumatoriaPar+=f[j];
            }
           
            j++;
        }
        double resultado= h/3*(fx0+fxn+4*sumatoriaImpar+2*sumatoriaPar);

        System.out.println ("Resultado aproximado de la integral "+resultado);
        
        
    }
    public static double [] llenarArregloManualmente(double [] array){
        for (int i=0; i<array.length;i++){
            System.out.println ("Ingrese el valor para el x"+i);
            array[i]=TecladoIn.readLineDouble();
            System.out.println (array[i]);
        }
        return array;
    }
    public static double [] llenarArregloConLaFuncion(double [] array, double h, double a){
        for (int i=0; i<array.length;i++){
            array[i]=f(a);
            a+=h;
        }
        return array;
    }
}

  