package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class GroupData {
  private int id = Integer.MAX_VALUE;;
  private String name;
  private String header;
  private String header1;
  private String footer;

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }
  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withHeader1(String header1) {
    this.header1 = header1;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
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

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name);
  }
}
