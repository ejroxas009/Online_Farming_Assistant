package org.group4.revalida.onlineFarmingAssistant.model.admin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farming_tips")
public class FarmingTips {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long farmingTipsId;
	
	private String farmingTips;

	public Long getFarmingTipsId() {
		return farmingTipsId;
	}

	public void setFarmingTipsId(Long farmingTipsId) {
		this.farmingTipsId = farmingTipsId;
	}

	public String getFarmingTips() {
		return farmingTips;
	}

	public void setFarmingTips(String farmingTips) {
		this.farmingTips = farmingTips;
	}
	
}
