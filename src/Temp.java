/*
 * Nagy János, 2022-11-12
 * Copyright (c) 2022, Nagy János
 * Licenc: MIT
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Temp {
    ArrayList<Double> tempData;

    public Temp() {
        Double[] temps = { 2.5, 2.8, 1.2, 0.5, -1.1 };
        this.tempData = new ArrayList<>(Arrays.asList(temps));        
    }

    public void tempRead() {
        String end = "";
        while(!end.equals("vege")) {
            end = getTemp();
            InputNum(end);
        }
    }

    public String getTemp() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hőmérséklet: ");
        return sc.nextLine();
    }
    
    public void InputNum(String tempStr) {
        if (!tempStr.equals("vege")) {
            output(tempStr);
        }else {
            outputTemps();
        }
    }    

    public void output(String tempStr) {
        if (CheckNumberInput(tempStr)) {
            double temp = Double.parseDouble(tempStr);
            tempData.add(temp);
        }else {
            System.err.println("Hiba! Számot kell beírni!");
        }
    }
    
    public boolean CheckNumberInput(String inputNum) {
        if (inputNum.matches("[0-9.]+")) {
            return true;
        }else {
            return false;
        }
    }

    public void outputTemps() {
        for (double temp : this.tempData) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
