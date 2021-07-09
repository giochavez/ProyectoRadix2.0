import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.io.*;
public class radixSort {
    private radixSort(){
        
    }
    public static void radixMenu(List<Integer> numeros){
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            System.out.println("De que forma quieres ordenar el archivo?");
            System.out.println(" 1) Ascendente\n 2) Descendente\n 3) Salir");
            System.out.println("Opcion: ");
            op = sc.nextInt();
            switch(op){
                case 1:
                    radixA(numeros);
                    break;
                case 2:
                    radixD(numeros);
                    break;
                case 3:
                    System.out.println("Saliendo de radix...");
                    break;
                default:
                    System.out.println("Opcion no es valida");
                    break;
            }
        }while(op != 3);
        //sc.close();
    }
    public static void radixA(List<Integer> numeros){
        int u = 1, d = 10, c = 100;
        List<Integer> aux = new LinkedList<>(); //Creamos un auxiliar, el auxiliar será el arreglo original
        aux = numeros; //Llenamos a auxiliar con los elementos del arreglo original.
        List<List<Integer>> listaListas = new LinkedList<>();
        List<Integer> lista0 = new LinkedList<>();
        List<Integer> lista1 = new LinkedList<>();
        List<Integer> lista2 = new LinkedList<>();
        List<Integer> lista3 = new LinkedList<>();
        List<Integer> lista4 = new LinkedList<>();
        List<Integer> lista5 = new LinkedList<>();
        List<Integer> lista6 = new LinkedList<>();
        List<Integer> lista7 = new LinkedList<>();
        List<Integer> lista8 = new LinkedList<>();
        List<Integer> lista9 = new LinkedList<>();
        listaListas.add(lista0);
        listaListas.add(lista1);
        listaListas.add(lista2);
        listaListas.add(lista3);
        listaListas.add(lista4);
        listaListas.add(lista5);
        listaListas.add(lista6);
        listaListas.add(lista7);
        listaListas.add(lista8);
        listaListas.add(lista9);
        System.out.println("Archivo original: " + aux);
        //Comienza el ordenamiento por unidades
        numeros = ordenarC(numeros, u, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9); //Ordenar cifras
        System.out.println("\n\tUNIDADES\n");
        imprimirListas(listaListas); //Se imprimen las listas después de adjuntar cada uno de los números
        numeros.clear(); //Borramos la copia del arreglo original para poder guardar los nuevos acomodos
        numeros = agregarListasA(numeros, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9); //Despues de verificar las unidades, agregamos una a una las listas
        //ESCRITURA PRUEBA DE ARCHIVOS
        EscrituraArchivosUnidades(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        EscrituraArchivos("Lista_aux1.txt", numeros);
        //ESCRITURA PRUEBA ARCHIVOS
        vaciarListas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9); //Vaciamos las listas de magnitudes, puesto que ahí se colocarán nuevas posiciones y se verificarán nuevas unidades
        System.out.println("\nNuevo arreglo: " + numeros); //Hacemos impresión del nuevo arreglo de numeros después de la primera iteración
        //Comienza el ordenamiento por decenas
        ordenarC(numeros, d, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\n\tDECENAS\n");
        imprimirListas(listaListas);
        numeros.clear();
        numeros = agregarListasA(numeros, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        //ESCRITURA ARCHIVOS DECENAS
        EscrituraArchivosDecenas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        EscrituraArchivos("Lista_aux2.txt", numeros);
        //ESCRITURA ARCHIVOS DECENAS
        vaciarListas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\nNuevo arreglo: " + numeros);
        //Comienza el ordenamiento por centenas
        ordenarC(numeros,c, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\n\tCENTENAS\n");
        imprimirListas(listaListas);
        numeros.clear();
        numeros = agregarListasA(numeros, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        //ESCRITURA ARCHIVOS CENTENAS
        EscrituraArchivosCentenas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        EscrituraArchivos("Lista_aux3.txt", numeros);
        //ESCRITURA ARCHIVOS CENTENAS
        vaciarListas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\nNuevo arreglo: " + numeros);
    }
    public static void radixD(List<Integer> numeros){
        int u = 1, d = 10, c = 100;
        List<Integer> aux = new LinkedList<>(); //Creamos un auxiliar, el auxiliar será el arreglo original
        aux = numeros; //Llenamos a auxiliar con los elementos del arreglo original.
        List<List<Integer>> listaListas = new LinkedList<>();
        List<Integer> lista0 = new LinkedList<>();
        List<Integer> lista1 = new LinkedList<>();
        List<Integer> lista2 = new LinkedList<>();
        List<Integer> lista3 = new LinkedList<>();
        List<Integer> lista4 = new LinkedList<>();
        List<Integer> lista5 = new LinkedList<>();
        List<Integer> lista6 = new LinkedList<>();
        List<Integer> lista7 = new LinkedList<>();
        List<Integer> lista8 = new LinkedList<>();
        List<Integer> lista9 = new LinkedList<>();
        listaListas.add(lista0);
        listaListas.add(lista1);
        listaListas.add(lista2);
        listaListas.add(lista3);
        listaListas.add(lista4);
        listaListas.add(lista5);
        listaListas.add(lista6);
        listaListas.add(lista7);
        listaListas.add(lista8);
        listaListas.add(lista9);
        System.out.println("Archivo original: " + aux);
        //Comenzamos ordenando las unidades pero ahora en reversa
        numeros = ordenarC(numeros, u, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9); //Ordenar cifras
        System.out.println("\n\tUNIDADES\n");
        imprimirListasR(listaListas); //Llamamos a imprimirListasR debido a que ahora no queremos imprimir la lista del 0, queremos la lista del 9 como primer lugar hasta llegar al 0
        numeros.clear(); //Limpiamos numeros para poder llenar con las nuevas posiciones.
        numeros = agregarListasD(numeros, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9); //ahora, para generar una lista en reversa, tenemos que empezar a encolar en la lista de listas por el número con mayor magnitud
        vaciarListas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9); //Vaciamos las listas para la siguiente unidad
        System.out.println("\nNuevo arreglo: " + numeros);
        //Comenzamos ordenamiento por decenas.
        ordenarC(numeros, d, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\n\tDECENAS\n");
        imprimirListasR(listaListas);
        numeros.clear();
        numeros = agregarListasD(numeros, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        vaciarListas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\nNuevo arreglo: " + numeros);
        //Comenzamos ordenamiento por centenas.
        ordenarC(numeros,c, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\n\tCENTENAS\n");
        imprimirListasR(listaListas);
        numeros.clear();
        numeros = agregarListasD(numeros, lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        vaciarListas(lista0, lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9);
        System.out.println("\nNuevo arreglo: " + numeros);
    }
    public static List<Integer> ordenarC(List<Integer> numeros, int unidad, List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9){
        for(int i=0; i<numeros.size(); i++){
            int indice = numeros.get(i)/unidad %10;
            if(indice>=0){
                switch(indice){
                    case 0:
                        lista0.add(numeros.get(i));
                        break;
                    case 1:
                        lista1.add(numeros.get(i));
                        break;
                    case 2:
                        lista2.add(numeros.get(i));
                        break;
                    case 3:
                        lista3.add(numeros.get(i));
                        break;
                    case 4:
                        lista4.add(numeros.get(i));
                        break;
                    case 5:
                        lista5.add(numeros.get(i));
                        break;
                    case 6:
                        lista6.add(numeros.get(i));
                        break;
                    case 7:
                        lista7.add(numeros.get(i));
                        break;
                    case 8:
                        lista8.add(numeros.get(i));
                        break;
                    case 9:
                        lista9.add(numeros.get(i));
                        break;
                    default:
                        System.out.println("Wtf no debería suceder");
                        break; 
                }
            }
        }
        return numeros;
    }
    public static void imprimirListas(List<List<Integer>> listaPrint){
        int i;
        for(i = 0; i<(listaPrint.size());i++){
            System.out.println("Lista " + i + ":" + listaPrint.get(i));
        }
        if(listaPrint.isEmpty()){
            System.out.println("[Lista vacia]");
        }
    }
    public static void imprimirListasR(List<List<Integer>> listaPrint){
        int i;
        for(i = listaPrint.size()-1; i >= 0;i--){
            System.out.println("Lista " + i + ":" + listaPrint.get(i));
        }
        if(listaPrint.isEmpty()){
            System.out.println("[Lista vacia]");
        }
    }
    public static List<Integer> agregarListasA(List<Integer> listaNum, List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9){
        for(int i=0; i<lista0.size(); i++){
            listaNum.add(lista0.get(i));
        }
        for(int i=0; i<lista1.size(); i++){
            listaNum.add(lista1.get(i));
        }
        for(int i=0; i<lista2.size(); i++){
            listaNum.add(lista2.get(i));
        }
        for(int i=0; i<lista3.size(); i++){
            listaNum.add(lista3.get(i));
        }
        for(int i=0; i<lista4.size(); i++){
            listaNum.add(lista4.get(i));
        }
        for(int i=0; i<lista5.size(); i++){
            listaNum.add(lista5.get(i));
        }
        for(int i=0; i<lista6.size(); i++){
            listaNum.add(lista6.get(i));
        }
        for(int i=0; i<lista7.size(); i++){
            listaNum.add(lista7.get(i));
        }
        for(int i=0; i<lista8.size(); i++){
            listaNum.add(lista8.get(i));
        }
        for(int i=0; i<lista9.size(); i++){
            listaNum.add(lista9.get(i));
        }
        return listaNum;
    }
    public static void vaciarListas(List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9){
        lista0.clear();
        lista1.clear();
        lista2.clear();
        lista3.clear();
        lista4.clear();
        lista5.clear();
        lista6.clear();
        lista7.clear();
        lista8.clear();
        lista9.clear();
    }
    public static List<Integer> agregarListasD(List<Integer> listaNum, List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9){
        for(int i=0; i<lista9.size(); i++){
            listaNum.add(lista9.get(i));
        }
        for(int i=0; i<lista8.size(); i++){
            listaNum.add(lista8.get(i));
        }
        for(int i=0; i<lista7.size(); i++){
            listaNum.add(lista7.get(i));
        }
        for(int i=0; i<lista6.size(); i++){
            listaNum.add(lista6.get(i));
        }
        for(int i=0; i<lista5.size(); i++){
            listaNum.add(lista5.get(i));
        }
        for(int i=0; i<lista4.size(); i++){
            listaNum.add(lista4.get(i));
        }
        for(int i=0; i<lista3.size(); i++){
            listaNum.add(lista3.get(i));
        }
        for(int i=0; i<lista2.size(); i++){
            listaNum.add(lista2.get(i));
        }
        for(int i=0; i<lista1.size(); i++){
            listaNum.add(lista1.get(i));
        }
        for(int i=0; i<lista0.size(); i++){
            listaNum.add(lista0.get(i));
        }
        return listaNum;
    }
    public static void EscrituraArchivos(String nombre, List<Integer> numeros) {
            PrintWriter fileOut;
            try{
                fileOut = new PrintWriter(nombre);
                        int[] aux = new int[numeros.size()];
                        for(int i=0;i<numeros.size();i++){
                            aux[i] = numeros.get(i);
                            fileOut.println(aux[i]+",");
                        }
                fileOut.close();
            }
            catch (FileNotFoundException e){
                System.out.println("Error: " + e.getMessage());
            }
    }
    public static void EscrituraArchivosUnidades(List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9) {
        PrintWriter fileOut;
        try{
            fileOut = new PrintWriter("Unidades_F0.txt");
                        int[] aux = new int[lista0.size()];
                        for(int i=0;i<lista0.size();i++){
                            aux[i] = lista0.get(i);
                            fileOut.println(aux[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F1.txt");
                        int[] aux1 = new int[lista1.size()];
                        for(int i=0;i<lista1.size();i++){
                            aux1[i] = lista1.get(i);
                            fileOut.println(aux1[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F2.txt");
                        int[] aux2 = new int[lista2.size()];
                        for(int i=0;i<lista2.size();i++){
                            aux2[i] = lista2.get(i);
                            fileOut.println(aux2[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F3.txt");
                        int[] aux3 = new int[lista3.size()];
                        for(int i=0;i<lista3.size();i++){
                            aux3[i] = lista3.get(i);
                            fileOut.println(aux3[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F4.txt");
                        int[] aux4 = new int[lista4.size()];
                        for(int i=0;i<lista4.size();i++){
                            aux4[i] = lista4.get(i);
                            fileOut.println(aux4[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F5.txt");
                        int[] aux5 = new int[lista5.size()];
                        for(int i=0;i<lista5.size();i++){
                            aux5[i] = lista5.get(i);
                            fileOut.println(aux5[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F6.txt");
                        int[] aux6 = new int[lista6.size()];
                        for(int i=0;i<lista6.size();i++){
                            aux6[i] = lista6.get(i);
                            fileOut.println(aux6[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F7.txt");
                        int[] aux7 = new int[lista7.size()];
                        for(int i=0;i<lista7.size();i++){
                            aux7[i] = lista7.get(i);
                            fileOut.println(aux7[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F8.txt");
                        int[] aux8 = new int[lista8.size()];
                        for(int i=0;i<lista8.size();i++){
                            aux8[i] = lista8.get(i);
                            fileOut.println(aux8[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Unidades_F9.txt");
                        int[] aux9 = new int[lista9.size()];
                        for(int i=0;i<lista9.size();i++){
                            aux9[i] = lista9.get(i);
                            fileOut.println(aux9[i]+",");
                        }
            fileOut.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void EscrituraArchivosDecenas(List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9) {
        PrintWriter fileOut;
        try{
            fileOut = new PrintWriter("Decenas_F0.txt");
                        int[] aux = new int[lista0.size()];
                        for(int i=0;i<lista0.size();i++){
                            aux[i] = lista0.get(i);
                            fileOut.println(aux[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F1.txt");
                        int[] aux1 = new int[lista1.size()];
                        for(int i=0;i<lista1.size();i++){
                            aux1[i] = lista1.get(i);
                            fileOut.println(aux1[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F2.txt");
                        int[] aux2 = new int[lista2.size()];
                        for(int i=0;i<lista2.size();i++){
                            aux2[i] = lista2.get(i);
                            fileOut.println(aux2[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F3.txt");
                        int[] aux3 = new int[lista3.size()];
                        for(int i=0;i<lista3.size();i++){
                            aux3[i] = lista3.get(i);
                            fileOut.println(aux3[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F4.txt");
                        int[] aux4 = new int[lista4.size()];
                        for(int i=0;i<lista4.size();i++){
                            aux4[i] = lista4.get(i);
                            fileOut.println(aux4[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F5.txt");
                        int[] aux5 = new int[lista5.size()];
                        for(int i=0;i<lista5.size();i++){
                            aux5[i] = lista5.get(i);
                            fileOut.println(aux5[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F6.txt");
                        int[] aux6 = new int[lista6.size()];
                        for(int i=0;i<lista6.size();i++){
                            aux6[i] = lista6.get(i);
                            fileOut.println(aux6[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F7.txt");
                        int[] aux7 = new int[lista7.size()];
                        for(int i=0;i<lista7.size();i++){
                            aux7[i] = lista7.get(i);
                            fileOut.println(aux7[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F8.txt");
                        int[] aux8 = new int[lista8.size()];
                        for(int i=0;i<lista8.size();i++){
                            aux8[i] = lista8.get(i);
                            fileOut.println(aux8[i]+",");
                        }
            fileOut.close();
            fileOut = new PrintWriter("Decenas_F9.txt");
                        int[] aux9 = new int[lista9.size()];
                        for(int i=0;i<lista9.size();i++){
                            aux9[i] = lista9.get(i);
                            fileOut.println(aux9[i]+",");
                        }
            fileOut.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
}
public static void EscrituraArchivosCentenas(List<Integer> lista0, List<Integer> lista1, List<Integer> lista2, List<Integer> lista3, List<Integer> lista4, List<Integer> lista5, List<Integer> lista6, List<Integer> lista7, List<Integer> lista8, List<Integer> lista9) {
    PrintWriter fileOut;
    try{
        fileOut = new PrintWriter("Centenas_F0.txt");
                    int[] aux = new int[lista0.size()];
                    for(int i=0;i<lista0.size();i++){
                        aux[i] = lista0.get(i);
                        fileOut.println(aux[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F1.txt");
                    int[] aux1 = new int[lista1.size()];
                    for(int i=0;i<lista1.size();i++){
                        aux1[i] = lista1.get(i);
                        fileOut.println(aux1[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F2.txt");
                    int[] aux2 = new int[lista2.size()];
                    for(int i=0;i<lista2.size();i++){
                        aux2[i] = lista2.get(i);
                        fileOut.println(aux2[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F3.txt");
                    int[] aux3 = new int[lista3.size()];
                    for(int i=0;i<lista3.size();i++){
                        aux3[i] = lista3.get(i);
                        fileOut.println(aux3[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F4.txt");
                    int[] aux4 = new int[lista4.size()];
                    for(int i=0;i<lista4.size();i++){
                        aux4[i] = lista4.get(i);
                        fileOut.println(aux4[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F5.txt");
                    int[] aux5 = new int[lista5.size()];
                    for(int i=0;i<lista5.size();i++){
                        aux5[i] = lista5.get(i);
                        fileOut.println(aux5[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F6.txt");
                    int[] aux6 = new int[lista6.size()];
                    for(int i=0;i<lista6.size();i++){
                        aux6[i] = lista6.get(i);
                        fileOut.println(aux6[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F7.txt");
                    int[] aux7 = new int[lista7.size()];
                    for(int i=0;i<lista7.size();i++){
                        aux7[i] = lista7.get(i);
                        fileOut.println(aux7[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F8.txt");
                    int[] aux8 = new int[lista8.size()];
                    for(int i=0;i<lista8.size();i++){
                        aux8[i] = lista8.get(i);
                        fileOut.println(aux8[i]+",");
                    }
        fileOut.close();
        fileOut = new PrintWriter("Centenas_F9.txt");
                    int[] aux9 = new int[lista9.size()];
                    for(int i=0;i<lista9.size();i++){
                        aux9[i] = lista9.get(i);
                        fileOut.println(aux9[i]+",");
                    }
        fileOut.close();
    }
    catch (FileNotFoundException e){
        System.out.println("Error: " + e.getMessage());
    }
}
    
}
