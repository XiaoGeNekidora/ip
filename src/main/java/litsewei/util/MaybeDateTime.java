package litsewei.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

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


    /**
     * Converts the MaybeDateTime to a string. <br/>
     * If the type is DATE, it will be formatted as "yyyy-MM-dd". <br/>
     * If the type is STRING, it will return the original string. <br/>
     *
     * <b>Note: use toString() when displaying a MaybeDateTime</b>
     *
     */
    public String serialize() {
        if (type == Type.DATE) {
            return date.format(DATE_FORMATTER);
        } else {
            return stringDate;
        }
    }

    /**
     * Converts the MaybeDateTime to a string. <br/>
     * If the type is DATE, it will be formatted as "MMM dd yyyy". <br/>
     * If the type is STRING, it will return the original string.
     * <br/>
     * <b>Note: use serialize() when saving a MaybeDateTime</b>
     */
    @Override
    public String toString() {
        if (type == Type.DATE) {
            return date.format(DateTimeFormatter.ofPattern("MMM dd yyyy").withLocale(Locale.ENGLISH));
        } else {
            return stringDate;
        }
    }

    /**
     * Constructs a MaybeDateTime.
     * @param stringDate the date string to parse or store
     */
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
