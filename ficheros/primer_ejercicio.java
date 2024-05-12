package ficheros;

import java.io.*;

public class primer_ejercicio {
    public static void main(String[] args) {
        String line;
        String[] campos;
        File fichi=new File("C:/Users/1DAM/Desktop/prout5_/src/ficheros/tema7");
        File fichiOut=new File("C:/Users/1DAM/Desktop/prout5_/src/ficheros/ut7_out.txt");

        if(!fichi.exists()){
            System.out.print("Oye, el fichero no existe");
            System.exit(0);
        }

        try{
            FileReader fr= new FileReader(fichi);
            FileWriter fw = new FileWriter(fichiOut);

            FileInputStream fis = new FileInputStream(fichi);
            InputStreamReader isr = new InputStreamReader(fis);

            BufferedReader bf=new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(fw);

            while((line = bf.readLine()) != null){
                campos=line.split(",");
                System.out.print(campos[1]+"--"+campos[2]);
                bw.write(campos[0]+"\n");
                bw.newLine();
                bw.flush();
            }
            fw.close();
            fr.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
