package com.atads.utils;

import java.util.Comparator;
import java.util.List;

public final class SortingUtils {

    private SortingUtils() { }
    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        if (list == null || comparator == null) return;
        list.sort(comparator);
    }

    public static Comparator<com.atads.model.AccidentEvent> bySeverity() {
        return (a1, a2) -> Integer.compare(a1.getSeverity(), a2.getSeverity());
    }

    public static Comparator<com.atads.model.AccidentEvent> byLocation() {
        return (a1, a2) -> a1.getLocation().compareToIgnoreCase(a2.getLocation());
    }

    public static Comparator<com.atads.model.AccidentEvent> byType() {
        return (a1, a2) -> a1.getAccidentType().compareToIgnoreCase(a2.getAccidentType());
    }
}
