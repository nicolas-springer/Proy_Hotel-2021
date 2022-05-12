package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Pintar extends DefaultTableCellRenderer {

		private int columna ;
		
		
		
		@Override
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
		{        
			

	        JLabel etiqueta = (JLabel) super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	      
	        
	        if (value instanceof String){
	          
	         String dato = (String) value;
	         
	         if (dato.equals("ocupado"))
	        	 etiqueta.setBackground(Color.red);
	         	etiqueta.setText("");
	        
	         if (dato.equals("mantenimiento"))
	 	        	etiqueta.setBackground(Color.gray);
	         etiqueta.setText("");
	         
	         if (dato.equals("reservado") )
	 	        	etiqueta.setBackground(Color.yellow);
	         etiqueta.setText("");
	         
	         if (dato.equals("ocupar")||dato.equals("ocuparReserva"))
	 	        	etiqueta.setBackground(Color.green);
	         etiqueta.setText("");
	        }
	        
	       
	        else {
	        	etiqueta.setBackground(table.getBackground());
	        }

	        return etiqueta;
	    }
		  
		}
		


