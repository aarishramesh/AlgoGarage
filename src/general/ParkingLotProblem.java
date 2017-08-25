package general;

public class ParkingLotProblem {
	public int solution(String E, String L) {
		String entryTime = "09:42";
		String exitTime = "11:42";
		try {
			int totalCost = calculateCost(entryTime, exitTime);
			System.out.println(totalCost);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int calculateCost(String entryTime, String exitTime) throws Exception{
		int totalCost = 0;
		if (entryTime.contains(":") && exitTime.contains(":")) {
			String[] entryTimeSplit = entryTime.split(":");
			String entryHour = entryTimeSplit[0];
			String entryMinute = entryTimeSplit[1];

			if (entryHour.length() == 2 && entryMinute.length() == 2) {

				int entryHourInt = Integer.parseInt(entryHour);
				int entryMinInt = Integer.parseInt(entryMinute);

				String[] exitTimeSplit = exitTime.split(":");
				String exitHour = exitTimeSplit[0];
				String exitMinute = exitTimeSplit[1];

				if (exitHour.length() == 2 && exitMinute.length() == 2) {
					int exitHourInt = Integer.parseInt(exitHour);
					int exitMinInt = Integer.parseInt(exitMinute);

					if (entryHourInt >=0 && exitHourInt >=0 &&
							entryHourInt <= 23 && exitHourInt <= 23) {
						if (exitHourInt > entryHourInt
								|| (exitHourInt == entryHourInt && exitMinInt >= entryMinInt)) {
							int totalEntryTimeMin = entryHourInt * 60 + entryMinInt;
							int totalExitTimeMin = exitHourInt * 60 + exitMinInt;
							
							int totalTimeParked = totalExitTimeMin - totalEntryTimeMin;
							int totalHoursParked = totalTimeParked / 60;
							int totalMinParked = totalTimeParked % 60;
							
							totalCost = 2 + 3 + (4 * totalHoursParked);
							if (totalMinParked > 0) {
								totalCost += 4;
							}
						} else {
							throw new Exception("Invalid time format");
						}
					} else {
						throw new Exception("Invalid time format");
					}
				} else {
					throw new Exception("Invalid time format");
				}
			} else {
				throw new Exception("Invalid time format");
			}
		} else {
			throw new Exception("Invalid time format");
		}
		return totalCost;
	}

}
