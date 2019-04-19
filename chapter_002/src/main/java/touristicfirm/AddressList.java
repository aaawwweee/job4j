package touristicfirm;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @version 1
 * @since 19.04.2019
 */
public class AddressList {
    public List<Profile.Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}