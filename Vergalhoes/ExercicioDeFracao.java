/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exerciciodefracao;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExercicioDeFracao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Informe quantos KG de Vergalhões foram comprados!");
        double Comprados = scanner.nextDouble();
        System.out.println("Informe qual é o peso do KG de vergalhão!");
        double KgV = scanner.nextDouble();

        System.out.println(KgV);
        double x, y, z;
        x = 1 / KgV;
        System.out.println(df.format(x));
        y = Comprados * x;
        z = Math.round(y);
        System.out.println("A quantidade de Unidades de Vergalhoes é de:" + z);
    }

}
