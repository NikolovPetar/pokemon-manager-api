package com.demo.projects.exception.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringMapper {

    public static String toSnakeCase(String camelStr) {
        if (camelStr == null) {
            return null;
        }
        return camelStr
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }
}