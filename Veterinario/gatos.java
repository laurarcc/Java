package Veterinario;

public class gatos extends animales implements animales2 {
    String raza;


    gatos(String name, Double size, String raza){
        super(name,size);
        this.raza=raza;
    }

    @Override
    public String toString() {
        return "gatos{" +
                "name='" + name + '\'' +
                "raza='" + raza + '\'' +
                "size='" + size+'\'' +
                '}';
    }

    @Override
    public String vacuna() {
        return this.vacuna();
    }
}
