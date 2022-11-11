public class Transaction {
  private String codename;

  private int id;

  private int value;

  public Transaction(String codename, int id, int value) {
    this.codename = codename;
    this.id = id;
    this.value = value;
  }

  public String getCodename() {
    return codename;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "- " + id + ":" + codename + ":" + value;
  }

}