public class Circulo extends Shape {
  private double raio;
  private Ponto2D centro;

  public Circulo(Ponto2D centro, double raio) {
    this.centro = centro;
    this.raio = raio;
  }

  public double getRaio() {
    return raio;
  }

  public Ponto2D getCentro() {
    return centro;
  }

  @Override
  double area() {
    return Math.PI * Math.pow(raio, 2);
  }

  @Override
  double perimeter() {
    return 2 * Math.PI * raio;
  }

  @Override
  boolean inside(Ponto2D p) {
    double distancia;
    distancia = Math.sqrt(Math.pow((p.getX() - centro.getX()), 2) + Math.pow((p.getY() - centro.getY()), 2));
    return distancia <= getRaio();
  }

  @Override
  public String toString() {
    return String.format("Círculo com centro em (%.1f,%.1f) e raio %.1f", centro.getX(), centro.getY(), raio);
  }
}
