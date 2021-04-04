package io.delta;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static int counter = 0;
    public static void main(String[] args) throws IOException {
        File file= new File(System.getProperty("user.home") + "/Desktop/game2.txt");
        findMoney(file,"bank :");
        findKm(file," trip_fuel: &3f1d46a9");
    }

    public static void findMoney(File f, String searchString) {
        boolean result = false;
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(f));
            while(in.hasNextLine() && !result) {
                counter++;

                if (in.nextLine().contains(searchString)) {
                    String money = in.nextLine().replaceAll("money_account: ", "").trim();
                    System.out.println("Paranız: "+money);
                    return;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try { in.close() ; } catch(Exception e) { /* ignore */ }
        }
    }
    public static void findKm(File f, String searchString) {
        boolean result = false;
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(f));
            while(in.hasNextLine() && !result) {
                counter++;

                if (in.nextLine().contains(searchString)) {
                    String km = in.nextLine().replaceAll("trip_distance_km: ", "").trim();
                    System.out.println("Kilometreniz: "+km);
                    return;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try { in.close() ; } catch(Exception e) { /* ignore */ }
        }
    }
}
