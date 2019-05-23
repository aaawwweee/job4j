package generics;

public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
}
