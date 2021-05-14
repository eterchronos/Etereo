package test;

import Ui.OccupationUi;
import model.DAO.OccupationDAO;

public class OccupationTest {

	public static void main(String[] args) {
		OccupationUi o = new OccupationUi();
		OccupationDAO oDAO = new OccupationDAO();
		OccupationUi oUi = new OccupationUi();
		oUi.windowUi();
	}

}
