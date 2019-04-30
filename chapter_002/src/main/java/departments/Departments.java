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
    public String[] sortAscending(String[] codes) {
        Set<String> result = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String code : codes) {
            String[] departmentsNames = code.split("\\\\");
            StringBuilder department = new StringBuilder();
            for (String departmentsName : departmentsNames) {
                department.append(departmentsName);
                result.add(department.toString());
                department.append("\\");
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] sortDescending(String[] codes) {
        Set<String> result = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l = Math.min(o1.length(), o2.length());
                int x = 0;
                while (x < l) {
                    if (o2.toCharArray()[x] != o1.toCharArray()[x]) {
                        return o2.toCharArray()[x] - o1.toCharArray()[x];
                    }
                    x++;
                }
                return o1.length() - o2.length();
            }
        });
        for (String code : codes) {
            String[] departmentNames = code.split("\\\\");
            StringBuilder department = new StringBuilder();
            for (String departmentName : departmentNames) {
                department.append(departmentName);
                result.add(department.toString());
                department.append("\\");
            }
        }
        return result.toArray(new String[0]);
    }
}