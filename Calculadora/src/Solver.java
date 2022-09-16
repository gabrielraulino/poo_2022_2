import java.util.Scanner;
import java.text.*;
class Calculator {
    private int batteryMax;
    private int battery;
    private double display;

    //Inicia os atributos, battery e display começam com o zero.
    public Calculator(int batteryMax) { 
        this.batteryMax = batteryMax;
        this.display = 0;
     }

    //Aumenta a bateria, porém não além do máximo.
    public void chargeBattery(int value) { 
        if(this.battery + value > this.batteryMax){
            this.battery = this.batteryMax;
        }else{
            this.battery += value;
        }
     } 

    //Tenta gastar uma unidade da bateria e emite um erro se não conseguir.
    public boolean useBattery() { 
        if (this.battery > 0) { 
            return true; 
        } 
        else { 
            return false; 
        }
     } 

    //Se conseguir gastar bateria, armazene a soma no atributo display.
    public void sum(int a, int b) { 
        if(useBattery()){
            this.display = a + b;
            this.battery--;
        }else{
            System.out.println("fail: bateria insuficiente");
        } 
     } 

    //Se conseguir gastar bateria e não for divisão por 0.
    public void division(double num, double den) { 
        if(useBattery()){
            if(den != 0){
                this.display = num / den;
                this.battery--;
            }else{
                System.out.println("fail: divisao por zero");
                this.battery--;
            }
        }else{
            System.out.println("fail: bateria insuficiente");
        } 
     }

    //Retorna o conteúdo do display com duas casas decimais.
    public String toString() { 
        DecimalFormat form = new DecimalFormat("0.00");
        return "display = " + form.format(this.display) + ", battery = " + this.battery;
    }
} 


class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(0);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(line.equals("end")) {
                break;
            } else if(ui[0].equals("init")) { //batteryMax
                calc = new Calculator(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("show")) {
                System.out.println(calc);
            } else if(ui[0].equals("charge")) {
                calc.chargeBattery(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("sum")) {//value value
                calc.sum(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if(ui[0].equals("div")) {//value value
                calc.division(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}

