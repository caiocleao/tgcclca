package mainpackeage;

import java.awt.Color;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;


public class MethodTester extends JFrame {
	
	private static final long serialVersionUID = 1L;
	double linen = 0.0;
	double lineb = 0.0;
	DecimalFormat df = new DecimalFormat("#.############");

	double[] mmqLine =  new double[2];
	
	
    public MethodTester(String applicationTitle, String chartTitle) throws IOException {
        super(applicationTitle);
        
        JFreeChart chart = ChartFactory.createScatterPlot(chartTitle, "Xi ( Seconds )", "Thetai", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel ( chart );
        panel.setPreferredSize( new java.awt.Dimension(800, 600));
        //final XYPlot plot = chart.getXYPlot();
        final XYPlot plot = chart.getXYPlot();
        
        
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setDrawSeriesLineAsPath(false);
        renderer.setSeriesPaint(0, Color.red);
        plot.setRenderer( renderer );
        setContentPane( panel );
        
    }
    
    public XYDataset createDataset() throws IOException {
    	
    	XYSeriesCollection dcd = new XYSeriesCollection();
    	final XYSeries mplValue = new XYSeries ("My Router");
    	final XYSeries mplAdsl = new XYSeries("adsl");
    	final XYSeries mplRenata = new XYSeries("Renata");
    	final XYSeries mplBruna = new XYSeries("Bruna");
    	
    	
    	//final XYSeries baseLine = new XYSeries("BaseLine");
    	FileManager fm = new FileManager();
        
    	List dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterOne");
        double mplClock = objectiveFunction(dataset);
        double mmqClock = clockScrewMmq(dataset);
        System.out.println("My Router ( MPL | MMQ )");
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(1, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterTwo");
        //mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(2, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterThree");
        //mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(3, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterFour");
        //mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(4, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterFive");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(5, mmqClock);
        
        mplClock = 0.0;
        System.out.println("adsl ( MPL | MMQ )");
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslOne");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(1, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslTwo");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(2, mmqClock);
        
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslThree");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(3, mmqClock);
        
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslFour");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(4, mmqClock);
        
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslFive");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(5, mmqClock);
       
       
        
        mplClock = 0.0;
        System.out.println("Bruna ( MPL | MMQ )");
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaOne");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(1, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaTwo");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(2, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaThree");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(3, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaFour");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(4, mmqClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaFive");
        // mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(5, mmqClock);
        

        /*
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterTwo");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(2, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterThree");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(3, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterFour");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(4, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/myRouterFive");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplValue.add(5, mplClock);
        
        mplClock = 0.0;
        System.out.println("adsl ( MPL | MMQ )");
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslOne");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(1, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslTwo");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(2, mplClock);
        
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslThree");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(3, mplClock);
        
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslFour");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(4, mplClock);
        
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/adslFive");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplAdsl.add(5, mplClock);
       
       
        
        mplClock = 0.0;
        System.out.println("Bruna ( MPL | MMQ )");
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaOne");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(1, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaTwo");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(2, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaThree");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(3, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaFour");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(4, mplClock);
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/brunaFive");
        mplClock = objectiveFunction(dataset);
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplBruna.add(5, mplClock);
        
        mplClock = 0.0;
        System.out.println("Renata ( MPL | MMQ )");
        
        dataset = fm.getDataset("/home/caio/Documents/tccFiles/correctFiles/renataOne");
        mplClock = objectiveFunction(dataset) / 1000000000;
        mmqClock = clockScrewMmq(dataset);
        System.out.println(df.format(mplClock) + " | " + df.format(mmqClock) + " " + dataset.size);
        mplRenata.add(1, mplClock);
         */  
        
        dcd.addSeries(mplValue);
        dcd.addSeries(mplAdsl);
        dcd.addSeries(mplBruna);
        //dcd.addSeries(mplRenata);
        //dcd.addSeries(baseLine);
        //dcd.addSeries(mmqValue);
        
        
    	return dcd;
    }
    
    public double clockScrewMmq ( List dataset ) {
    	
    	double a = 0.0;
    	
    	Packet aux = dataset.header;
    	
    	double x = 0.0;
    	double y = 0.0;
    	double z = 0.0;
    	double w = 0.0;
    	double n = dataset.size;
    	
    	
    	// Calculate medians
    	
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
    	
    	
    	//downSide = downSide / 1000000.0;
    	// 10000000000 works for tplink.
    	
    	
    	a = upperSide / downSide;
    	
    	//System.out.println("Sigma(x²): " + df.format(y) + " SIGMA(X)² " + df.format(( Math.pow(y, 2) / dataset.size )));
    	//System.out.println(df.format(upperSide) + " / " + df.format(downSide));
    	//System.out.println("Result: " + df.format(a));
    	
    	
    	return a;
    }
    
    public double objectiveFunction ( List dataset ) {
    	
    	//
    	double n = dataset.size;
    	Packet aux = dataset.header;
    	Packet aux2 = dataset.header.right;
    	Packet aux3 = dataset.header;
    	double result = 0.0;
    	double currentResult = 0.0;
    	double a = 0.0;
    	double b = 0.0;
    	boolean first = true;
    	double[] firstPoint = new double[2];
    	double[] secondPoint = new double[2];
    	double[] lineInfo;
   
    	double condition = 0.0;
    
    	double resulta = 0.0;
    	double resultb = 0.0;
    	
    	
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
        			
        			
        			condition = a * aux2.xi + b;
        			
        			if ( condition < aux2.ti ) {
        				
        				//System.out.println("Condition not met:");
        				aux2 = aux2.right;
        				
        			} else {
        				
        				aux3 = dataset.header;
            			//System.out.print("point a: " + pointa + " ");
            			//System.out.println("poinb b: " + pointb);
            			while ( aux3 != null ) {
            				result += ( a * aux3.xi ) + b - aux3.ti;
            				aux3 = aux3.right;
            				
            			}
            			
            			result = result/n;
            			//System.out.println(result);
            			
            			if ( first ) {
            				resulta = a;
            				resultb = b;
            				currentResult = result;
            				first = false;
            				
            			} else {
            				if ( currentResult > result ) {           				
                				resulta = a;
                				resultb = b;
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
    	
    	return resulta;
    }
    
    // Creating 
    
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
		
		MethodTester chart = new MethodTester("Dataset Behavior", "Dataset Behavior");
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chart.setVisible(true);
		
	}

}
