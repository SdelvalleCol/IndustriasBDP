package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        int cont1 = 0;
        String p;
        String data = "";
        boolean pared = false;
        do {
            p = l.nextLine();
            for (int r = 0; r < p.length(); r++) {
                char o = p.charAt(r);
                if (o == 'e' || o == 'm' || o == '0' || o == '1') {
                    data += o;
                }
            }
            if (cont1 != 0) {
                for (int j = 0; j < p.length(); j++) {
                    char k = p.charAt(j);
                    if (k == '0' || k == 'm' || k == 'e') {
                        pared = false;
                        break;
                    } else if (k == '1') {
                        pared = true;
                    }
                }
            }
            cont1++;
        } while (pared != true);
        System.out.println("Digite el ancho de la matriz");
        int a = l.nextInt();
        //Metodo para encontrar e
        int coordxe = 0;
        int coordye = 0;
        int ind1 = 0;
        char gg1 = 'x';
        do {
            ind1++;
            gg1 = data.charAt(ind1);
            coordxe++;
            if (coordxe >= a) {
                coordxe = 0;
                coordye++;
            }
        } while (gg1 != 'e');
        System.out.println("Las coordenas de e son \n" + "[" + coordye + "," + coordxe + "]");

        //Metodo para encontrar M
        int coordxm = 0;
        int coordym = 0;
        int ind2 = 0;
        char gg2 = 'x';
        do {
            ind2++;
            gg2 = data.charAt(ind2);
            coordxm++;
            if (coordxm >= a) {
                coordxm = 0;
                coordym++;
            }
        } while (gg2 != 'm');
        System.out.println("Las coordenas de m son \n" + "[" + coordym + "," + coordxm + "]");
        //System.out.println(data);

        //Camino de m a e
        char rev;
        char cond = data.charAt(coordxm+(a*coordym));
        ListStack structure = new ListStack();
        Object rute;
        while (cond != 'e'){
            if(coordxm!=coordxe){
                if(coordxm>coordxe){
                    coordxm--;
                    rev = data.charAt(coordxm+(a*coordym));
                    if(rev=='1'){
                        coordxm++;
                    }
                }else if (coordxm < coordxe) {
                    coordxm++;
                    rev = data.charAt(coordxm+(a*coordym));
                    if(rev=='1'){
                        coordxm--;
                    }
                }
            }
            rute = "[" + coordym + "," + coordxm + "]";
            structure.push(rute);
            if(coordym!=coordye){
                if(coordym>coordye){
                    coordym--;
                    rev = data.charAt(coordxm+(a*coordym));
                    if(rev=='1'){
                        coordym++;
                    }
                }else if (coordym < coordye) {
                    coordym++;
                    rev = data.charAt(coordxm+(a*coordym));
                    if(rev=='1'){
                        coordym--;
                    }
                }
            }
            rute = "[" + coordym + "," + coordxm + "]";
            structure.push(rute);
            cond = data.charAt(coordxm+(a*coordym));
        }
        System.out.println("El camino a seguir es" + structure); // Se lee de derecha a izquierda*
    }
}