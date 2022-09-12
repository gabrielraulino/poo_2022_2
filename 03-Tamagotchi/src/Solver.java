import java.util.Scanner;
class Pet{
  private int energyMax, hungryMax, cleanMax;
  private int energy, hungry, shower;
  private int diamonds;
  private int age;
  private boolean alive;
  // Atribui o valor de energia
  // Se o valor ficar abaixo de 0, o pet morre de fraqueza
  // Garanta que os valores ficarão no interalo 0 - max
  // Use esse modelo para fazer os outros métodos set
  void setEnergy(int value){
      if(value <= 0){
          this.energy = 0;
          System.out.println("fail: pet morreu de fraqueza");
          this.alive = false;
      }
      else if(value > this.energyMax)
          this.energy = this.energyMax;
      else
          this.energy = value;
  }
  public void setHungry(int value){
    if(value <= 0){
      this.hungry = 0;
      System.out.println("fail: pet morreu de fome");
      this.alive = false;
    }else if(value > this.hungryMax)
      this.hungry = hungryMax;
      else
        this.hungry = value;
  
  }
  public void setClean(int value){
    if(value <= 0){
      this.shower = 0;
      System.out.println("fail: pet morreu de sujeira");
      this.alive = false;
    }else if(value > this.cleanMax)
      this.shower = cleanMax;
      else
        this.shower = value;
  }
  public Pet(int energy, int hungry, int shower){
      this.energy = energy;
      this.energyMax = energy;
      this.hungry = hungry;
      this.hungryMax = hungry;
      this.shower = shower;
      this.cleanMax = shower;
      diamonds = 0;
      age = 0;
      alive = true;

  }
  public String toString(){
      return 
        "E:"+ energy + "/" + energyMax + 
      ", S:" + hungry + "/" + hungryMax + 
      ", L:" + shower + "/" + cleanMax + 
      ", D:" + diamonds +
      ", I:" + age;
  }
  private boolean testAlive(){
      if(!alive){
          System.out.println("fail: pet esta morto");
          alive = false;
          return alive;
      }

      return alive;
  }
  // Invoca o método testAlive para verificar se o pet esta vivo
  // Se estiver vivo, altere os atributos utilizando os métodos set e get
  public void play(){
      if(!testAlive())
          return;
      setEnergy(getEnergy() - 2);
      setHungry(getHungry() - 1);
      setClean(getClean() - 3);
      diamonds += 1;
      age += 1;
  } 
  public void shower(){
    if(!testAlive())
      return;
    
    setClean(cleanMax);
    setEnergy(getEnergy() - 3);
    setHungry(getHungry() - 1);
    age += 2;
      

  }
  public void eat(){
    if(!testAlive())
      return;
    else{
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 4);
        setClean(getClean() - 2);
        age += 1;
      }
  }
  public void sleep(){
    if(!testAlive())
      return;

    if(getEnergy() > (getEnergyMax() - 5)){
      System.out.println("fail: nao esta com sono");
    }else{
      setHungry(getHungry() - 1);
      age += getEnergyMax() - getEnergy();
      setEnergy(getEnergyMax());
    }
  }
  //Métodos GET
  int getClean(){
    return shower;
  }
  int getHungry(){
    return hungry;
  }
  int getEnergy(){
    return energy;
  }
  int getEnergyMax(){
    return energyMax;
  }
  int getCleanMax(){
    return cleanMax;
  }
  int getHungryMax(){
    return hungryMax;
  }
}
class Solver{
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Pet pet = new Pet(0, 0, 0);
      while(true) {
          String line = scanner.nextLine();
          System.out.println("$" + line);
          String ui[] = line.split(" ");
          if(ui[0].equals("end")) {
              break;
          } else if(ui[0].equals("show")) {
              System.out.println(pet.toString());
          } else if(ui[0].equals("init")) {
              int energy = Integer.parseInt(ui[1]);
              int hungry = Integer.parseInt(ui[2]);
              int shower = Integer.parseInt(ui[3]);
              pet = new Pet(energy, hungry, shower);
          } else if(ui[0].equals("play")) {
              pet.play();
          } else if(ui[0].equals("eat")) {
              pet.eat();
          } else if(ui[0].equals("shower")) {
              pet.shower();
          } else if(ui[0].equals("seep")) {
              pet.sleep();
          } else {
              System.out.println("fail: comando invalido");
          }
      }
      scanner.close();
  }
}