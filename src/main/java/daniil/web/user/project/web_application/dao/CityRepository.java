package daniil.web.user.project.web_application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import daniil.web.user.project.web_application.model.City;

@RepositoryRestResource
public interface CityRepository  extends JpaRepository <City, Integer>{

}
