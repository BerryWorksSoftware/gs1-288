package com.berryworks.labels;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ObjectToXmlTest {

    @Test
    public void canGenerateXmlFromObject() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(ShippingLabelContent.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final ShippingLabelContent slc = Sample.sample();
        marshaller.marshal(slc, new FileOutputStream("slc.xml"));
    }
}
