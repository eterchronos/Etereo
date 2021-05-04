package test;

import model.DAO.OccupationDAO;
import model.bean.Occupation;

public class OccupationTest {

	public static void main(String[] args) {
		Occupation o = new Occupation();
		OccupationDAO oDAO = new OccupationDAO();
		
		o.setCargo("Trapezista");
		o.setId(7);
		oDAO.update(o);
		System.out.println(oDAO.select());

	}

}
