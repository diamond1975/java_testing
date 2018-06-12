package ru.stqa.pft.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
    List<ContactData> contact = generateContact(count);
    save(contact, new File(file));
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

