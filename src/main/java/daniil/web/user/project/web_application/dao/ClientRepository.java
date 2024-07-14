package daniil.web.user.project.web_application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import daniil.web.user.project.web_application.model.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository <Client, Integer>{

}
