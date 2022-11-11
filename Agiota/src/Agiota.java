  import java.util.ArrayList;
  import java.util.Iterator;
  import java.util.List;
  import java.util.Map;
  import java.util.TreeMap;
import java.util.Map.Entry;

  public class Agiota {
    private int balance;
    private int nextTrid;
    Map<String, Client> repCli;
    Map<Integer, Transaction> repTr;

    Agiota(int balance) {
      this.balance = balance;
      this.nextTrid = 0;
      repCli = new TreeMap<>();
      repTr = new TreeMap<>();
    }

    public int getBalance() {
      return balance;
    }

    public void addClient(String codename, int limit) {
      Iterator<Map.Entry<String, Client>> it = repCli.entrySet().iterator();
      if (!it.hasNext()) {
        repCli.put(codename, new Client(codename, limit));
      }
      while (it.hasNext()) {
        if (it.next().getKey().equals(codename)) {
          System.out.println("fail: cliente ja existe");
          return;
        }
      }
      repCli.put(codename, new Client(codename, limit));
    }

    public Client getClient(String nome) {
      Iterator<Map.Entry<String, Client>> it = repCli.entrySet().iterator();
      if (!it.hasNext()) {
        System.out.println("fail: cliente nao existe");
        return null;
      }
      for (Entry<String, Client> cliente : repCli.entrySet()) {
        if(cliente.getValue().getCodename().equals(nome))
          return cliente.getValue();
      }

      System.out.println("fail: cliente nao existe");
      return null;
    }

    public void kill(String codename) {
      List<Integer> killed = new ArrayList<>();
      for(Map.Entry<Integer,Transaction> par : repTr.entrySet()){
        if(par.getValue().getCodename().equals(codename))
          killed.add(par.getKey());
      }
      for (Integer integer : killed) {
        repTr.remove(integer);
      }
      repCli.remove(codename);

    }

    public void lends(String codenome, int value) {
      Client client = getClient(codenome);
      if (client == null) {
        return;
      }
      if (balance < value) {
        System.out.println("fail: fundos insuficientes");
        return;
      }
      if (client.getLimite() < value + client.getBalance()) {
        System.out.println("fail: limite excedido");
        return;
      }
      repTr.put(nextTrid, new Transaction(codenome, nextTrid, value));
      client.setBalance(value + client.getBalance());
      balance -= value;
      nextTrid++;
    }

    public void receive (String codename, int value){
      Client client = getClient(codename);
      if(client == null){
        return;
      }
      if(value > client.getBalance()){
        System.out.println("fail: valor maior que a divida");
        return;
      }
      client.setBalance(client.getBalance() - value);
      balance += value;
      repTr.put(nextTrid, new Transaction(codename, nextTrid, value * -1));
      nextTrid++;

    }
    @Override
    public String toString() {
      StringBuilder imprime = new StringBuilder();
      Iterator<Map.Entry<String, Client>> itClient = repCli.entrySet().iterator();
      imprime.append("clients:\n");
      while (itClient.hasNext()) {
        imprime.append(itClient.next().getValue().toString() + "\n");
      }
      Iterator<Map.Entry<Integer, Transaction>> itTr = repTr.entrySet().iterator();
      imprime.append("transactions:\n");
      while (itTr.hasNext()) {
        imprime.append(itTr.next().getValue().toString()+ "\n");
      }
      imprime.append("balance: " + balance);

      return imprime.toString();
    }
  }
