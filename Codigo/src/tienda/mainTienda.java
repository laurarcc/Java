package tienda;

public class mainTienda {
    public static void main(String[] args){

        productos taladro=new ferreteria("T01");
        productos servidor=new informatica("Server05");
        taladro.setPrecio(100.25);
        servidor.setPrecio(20000.5);

        for(productos p:productos.listraProd){
            System.out.println(p.toString());
            System.out.println("Precio final "+ (p.getPrecio()-(p.getPrecio()* p.descuento())));
        }


    }
}
