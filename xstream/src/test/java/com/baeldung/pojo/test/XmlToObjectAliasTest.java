package com.baeldung.pojo.test;

import com.baeldung.initializer.SimpleXstreamInitializer;
import com.baeldung.pojo.Customer;
import com.thoughtworks.xstream.XStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class XmlToObjectAliasTest {

    private XStream xstream = null;

    @Before
    public void dataSetup() {
        SimpleXstreamInitializer simpleXstreamInitializer = new SimpleXstreamInitializer();
        xstream = simpleXstreamInitializer.getXstreamInstance();
        xstream.alias("customer", Customer.class);
    }

    @Test
    public void convertXmlToObjectFromFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            FileReader reader = new FileReader(classLoader.getResource("data-file-alias.xml").getFile());
            Customer customer = (Customer) xstream.fromXML(reader);
            Assert.assertNotNull(customer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
