package touristicfirm;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 19.04.2019
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
    public static class Address {
        private String city;
        private String street;
        private int home;
        private int apartment;

        public Address(String city, String street, int home, int apartment) {
            this.city = city;
            this.street = street;
            this.home = home;
            this.apartment = apartment;
        }
    }
}