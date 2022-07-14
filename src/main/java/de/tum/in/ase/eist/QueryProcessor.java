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
            } else if (query.contains(" number in the Fibonacci sequence")) {
                String str = query.split(" number in the Fibonacci sequence")[0];
                str = str.split("what is the ")[0];
                str = str.split("st")[0];
                str = str.split("nd")[0];
                str = str.split("rd")[0];
                str = str.split("th")[0];
                int num = Integer.parseInt(str);

                return fib(num) "";
            } else if (query.contains("which of the following numbers is both a square and a cube: ")) {
                String str = query.split("which of the following numbers is the largest: ")[0];
                String[] numbers = str.split(", ");
                for (int i = 0; i < numbers.length; i++) {
                    int num = Integer.parseInt(numbers[i]);
                    double s_root = Math.sqrt(num);
                    double c_root = Math.cbrt(num);
                    if (Math.floor(c_root) == c_root && Math.floor(s_root) == s_root) {
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

    long fib(long num) {
        long b1 = 1;
        long b2 = 1;
        for (int i = 1; i < num; i++){
            long b3 = b2;
            b2 = b2 + b1;
            b1 = b3;
        }
        return b1;
    }
}
