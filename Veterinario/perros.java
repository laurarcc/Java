package Veterinario;

public class perros extends animales implements animales2{
    String raza;
    String vacuna;
    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    perros(String name, Double size,String raza){
        super(name,size);
        this.raza=raza;
    }

    @Override
    public String toString() {
        return "perros{" +
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
