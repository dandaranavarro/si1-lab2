package models;


import java.util.ArrayList;
import java.util.List;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;


public class ControlaMetas {

	private List<Meta> listaMetas;
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



	public GenericDAO getDao() {
		return dao;
	}

	public void setDao(GenericDAO dao) {
		this.dao = dao;
	}

	private List<Meta> getListMetas() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean podeInserir(Meta meta) {
		// TODO Auto-generated method stub
		return false;
	}



	

}