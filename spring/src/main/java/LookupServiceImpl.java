import basics.Animal;
import basics.Cat;
import basics.Dog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * This is the same class as in the mocktests example. We will change the SomeAction here instead.
 *
 * @author Created by ergouser on 05.10.16.
 */
@org.springframework.stereotype.Service
@org.springframework.context.annotation.Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LookupServiceImpl implements LookupService {

    private final static Collection<Animal> animals = Arrays.asList(
            new Dog("molly"), new Cat("poppy"), new Cat("molly"));

    /**
     * takes the given name and searches for alle known animals with that name
     *
     * @param name name of the animal
     * @return all animals found with the {@code name}
     */
    public final Collection<Animal> findAnimalByName(final String name) {
        Collection<Animal> result = new ArrayList<>();
        if (StringUtils.isNotEmpty(name)) {
            for (Animal a : animals) {
                if (name.equalsIgnoreCase(a.getName())) {
                    result.add(a);
                }
            }
        }
        return result;
    }
}
