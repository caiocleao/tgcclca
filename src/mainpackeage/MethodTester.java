package mainpackeage;

import java.awt.Color;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;


public class MethodTester extends JFrame {
	
	private static final long serialVersionUID = 1L;
	double linen = 0.0;
	double lineb = 0.0;
	double lastPacketRecieved = 0.0;
	DecimalFormat df = new DecimalFormat("#.############");

	double[] mmqLine =  new double[2];
	
	
    public MethodTester(String applicationTitle, String chartTitle, String chartType) throws IOException {
        super(applicationTitle);
        
        if ( chartType.equals("line")) {
        
	        JFreeChart chart = ChartFactory.createScatterPlot(chartTitle, "Dataset #", "Estimate Value", createDataset(), PlotOrientation.VERTICAL, true, true, false);
	        ChartPanel panel = new ChartPanel ( chart );
	        panel.setPreferredSize( new java.awt.Dimension(800, 600));
	        //final XYPlot plot = chart.getXYPlot();
	        final XYPlot plot = chart.getXYPlot();
	        
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesPaint(1, Color.BLUE);
	        renderer.setSeriesPaint(0, Color.red);
	        plot.setRenderer( renderer );
	        setContentPane( panel );
	        
        } else if ( chartType.equals("pie")) {
        
        	JFreeChart chart = ChartFactory.createPieChart( chartTitle, createPieDataset(), true, true, false);
        	JPanel panel = new ChartPanel(chart);
        	panel.setPreferredSize( new java.awt.Dimension(800, 600));
	        
        	setContentPane( panel );
        	
        }
        
    }
    
    public PieDataset createPieDataset() {
    	
    	 DefaultPieDataset dataset = new DefaultPieDataset( );
         dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
         dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
         dataset.setValue( "MotoG" , new Double( 40 ) );    
         dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
         return dataset; 
    	
    }
    
    public XYDataset createDataset() throws IOException {
    	
    	XYSeriesCollection dcd = new XYSeriesCollection();
    	final XYSeries mplValue = new XYSeries ("MPL My Router");
    	final XYSeries mmqValue = new XYSeries("MMQ My Router");
    	
    	final XYSeries mplMyRouter = new XYSeries("MPL adsl");
    	final XYSeries mmqMyRouter = new XYSeries("MMQ adsl");
    	
    	List dataset = new List();
    	double mplClock = 0.0;
    	double mmqClock = 0.0;
    	
    	FileManager fm = new FileManager();
        
    	dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/myRouterOne");
        /*
    	mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println("My Router ( MPL | MMQ )");
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplMyRouter.add(1, mplClock);
        mmqMyRouter.add(1, mmqClock);
        */
    	
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/myRouterTwo");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplMyRouter.add(2, mplClock);
        mmqMyRouter.add(2, mmqClock);
       
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/myRouterThree");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplMyRouter.add(3, mplClock);
        mmqMyRouter.add(3, mmqClock);
        
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/myRouterFour");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplMyRouter.add(4, mplClock);
        mmqMyRouter.add(4, mmqClock);
        
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/myRouterFive");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplMyRouter.add(5, mplClock);
        mmqMyRouter.add(5, mmqClock);
        
        
        mplClock = 0.0;
        System.out.println("adsl ( MPL | MMQ )");
        /*
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/adslOne");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mmqValue.add(1, mmqClock);
        mplValue.add(1, mplClock);
        */
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/adslTwo");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mmqValue.add(2, mmqClock);
        mplValue.add(2, mplClock);
        
        
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/adslThree");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mmqValue.add(3, mmqClock);
        mplValue.add(3, mplClock);
        
        
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/adslFour");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mmqValue.add(4, mmqClock);
        mplValue.add(4, mplClock);
        
        
        dataset = fm.getDataset("/home/caio/workspace/tcc/correctFiles/adslFive");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mmqValue.add(5, mmqClock);
        mplValue.add(5, mplClock);
       
        dcd.addSeries(mmqMyRouter);
        dcd.addSeries(mplMyRouter);
        dcd.addSeries(mmqValue);
        dcd.addSeries(mplValue);
        
    	return dcd;
    }
    
    public double clockScrewMmq ( List dataset ) {
    	
    	double a = 1.0;
    	
    	Packet aux = dataset.header;
    	
    	double x = 0.0;
    	double y = 0.0;
    	double z = 0.0;
    	double w = 0.0;
    	double n = dataset.size;
    	
    	while ( aux.right != null ) {
    		
    		//System.out.println(df.format(aux.xi));
    		//System.out.println(aux.ti);
    		
    		x +=  aux.xi * aux.ti;
    		y +=  aux.xi ;
    		z += aux.ti;
    		w += aux.xi * aux.xi;
    		
    		
    		aux = aux.right;
    	}
    	
    	double upperSide = x - ( ( y * z ) / n );
    	double downSide = w -  ( ( y * y ) / n ) ;
    	a = upperSide / downSide;
    	
    	a = a * 1000000;
    	
    	return a;
    }
    
    public double objectiveFunction ( List dataset ) {
    	
    	//
    	double n = dataset.size;
    	Packet aux = dataset.header;
    	Packet aux2 = dataset.header.right;
    	Packet aux3 = dataset.header;
    	Packet auxCond = dataset.header;
    	double result = 0.0;
    	double currentResult = 0.0;
    	double a = 0.0;
    	double b = 0.0;
    	boolean first = true;
    	double[] firstPoint = new double[2];
    	double[] secondPoint = new double[2];
    	double[] lineInfo;
   
    	double condition = 0.0;
    	boolean conditionResult = true;
    	double resulta = 0.0;
    	
    	
    	while ( aux != null ) {

			firstPoint[0] = aux.xi;
			firstPoint[1] = aux.ti;
			
			if ( aux.right != null ) {
				aux2 = aux.right;
			}
			
    		while ( aux2 != null ) {
    			
    			if ( aux.right != null ) {
    				
    				secondPoint[0] = aux2.xi;
        			secondPoint[1] = aux2.ti;
        			lineInfo = getLineInfo(firstPoint, secondPoint);
        			a = lineInfo[0];
        			b = lineInfo[1];
        			conditionResult = true; // Reseting the value for we have new combination of two points.
        			
        			auxCond = dataset.header;
        			
        			// Put timer here.
        			
        			while ( auxCond != null && conditionResult ) {
        				
        				condition = a * auxCond.xi + b;
            			if ( condition < auxCond.ti ) {
            				conditionResult = false;
            			}
            			
            			auxCond = auxCond.right;
        			}
        			
        			
        			if ( !conditionResult ) {
        				
        				aux2 = aux2.right;
        				
        			} else {
        				
        				aux3 = dataset.header;
        				
        				// Put timer here
        				
            			while ( aux3 != null ) {
            				result += ( a * aux3.xi ) + b - aux3.ti;
            				aux3 = aux3.right;
            				
            			}
            			
            			result = result/n;
            			
            			if ( first ) {
            				resulta = a;
            				currentResult = result;
            				first = false;
            				
            			} else {
            				if ( currentResult > result ) {           				
                				resulta = a;
                				currentResult = result;
            				}
            			}
            			
            			aux2 = aux2.right;
            			result = 0;
            			
        			}
        			
    			} else {
    				aux2 = null;
    			}
    			
    		}
    		
    		aux = aux.right;
    		
    	}
    	
    	return resulta * 1000000;
    }
    
    public double[] getLineInfo ( double[] a, double[] b) {
		
		// a (xa, ya) , b (xb, yb)
		// y = nx + lineb
		// We will use a to find b.
		
    	double n = ( b[1] - a[1] ) / ( b[0] - a[0] );
    	double lineb = a[1] - ( n * a[0] );
		
    	double[] lineInfo = new double[2];
		lineInfo[0] = n;
		lineInfo[1] = lineb;
		
		return lineInfo;
	}

   public static void main(String[] args) throws IOException {
		
		MethodTester chart = new MethodTester("Estimate Clock Skew", "Most Aproximate Skews Estimated Values", "pie");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chart.setVisible(true);
		
	}

}
