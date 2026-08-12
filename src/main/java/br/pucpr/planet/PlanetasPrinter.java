package br.pucpr.planet;

import static br.pucpr.planet.PlanetType.*;

import br.pucpr.user.Theme;
import java.util.ArrayList;

public class PlanetasPrinter {
  public void print(ArrayList<Planet> planetas, boolean alignRight, Theme theme) {
    if (planetas == null || planetas.isEmpty()) {
      System.out.println("ERRO: Lista de planetas vazia ou nula.");
      return;
    }
    final var borderChar = theme.getBorderChar();

    // Borda superior e cabeçalho
    final var BORDER_WIDTH = 70;
    var sb = new StringBuilder();
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");
    sb.append(String.format("| %-8s | %-10s | %-14s | %-14s | %-8s |%n", "Nome", "Diâmetro", "Dist. sol (km)", "Dist. sol (ua)", "Tipo"));
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");
    for (var planeta : planetas) {
      if (planeta == null) {
        continue;
      }

      // 1 uma unidade astronomica (UA) é equivalente à distância da Terra ao Sol.
      double sunDistanceUa = (double) planeta.sunDistanceKm() / 149_600_000L;

      if (planeta.type() == ROCK) {
          sb.append(
                  String.format(
                          "| %-8s | %-10s | %-14s | %-14s | %-8s |%n",
                          planeta.name(),
                          String.format("%,.1f", planeta.diameterKm()),
                          String.format("%,d", planeta.sunDistanceKm()),
                          String.format("%,.2f", sunDistanceUa),
                          "Rochoso"));
      } else if (planeta.type() == GAS) {
        sb.append(
                String.format(
                        "| %-8s | %-10s | %-14s | %-14s | %-8s |%n",
                        planeta.name(),
                        String.format("%,.1f", planeta.diameterKm()),
                        String.format("%,d", planeta.sunDistanceKm()),
                        String.format("%,.2f", sunDistanceUa),
                        "Gasoso")); // Prof você escreveu gasoso errado no readme
      } else if (planeta.type() == ICE) {
        sb.append(
                String.format(
                        "| %-8s | %-10s | %-14s | %-14s | %-8s |%n",
                        planeta.name(),
                        String.format("%,.1f", planeta.diameterKm()),
                        String.format("%,d", planeta.sunDistanceKm()),
                        String.format("%,.2f", sunDistanceUa),
                        "Gelado"));
      } else if (planeta.type() == DWARF) {
        sb.append(
                String.format(
                        "| %-8s | %-10s | %-14s | %-14s | %-8s |%n",
                        planeta.name(),
                        String.format("%,.1f", planeta.diameterKm()),
                        String.format("%,d", planeta.sunDistanceKm()),
                        String.format("%,.2f", sunDistanceUa),
                        "Anão"));
      }

      // Borda inferior
      sb.repeat(borderChar, BORDER_WIDTH).append("\n");

      // Espaçamento
      if (alignRight) {
        var lines = sb.toString().split("\n");
        for (var line : lines) {
          System.out.println("                    " + line);
        }
      } else {
        System.out.print(sb);
      }
    }
  }


  // Eu coloquei o static e a ‘string’[] args para poder rodar pela IDE porque o javac não funcionava
  public static void main(String[] args) {
    var planetas = new ArrayList<Planet>();
    planetas.add(new Planet("Mercúrio", 4879, 57_910_000L, ROCK));
    planetas.add(new Planet("Vênus", 12104, 108_200_000L, ROCK));
    planetas.add(new Planet("Terra", 12756, 149_600_000L, ROCK));
    planetas.add(new Planet("Marte", 6792, 227_940_000L, ROCK));
    planetas.add(new Planet("Júpiter", 142984, 778_330_000L, GAS));
    planetas.add(new Planet("Saturno", 120536, 1_429_400_000L, GAS));
    planetas.add(new Planet("Urano", 51118, 2_870_990_000L, ICE));
    planetas.add(new Planet("Netuno", 49528, 4_504_300_000L, ICE));
    planetas.add(new Planet("Plutão", 2376, 5_906_380_000L, DWARF));
    new PlanetasPrinter().print(planetas, false, Theme.NORMAL);
  }
}
