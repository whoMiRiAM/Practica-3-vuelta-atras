package org.example;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Principal {

    public static final int MAX_CAMIONES = 3;
    public static final int MAX_CAPACIDAD = 59000;
    public static int N; //número de camiones
    public static int M; //capacidad máxima del camión
    public static int[] C; //carga
    public static int P; //número de paquetes
    public static int[] V; //vector de paquetes
    public static int[] A; //asignados
    private static final Logger logger = LogManager.getLogger(Principal.class);

    public static void main(String[] args) {

        inicializar();
        VA(0);
        mostrarSolucion();

    }

    public static void inicializar(){
        Scanner s = new Scanner(System.in);
        logger.info("Número de paquetes:");

        //PAQUETES
        P = s.nextInt();
        V = new int[P];
        A = new int[P];


        for (int i = 0; i < V.length; i++) {
            logger.info("Paquete " + (i + 1) + ": ");
            if(s.nextInt() > 0){
                V[i] = s.nextInt();
            }

        }

        //CAMIONES
        N = MAX_CAMIONES; //camiones que tenemos
        C = new int[N]; //carga actual
        M = MAX_CAPACIDAD; //capacidad maxima de cada camion
    }

    public static boolean vivo(int k){
        return C[k] <= M;
    } //para ver si la carga esta bien o sobrepasa

    public static void VA(int k){
        for(int camion = 1; camion <= N; camion++){ //restricción explícita
            A[k] = camion;
            C[camion - 1] += V[k];

            if(vivo(camion - 1)){
                if(k < P - 1){
                    VA(k + 1); //siguiente etapa
                }else{ //si ya no quedan paquetes, hemos encontrado solución
                    mostrarSolucion();
                    System.exit(0); //salimos
                }
            }
            C[camion - 1] -= V[k]; //nodo muerto
        }
        A[k] = 0; //al terminar el último valor de la restricción explícita/exhaustividad, hacemos VA. Nodo vuelta atrás
    }

    public static void mostrarSolucion() { 
        if (A.length > 0 && A[0] != 0) {
            for (int i = 0; i < A.length; i++) {
                System.out.print("[" + A[i] + "]");
            }
            System.out.println();
        } else {
            logger.info("No hay solución.");
        }
    }

}
