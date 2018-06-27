package ru.stqa.pft.adressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import org.testng.annotations.DataProvider;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String name1;

    @Expose
    @Column(name = "lastname")
    private String name2;

    @Expose
    @Column(name = "nickname")
    private String name3;

    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String mobileHome;

    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;

    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String mobileWork;

    @Expose
    @Transient
    private String allPhones;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email1;

    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;

    @Expose
    @Transient
    private String allEmails;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();


    public Set<GroupData> getGroups() {
        return groups;
    }

    @Expose
    @Column(name = "photo")
    @Type(type = "text")
    private String photo = "src/test/resources/stru.jpg";

    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

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


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", address='" + address + '\'' +
                ", mobileHome='" + mobileHome + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobileWork='" + mobileWork + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (name1 != null ? !name1.equals(that.name1) : that.name1 != null) return false;
        if (name2 != null ? !name2.equals(that.name2) : that.name2 != null) return false;
        if (name3 != null ? !name3.equals(that.name3) : that.name3 != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (mobileHome != null ? !mobileHome.equals(that.mobileHome) : that.mobileHome != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (mobileWork != null ? !mobileWork.equals(that.mobileWork) : that.mobileWork != null) return false;
        if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        return (email3 != null ? !email3.equals(that.email3) : that.email3 != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name1 != null ? name1.hashCode() : 0);
        result = 31 * result + (name2 != null ? name2.hashCode() : 0);
        result = 31 * result + (name3 != null ? name3.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mobileHome != null ? mobileHome.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (mobileWork != null ? mobileWork.hashCode() : 0);
        result = 31 * result + (email1 != null ? email1.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        return result;
    }
    public ContactData inGroups(GroupData group) {
        groups.add(group);
        return this;
    }
}