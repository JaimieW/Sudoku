package solver;

public class SudokuSolver {

	int[][] grid;

	public SudokuSolver(){
		grid = new int[9][9];
	}

	public void loadValues(String values){

		for(int i=0; i<9; i++){

			for(int j=0; j<9; j++){
				grid[i][j] = Integer.parseInt(String.valueOf(values.charAt((i*9)+j)));
			}
		}

	}

	public void solve(){

		int x = 0, y = 0;
		
		solve(x, y);
		
	}
	
	public void solve(int x, int y){
		
			
			if(grid[x][y] == 0){
				int tmp = 1;
				while(grid[x][y] == 0 && tmp <= 9){
					if((!rowContains(x, tmp)) && (!columnContains(y, tmp)) && (!boxContains(x, y, tmp))){
						grid[x][y] = tmp;
					}
					else {
						tmp++;
					}
				}
			}
			else{
				while(x < 8){
					x++;
					solve(x, y);
					if(x == 8 && y<8){
						x = 0;
						y++;
						solve(x, y);
						if(y == 8) return;
					}
					
				}
			}


	}

	boolean rowContains(int row, int value){
		for(int i=0; i<9; i++){
			if(grid[row][i] == value) return true;
		}
		return false;
	}

	boolean columnContains(int col, int value){
		for(int i=0; i<9; i++){
			if(grid[i][col] == value) return true;
		}
		return false;
	}

	boolean boxContains(int row, int col, int val){
		int hBox = 3*(row/3);
		int vBox = 3*(col/3);

		for(int x=hBox ; x<3+hBox; x++){

			for(int y=vBox; y<3+vBox; y++){
				//				System.out.println("checking grid["+x+"]["+y+"]");
				if(grid[x][y] == val)return true;
			}
		}
		return false;
	}

	public String toString(){
		StringBuilder val = new StringBuilder();
		for(int i=0; i<9; i++){
			if(i%3 == 0) val.append("--------------------------------------\n");

			for(int j=0; j<9; j++){
				if(j%3 == 0) val.append(" | ");
				val.append(" "+ grid[i][j] + " ");
			}
			val.append(" | \n");

		}
		val.append("--------------------------------------\n");
		return val.toString();
	}

	public String values(){
		StringBuilder val = new StringBuilder();
		for(int i=0; i<9; i++){

			for(int j=0; j<9; j++){
				val.append(grid[i][j]);
			}

		}
		return val.toString();
	}
}
