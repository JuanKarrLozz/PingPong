import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReboteFrame extends JFrame {
	private PelotaComponentes comp;
	
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;
	
	public static final int PASOS = 5000;
	public static final int RETRASO = 1;
	
	public ReboteFrame(){
		this.setSize( DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.setTitle("PONG");
		comp = new PelotaComponentes();
		this.add(comp,BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		
		this.addButton(buttonPanel,"Iniciar",new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addPelota();
			}
		
		});
		
		this.addButton(buttonPanel,"Cerrar",new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		add(buttonPanel,BorderLayout.NORTH);
	}
	public void addButton(Container c,String titulo, ActionListener listener){
		JButton btn = new JButton(titulo);
		c.add(btn);
		btn.addActionListener(listener);
	}
	
	private void addPelota() {
		Pelota p = new Pelota();
		comp.addPelota(p);
		
		
		for(int i = 1; i < PASOS; i++){
			try {
			
			p.move(comp.getBounds());
			comp.paint(comp.getGraphics());
			Thread.sleep(RETRASO);
			
			} catch (InterruptedException e) {
				
			}
		}
	}
	
}
