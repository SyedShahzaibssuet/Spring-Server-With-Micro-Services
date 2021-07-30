package org.java.avanza.services;

import org.java.avanza.Data.entity.User;
import org.java.avanza.Data.repositry.UserRepositry;
import org.java.avanza.Model.RegistrationModel;
import org.java.avanza.Model.RegistrationUpdateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
//Service when we have diffrent services we define name as @Service("setnameservice")
public class Registrationserviceimpl implements Registrationservice {
    @Autowired
    public UserRepositry userrepositry;

    @Override
    public void registeruser(RegistrationModel registrationmodel) {
        User user = new User();
        user.setFirstname(registrationmodel.getFirstname());
        user.setLastname(registrationmodel.getLastname());
        userrepositry.save(user);
    }

    @Override
    public List<User> getall() {
        List<User> user = userrepositry.findAll();
        return user;
    }

    @Override
    public void deleteuser(RegistrationUpdateModel updatereg) {
        userrepositry.deleteById(updatereg.getID());
    }

    @Override
    public void updateuser(RegistrationUpdateModel updatereg) {
        Optional<User> users = userrepositry.findById(updatereg.getID());
        if (users.isPresent()) {
            users.get().setFirstname(updatereg.getFirstname());
            users.get().setLastname(updatereg.getLastname());
            userrepositry.save(users.get());
        }
    }
}
