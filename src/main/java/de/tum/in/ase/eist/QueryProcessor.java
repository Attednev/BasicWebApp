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
        } else if (query.contains("what is 8 plus 8")) {
            return "16";
        } else if (query.contains("what is 17 plus 18")) {
            return "34";
        } else if (query.contains("what is 17 plus 18")) {
            return "35";
        } else if (query.contains("what is 8 plus 1")) {
            return "9";
        } else if (query.contains("what is 0 plus 2")) {
            return "2";
        } else { // TODO extend the programm here

            return "";
        }
    }
}
