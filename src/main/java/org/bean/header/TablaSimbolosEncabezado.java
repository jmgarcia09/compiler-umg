/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bean.header;

import org.springframework.core.io.ClassPathResource;

import java.io.*; // PARA LEER EL ARCHIVO
import java.util.ArrayList;

/**
 * @author WorkStation_Pro
 */
public class TablaSimbolosEncabezado {
    static final String SEPARATOR = ";";
    BufferedReader br;

    public ArrayList<EstructuraEncabezado> RetornaTablaSimbEnc1() throws IOException {
        ArrayList<EstructuraEncabezado> listaInterna = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("./TablasSimbolos/TablaSimbolos_Encabezado_Part1.csv");

            EstructuraEncabezado enc = new EstructuraEncabezado();
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = br.readLine();
            while (null != line) {
                String[] arr = line.split(SEPARATOR);
                //System.out.println(Arrays.toString(arr));

                if (arr.length == 1) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], "", "", "", "", ""));
                } else if (arr.length == 2) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], "", "", "", ""));
                } else if (arr.length == 3) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], "", "", ""));
                } else if (arr.length == 4) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], "", ""));
                } else if (arr.length == 5) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], arr[4], ""));
                } else if (arr.length == 6) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
                }

                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("El error es de tipo " + e);
        } finally {
            if (null != br) {
                br.close();
            }
        }
        return listaInterna;
    }

    public ArrayList<EstructuraEncabezado> RetornaTablaSimbEnc2() throws IOException {
        ArrayList<EstructuraEncabezado> listaInterna = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("./TablasSimbolos/TablaSimbolos_Encabezado_Part2.csv");
            EstructuraEncabezado enc = new EstructuraEncabezado();

            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = br.readLine();
            while (null != line) {
                String[] arr = line.split(SEPARATOR);
//            System.out.println(Arrays.toString(fields));

                if (arr.length == 1) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], "", "", "", "", ""));
                } else if (arr.length == 2) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], "", "", "", ""));
                } else if (arr.length == 3) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], "", "", ""));
                } else if (arr.length == 4) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], "", ""));
                } else if (arr.length == 5) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], arr[4], ""));
                } else if (arr.length == 6) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
                }

                line = br.readLine();
            }



        } catch (Exception e) {
            System.out.println("El error es de tipo " + e);
        } finally {
            if (null != br) {
                br.close();
            }
        }
        return listaInterna;
    }

    public ArrayList<EstructuraEncabezado> RetornaTablaSimbEnc3() throws IOException {
        ArrayList<EstructuraEncabezado> listaInterna = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("./TablasSimbolos/TablaSimbolos_Encabezado_Part3.csv");
            EstructuraEncabezado enc = new EstructuraEncabezado();

            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = br.readLine();
            while (null != line) {
                String[] arr = line.split(SEPARATOR);
                // System.out.println(Arrays.toString(arr));

                if (arr.length == 1) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], "", "", "", "", ""));
                } else if (arr.length == 2) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], "", "", "", ""));
                } else if (arr.length == 3) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], "", "", ""));
                } else if (arr.length == 4) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], "", ""));
                } else if (arr.length == 5) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], arr[4], ""));
                } else if (arr.length == 6) {
                    listaInterna.add(new EstructuraEncabezado(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]));
                }

                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("El error es de tipo " + e);
        } finally {
            if (null != br) {
                br.close();
            }
        }
        return listaInterna;
    }
}
    
    
    
    
    
     

    
    
    
    


 
