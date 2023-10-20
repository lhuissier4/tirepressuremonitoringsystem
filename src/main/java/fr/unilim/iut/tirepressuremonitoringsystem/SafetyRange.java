package fr.unilim.iut.tirepressuremonitoringsystem;

public class SafetyRange {
	double lowThreshold;
	double highThreshold;
	
	public SafetyRange(double lowThreshold, double highThreshold) {
		this.lowThreshold=lowThreshold;
		this.highThreshold=highThreshold;
	}
	public boolean contains(double value) {
		if ((value > lowThreshold ) && (value < highThreshold)){
			return true;
		}
		return false;
	}
	public boolean doesNotContain(double value) {
		if ((value > lowThreshold ) && (value < highThreshold)){
			return false;
		}
		return true;
	}
	
}
