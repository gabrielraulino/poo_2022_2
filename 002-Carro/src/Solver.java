import java.util.Scanner;

class Car{
    private int pass; // Passageiros
    private int passMax; // limite de Passageiros
    private int gas; // tanque
    private int gasMax; // limite do tanque
    private int km; // quantidade de quilometragem
    
    public Car(){
        this.pass = 0;
        this.gas = 0;
        this.km = 0;
        this.gasMax = 100;
        this.passMax = 2;

    }
    public String toString(){
        
        return ("pass: "+ this.pass +", gas: "+ this.gas +", km: " + this.km);
    }
    public void enter(){
        if(this.pass < 2){
            this.pass++;
        }else{
            System.out.println("fail: limite de pessoas atingido");
        }
    }
    public void leave(){
        if(this.pass > 0){
            this.pass--;
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    public void fuel(int gas){
        if((this.gas + gas) <= this.gasMax){
            this.gas += gas;
        }else{
            this.gas = this.gasMax;
        } 
    }
    public void drive (int km){
        if(this.pass > 0){
            if(this.gas >= km){
                this.km = km;
                this.gas -= km;
            }else{
                if(this.gas == 0){
                    System.out.println("fail: tanque vazio");
                }else{
                    this.km += this.gas;
                    System.out.println("fail: tanque vazio apos andar "+ this.gas +" km");
                    this.gas = 0;
                }
            }
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
};

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("enter")) {
                car.enter();
            } else if(ui[0].equals("leave")) {
                car.leave();
            } else if(ui[0].equals("show")) {
                System.out.println(car.toString());
            } else if (ui[0].equals("drive")) {//km
                car.drive(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("fuel")) {//gas
                car.fuel(Integer.parseInt(ui[1]));
            } else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}