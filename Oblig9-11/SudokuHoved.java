/**
* Main-klassen til Sudoku-programmet
*/
class SudokuHoved {
	public static void main (String[] args) {
		RunnableGUI minRun= new RunnableGUI();
   		Thread trad = new Thread(minRun);
   		trad.start();

	//	System.out.println("Program slutt.");
	}
}