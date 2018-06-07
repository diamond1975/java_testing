package ru.stqa.pft.adressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name1;
  private String name2;
  private String name3;
  private String address;
  private String mobileHome;
  private String mobile;
  private String mobileWork;
  private String email1;


  private String email2;
  private String email3;
  private String group;

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName1(String name1) {
    this.name1 = name1;
    return this;
  }

  public ContactData withName2(String name2) {
    this.name2 = name2;
    return this;
  }

  public ContactData withName3(String name3) {
    this.name3 = name3;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobileHome(String mobileHome) {
    this.mobileHome = mobileHome;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withMobileWork(String mobileWork) {
    this.mobileWork = mobileWork;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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