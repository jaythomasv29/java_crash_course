package lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Data {
    private String name;

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                '}';
    }
}

class App {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data("Andy"));
        list.add(new Data("Jaames"));
        list.add(new Data("Beth"));
        list.add(new Data("Carter"));

        Collections.sort(list, (Data o1, Data o2)-> o1.getName().compareTo(o2.getName()));

        for(Data data: list) {
            System.out.println(data.getName());
        }
    }


}
