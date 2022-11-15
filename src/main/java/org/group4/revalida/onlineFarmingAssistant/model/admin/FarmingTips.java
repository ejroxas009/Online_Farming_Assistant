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
	private String farmingTipsDesc;
	private String farmingTipsImg;
	private String farmingTipsLink;

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

	public String getFarmingTipsDesc() {
		return farmingTipsDesc;
	}

	public void setFarmingTipsDesc(String farmingTipsDesc) {
		this.farmingTipsDesc = farmingTipsDesc;
	}

	public String getFarmingTipsImg() {
		return farmingTipsImg;
	}

	public void setFarmingTipsImg(String farmingTipsImg) {
		this.farmingTipsImg = farmingTipsImg;
	}

	public String getFarmingTipsLink() {
		return farmingTipsLink;
	}

	public void setFarmingTipsLink(String farmingTipsLink) {
		this.farmingTipsLink = farmingTipsLink;
	}
	
}
