package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.util.List;

/**
 * Business Logic Layer for management of Habitats
 *
 * @author Eman Alibalić
 */
public class HabitatManager {

    public void validateHabitatName(String name) throws AnimalException{
        if (name == null || name.length() > 45 || name.length() < 3){
            throw new AnimalException("Habitat name must be between 3 and 45 chars");
        }
    }

    public Habitat add(Habitat cat) throws AnimalException {
        if (cat.getId() != 0){
            throw new AnimalException("Can't add habitat with ID. ID is autogenerated");
        }
        validateHabitatName(cat.getName());

        try{
            return DaoFactory.habitatDao().add(cat);
        }catch (AnimalException e){
            if (e.getMessage().contains("UQ_NAME")){
                throw new AnimalException("Habitat with same name exists");
            }
            throw e;
        }
    }

    public void delete(int habitatId) throws AnimalException{
        try{
            DaoFactory.habitatDao().delete(habitatId);
        }catch (AnimalException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new AnimalException("Cannot delete habitat which is related to animals. First delete related animals before deleting habitat.");
            }
            throw e;
        }

    }

    public Habitat update(Habitat cat) throws AnimalException{
        validateHabitatName(cat.getName());
        return DaoFactory.habitatDao().update(cat);
    }

    public List<Habitat> getAll() throws AnimalException{
        return DaoFactory.habitatDao().getAll();
    }

}