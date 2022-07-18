//package se.citerus.dddsample.client.location;
//
//import org.apache.commons.lang.Validate;
//
//import java.util.regex.Pattern;
//
///**
// * United nations location code.
// * <p/>
// * http://www.unece.org/cefact/locode/
// * http://www.unece.org/cefact/locode/DocColumnDescription.htm#LOCODE
// */
//public final class UnLocode implements UnLocode {
//
//  private String unlocode;
//
//  // Country code is exactly two letters.
//  // Location code is usually three letters, but may contain the numbers 2-9 as well
//  private static final Pattern VALID_PATTERN = Pattern.compile("[a-zA-Z]{2}[a-zA-Z2-9]{3}");
//
//  /**
//   * Constructor.
//   *
//   * @param countryAndLocation Location string.
//   */
//  public UnLocodeImpl(final String countryAndLocation) {
//    Validate.notNull(countryAndLocation, "Country and location may not be null");
//    Validate.isTrue(VALID_PATTERN.matcher(countryAndLocation).matches(),
//      countryAndLocation + " is not a valid UN/LOCODE (does not match pattern)");
//
//    this.unlocode = countryAndLocation.toUpperCase();
//  }
//
////  @Override public Long getId() {
////    return id;
////  }
//
//  @Override
//  public String idString() {
//    return unlocode;
//  }
//
//  @Override
//  public boolean equals(final Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    UnLocodeImpl other = (UnLocodeImpl) o;
//
//    return sameValueAs(other);
//  }
//
//  @Override
//  public int hashCode() {
//    return unlocode.hashCode();
//  }
//
//  @Override
//  public boolean sameValueAs(UnLocode other) {
//    if(!(other instanceof UnLocodeImpl)) {
//      throw new IllegalArgumentException("Expected implementation class");
//    }
//    return (UnLocodeImpl) other != null && this.unlocode.equals(((UnLocodeImpl) other).unlocode);
//  }
//
//  @Override
//  public String toString() {
//    return idString();
//  }
//
//  UnLocodeImpl() {
//    // Needed by Hibernate
//  }
//
//}
