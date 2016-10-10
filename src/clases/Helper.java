/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaime
 */
public class Helper {

    public static void mensaje(Component ventana, String mensaje, int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;

        }
    }

    public static void limpiadoTabla(JTable tabla1) {
        int nf = tabla1.getRowCount();
        int nc = tabla1.getColumnCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {
                tabla1.setValueAt("", i, j);
            }

        }
    }

    public static void porDefectoTabla(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        tm.setRowCount(0);
        tm.setColumnCount(0);
    }

    public static void habilitarBotones(JButton[] botonesH) {

        for (int i = 0; i < botonesH.length; i++) {
            botonesH[i].setEnabled(true);
        }
    }

    public static void deshabilitarBotones(JButton[] botonesD) {

        for (int i = 0; i < botonesD.length; i++) {
            botonesD[i].setEnabled(false);
        }
    }

    public static String mostrar(int[][] m) {
        String aux = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                aux = aux + m[i][j] + " ";

            }
            aux = aux + "\n";

        }
        return aux;

    }

    public static int[][] pasoDeDatos(JTable tabla1) {
        int nf, nc;
        nc = tabla1.getColumnCount();
        nf = tabla1.getRowCount();

        int m[][] = new int[nf][nc];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                m[i][j] = (int) tabla1.getValueAt(i, j);
            }

        }
        return m;

    }

    public static String recorridoHaciaDerecha(int[][] m, int i, int in, int fin) {

        String aux = "";
        for (int j = in; j <= fin; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }

    public static String recorridoHaciaAbajo(int[][] m, int j, int in, int fin) {

        String aux = "";
        for (int i = in; i < fin; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }

    public static String recorridoHaciaIzquierda(int[][] m, int i, int in, int fin) {

        String aux = "";
        for (int j = in; j >= fin; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }

    public static String recorridoUno(JTable tabla) {
        int m[][] = pasoDeDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 0, nc - 1);
        aux = aux + Helper.recorridoHaciaAbajo(m, nf - 1, 1, (nf / 2) + 1);
        aux = aux + Helper.recorridoHaciaIzquierda(m, (nf / 2), nc - 2, 0);
        aux = aux + Helper.recorridoHaciaAbajo(m, 0, (nf / 2) + 1, nf - 1);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf - 1, 0, nc - 1);
        aux = aux.substring(0, aux.length() - 2) + ".";

        return aux;
    }

    public static String recorridoHaciaArriba(int[][] m, int j, int in, int fin) {

        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;

    }

    public static String recorridoDos(JTable tabla) {
        int m[][] = pasoDeDatos(tabla);
        int nf = m.length;
        int nc = m[0].length;
        String aux = "";

        aux = aux + Helper.recorridoHaciaArriba(m, 0, nf-1, 0);
        aux = aux + Helper.recorridoHaciaDerecha(m, 0, 1, nc/2);
        aux = aux + Helper.recorridoHaciaAbajo(m, nc/2, 1, nc);
        aux = aux + Helper.recorridoHaciaDerecha(m, nf -1 , (nc/2)+1, nc-1);
        aux = aux + Helper.recorridoHaciaArriba(m, nc - 1, nf-2, 0);
        aux = aux.substring(0, aux.length() - 2) + ".";

        return aux;
    }

}
