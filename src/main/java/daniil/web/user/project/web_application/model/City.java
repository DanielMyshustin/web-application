package daniil.web.user.project.web_application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer cityId;
	
	@Column(name = "name")
	private String cityName;

	public int getId() {
		return cityId;
	}

	public void setId(int id) {
		this.cityId = id;
	}

	public String getName() {
		return cityName;
	}

	public void setName(String name) {
		this.cityName = name;
	}
}

