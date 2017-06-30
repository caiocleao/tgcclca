package mainpackeage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class FileManager {
	
	boolean firstPacket = true;
	double biggestValue = 0.0;
	double xofBiggest = 0.0;
	double secondBiggestValue = 0.0;
	double xofSecondBiggest = 0.0;
	double previousT = 0.0;
	double totalDeltaT = 0.0;
	int contador;
	DecimalFormat df = new DecimalFormat ("#.########");
	
	
	public List getDataset ( String filePath ) throws IOException {
		
		FileReader frIn = new FileReader(filePath);
		BufferedReader br = new BufferedReader(frIn);
		
		String line = "";
		String[] brokenLine;
		
		// Variables to create Packet
		long apTimelong = 0L;
		double apTimestamp = 0.0;
		double deviceTimestamp = 0.0;
		double xi, ti, tzaodif;
		previousT = 0.0;
		totalDeltaT = 0.0;
		contador = 0;
		
		List packetList = new List();
		//System.out.println("BEGIN");
		do { 
			
			if ( line.contains("Timestamp:") ) {
				
				brokenLine = line.split(" ");
				String arrivalString = brokenLine[brokenLine.length-1];
				//System.out.println(arrivalString);
				String[] brokenHours = arrivalString.split(" ");
				apTimelong = hex2decimal(brokenHours[brokenHours.length-1]);
				apTimestamp = Double.parseDouble(Long.toString(apTimelong));
				//System.out.println(df.format(apTimestamp));
				if ( firstPacket ) {
					
					packetList.xUm = deviceTimestamp;
					packetList.tUm = apTimestamp;
					firstPacket = false;

				}
				
				xi = deviceTimestamp - packetList.xUm;
				tzaodif = apTimestamp - packetList.tUm; 
				ti =  tzaodif - xi;
				contador++;
				packetList.addElement(xi, ti);
				
			} else if ( line.contains("MAC timestamp:") ) {
				
				brokenLine = line.split(" ");
				deviceTimestamp = Long.parseLong(brokenLine[brokenLine.length-1]);
				
			}
			
			line =  br.readLine();
			
		} while ( line != null && contador <= 400 ) ;
		br.close();
		firstPacket = true;
		return packetList;
		
	}
	
	 public static long hex2decimal(String s) {
         String digits = "0123456789ABCDEF";
         s = s.toUpperCase();
         long val = 0L;
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             int d = digits.indexOf(c);
             val = 16*val + d;
         }
         return val;
     }
	
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
}
