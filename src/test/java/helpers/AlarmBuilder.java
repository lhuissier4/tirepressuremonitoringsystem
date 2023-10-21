package helpers;

import fr.unilim.iut.tirepressuremonitoringsystem.Alarm;
import fr.unilim.iut.tirepressuremonitoringsystem.SafetyRange;
import fr.unilim.iut.tirepressuremonitoringsystem.Sensor;

public class AlarmBuilder {
	private SafetyRange mySafetyRange;
	private Sensor mySensor;
	

	public AlarmBuilder withSafetyRange(SafetyRange safetyRange ){
		this.mySafetyRange=safetyRange;
		return this;
		
	}
	public AlarmBuilder withSensor(Sensor sensor) {
		this.mySensor=sensor;
		return this;
		
	}
	public Alarm build() {
		return new Alarm(mySensor,mySafetyRange);
	
	}
	public static AlarmBuilder anAlarm() {
		return new AlarmBuilder();
	}
}


