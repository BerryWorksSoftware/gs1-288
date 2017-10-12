package com.berryworks.labels;

import com.berryworks.labels.model.ShippingLabelContent;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

public class ObjectToXmlTest {

    private ShippingLabelContent slc;

    @Test
    public void canMarshallToXml() throws JAXBException, IOException, SAXException {
        JAXBContext context = JAXBContext.newInstance(ShippingLabelContent.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        slc = Sample.sample();
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(slc, baos);
        final String xml = baos.toString();
        // System.out.println(xml);
        // Validate the XML against the XSD
        final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        final Schema schema = schemaFactory.newSchema(new File("src/main/resources/ShippingLabelContent.xsd"));
        final Validator validator = schema.newValidator();
        validator.validate(new StreamSource(new StringReader(xml)));
    }

    @Test
    public void canUnmarshallFromXml() throws JAXBException {
        // First marshal a sample to XML
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final JAXBContext context = JAXBContext.newInstance(ShippingLabelContent.class);
        final ShippingLabelContent seed = Sample.sample();
        context.createMarshaller().marshal(seed, baos);
        final String xml = baos.toString();
        // Now unmarshal that XML into an object
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        slc = (ShippingLabelContent) unmarshaller.unmarshal(new StringReader(xml));
        assertEquals(seed, slc);
    }
}
