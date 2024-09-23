import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        op.leerArchivo("/home/dam/Work/Clase/AccesoDatos/ExercicioCopiaImaxe2/foto.jpeg");
        op.escribirArchivo("/home/dam/Work/Clase/AccesoDatos/ExercicioCopiaImaxe2/foto2.jpeg");
    }
}

class Operaciones {
    ArrayList<Integer> listaBytes = new ArrayList<Integer>();

    public void leerArchivo (String dirName) {

        int lbyte = 0;

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(dirName));
                do {
                    lbyte = bis.read();
                    if (lbyte != -1) {
                        listaBytes.add(lbyte);
                    }

                } while (lbyte != -1);
            bis.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo");
        }
    }

    public void escribirArchivo (String dirName) {

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dirName));
            for (Integer listaByte : listaBytes) {
                bos.write(listaByte);
            }
            bos.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo");
        }

    }
}