package mainpackeage;

public class List {

	double xUm;
	double  tUm; // ti de Thetai, não tzinho i
	int size;
	Packet header;
	
	public List ( ) {
		// Default values
		this.header = null;
		this.xUm = 0L;
		this.tUm = 0L;
		this.size = 0;
	}
	
	public void addElement( double xi, double ti ) {
		
		Packet right = new Packet(xi, ti);
		
		if ( header == null ) {
			header = right;
		} else {
			Packet current = header;
			while ( current.getRight() != null ) {
				current = current.getRight();
			}
			
			current.setRight(right);
			size++;
			
		}
	}
	
	
}
