package com.berryworks.labels;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.DocumentException;

import static org.junit.Assert.assertTrue;

public class ShippingLabelCreatorTest
{
  private ShippingLabelCreator creator;
  private File pdf;

  @Test
  public void basics() throws IOException, DocumentException
  {
    creator = new ShippingLabelCreator();
    pdf = creator.createLabel("xml ...");
    assertTrue(pdf.exists());
  }
}
