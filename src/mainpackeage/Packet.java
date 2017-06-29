package mainpackeage;

public class Packet {

	double xi; // in Microseconds
	double ti; // in Seconds - converted to microseconds in FileManager
	Packet right;
	
	public Packet ( double xi, double ti) {
		this.xi = xi;
		this.ti = ti;
		this.right = null;
	}
	
	public Packet getRight() {
		return right;
	}

	public void setRight(Packet right) {
		this.right = right;
	}

	public double getXi() {
		return xi;
	}

	public void setXi(double xi) {
		this.xi = xi;
	}

	public double getTi() {
		return ti;
	}

	public void setTi(double ti) {
		this.ti = ti;
	}

}
