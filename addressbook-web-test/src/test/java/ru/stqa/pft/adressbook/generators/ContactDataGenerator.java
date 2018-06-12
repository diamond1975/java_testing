package ru.stqa.pft.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.adressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContact(count);
    if (format.equals("csv")) {
      saveASXml(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveASXml(contacts, new File(file));
    }else if(format.equals("json")) {
      saveASJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }
  private void saveASJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson (contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveASXml(List<ContactData> cotacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml =xStream.toXML(cotacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }
  private void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", contact.getName1(), contact.getName2(),
              contact.getAddress(), contact.getEmail1(),contact.getEmail2(),contact.getEmail3(), contact.getMobileHome()
                      ,contact.getMobile(),contact.getMobileWork(), contact.getGroup()));
    }
    writer.close();
  }


  private List<ContactData> generateContact(int count) {
    List<ContactData> contact = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contact.add(new ContactData().withName1(String.format("Gabdullin %s", i)).withName2 (String.format("Almaz %s", i))
              .withAddress(String.format("Moscow %s", i)).withEmail1(String.format("test@yandex.ru %s", i))
              .withEmail2(String.format("test2@yandex.ru %s", i)).withEmail3(String.format("test3@yandex.ru %s", i))
              .withMobileHome(String.format("112548932", i)).withMobile(String.format("252685", i)).withMobileWork(String.format("158322215", i)).withGroup(String.format("diamind", i)));
    }
    return contact;
  }
}

