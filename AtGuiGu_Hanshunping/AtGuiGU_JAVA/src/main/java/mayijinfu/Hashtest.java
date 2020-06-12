package mayijinfu;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Hashtest {
    @Test
    public void test(){

        Set<Person> set = new HashSet<>();
        set.add(new Person("1","1"));
        set.add(new Person("1","2"));
        set.add(new Person("1","1"));
        set.add(new Person("1","1"));
        System.out.println(set);
    }
}

class Person{
    String name;
    String num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(num, person.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }

    public Person(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
