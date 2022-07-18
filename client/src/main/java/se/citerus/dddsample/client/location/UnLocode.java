//package se.citerus.dddsample.client.location;
//
//public interface UnLocode {
////    Long getId();
//
//    String idString();
//
//    @Override
//    boolean equals(Object o);
//
//    @Override
//    int hashCode();
//
//    boolean sameValueAs(UnLocode other);
//
//    @Override
//    String toString();
//}

package se.citerus.dddsample.client.location;

import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * United nations location code.
 * <p/>
 * http://www.unece.org/cefact/locode/
 * http://www.unece.org/cefact/locode/DocColumnDescription.htm#LOCODE
 */
public final class UnLocode implements Serializable {

    private String unlocode;

    // Country code is exactly two letters.
    // Location code is usually three letters, but may contain the numbers 2-9 as well
    private static final Pattern VALID_PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-Z2-9]{3}");

    /**
     * Constructor.
     *
     * @param countryAndLocation Location string.
     */
    public UnLocode(final String countryAndLocation) {
        Validate.notNull(countryAndLocation, "Country and location may not be null");
        Validate.isTrue(VALID_PATTERN.matcher(countryAndLocation).matches(),
                countryAndLocation + " is not a valid UN/LOCODE (does not match pattern)");

        this.unlocode = countryAndLocation.toUpperCase();
    }

//  @Override public Long getId() {
//    return id;
//  }

    public String idString() {
        return unlocode;
    }

    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnLocode other = (UnLocode) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return unlocode.hashCode();
    }

    public boolean sameValueAs(UnLocode other) {
        return other != null && this.unlocode.equals(other.unlocode);
    }

    @Override
    public String toString() {
        return idString();
    }

    UnLocode() {
        // Needed by Hibernate
    }

}

