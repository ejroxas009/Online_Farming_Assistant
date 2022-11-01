package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "crop_received_table")
public class CropReceived {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cropReceivedId;
	@OneToOne
	private Advertisement advertisement;
	private boolean isReceived;
	
	
	
	public Long getCropReceivedId() {
		return cropReceivedId;
	}
	public void setCropReceivedId(Long cropReceivedId) {
		this.cropReceivedId = cropReceivedId;
	}
	public Advertisement getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	
	
}
