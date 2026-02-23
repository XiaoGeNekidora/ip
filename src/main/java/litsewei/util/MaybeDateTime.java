package litsewei.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A union class for string and LocalDate. <br/>
 * It tries to parse the input string as a LocalDate, if it fails, it will store the string as is.
 */
public class MaybeDateTime {
    enum Type{
        STRING, DATE
    }
    private String stringDate;
    private LocalDate date;
    private Type type;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public String serialize() {
        if (type == Type.DATE) {
            return date.format(DATE_FORMATTER);
        } else {
            return stringDate;
        }
    }

    @Override
    public String toString() {
        if (type == Type.DATE) {
            return date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
        } else {
            return stringDate;
        }
    }

    public MaybeDateTime(String stringDate) {
        try {
            date = LocalDate.parse(stringDate, DATE_FORMATTER);
            type = Type.DATE;
        } catch (DateTimeParseException e) {
            // fallback to string
            this.stringDate = stringDate;
            type = Type.STRING;
        }
    }
}
