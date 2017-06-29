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
		
				
			} else if ( line.contains("MAC timestamp:") ) {
				
				brokenLine = line.split(" ");
				deviceTimestamp = Long.parseLong(brokenLine[brokenLine.length-1]);
				//System.out.println(df.format(deviceTimestamp));
				
				if ( firstPacket ) {
					
					packetList.xUm = deviceTimestamp;
					packetList.tUm = apTimestamp;
					firstPacket = false;

				}
				
				xi = deviceTimestamp - packetList.xUm;
				tzaodif = apTimestamp - packetList.tUm; 
				ti =  tzaodif - xi;
				
				//System.out.println("xi: " + df.format(xi));
				//System.out.println("ti: " + df.format(ti));
				
				if ( ti > biggestValue ) {
					biggestValue = ti;
					xofBiggest = xi;
				} else if ( ti > secondBiggestValue ) {
					secondBiggestValue = ti;
					xofSecondBiggest = xi;
				}
				
				packetList.addElement(xi, ti);
				
			}
			
			line =  br.readLine();
			
		} while ( line != null ) ;
		br.close();
		
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
