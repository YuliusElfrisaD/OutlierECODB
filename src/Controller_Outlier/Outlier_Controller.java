/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_Outlier;

import Interface_Outlier.Home;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author ASUS
 */
public class Outlier_Controller {

    public double EuclideanDistance(double data[][], int indexData1, int indexData2) {
        int kolom = data[0].length;
        double jarak = 0;
        double jumlah = 0.0;
        jarak = 0.0;
        for (int j = 1; j < kolom; j++) {
            jumlah = jumlah + Math.pow(data[indexData1][j] - data[indexData2][j], 2);
//            jarak = Math.sqrt(jumlah);
        }
        DecimalFormat format = new DecimalFormat("#0.00");
//        System.out.println("Jarak " + indexData + " - " + i + " : " + format.format(jarak));
//        return Double.valueOf(format.format(jarak));
        return Double.valueOf(format.format(Math.sqrt(jumlah)));
    }

    public void sort(double[][] baru, int x) {
        java.util.Arrays.sort(baru, new java.util.Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return compare(a[x], b[x]);
            }

            public int compare(double d1, double d2) {
                if (d1 < d2) {
                    return -1;
                }
                if (d1 > d2) {
                    return 1;
                }

                long thisBits = Double.doubleToLongBits(d1);
                long anotherBits = Double.doubleToLongBits(d2);

                return (thisBits == anotherBits ? 0
                        : (thisBits < anotherBits ? -1
                                : 1));
            }
        });
    }

    public double[][] PCL_DEV_Kdist(double simpanjarak[][], LinkedList temp, double[][] data, LinkedList[] test, int nn) {
        Outlier_Controller oc = new Outlier_Controller();
        double[][] hasil = new double[simpanjarak.length][7];
        DecimalFormat format = new DecimalFormat("#0.00");
        for (int i = 0; i < simpanjarak.length; i++) {
            double[][] baru = new double[simpanjarak[i].length][2];
            for (int j = 0; j < simpanjarak[i].length; j++) {
                baru[j][0] = simpanjarak[i][j];
                baru[j][1] = j;
            }
            oc.sort(baru, 0);

            int idx = -1;
            for (int j = 0; j < temp.size(); j++) {
                if (Double.parseDouble(temp.get(j).toString()) == data[i][0]) {
                    idx = j;
                }
            }
            int count = 0;
            System.out.println("ID Dosen ke - "+(i+1));
            double sumdat = 0;
            for (int j = 0; j < nn; j++) {
                for (int k = 0; k < test[idx].size(); k++) {
                    if (Double.parseDouble(test[idx].get(k).toString()) == baru[j][1]) {
                        count++;
                    }
                }
                sumdat = sumdat + baru[j][0];
                
                //Mencari data nilai tetangga terdekat
                String tk = Integer.toString(Home.getCek()[(int)baru[j][1]][1]);
                if (tk.equals("1")) {
                    System.out.println(((int)baru[j][1]+1)+". DASAR");
                } else if (tk.equals("2")) {
                    System.out.println(((int)baru[j][1]+1)+". MENENGAH");
                } else if (tk.equals("3")) {
                    System.out.println(((int)baru[j][1]+1)+". LANJUT");
                }
//                System.out.println(((int)baru[j][1]+1)+". "+Home.getCek()[(int)baru[j][1]][1]);               
            }
            System.out.println("");


            double sumdatx = 0;
//            System.out.println("-------------------");
            for (int j = 0; j < baru.length; j++) {
                for (int k = 0; k < test[idx].size(); k++) {
                    if (Double.parseDouble(test[idx].get(k).toString()) == ((double) baru[j][1])) {
//                        System.out.println(baru[j][1]+"   "+baru[j][0]);
                        sumdatx = sumdatx + baru[j][0];
                    }
                }
            }

            hasil[i][0] = count; //PCL
            hasil[i][1] = Double.valueOf(format.format(((double) count) / ((double) nn))); //PCL(T/K)
            hasil[i][2] = Double.valueOf(format.format(sumdatx)); //Deviation
            hasil[i][3] = Double.valueOf(format.format(sumdat)); //Kdist
        }
        return hasil;
    }

    public double Max(double data[]) {
        double max = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                max = data[i];
            } else {
                if (max < data[i]) {
                    max = data[i];
                }
            }
        }
        return max;
    }

    public double Min(double data[]) {
        double min = 0;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                min = data[i];
            } else {
                if (min > data[i]) {
                    min = data[i];
                }
            }
        }
        return min;
    }

    DecimalFormat format = new DecimalFormat("#0.00");

    public double normDeviation(double dev, double maxDev, double minDev) {
        double hasilNormDev = 0;
        hasilNormDev = (dev - minDev) / (maxDev - minDev);
        return Double.parseDouble(format.format(hasilNormDev));
    }

    public double normKDist(double KDist, double maxDev, double minDev) {
        double hasilNormKDist = 0;
        hasilNormKDist = (KDist - minDev) / (maxDev - minDev);
        return Double.parseDouble(format.format(hasilNormKDist));
    }

    public double COF(double PCL, double normDeviation, double normKDist, int K) {
        double hasilCOF = 0;
        hasilCOF = K * PCL - normDeviation + normKDist;
        return Double.parseDouble(format.format(hasilCOF));
    }
}
