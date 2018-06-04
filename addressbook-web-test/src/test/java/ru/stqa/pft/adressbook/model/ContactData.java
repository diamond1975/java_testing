package ru.stqa.pft.adressbook.model;

public class ContactData {

  private int id;
  private final String name1;
  private final String name2;
  private final String name3;
  private final String address;
  private final String mobileHome;
  private final String mobile;
  private final String mobileWork;
  private final String email1;
  private final String email2;
  private final String email3;
  private String group;

  public ContactData(String name1, String name2, String name3, String address, String mobileHome, String mobile, String mobileWork, String email1, String email2, String email3, String group) {

    this.id = Integer.MIN_VALUE;
    this.name1 = name1;
    this.name2 = name2;
    this.name3 = name3;
    this.address = address;
    this.mobileHome = mobileHome;
    this.mobile = mobile;
    this.mobileWork = mobileWork;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.group = group;
  }

  public ContactData(int id, String name1, String name2, String name3, String address, String mobileHome, String mobile, String mobileWork, String email1, String email2, String email3, String group) {
    this.id = id;
    this.name1 = name1;
    this.name2 = name2;
    this.name3 = name3;
    this.address = address;
    this.mobileHome = mobileHome;
    this.mobile = mobile;
    this.mobileWork = mobileWork;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.group = group;
  }

  public String getName1() {
    return name1;
  }

  public String getName2() {
    return name2;
  }

  public String getName3() {
    return name3;
  }

  public String getAddress() {
    return address;
  }

  public String getMobileHome() {
    return mobileHome;
  }

  public String getMobile() {
    return mobile;
  }

  public String getMobileWork() {
    return mobileWork;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name1='" + name1 + '\'' +
            ", name2='" + name2 + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (name1 != null ? !name1.equals(that.name1) : that.name1 != null) return false;
    return name2 != null ? name2.equals(that.name2) : that.name2 == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name1 != null ? name1.hashCode() : 0);
    result = 31 * result + (name2 != null ? name2.hashCode() : 0);
    return result;
  }
}