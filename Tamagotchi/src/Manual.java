
class Manual {
  public static void main(String[] args) {
      //case inicio
      Pet pet = new Pet(20, 10, 15);
      System.out.println(pet);
      //E:20/20, S:10/10, L:15/15, D:0, I:0
      pet = new Pet(10, 20, 50);
      System.out.println(pet);
      //E:10/10, S:20/20, L:50/50, D:0, I:0

      //case play - Brincar 
      pet = new Pet(20, 10, 15);
      pet.play();
      System.out.println(pet);
      //E:18/20, S:9/10, L:12/15, D:1, I:1
      pet.play();
      System.out.println(pet);
      //E:16/20, S:8/10, L:9/15, D:2, I:2

      //case comer 
      pet.eat();
      System.out.println(pet);
      //E:15/20, S:10/10, L:7/15, D:2, I:3

      //case dormir
      pet.sleep();
      System.out.println(pet);
      //E:20/20, S:9/10, L:7/15, D:2, I:8

      //case tomar banho
      pet.shower();
      System.out.println(pet);
      //E:17/20, S:8/10, L:15/15, D:2, I:10

      //case dormir sem sono
      pet.sleep();
      //fail: nao esta com sono

      //case morrer
      pet.play();
      pet.play();
      pet.play();
      pet.play();
      System.out.println(pet);
      //E:9/20, S:4/10, L:3/15, D:6, I:14
      pet.play();
      //fail: pet morreu de sujeira
      System.out.println(pet);
      //E:7/20, S:3/10, L:0/15, D:7, I:15
      pet.play();
      //fail: pet esta morto
      pet.eat();
      //fail: pet esta morto
      pet.shower();
      //fail: pet esta morto
      pet.sleep();
      //fail: pet esta morto

      //case exemplo2
      pet = new Pet(5, 10, 10);
      pet.play();
      pet.play();
      pet.play();
      //fail: pet morreu de fraqueza
      pet.play();
      //fail: pet esta morto
      System.out.println(pet);
      //E:0/5, S:7/10, L:1/10, D:3, I:3

      //case exemplo3
      pet = new Pet(10, 3, 10);
      pet.play();
      pet.play();
      pet.play();
      //fail: pet morreu de fome
      pet.play();
      //fail: pet esta morto
      System.out.println(pet);
      //E:4/10, S:0/3, L:1/10, D:3, I:3
  }
}