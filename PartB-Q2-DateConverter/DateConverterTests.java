package DateConverterTest;

import infra.DateConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateConverterTests {

    DateConverter converter = new DateConverter();

    @Test
    public void positive_test_convert_valid_dates() {
        // Valid date formats
        assertEquals("01/06/2025",
                converter.changeDateFormat("2025-01-06", "MM/dd/yyyy"));
        assertEquals("20250106",
                converter.changeDateFormat("06-01-2025", "yyyyMMdd"));
    }

    @Test
    public void negative_test_convert_invalid_input_dates() {
        // invalid input dates
        assertEquals(converter.invalidInputDateMess,
                converter.changeDateFormat(null, "MM/dd/yyyy"));
        assertEquals(converter.invalidInputDateMess,
                converter.changeDateFormat("", "MM/dd/yyyy"));
    }

    @Test
    public void negative_test_convert_invalid_target_format() {
        // invalid target dates
        assertEquals(converter.invalidDateFormatMess,
                converter.changeDateFormat("07/01/2024", "invalid"));
        assertEquals(converter.invalidDateFormatMess,
                converter.changeDateFormat( "JUL 09 ,2011", ""));
    }
}
