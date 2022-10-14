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
//    w = infEsq.getX() - subDir.getX();
//    w = Math.sqrt(Math.pow((subDir.getX() - infEsq.getX()),2) + Math.pow((subDir.getY() - infEsq.getY()),2));
    if(w < 0)
      w = w * -1;
    return w;
  }
  private double getHeight(){
    double h;
    h = subDir.getY() - infEsq.getY();
//    h = infEsq.getY() - subDir.getY();
    if(h < 0)
      h = h * -1;
    return h;
  }
  @Override
  double area() {
//    double l = Math.sqrt(Math.pow((subDir.getX() - infEsq.getX()),2) + Math.pow((subDir.getY() - infEsq.getY()),2));
    return getWidt() * getHeight();
  }

  @Override
  double perimeter() {
//    double l = Math.sqrt(Math.pow((subDir.getX() - infEsq.getX()),2) + Math.pow((subDir.getY() - infEsq.getY()),2));
    return 2 * (getHeight() + getWidt());
  }

  @Override
  public boolean inside(Ponto2D p) {
    boolean inside = false;
    if(p.getY() <= subDir.getY() && p.getY() >= infEsq.getY())
      inside = true;
    if(p.getX() <= subDir.getX() && p.getX() >= infEsq.getX() )
      inside = true;
    return inside;
  }
}
