package pelicula;

import java.util.Scanner;

public class Mpelis {
    public static void main(String[] args) {
        ALpelicula objmio = new ALpelicula();
        Scanner Leer = new Scanner(System.in);
        boolean salir = false;
        int opc = 0;
        objmio.abrir();
        while(!salir){
            System.out.println("Menú");
            System.out.println("1 - ALtas");
            System.out.println("2 - Bajas");
            System.out.println("3 - Cambios");
            System.out.println("4 - Consultas");
            System.out.println("5 - Fin");
            System.out.println("Elije la opcion deseada");
            opc = Leer.nextInt();
            switch(opc){
                case 1:
                    objmio.altas();
                    break;
                case 2:
                    objmio.bajas();
                    break;
                case 3:
                    objmio.cambios();
                    break;
                case 4:
                    objmio.consultas();
                    break;
                case 5:
                    salir = true;
                    objmio.terminar();
                    break;
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }
        }
    }
    
}
