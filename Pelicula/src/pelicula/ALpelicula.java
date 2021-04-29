package pelicula;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ALpelicula implements java.io.Serializable{
    ArrayList<Pelicula> ALpeli= new ArrayList<>();
    
    public void abrir(){
        try{
            FileInputStream fis = new FileInputStream("cosas.dat");
            ObjectInputStream entrada = new ObjectInputStream(fis);
            ALpeli = (ArrayList <Pelicula>)entrada.readObject();
            fis.close();
            entrada.close();
        }
        catch(IOException | ClassNotFoundException e){
        System.out.println("Error se empezará a crear la lista");            
        System.out.println(e.toString());
        }
    }
    public void altas(){
        Scanner Leer = new Scanner(System.in);
        char cond = 's';
        while(cond == 's'){
            Pelicula objpeli = new Pelicula();
            System.out.println("De la clave : ");
            objpeli.setClave(Leer.nextInt());
            Leer.nextLine();
            System.out.println("Del el nombre : ");
            objpeli.setTitulo(Leer.nextLine());
            System.out.println("Del costo : ");
            objpeli.setCosto(Leer.nextInt());
            ALpeli.add(objpeli);
            System.out.println("Más pelis ???  s / n");
            cond = Leer.next().charAt(0);
        }
    }
    public void bajas(){
        Scanner Leer = new Scanner(System.in);
        int buscar = 0, cuanto = ALpeli.size();
        boolean encontrado = false;
        char cond = ' ';
        System.out.println("De la clave a borrar?? ");
        buscar = Leer.nextInt();
        for (int i = 0; i < cuanto; i++) {
            if(buscar == ALpeli.get(i).getClave()){
                encontrado = true;
                System.out.println("De la peli " + ALpeli.get(i).getTitulo() + " Del costo $" + ALpeli.get(i).getCosto());
                System.out.println("Seguro que lo quieres borrar ??     s / n");
                cond = Leer.next().charAt(0);
                if(cond == 's'){
                    ALpeli.remove(i);
                }
                else
                    System.out.println("No lo borro");
                break;
            }
        }
        if(encontrado == false)
            System.out.println("No existe esa peli");
    }
    public void cambios(){
        Scanner Leer = new Scanner(System.in);
        int buscar = 0, cuanto = ALpeli.size(), opc = 0, costos = 0;
        boolean encontrado = false;
        String Titulo = "";
        char cond = ' ', condi = 's';
        while(condi == 's'){
            System.out.println("De la clave a cambiar?? ");
            buscar = Leer.nextInt();
            for (int i = 0; i < cuanto; i++) {
                if(buscar == ALpeli.get(i).getClave()){
                    encontrado = true;
                    System.out.println("1 - " + ALpeli.get(i).getTitulo());
                    System.out.println("2 - $" + ALpeli.get(i).getCosto());
                    System.out.println("La deseas cambiar ?? s/n");
                    cond = Leer.next().charAt(0);
                    if(cond == 's'){
                        System.out.println("Cual deseas cambiar?");
                        System.out.println("1 - " + ALpeli.get(i).getTitulo());
                        System.out.println("2 - $" + ALpeli.get(i).getCosto());
                        opc = Leer.nextInt();
                        switch(opc){
                            case 1:
                                Leer.nextLine();
                                System.out.println("Del nuevo titulo");
                                Titulo = Leer.nextLine();
                                ALpeli.get(i).setTitulo(Titulo);
                                break;
                            case 2:
                                System.out.println("Del nuevo costo");
                                costos = Leer.nextInt();
                                ALpeli.get(i).setCosto(costos);
                                break;
                        }
                    }
                    else
                        System.out.println("Esta bien");
                    break;
                }
            }
            if(encontrado == false)
                System.out.println("No existe esa pelicula");
            System.out.println("Otro cambio ??  s/n");
            condi = Leer.next().charAt(0);
        }
    }
    public void consultas(){
        int cuanto = ALpeli.size();
        System.out.println("De las pelis ");
        System.out.println("Clave" + "\t" + "Titulo" + "\t" + "Costo");
        for (int i = 0; i < cuanto; i++) {
            System.out.println(ALpeli.get(i).getClave() + "\t" + ALpeli.get(i).getTitulo() + "\t$" + ALpeli.get(i).getCosto());
        }
    }
    public void terminar(){
        try{
            FileOutputStream fos = new FileOutputStream("cosas.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(ALpeli);
            fos.close();
            out.close();
        }
        catch(Exception e){
            System.out.println("Error al final");
        }
    }
}
