package org.example;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("TestCase you want to run");
            int test = scn.nextInt();
            String testcase = "testcase"+test+".json";
            // Read the JSON file
            String content = new String(Files.readAllBytes(Paths.get(testcase)));
            JSONObject json = new JSONObject(content);

            // Extract n and k from the JSON
            int n = json.getJSONObject("keys").getInt("n");
            int k = json.getJSONObject("keys").getInt("k");

            // Store the (x, y) pairs
            List<int[]> points = new ArrayList<>();

            for (String key : json.keySet()) {
                if (!key.equals("keys")) {
                    int x = Integer.parseInt(key);  // x is the key itself
                    JSONObject valueObj = json.getJSONObject(key);

                    int base = valueObj.getInt("base");  // Extract base
                    String value = valueObj.getString("value");  // Encoded y value

                    // Decode the y value based on the given base
                    int y = new BigInteger(value, base).intValue();
                    points.add(new int[]{x, y});
                }
            }

            // Calculate the constant term c using Lagrange interpolation
            int constantTerm = lagrangeInterpolation(points, k);
            System.out.println("The secret (constant term c) is: " + constantTerm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to perform Lagrange interpolation and find the constant term
    public static int lagrangeInterpolation(List<int[]> points, int k) {
        double c = 0.0;

        // Iterate over the first k points
        for (int i = 0; i < k; i++) {
            int[] pointI = points.get(i);
            int xi = pointI[0];
            int yi = pointI[1];

            double term = yi;
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    int[] pointJ = points.get(j);
                    int xj = pointJ[0];

                    term *= (0.0 - xj) / (xi - xj);
                }
            }
            c += term;
        }

        // Return the constant term rounded to the nearest integer
        return (int) Math.round(c);
    }
}
