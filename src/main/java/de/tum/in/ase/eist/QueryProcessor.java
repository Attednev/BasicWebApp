package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();

        try {
            if (query.contains("shakespeare")) {
                return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                        "English poet, playwright, and actor, widely regarded as the greatest " +
                        "writer in the English language and the world's pre-eminent dramatist.";
            } else if (query.contains("what is ")) {
                if (query.contains(" plus ")) {
                    String p = query.split("what is ")[0];
                    String n1 = p.split(" plus ")[0];
                    String n2 = p.split(" plus ")[1];
                    return (Integer.parseInt(n1) + Integer.parseInt(n2)) + "";
                }
                return "";
            } else if (query.contains("which of the following numbers is both a square and a cube: ")) {
                String str = query.split("which of the following numbers is the largest: ")[0];
                String[] numbers = str.split(", ");
                for (int i = 0; i < numbers.length; i++) {
                    int num = Integer.parseInt(numbers[i]);
                    double s_root = Math.sqrt(num);
                    double c_root = Math.cbrt(num);
                    if (Math.floor(croot) == c_root && Math.floor(s_root) == s_root) {
                        return numbers[i];
                    }
                }
                return "";
            } else if (query.contains("which of the following numbers is the largest: ")) {
                String str = query.split("which of the following numbers is the largest: ")[0];
                String[] numbers = str.split(", ");
                int max = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (i == 0) {
                        max = Integer.parseInt(numbers[i]);
                    } else {
                        int num = Integer.parseInt(numbers[i]);
                        if (num > max) {
                            max = num;
                        }
                    }
                }
                return "" + max;
            } else {

                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }
}
