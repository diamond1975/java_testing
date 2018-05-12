package ru.stqa.pft.adressbook;

public class ContactData {
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

  public ContactData(String name1, String name2, String name3, String address, String mobileHome, String mobile, String mobileWork, String email1, String email2, String email3) {
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
}
