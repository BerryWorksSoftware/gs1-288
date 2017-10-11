package com.berryworks.labels;

import com.berryworks.labels.model.ShippingLabelContent;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class ObjectToXmlTest {

    private ShippingLabelContent slc;

    @Test
    public void canMarshallToXml() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(ShippingLabelContent.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        slc = Sample.sample();
        marshaller.marshal(slc, new FileOutputStream("slc.xml"));
    }

    @Test
    public void canUnmarshallFromXml() throws JAXBException {
        // First marshall a smaple to XML
        final ByteArrayOutputStream boas = new ByteArrayOutputStream();
        final JAXBContext context = JAXBContext.newInstance(ShippingLabelContent.class);
        final ShippingLabelContent seed = Sample.sample();
        context.createMarshaller().marshal(seed, boas);
        final String xml = boas.toString();
        System.out.println(xml);
        //
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        slc = (ShippingLabelContent) unmarshaller.unmarshal(new StringReader(xml));
        assertEquals(seed, slc);
    }
}
