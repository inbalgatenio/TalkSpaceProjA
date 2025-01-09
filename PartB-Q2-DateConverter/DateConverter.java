package infra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public String invalidInputDateMess = "Invalid date input";
    public String invalidDateFormatMess = "Invalid date format";
    public String errorParseOrFormatMess = "Error parse or format date";
    String dateFormat;
    Date date;

    public String changeDateFormat(String originalDate, String targetDate) {

        // Check if original date is valid
        if (originalDate == null || originalDate.trim().isEmpty())
            return invalidInputDateMess;

        // Find original date format
        dateFormat = dateFormatFinder(originalDate);

        // If can't find the format, return error
        if (dateFormat == null) return invalidDateFormatMess;

        // Try to convert the original date to the target format
        SimpleDateFormat originalFormat = new SimpleDateFormat(dateFormat);

        try {
            // Try to parse the original date
            date = originalFormat.parse(originalDate);

            // Validate target format before using it to format the date
            try {
                SimpleDateFormat targetFormat = new SimpleDateFormat(targetDate);
                targetFormat.setLenient(false); // Disable leniency

                // If the target format is invalid, it will throw a ParseException here
                targetFormat.format(date);

                return targetFormat.format(date);
            } catch (IllegalArgumentException e) {
                return invalidDateFormatMess;
            }

        } catch (ParseException e) {
            // If parsing fails, return an error message for invalid input
            return errorParseOrFormatMess;
        }
    }

    public String dateFormatFinder(String dateStr) {
        // List of potential date formats
        String[] formats = {
                "yyyy-MM-dd",
                "MM/dd/yyyy",
                "dd-MM-yyyy",
                "yyyyMMdd",
                "dd/MM/yyyy",
                "MMM dd, yyyy",
                "dd MMM yyyy"
        };

        // Search the date format
        for (String format : formats) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            try {
                // Try to parse the date
                date = sdf.parse(dateStr);
                // If successful, return the detected format
                return format;
            } catch (ParseException e) {

            }
        }
        System.out.println("Can't find input date format");
        return null;
    }
}

