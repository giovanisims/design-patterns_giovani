package br.pucpr.planet;

import static br.pucpr.planet.PlanetType.*;

import br.pucpr.user.Theme;
import java.util.ArrayList;

public class PlanetasPrinter {
  public void print(ArrayList<Planet> planetas, boolean alignRight, Theme theme) {
    // Implemente sua solução aqui
  }

  static void main() {
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
