import com.berryworks.labels.ShippingLabelCreator;
import com.itextpdf.text.DocumentException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ShippingLabelCreatorTest {

    private ShippingLabelCreator creator;
    private File pdf;

    @Test
    public void basics() throws IOException, DocumentException {
        creator = new ShippingLabelCreator();
        pdf = creator.createLabel("xml ...");
        assertTrue(pdf.exists());
    }
}
