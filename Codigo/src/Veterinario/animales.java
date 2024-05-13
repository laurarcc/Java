package Veterinario;

public class animales {
    String name;
    String vacuna;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    Double size;
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
    public animales(String name, Double size){
        this.size = size;
        this.name = name;
    }




}
