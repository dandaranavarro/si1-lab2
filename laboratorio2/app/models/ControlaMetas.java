package models;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;


public class ControlaMetas {

	private List<Meta> listaMetas;
	private final int MAX_DIAS = 42;
	private GenericDAO dao = new GenericDAOImpl(); 

	public ControlaMetas(){
		listaMetas = new ArrayList<Meta>();
	}

	public boolean isEmpty(){
		return listaMetas.isEmpty();
	}

	public void adicionaMeta(Meta meta) throws Exception{
		if(podeInserir(meta) == true){
			getListMetas().add(meta);
			getDao().merge(getListMetas());
		}else{
			throw new Exception("Data Invalida");
		}

	}

	private boolean podeInserir(Meta meta) {
		// TODO Auto-generated method stub
		return false;
	}

	/*public int getSemana(Meta meta) throws ParseException{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Date data_final = format.parse(meta.getDataFinal());
		Calendar data = new GregorianCalendar();
		data.setTime(data_final);
		return data.get(Calendar.WEEK_OF_YEAR);
	}
*/
	public static String getDataAtual(){

		Calendar cal = Calendar.getInstance(); 
		String day = String.valueOf((cal.get(Calendar.DAY_OF_MONTH)));
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String currentDate = year  + "-" + month + "-" + day ; 
		return currentDate;
	}




	public List<Meta> getListMetas(){
        carregaListaMetas();
        return listaMetas;
	}

	public void carregaListaMetas() {
        if (listaMetas.isEmpty()){
			listaMetas = new ArrayList<Meta>();
            listaMetas = getDao().findAllByClassName("Meta");
        }else{
			listaMetas = listaMetas;
        }
	}


	

	public int ordenaPorPrioridade(Meta meta1, Meta meta2) {
		int result;
		if (meta1.getPrioridade() > meta2.getPrioridade()){
			result = -1;
		}else if(meta1.getPrioridade() < meta2.getPrioridade()){
			result = 1;
		}else{
			result = 0;
		}
		return result;

	}


	public GenericDAO getDao() {
		return dao;
	}


	public class ComparatorPrioridade implements Comparator<Meta>{


		@Override
		public int compare(Meta meta1, Meta meta2) {
			int result = 0;
			if (ordenaPorData(meta1, meta2) == 1 && ordenaPorPrioridade(meta1, meta2) == 1){
				result = 1;
			}else if (ordenaPorData(meta1, meta2) == -1 && ordenaPorPrioridade(meta1, meta2) == -1){
				result = -1;
			}else{
				result = 0;
			}
			return result;
		}

		private int ordenaPorData(Meta meta1, Meta meta2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

}