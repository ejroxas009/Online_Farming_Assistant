package org.group4.revalida.onlineFarmingAssistant.model.wholesaler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crop_received_table")
public class CropReceived {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cropReceivedId;
//	@OneToOne;
//	private Advertisement advertisement;
	private boolean isReceived;
}
