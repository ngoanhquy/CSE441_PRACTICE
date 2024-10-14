package com.example.bai3;

public class Country {
    private final String name;
    private final String capital;
    private final String population;
    private final String area;
    private final String density;
    private final String worldShare;
    private final int flagResId;  // Lưu trữ resource id của lá cờ

    public Country(String name, String capital, String population, String area, String density, String worldShare, int flagResId) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
        this.flagResId = flagResId;
    }

    public String getName() { return name; }
    public String getCapital() { return capital; }
    public String getPopulation() { return population; }
    public String getArea() { return area; }
    public String getDensity() { return density; }
    public String getWorldShare() { return worldShare; }
    public int getFlagResId() { return flagResId; }
}
