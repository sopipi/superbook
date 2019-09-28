package superbook.daoTest;

import org.junit.Test;

import superbook.bean.Machine;
import superbook.dao.MachineDao;

public class MachineDaoTest {
	private MachineDao dao = new MachineDao();
	
	@Test
	public void add() {
		Machine e = new Machine(); 
		e.setMachineState(2);
		e.setPosition("南区");
		e.setMid(2);
		dao.add(e);
	}
	
	@Test 
	public void delete() {
		dao.delete(2);
	}
	
	@Test
	public void selectPosition() {
		System.out.println(dao.selectPosition(1));
	}
	
	@Test
	public void selectMachineState() {
		System.out.println(dao.selectMachineState(1));
	}
	
	@Test
	public void changeState() {
		dao.changeState(1, 3);
	}
}
