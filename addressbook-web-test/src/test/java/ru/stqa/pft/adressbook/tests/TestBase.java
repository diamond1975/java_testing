package ru.stqa.pft.adressbook.tests;

import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook.appmanager.ApplicationManager;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.remote.BrowserType.CHROME;

public class TestBase {
  org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", CHROME));

  // = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parametrs " + Arrays.asList(p));
  }


  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()).withHeader(g.getHeader()).withFooter(g.getFooter()))
              .collect(Collectors.toSet())));
    }
  }
  public void verifyContactListtInUI() {
    if (Boolean.getBoolean("verifyUI")) {
        Contacts dbContacts = app.db().contacts();
        Contacts uiContacts = app.contact().all();
        assertThat(uiContacts, equalTo(dbContacts.stream()
                .map((g) -> new ContactData().withId(g.getId()).withName1(g.getName1())
                        .withName2(g.getName2()).withName3(g.getName3()).withAddress(g.getAddress())
                        .withEmail1(g.getEmail1()).withEmail2(g.getEmail2()).withEmail3(g.getEmail3())
                        .withMobileHome(g.getMobileHome()).withMobile(g.getMobile()).withMobileWork(g.getMobileWork()).withGroup("diamind"))
                .collect(Collectors.toSet())));
      }
    }
  }

