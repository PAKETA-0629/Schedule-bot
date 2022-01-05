package org.springbootschedulebot.util;

import java.util.List;

public class PostgresConverter {

    public static String listToPostgresArray(List<String> collection) {

        return collection.toString()
                .replaceAll(", ", ",")
                .replaceAll("\\[", "{")
                .replaceAll("]", "}");
    }
}
