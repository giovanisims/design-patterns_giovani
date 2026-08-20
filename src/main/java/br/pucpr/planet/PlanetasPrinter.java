package br.pucpr.planet;

import br.pucpr.table.Table;
import br.pucpr.table.TableData;
import br.pucpr.user.Theme;
import java.util.ArrayList;
import java.util.List;

public class PlanetasPrinter implements TableData<Planet> {

    @Override
    public List<String> getHeaders() {
        return List.of("Nome                ", "Diâmetro  ", "Dist. sol (km) ", "Dist. sol (ua) ", "Tipo      ");
    }

    @Override
    public List<String> getRowValues(Planet planet) {
        if (planet == null) {
            return List.of("", "", "", "", "");
        }
        return List.of(
                formatName(planet.name()),
                String.format("%,10.1f", planet.diameterKm()),
                String.format("%,15d", planet.sunDistanceKm()),
                String.format("%15.02f", Planet.kmToAu(planet.sunDistanceKm())),
                formatType(planet.type()));
    }

    public void print(ArrayList<Planet> planets, boolean alignRight, Theme theme) {
        if (planets == null || planets.isEmpty()) {
            System.out.println("ERRO: Lista de usuários vazia ou nula.");
            return;
        }
        new Table().print(planets, this, alignRight, theme);
    }

    private static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return "NÃO INFORMADO";
        }
        if (name.length() > 20) {
            name = name.substring(0, 17) + "...";
        }
        return name;
    }

    private static String formatType(PlanetType type) {
        return switch (type) {
            case ROCK -> "Rochoso";
            case GAS -> "Gasoso";
            case ICE -> "Gelado";
            case DWARF -> "Anão";
        };
    }
}
