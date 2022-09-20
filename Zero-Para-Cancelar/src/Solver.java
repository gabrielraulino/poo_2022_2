import java.util.Scanner;
import java.util.ArrayList;
class ComputaSequencia{

    private ArrayList<Integer> numeros = new ArrayList<>();

    public void cadastra(int valor){
      if(valor == 0)
        numeros.remove(numeros.size() - 1);
      else  
        numeros.add(valor);
    }

    public int computa(){
      Integer sum = 0;
      for (Integer integer : numeros) {
        sum += integer;
      }
      return sum;
    }
    
      
    public String toString(){
      return "valores = " + numeros ;
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputaSequencia sequencia = new ComputaSequencia();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("cadastra")) {
                sequencia.cadastra( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("computa")) {
                System.out.println( sequencia.computa() ); 
            } else if(ui[0].equals("show")) {
                System.out.println( sequencia );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}