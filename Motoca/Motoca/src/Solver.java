import java.util.Scanner;

class Person {
    private String name;
    private int age;
    public Person(String name, int age){
      this.name = name;
      this.age = age;
    }
    public String getName(){
      return name;
    }
    public int getAge(){
      return age;
    }
    public String toString(){
      return "person:(" + getName() + ":" + getAge() +")"; 
    }
}
class Motorcycle {
    private Person person; //agregacao
    private int power;
    private int time;
    //Inicia o atributo power, time com zero e person com null
    public Motorcycle(int power){
      this.power = power;
      time = 0;
      person = null;
    }
    public int getPower(){
      return power;
    }
    public int getTime(){
      return time;
    }
    public Person getPerson(){
      return person;
    }
    //Comprar mais tempo
    public void buy(int time){
      this.time = time;
    }
    //Se estiver vazio, coloca a pessoa na moto e retorna true
    public boolean enter(Person person){
      if(this.person != null){
        System.out.println("fail: busy motorcycle");
        return false;
      }
      this.person = person;
      return true;
    }
    //Se houver uma person, retira e retorna
    //Se não, retorna null
    public Person leave(){
      if(person == null){
        System.out.println("fail: empty motorcycle");
        return null;
      }
      Person retorno = person;
      person = null;
      System.out.println(retorno.getName() + ":" + retorno.getAge());    
      return retorno;
    }
    public void drive(int time){
      if(person.getAge() > 10 ){
        System.out.println("fail: too old to drive");
        return;
      }
      if(this.time <=0 ){
        System.out.println("fail: buy time first");
        return;
      }
      if(time > this.time){
        System.out.println("fail: time finished after " + this.time +" minutes");
        this.time = 0;
        return;
      }
      this.time -= time;
    }
    //buzinar
    public void honk(){
      String honk = "P";
      for(int i = 0; i < power; i++){
        honk +="e";
      }
      honk += "m";
      System.out.println(honk);
    }
    public String toString(){
      if(person == null)
        return "power:" + getPower() + ", time:" + getTime() + ", person:(empty)" ; 
      else 
        return  "power:" + getPower() + ", time:" + getTime() + ", " + person.toString();
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Motorcycle motoca  = new Motorcycle(1);
        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" "); //ui user input eh um vetor de strings
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            }else if(ui[0].equals("init")) { //power
                motoca = new Motorcycle(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("enter")) { //enter name age
                int age = Integer.parseInt(ui[2]);
                Person person = new Person(ui[1], age);
                motoca.enter(person);
            }else if(ui[0].equals("leave")) {
                motoca.leave();
            }else if(ui[0].equals("show")) {
                System.out.println(motoca);
            }else if(ui[0].equals("drive")) {
                motoca.drive(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("buy")) {
                motoca.buy(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("honk")) {
                motoca.honk();
            }else {
                System.out.println("Comando invalido");
            }
        }
        scanner.close();
    }
}

