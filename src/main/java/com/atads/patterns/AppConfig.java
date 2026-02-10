package com.atads.patterns;

public final class AppConfig {
    private static AppConfig instance;

    private final String appName = "ATADS Accident API";
    private final String version = "1.0.0";

    private AppConfig() {}

    public static AppConfig getInstance() {
        if (instance == null) instance = new AppConfig();
        return instance;
    }

    public String getAppName() { return appName; }
    public String getVersion() { return version; }
}
