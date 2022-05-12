package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class PintarSeleccionada extends DefaultTableCellRenderer {

    private Integer columna;
    private Integer fila;
   
    PintarSeleccionada (int col, int f){
    	
    	this.columna= col ;
    	this.fila = f;
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtenemos la celda que se esta renderizando
    	JLabel etiqueta = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


    	
	
    	
    	if (value instanceof String){
	          
	         String dato = (String) value;
	         
	         if (dato.equals("ocupado"))
	        	 etiqueta.setBackground(Color.red);
	         	etiqueta.setText("");
	                 
	         if (dato.equals("mantenimiento"))
	 	        	etiqueta.setBackground(Color.gray);
	         etiqueta.setText("");
	         
	         if (dato.equals("reservado"))
	 	        	etiqueta.setBackground(Color.yellow);
	         etiqueta.setText("");
	         
	         
	 	        	
	        }
    /*
    	else if (etiqueta.getBackground().equals(Color.green)) {
   		 etiqueta.setBackground(Color.green);
    	 System.out.println(etiqueta.getText().toString() + "aber");
}*/
    	
    	if (columna.compareTo(column) == 0 && fila.compareTo(row) == 0) {
            etiqueta.setBackground(Color.green);
           
            
            System.out.println("s");
        }
    	
    	
    	else etiqueta.setBackground(table.getBackground());
       
    
        return etiqueta;
    }
    
    public Integer setColumna (Integer c) {
    	return this.columna = c;
    }
}
