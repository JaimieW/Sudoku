package solver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.fest.assertions.Assertions.*;

public class SudokuSolverTest {

	SudokuSolver solver;
	
	@Before
	public void setup(){
		solver= new SudokuSolver();
		solver.loadValues("200370009009200007001004002050000800008000900006000040900100500800007600400089001");
		System.out.println(solver);
	}
	@After
	public void teardown(){
		solver = null;
	}
	
	@Test
	public void shouldLoadTestData(){
		assertThat(solver.values()).isEqualTo("200370009009200007001004002050000800008000900006000040900100500800007600400089001");
	}
	
	@Test
	public void canCheckRowValues(){
		assertThat(solver.rowContains(0, 2)).isTrue();
		assertThat(solver.rowContains(0, 1)).isFalse();
		assertThat(solver.rowContains(2, 1)).isTrue();
		assertThat(solver.rowContains(2, 9)).isFalse();
	}
	
	@Test
	public void canCheckColumnValues(){
		assertThat(solver.columnContains(0, 2)).isTrue();
		assertThat(solver.columnContains(0, 1)).isFalse();
		assertThat(solver.columnContains(2, 1)).isTrue();
		assertThat(solver.columnContains(2, 3)).isFalse();
	}
	
	@Test
	public void canCheck1stBoxValues(){
		assertThat(solver.boxContains(0, 0, 1)).isTrue();
		assertThat(solver.boxContains(0, 1, 2)).isTrue();
		assertThat(solver.boxContains(0, 2, 9)).isTrue();		
		assertThat(solver.boxContains(1, 0, 2)).isTrue();
		assertThat(solver.boxContains(1, 1, 1)).isTrue();
		assertThat(solver.boxContains(1, 2, 9)).isTrue();
		assertThat(solver.boxContains(2, 0, 9)).isTrue();
		assertThat(solver.boxContains(2, 1, 1)).isTrue();
		assertThat(solver.boxContains(2, 2, 2)).isTrue();
		
		assertThat(solver.boxContains(2, 1, 8)).isFalse();

	}
	
	@Test
	public void canCheck2ndBoxValues(){
		assertThat(solver.boxContains(0, 3, 2)).isTrue();
		assertThat(solver.boxContains(0, 4, 3)).isTrue();
		assertThat(solver.boxContains(0, 5, 4)).isTrue();		
		assertThat(solver.boxContains(1, 3, 2)).isTrue();
		assertThat(solver.boxContains(1, 4, 7)).isTrue();
		assertThat(solver.boxContains(1, 5, 2)).isTrue();
		assertThat(solver.boxContains(2, 3, 3)).isTrue();
		assertThat(solver.boxContains(2, 4, 7)).isTrue();
		assertThat(solver.boxContains(2, 5, 4)).isTrue();
		
		assertThat(solver.boxContains(2, 5, 8)).isFalse();

	}
	
	@Test
	public void canCheck4thBoxValues(){
		assertThat(solver.boxContains(3, 0, 5)).isTrue();
		assertThat(solver.boxContains(3, 1, 8)).isTrue();
		assertThat(solver.boxContains(3, 2, 6)).isTrue();		
		assertThat(solver.boxContains(4, 0, 8)).isTrue();
		assertThat(solver.boxContains(4, 1, 6)).isTrue();
		assertThat(solver.boxContains(4, 2, 5)).isTrue();
		assertThat(solver.boxContains(5, 0, 5)).isTrue();
		assertThat(solver.boxContains(5, 1, 8)).isTrue();
		assertThat(solver.boxContains(5, 2, 6)).isTrue();
		
		assertThat(solver.boxContains(2, 5, 8)).isFalse();

	}
	
	@Test
	public void canCheck9thBoxValues(){
		assertThat(solver.boxContains(6, 6, 5)).isTrue();
		assertThat(solver.boxContains(6, 7, 6)).isTrue();
		assertThat(solver.boxContains(6, 8, 1)).isTrue();		
		assertThat(solver.boxContains(7, 6, 6)).isTrue();
		assertThat(solver.boxContains(7, 7, 5)).isTrue();
		assertThat(solver.boxContains(7, 8, 1)).isTrue();
		assertThat(solver.boxContains(8, 6, 1)).isTrue();
		assertThat(solver.boxContains(8, 7, 6)).isTrue();
		assertThat(solver.boxContains(8, 8, 5)).isTrue();
		
		assertThat(solver.boxContains(2, 5, 8)).isFalse();

	}
	
	@Test
	public void shouldSolve(){
		solver.solve();
		assertThat(solver.values()).isEqualTo("284375169639218457571964382152496873348752916796831245967143528813527694425689731");
	}
	
}
