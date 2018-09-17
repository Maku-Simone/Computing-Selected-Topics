import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
  
public class G extends JPanel implements ChangeListener {
    Shape[] shapes;
    Dimension size;
    double scale = 1.0;
  
    public G() {
        size = new Dimension(1000,1000);
        setBackground(new Color(240,200,200));
    }
  
    public void stateChanged(ChangeEvent e) {
        int value = ((JSlider)e.getSource()).getValue();
        scale = value/100.0;
        repaint();
        revalidate();
    }
  
    protected void paintComponent(Graphics g) 
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
								RenderingHints.VALUE_ANTIALIAS_ON);
			if(shapes == null) 
				initShapes();
			// Keep shapes centered on panel.
			double x = (getWidth()  - scale*size.width)/2;
			double y = (getHeight() - scale*size.height)/2;
			AffineTransform at = AffineTransform.getTranslateInstance(x, y);
			at.scale(scale, scale);
			
	
							g2.setPaint(Color.blue);
							g2.draw(at.createTransformedShape(shapes[0]));
		
						
		}
  
    public Dimension getPreferredSize() 
		{
			int w = (int)(scale*size.width);
			int h = (int)(scale*size.height);
			return new Dimension(w, h);
		}
  
    private void initShapes() 
		{
			shapes = new Shape[3];
			int w = getWidth();
			int h = getHeight();
			

			shapes[0] = new Rectangle2D.Double(h, w, h/10, w/10); //x, y, alto, ancho
			size.width = w;
			size.height = h;
		}
  
    private JSlider getControl() //mi barra del zoom :3
		{
			JSlider zoom = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
			zoom.setMajorTickSpacing(50);
			zoom.setMinorTickSpacing(10);
			zoom.setPaintTicks(true);
			zoom.setPaintLabels(true);
			zoom.addChangeListener(this);
			return zoom;        
		}
  
    public static void main(String[] args) {
        G app = new G();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JScrollPane(app));
        f.getContentPane().add(app.getControl(), "Last");
        f.setSize(1000, 900); //x, y
        f.setLocation(500,100);//x, y
        f.setVisible(true);
    }
}