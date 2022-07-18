//package se.citerus.dddsample.client.location;
//
//import org.apache.commons.lang.Validate;
//
///**
// * A location is our model is stops on a journey, such as cargo
// * origin or destination, or carrier movement endpoints.
// *
// * It is uniquely identified by a UN Locode.
// *
// */
//public final class LocationImpl implements Location, Entity<Location> {
//  private UnLocodeImpl unLocode;
//  private String name;
//
//  /**
//   * Special Location object that marks an unknown location.
//   */
//  public static final Location UNKNOWN = new LocationImpl(
//          new UnLocode("XXXXX"), "Unknown location"
//  );
//
//  /**
//   * Package-level constructor, visible for test only.
//   *
//   * @param unLocode UN Locode
//   * @param name     location name
//   * @throws IllegalArgumentException if the UN Locode or name is null
//   */
//  // TODO Make sure constructor is public (for now, before making it a call?)
//  public LocationImpl(final UnLocodeImpl unLocode, final String name) {
//    Validate.notNull(unLocode);
//    Validate.notNull(name);
//
//    this.unLocode = unLocode;
//    this.name = name;
//  }
//
//  @Override public Long getId() {
//    return id;
//  }
//
//  /**
//   * @return UN Locode for this location.
//   */
//  @Override public UnLocodeImpl unlocode() {
//    return unLocode;
//  }
//
//  /**
//   * @return Actual name of this location, e.g. "Stockholm".
//   */
//  @Override public String name() {
//    return name;
//  }
//
//  /**
//   * @param object to compare
//   * @return Since this is an entiy this will be true iff UN locodes are equal.
//   */
//  @Override
//  public boolean equals(final Object object) {
//    if (object == null) {
//      return false;
//    }
//    if (this == object) {
//      return true;
//    }
//    if (!(object instanceof Location)) {
//      return false;
//    }
//    Location other = (Location) object;
//    return sameIdentityAs(other);
//  }
//
//  @Override public boolean sameIdentityAs(final Location other) {
//    if(!(other instanceof LocationImpl)) {
//      throw new IllegalArgumentException("Expected implementation class");
//    }
//    return this.unLocode.sameValueAs(((LocationImpl) other).unLocode);
//  }
//
//  /**
//   * @return Hash code of UN locode.
//   */
//  @Override
//  public int hashCode() {
//    return unLocode.hashCode();
//  }
//
//  @Override
//  public String toString() {
//    return name + " [" + unLocode + "]";
//  }
//
//  LocationImpl() {
//    // Needed by Hibernate
//  }
//
//  private Long id;
//
//}
