package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{


    private Sensor sensor;
    private boolean alarmOn;
    
    private SafetyRange safetyRange;
    public Alarm() {
    	this(new PressureSensor(), new SafetyRange(17,21));
    	
       }
    public Alarm(Sensor sensor, SafetyRange safetyRange) {
		this.sensor=sensor;
		this.alarmOn = false;
		this.safetyRange = safetyRange;

	}
    

	public void check()
    {
        double value = probe();

        if (isNotSafe(value))
        {
            activate();
        }
    }

	private void activate() {
		alarmOn = true;
	}

	private double probe() {
		return sensor.popValue();
	}

	private boolean isNotSafe(double value) {
		return safetyRange.doesNotContain(value);
	}

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
