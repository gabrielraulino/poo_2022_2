import java.util.Scanner;
import java.util.Locale;

enum Planeta {
  MERCURY(3.303e+23, 2.4397e6),
  VENUS(4.869e+24, 6.0518e6),
  EARTH(5.976e+24, 6.37814e6),
  MARS(6.421e+23, 3.3972e6),
  JUPITER(1.9e+27, 7.1492e7),
  SATURN(5.688e+26, 6.0268e7),
  URANUS(8.686e+25, 2.5559e7),
  NEPTUNE(1.024e+26, 2.4746e7);

  private final double mass; // in kilograms
  private final double radius; // in meters

  Planeta(double mass, double radius) {
    this.mass = mass;
    this.radius = radius;
  }

  private static final Double G = 6.67300E-11;

  public double forcaGravitacional() {
    return (this.G * this.mass) / (this.radius * this.radius);
  }

  public double pesoSuperficie(double otherMass) {
    return otherMass * this.forcaGravitacional() / EARTH.forcaGravitacional();
  }
}

class Pessoa {
  private String nome;
  private double mass;
  private Planeta p;

  public Pessoa(String nome, double mass, Planeta p) {
    this.nome = nome;
    this.mass = mass;
    this.p = p;
  }

  public double massaEquivalente(Planeta otherPlanet) {
    System.out.println("A forca gravitacional no planeta " + otherPlanet + " é "
        + String.format("%.2f", otherPlanet.forcaGravitacional()));
    return otherPlanet.pesoSuperficie(mass);

  }

  public String toString() {
    return "nome: " + nome + " mass: " + String.format("%.2f", mass) + " planeta: " + p;
  }

}

class Solver {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Pessoa p = new Pessoa("", 0, Planeta.EARTH);

    while (true) {
      String line = scanner.nextLine();
      String ui[] = line.split(" ");
      System.out.println("$" + line);
      if (ui[0].equals("end")) {
        break;
      } else if (ui[0].equals("init")) {
        p = new Pessoa(
            ui[1],
            Double.parseDouble(ui[2]),
            Planeta.valueOf(ui[3])
          );
      } else if (ui[0].equals("massaEquivalente")) {
        System.out.printf(Locale.US, "%.2f\n", p.massaEquivalente(Planeta.valueOf(ui[1])));
      } else if (ui[0].equals("show")) {
        System.out.println(p);
      } else {
        System.out.println("fail: comando invalido");
      }
    }
    scanner.close();
  }
}