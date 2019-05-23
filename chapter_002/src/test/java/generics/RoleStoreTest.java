package generics;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoleStoreTest {
    RoleStore rs = new RoleStore(10);
    @Before
    public void addSomeRoles() {
        rs.add(new Role("testid1"));
        rs.add(new Role("testid2"));
        rs.add(new Role("testid3"));
    }
    @Test
    public void whenFindById() {
        assertThat(rs.findById("testid1").getId(), is("testid1"));
        assertThat(rs.findById("testid2").getId(), is("testid2"));
        assertThat(rs.findById("testid3").getId(), is("testid3"));
    }
    @Test
    public void whenReplaceModels() {
        rs.replace(rs.findById("testid1").getId(), new Role("testid4"));
        assertThat(rs.findById("testid4").getId(), is("testid4"));
    }
    @Test
    public void whenDeleteModel() {
        rs.delete("testid1");
        assertThat(rs.getIndex("testid2"), is(0));
    }
}