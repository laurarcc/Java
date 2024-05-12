package FigurasGeometricas;
import java.util.ArrayList;

public class mainformas {
    public static void main(String[] args){
        ArrayList<Geo> listsGeo=new ArrayList<>();

        //Geo g1=new Geo("miguel"); //migeo

        Triangulo t1=new Triangulo("t1name");
        System.out.println(t1.name);
        listsGeo.add(t1);

        Cuadrado c1=new Cuadrado("c1name");
        System.out.println(c1.name);
        listsGeo.add(c1);

        Geo t2=new Triangulo("t2name");
        System.out.println(t2.name);
        listsGeo.add(t2);
        //t2.Area();
    }
}
