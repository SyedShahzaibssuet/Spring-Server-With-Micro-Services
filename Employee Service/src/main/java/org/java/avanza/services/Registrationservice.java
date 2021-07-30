package org.java.avanza.services;

import org.java.avanza.Data.entity.User;
import org.java.avanza.Model.RegistrationModel;
import org.java.avanza.Model.RegistrationUpdateModel;

import java.util.List;

public interface Registrationservice {
    void registeruser(RegistrationModel registrationmodel);
    List<User> getall();
    void deleteuser(RegistrationUpdateModel updatereg);
    void updateuser(RegistrationUpdateModel updatereg);
}
