import java.util.ArrayList;
import java.util.List;

public class Empresa {
  ArrayList<Empregado> empregados = new ArrayList<>();
  Empresa() {

  }

  public void adicionaEmpregado(Empregado e) {
    empregados.add(e);
  }

  public void mostraEmpregado() {
    System.out.println("empresa:");
    for (Empregado empregado : empregados) {
      System.out.println(empregado.toString());
    }
  }

  public double calculaFolha() {
    double folha = 0d;
    for (Empregado empregado : empregados) {
      folha += empregado.pagamento();
    }
    return folha;
  }

}