package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.HabitatDao;
import ba.unsa.etf.rpr.dao.HabitatDaoSQLImpl;
import ba.unsa.etf.rpr.dao.AnimalDao;
import ba.unsa.etf.rpr.dao.AnimalDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * App interface demo
 * @author Eman Alibalić
 * @version 0.0.1
 */
public class App {
    public static void main(String[] args) {

//        AnimalDao dao = new AnimalDaoSQLImpl();
//
//        Habitat habitat = new Habitat();
//        habitat.setId(2);
//        habitat.setName("Zivotinje");
//        ArrayList<Animal> animalsByHabitats = new ArrayList<Animal>(dao.searchByHabitat(habitat));
//        System.out.println("Treba ispisati zivotinje u drugom habitatu: ");
//        animalsByHabitats.forEach(q -> System.out.println(q.getAnimal()));
//
//
//        System.out.println("\nZivotinja sa inside word \"in\": \n|  ID  |  Animal  |\n-------------------");
//        ArrayList<Animal> animals = new ArrayList<Animal>(dao.searchByType("in"));
//        for (Animal a : animals) {
//            System.out.println(a.getId() + " " + a.getAnimal());
//        }
    }
}