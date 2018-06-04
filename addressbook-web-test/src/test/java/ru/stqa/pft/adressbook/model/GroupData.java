package ru.stqa.pft.adressbook.model;

import java.util.Objects;

public class GroupData {
  private int id;
  private final String name;
  private final String header;
  private final String header1;
  private final String footer;

  public GroupData(String name, String header, String header1, String footer) {
    this.id = Integer.MAX_VALUE; // новая группа оказывается на самомм конце
    this.name = name;
    this.header = header;
    this.header1 = header1;
    this.footer = footer;
  }


  public GroupData(int id, String name, String header, String header1, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.header1 = header1;
    this.footer = footer;
  }
  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
