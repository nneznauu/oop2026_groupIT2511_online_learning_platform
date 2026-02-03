package edu.aitu.oop3.config;

public class PlatformConfig {
    private static PlatformConfig instance;
    private String platformName;
    private String version;

    private PlatformConfig() {
        this.platformName = "AITU Online Learning Platform";
        this.version = "Milestone 2 - Build 2026";
    }

    public static synchronized PlatformConfig getInstance() {
        if (instance == null) {
            instance = new PlatformConfig();
        }
        return instance;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getVersion() {
        return version;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}