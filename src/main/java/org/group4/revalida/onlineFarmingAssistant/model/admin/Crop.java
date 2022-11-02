package org.group4.revalida.onlineFarmingAssistant.model.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crop_table")
public class Crop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cropId;
	
	
	private String cropName;

	public Long getCropId() {
		return cropId;
	}

	public void setCropId(Long cropId) {
		this.cropId = cropId;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	
	
}
