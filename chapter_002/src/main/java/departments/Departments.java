package departments;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
/**
 * @author Alexander Kashkin (kashkinmsk@gmail.com)
 * @since 15.04.2019
 * @version 1
**/
public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            int len = Integer.min(this.deps.size(), o.deps.size());
            int rst = 0;
            for (int i = 0; i < len; i++) {
                rst = this.deps.get(i).compareTo(o.deps.get(i));
                if (rst != 0) {
                    break;
                }
            }
            return rst;
        }

        @Override
        public String toString() {
            return deps.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null && getClass() != obj.getClass()) {
                return false;
            }
            Org org = (Org) obj;
            return Objects.equals(deps, org.deps);
        }

        @Override
        public int hashCode() {
            return Objects.hash(deps);
        }
    }

    public List<Org> convert(List<String> deps) {
        List<Org> rstDeps = new ArrayList<>();
        Set<Org> setSort = new LinkedHashSet<>();
        for (String string : deps) {
            String[] arrayDep = string.split("/");
            List<String> listDeps = new ArrayList<>();
            for (String dep : arrayDep) {
                listDeps.add(dep);
                setSort.add(new Org(new ArrayList<>(listDeps)));
            }
        }
        rstDeps.addAll(setSort);
        return rstDeps;
    }

    public List<Org> sortAsc(List<Org> orgs) {
        Collections.sort(orgs);
        return orgs;
    }

    public List<Org> sortDesc(List<Org> orgs) {
        Collections.sort(orgs, Collections.reverseOrder());
        return orgs;
    }
}