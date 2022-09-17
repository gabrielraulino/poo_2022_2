class Manual{
  public static void main(String[] args) {
      //case subindo e buzinando
      Motorcycle moto = new Motorcycle(1);
      System.out.println(moto);
      //power: 1, minutos: 0, person: null
      moto.honk();
      //fail: moto vazia
      moto.enter(new Person("marcos", 4));
      System.out.println(moto);
      //power: 1, minutos: 0, person: [marcos:4]
      moto.honk();
      //Pem
      moto.enter(new Person("marisa", 2));
      //fail: moto ocupada
      System.out.println(moto);
      //power: 1, minutos: 0, person: [marcos:4]

      //case subindo e buzinando
      moto = new Motorcycle(5);
      System.out.println(moto);
      //power: 5, minutos: 0, person: null
      moto.enter(new Person("marcos", 4));
      System.out.println(moto);
      //power: 5, minutos: 0, person: [marcos:4]
      moto.honk();
      //Peeeeem

      //case subindo e trocando
      moto = new Motorcycle(7);
      moto.enter(new Person("heitor", 6));
      System.out.println(moto);
      //power: 7, minutos: 0, person: [heitor:6]
      Person heitor = moto.leave();
      System.out.println(heitor);
      //[heitor:6]
      moto.leave();
      //fail: moto vazia
      moto.enter(new Person("suzana", 8));
      System.out.println(moto);
      //power: 7, minutos: 0, person: [suzana:8]

      //case passeando
      moto = new Motorcycle(7);
      moto.enter(new Person("suzana", 8));
      moto.drive(10);
      //fail: time zerado
      moto.buy(40);
      System.out.println(moto);
      //power: 7, minutos: 40, person: [suzana:8]
      moto.drive(20);
      System.out.println(moto);
      //power: 7, minutos: 20, person: [suzana:8]

      //case nem grande nem pequeno
      moto = new Motorcycle(7);
      moto.buy(20);
      moto.enter(new Person("andreina", 23));
      moto.drive(15);
      //fail: muito grande para andar de moto
      System.out.println(moto);
      //power: 7, minutos: 20, person: [andreina:23]

      //case acabou o time
      moto = new Motorcycle(7);
      moto.buy(20);
      moto.enter(new Person("andreina", 6));
      moto.drive(15);
      System.out.println(moto);
      //power: 7, minutos: 5, person: [andreina:6]
      moto.drive(10);
      //fail: andou 5 min e acabou o time
  }
}