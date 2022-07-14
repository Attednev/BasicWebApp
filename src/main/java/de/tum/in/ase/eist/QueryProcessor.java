package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();

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
        } else if (query.contains("which of the following numbers is the largest: ")) {
            String str = query.split("which of the following numbers is the largest: ");
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
        } else { // TODO extend the programm here

            return "";
        }
    }
}
