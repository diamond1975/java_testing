package ru.stqa.pft.adressbook.model;

import com.google.gson.annotations.Expose;
import com.sun.javafx.beans.IDProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Table;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@XStreamAlias("group")
@Entity
@javax.persistence.Table (name= "group_list")
public class GroupData {
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
    if (header != null ? !header.equals(groupData.header) : groupData.header != null) return false;
    return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (header != null ? header.hashCode() : 0);
    result = 31 * result + (footer != null ? footer.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            '}';
  }

  @XStreamOmitField
  @Id
  @Column (name = "group_id")
  private int id = Integer.MAX_VALUE;;

  @Expose
  @Column (name = "group_name")
  private String name;

  @Expose
  @Column (name = "group_header")
  @Type(type = "text")
  private String header;

  @Expose
  @Column (name = "group_footer")
  @Type(type = "text")
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

 // public GroupData withHeader1(String header1) {
    //this.header1 = header1;
    //return this;
  //}

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }
  public String getHeader() {
    return header;
  }

  //public String getHeader1() {
   // return header1;
  //}

  public String getFooter() {
    return footer;
  }

}
