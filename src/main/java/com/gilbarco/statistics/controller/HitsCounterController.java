package com.gilbarco.statistics.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gilbarco.statistics.response.HitsCounterResponse;

/**
 * Rest Controller class to represent counter handler methods.
 * 
 * @author Ravi Kant
 * @version 1.0
 * @since 2018-10-11
 */

@RestController
public class HitsCounterController {

	/**
	 * Counter variable that can be updated atomically to avoid data inconsistency in concurrent environment.
	 */
	private AtomicInteger hitsCounter = new AtomicInteger();

	/**
	 * <p>
	 * This is the handler method for the Rest Api End point URL:
	 * <b>{@code /hitsCount [GET]}</b>
	 * </p>
	 * Use this to get total count of calls to this api along with the current time in ISO8601 timestamp.
	 * The count increases each time the service is called.
	 * 
	 * @return Json representation of object of type
	 *         {@link com.gilbarco.statistics.response.HitsCounterResponse}.<br>
	 *         <br>
	 *         <b>Example Response:</b><br>
	 *         {@code {"timestamp":"2018-10-11T17:34:59.03","calls":10}}
	 */
	@RequestMapping(value = "/hitsCount", method = RequestMethod.GET, produces = "application/json")
	public HitsCounterResponse hitsCount() {
		return new HitsCounterResponse(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()), hitsCounter.incrementAndGet());
	}
}
