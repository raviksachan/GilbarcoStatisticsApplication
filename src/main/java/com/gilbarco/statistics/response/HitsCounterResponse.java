package com.gilbarco.statistics.response;

public class HitsCounterResponse {
	/**
	 * The current ISO8601 timestamp.
	 */
	private String timestamp;

	/**
	 * The total number of hit calls
	 */
	private int calls;

	/**
	 * Constructs a new HitsCounterResponse with the specified timestamp and total number of hit calls.
	 *
	 * @param timeStamp		current ISO8601 timestamp
	 * @param calls			total number of hit calls
	 */
	public HitsCounterResponse(String timeStamp, int calls) {
		this.timestamp = timeStamp;
		this.calls = calls;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public int getCalls() {
		return calls;
	}
}
