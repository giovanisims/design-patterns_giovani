package br.pucpr.planet;

import br.pucpr.table.TableData;
import java.util.List;

public record Planet(String name, double diameterKm, long sunDistanceKm, PlanetType type)
    implements TableData<Planet> {
  public static final long EARTH_SUN_DISTANCE_KM = 149_600_000L;

  public static double kmToAu(long km) {
    return km / (double) EARTH_SUN_DISTANCE_KM;
  }

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
        String.format("%15.02f", kmToAu(planet.sunDistanceKm())),
        formatType(planet.type()));
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
