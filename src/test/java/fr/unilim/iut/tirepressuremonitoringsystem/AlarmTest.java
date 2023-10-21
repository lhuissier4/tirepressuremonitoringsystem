package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import helpers.AlarmBuilder;

class AlarmTest {

	@Test
	void alarm_On_when_value_too_low() {
		Sensor sensor = probeValue(1.0);

		Alarm alarm = new AlarmBuilder()
				.withSensor(sensor)
				.withSafetyRange(new SafetyRange(17,21))
				.build();
		alarm.check();

		assertTrue(alarm.isAlarmOn());
	}

	@Test
	void alarm_On_when_value_too_high() {
		Sensor sensor = probeValue(150.0);
	
		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));
		alarm.check();
	
		assertTrue(alarm.isAlarmOn());
	}

	@Test
	void alarm_Off_when_value_safe() {
		Sensor sensor = probeValue(20.0);
	
		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));
		alarm.check();
	
		assertFalse(alarm.isAlarmOn());
	}
	
	@Test
	void alarm_once_on_stays_on_everytime() {
		Sensor sensor = probeValue(10.0,19.0);
	
		Alarm alarm = new Alarm(sensor, new SafetyRange(17,21));
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	private Sensor probeValue(double value) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.popValue()).thenReturn(value);
		return sensor;
	}
	
	private Sensor probeValue(double value1, double value2) {
		Sensor sensor = mock(PressureSensor.class);
		when(sensor.popValue()).thenReturn(value1).thenReturn(value2);
		return sensor;
	}

}
