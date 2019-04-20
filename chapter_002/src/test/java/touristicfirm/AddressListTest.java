package touristicfirm;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class AddressListTest {
    @Test
    public void whenTakesAllProfiles() {
        List<Profile> clients = new ArrayList<>();
        AddressList addressList = new AddressList();
        Profile.Address first = new Profile.Address("AMoscow", "Tverskaya", 1, 1);
        Profile.Address second = new Profile.Address("CMoscow", "Tverskaya", 2, 2);
        Profile.Address third = new Profile.Address("BMoscow", "Tverskaya", 3, 3);
        Profile.Address fourth = new Profile.Address("BMoscow", "Tverskaya", 4, 4);
        clients.add(new Profile(first));
        clients.add(new Profile(second));
        clients.add(new Profile(third));
        clients.add(new Profile(fourth));
        assertThat(addressList.collect(clients), is(Arrays.asList(first, third, second)));
    }
}