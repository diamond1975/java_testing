package ru.stqa.pft.adressbook;

public class GroupData {
  private final String name;
  private final String header;
  private final String header1;
  private final String footer;

  public GroupData(String name, String header, String header1, String footer) {
    this.name = name;
    this.header = header;
    this.header1 = header1;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getHeader1() {
    return header1;
  }

  public String getFooter() {
    return footer;
  }
}
