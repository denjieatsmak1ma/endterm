package com.atads.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflectionUtils {

    private ReflectionUtils() { }

    public static String describe(Object obj) {
        if (obj == null) return "null";

        StringBuilder sb = new StringBuilder();
        Class<?> c = obj.getClass();

        sb.append("Class: ").append(c.getName()).append("\n");

        sb.append("Fields:\n");
        for (Field f : c.getDeclaredFields()) {
            f.setAccessible(true);
            sb.append(" - ").append(f.getName())
                    .append(" : ").append(f.getType().getSimpleName());
            try {
                sb.append(" = ").append(f.get(obj));
            } catch (Exception e) {
                sb.append(" = <error>");
            }
            sb.append("\n");
        }

        sb.append("Methods:\n");
        for (Method m : c.getDeclaredMethods()) {
            sb.append(" - ").append(m.getName()).append("()\n");
        }

        return sb.toString();
    }
}
