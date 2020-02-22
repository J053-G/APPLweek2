/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Copyfille;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class CopyFile {
    public static void main(String[] args) throws FileNotFoundException{
      //  String location = "C:\\Users\\Asus\\Documents\\NetBeansProjects\\matkulapplweek2\\src\\Copyfille\\Dokumen.txt";
        String location ="C:\\Users\\Asus\\Documents\\NetBeansProjects\\matkulapplweek2\\src\\Copyfille\\Dokumen.txt";
        int panjang= location.length();
        System.out.println(panjang);
        String file_name = location.substring(panjang-11);
        Scanner input_scan = new Scanner(System.in);
        String input ="";
        while(!(file_name.equals(input))){
            try{
                System.out.print("Input name file : ");
                input = input_scan.nextLine();
                
                if(file_name.equals(input)){
                    File file =new File(location);
                    Scanner scan_file = new Scanner(file);
                    
                    while(scan_file.hasNextLine()){
                        String line = scan_file.nextLine();
                        System.out.println(line);
                    }
                }else{
                    throw new FileNotFoundException();
                }
            }catch(FileNotFoundException ex){
                System.out.println("File Not Found");
            }
        }
    }
}
