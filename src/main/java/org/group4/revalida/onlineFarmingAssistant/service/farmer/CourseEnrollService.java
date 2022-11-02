package org.group4.revalida.onlineFarmingAssistant.service.farmer;

import org.group4.revalida.onlineFarmingAssistant.repo.farmer.CourseEnrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseEnrollService {

	@Autowired
	CourseEnrollRepo courseEnrollRepo;
	
}
