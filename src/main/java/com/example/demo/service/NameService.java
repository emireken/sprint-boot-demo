
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

//
package com.example.demo.service;

import com.example.demo.dao.FirstNameDataAccessService;
import com.example.demo.dao.LastNameDataAccessService;
import com.example.demo.model.FirstName;
import com.example.demo.model.LastName;
import com.example.demo.model.Name;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    private static FirstNameDataAccessService firstNameDataAccessService;
    private static LastNameDataAccessService lastNameDataAccessService;

    @Autowired
    public NameService(FirstNameDataAccessService firstNameDataAccessService, LastNameDataAccessService lastNameDataAccessService) {
        NameService.firstNameDataAccessService = firstNameDataAccessService;
        NameService.lastNameDataAccessService = lastNameDataAccessService;
    }

    @NotBlank
    public static Name getRandomName() {
        List<FirstName> first = firstNameDataAccessService.getRandomFirstName();
        List<LastName> last = lastNameDataAccessService.getRandomLastName();
        Name name = new Name(((FirstName)first.get(0)).id, ((FirstName)first.get(0)).first_name, ((LastName)last.get(0)).last_name, ((FirstName)first.get(0)).locale, ((FirstName)first.get(0)).gender);
        return name;
    }

    public static List<Name> getNumberOfRandomName(Integer numberOfRandom) {
        List<FirstName> first = firstNameDataAccessService.getNumberOfRandomFirstName(numberOfRandom);
        List<LastName> last = lastNameDataAccessService.getNumberOfRandomLastName(numberOfRandom);
        ArrayList<Name> name = new ArrayList();

        for(int i = 0; i < numberOfRandom; ++i) {
            Name nameTemp = new Name(i, ((FirstName)first.get(i)).first_name, ((LastName)last.get(i)).last_name, ((FirstName)first.get(i)).locale, ((FirstName)first.get(i)).gender);
            name.add(i, nameTemp);
        }

        return name;
    }

    @NotBlank
    public static Name getRandomNameByLocale(String locale) {
        List<FirstName> first = firstNameDataAccessService.getRandomFirstNameByLocale(locale);
        List<LastName> last = lastNameDataAccessService.getRandomLastNameByLocale(locale);
        Name name = new Name(((FirstName)first.get(0)).id, ((FirstName)first.get(0)).first_name, ((LastName)last.get(0)).last_name, ((FirstName)first.get(0)).locale, ((FirstName)first.get(0)).gender);
        return name;
    }

    @NotBlank
    public static List<Name> getNumberOfRandomNameByLocale(String locale, Integer numberOfRandom) {
        List<FirstName> first = firstNameDataAccessService.getNumberOfRandomFirstNamByLocale(locale, numberOfRandom);
        List<LastName> last = lastNameDataAccessService.getNumberOfRandomLastNameByLocale(locale, numberOfRandom);
        ArrayList<Name> name = new ArrayList();

        for(int i = 0; i < numberOfRandom; ++i) {
            Name nameTemp = new Name(i, ((FirstName)first.get(i)).first_name, ((LastName)last.get(i)).last_name, ((FirstName)first.get(i)).locale, ((FirstName)first.get(i)).gender);
            name.add(i, nameTemp);
        }

        return name;
    }
}
