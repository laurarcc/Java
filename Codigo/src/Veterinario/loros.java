package Veterinario;

public class loros extends animales implements animales2{
    loros(String name, Double size){
        super(name,size);
    }

    @Override
    public String toString() {
        return "loros{" +
                "name='" + name + '\'' +
                "size='" + size+'\'' +
                '}';
    }
    @Override
    public String vacuna() {
        return this.vacuna();
    }
}
