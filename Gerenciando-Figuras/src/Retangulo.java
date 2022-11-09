public class Retangulo extends Shape
{
  private Ponto2D infEsq;
  private Ponto2D subDir;

  public Retangulo(Ponto2D infEsq, Ponto2D subDir) {
    this.infEsq = infEsq;
    this.subDir = subDir;
  }

  public Ponto2D getInfEsq() {
    return infEsq;
  }

  public Ponto2D getSubDir() {
    return subDir;
  }
  private double getWidt(){
    double w;
    w = subDir.getX() - infEsq.getX();
    if(w < 0)
      w = w * -1;
    return w;
  }
  private double getHeight(){
    double h;
    h = subDir.getY() - infEsq.getY();
    if(h < 0)
      h = h * -1;
    return h;
  }
  @Override
  double area() {
    return getWidt() * getHeight();
  }

  @Override
  double perimeter() {
    return 2 * (getHeight() + getWidt());
  }

  @Override
  public boolean inside(Ponto2D p) {
    boolean inside = true;
    if(p.getX() > subDir.getX() || p.getY() > subDir.getY())
      inside = false;
    if(p.getX() < infEsq.getX() && p.getY() >= infEsq.getY() )
      inside = false;
    return inside;
  }

  @Override
  public String toString() {
    return String.format("Retângulo com cantos (%.1f,%.1f) e (%.1f,%.1f)", infEsq.getX(), infEsq.getY(), subDir.getX(), subDir.getY());
  }
}
