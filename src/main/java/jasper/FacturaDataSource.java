package jasper;

import java.util.ArrayList;

import net.sf.jasperreports.*;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class FacturaDataSource implements JRDataSource{

//	private  ArrayList<ArrayList<String>> listado  = new ArrayList<ArrayList<String>>();
	private Integer indice; 
	private  Object [][] lista;
		
	/*
	public void inicializarListado(ArrayList<ArrayList<String>> lis) {
		
	
		
		this.indice = -1 ; 
		this.listado = lis;
		

	}
	*/
	public FacturaDataSource(Object[][] esperoquean){
	
	indice = -1;
	
	lista = esperoquean;
/*
	lista = new Object [][] {
		
		{"S","w","SA"},
		{"S","w","SDSASDA"},
	};
	*/
	
	
	}

	@Override
	public boolean next() throws JRException {
	
		indice++;

		return (indice < lista.length);
		
	}

	@Override
	public Object getFieldValue(JRField jrField) throws JRException {
		
		Object value = null;
		
		String fieldName = jrField.getName();
		
		
		
		/*
		switch(fieldName){
			
		case "cDescripcion":
			System.out.println("1");
			value = listado.get(indice).get(0);
			break;
	
			
		case "cPrecioU":
		System.out.println(2);
			value = listado.get(indice).get(1);
			break;
			
		
		
		case "cPrecio":
		System.out.println(3);
		value = listado.get(indice).get(2);
		break;
		*/
		switch(fieldName){
		
		case "cDescripcion":
			
			value = lista[indice][0];
			break;
	
			
		case "cPrecioU":
	
			value = lista[indice][1];
			break;
			
		
		
		case "cPrecio":
	
		value = lista[indice][2];
		break;
	}
		return value;
	}
	
	public static  JRDataSource getDataSource(Object[][] esperoquean) {
		
		
		return new FacturaDataSource(esperoquean);
	}



}
