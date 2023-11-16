/*
 * Nagy János, 2022-11-12
 * Copyright (c) 2022, Nagy János
 * Licenc: MIT
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Temp {
    ArrayList<Double> tempList;
    protected Scanner sc;

    public Temp() {
        Double[] baseTemps = { 2.5, 2.8, 1.2, 0.5, -1.1 };
        this.tempList = new ArrayList<>(Arrays.asList(baseTemps));        
    }

    public void tempRead() {
        String inputData = "";
        while(!inputData.equals("vege")) {
            inputData = getTemp();
            checkIfRunning(inputData);
        }
    }

    public String getTemp() {
        sc = new Scanner(System.in);
        System.out.print("Hőmérséklet: ");
        return sc.nextLine();
    }
    
    public void checkIfRunning(String tempStr) {
        if (!tempStr.equals("vege")) {
            convertAndAdd(tempStr);
        }else {
            sc.close();
            writeList();
        }
    }    

    public void convertAndAdd(String tempStr) {
        if (checkInput(tempStr)) {
            double temp = Double.parseDouble(tempStr);
            tempList.add(temp);
        }else {
            System.err.println("Hiba! Számot kell beírni!");
        }
    }
    
    public boolean checkInput(String input) {
        if (input.matches("[0-9.]+")) {
            return true;
        }else {
            return false;
        }
    }

    public void writeList() {
        for (double temp : this.tempList) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
