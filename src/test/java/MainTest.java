import org.example.Principal;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testSolucionExistente() {
        Principal.P = 3;  //3 paquetes
        Principal.V = new int[]{5000, 5000, 15000};  //pesos de los paquetes
        Principal.A = new int[3];
        Principal.C = new int[Principal.MAX_CAMIONES];
        Principal.N = Principal.MAX_CAMIONES;
        Principal.M = Principal.MAX_CAPACIDAD;

        Principal.VA(0);  //iniciar vuelta atrás
        assertTrue(Principal.A[0] != 0 && Principal.A[1] != 0 && Principal.A[2] != 0);
    }

    @Test
    public void testSinSolucion() {
        Principal.P = 3;  //3 paquetes
        Principal.V = new int[]{20000, 20000, 20001};  //pesos de los paquetes que exceden la capacidad máxima si se asignan al mismo camión
        Principal.A = new int[3];
        Principal.C = new int[Principal.MAX_CAMIONES];
        Principal.N = Principal.MAX_CAMIONES;
        Principal.M = Principal.MAX_CAPACIDAD;

        Principal.VA(0);  //iniciar vuelta atrás
        assertTrue(Principal.A[0] == 0 && Principal.A[1] == 0 && Principal.A[2] == 0);
    }

    @Test
    public void testPesosNegativos() {
        Principal.P = 2;  //2 paquetes
        Principal.V = new int[]{-5000, 2000};
        Principal.A = new int[Principal.P];
        Principal.C = new int[Principal.MAX_CAMIONES];
        Principal.N = Principal.MAX_CAMIONES;
        Principal.M = Principal.MAX_CAPACIDAD;

        Principal.VA(0);  //iniciar vuelta atrás
        assertTrue(Principal.A[0] == 0);
    }

    @Test
    public void testNoPaquetes() { 
        Principal.P = 0;  //0 paquetes
        Principal.V = new int[]{};
        Principal.A = new int[0];
        Principal.C = new int[Principal.MAX_CAMIONES];
        Principal.N = Principal.MAX_CAMIONES;
        Principal.M = Principal.MAX_CAPACIDAD;

        //verificar si lanza alguna excepción cuando se intenta procesar 0 paquetes
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Principal.VA(0);
        });
    }
    @Test
    public void testCapacidadExcedidaInicialmente() {
        Principal.P = 1;  //1 paquete
        Principal.V = new int[]{25000};  //el peso excede la capacidad máxima
        Principal.A = new int[Principal.P];
        Principal.C = new int[Principal.MAX_CAMIONES];
        Principal.N = Principal.MAX_CAMIONES;
        Principal.M = Principal.MAX_CAPACIDAD;

        Principal.VA(0);  // Iniciar vuelta atrás
        assertTrue(Principal.A[0] == 0);
    }

    @Test
    public void testSolucionExistente2() {
        Principal.P = 20;  //20 paquetes
        Principal.V = new int[]{15000,20000,5000,10000,20000,1000,20000,15000,8000,900,1000,1100,1200,1300,1400,1500,1000,1000,500,5000};
        Principal.A = new int[20];
        Principal.C = new int[Principal.MAX_CAMIONES];
        Principal.N = Principal.MAX_CAMIONES;
        Principal.M = Principal.MAX_CAPACIDAD;

        Principal.VA(0);  //iniciar vuelta atrás

        for(int i = 0; i < Principal.A.length; i++){
            assertTrue(Principal.A[i] != 0);
        }

//        assertTrue(Principal.A[0] != 0 && Principal.A[1] != 0 && Principal.A[2] != 0 && Principal.A[3] != 0 && Principal.A[4] != 0
//                && Principal.A[5] != 0 && Principal.A[6] != 0 && Principal.A[7] != 0 && Principal.A[8] != 0 && Principal.A[9] != 0
//                && Principal.A[10] != 0 && Principal.A[11] != 0 && Principal.A[12] != 0 && Principal.A[13] != 0 && Principal.A[14] != 0
//                && Principal.A[15] != 0 && Principal.A[16] != 0 && Principal.A[17] != 0 && Principal.A[18] != 0 && Principal.A[19] != 0);
    }

}
