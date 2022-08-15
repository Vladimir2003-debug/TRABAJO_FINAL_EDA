
public class ResultChecker {
private boolean[] result;
	private BTree[] fuentes;
	private BTree file;

	public ResultCheker(int n, BTree[] fuentes, BTree file){
          result = new boolean[n];
          this.fuentes = fuentes;
          this.file = file;
    }

	public void compareFiles(int n){
           for(int x: n)
                 matchFiles(fuentes[x], file, x);
    }

	public void matchFiles(BTree x, BTree y, int z){
		int perc = 0;
     	perc += algoritmoA(x,y);
        perc += algoritmoB(x,y);
        
        //....... masAlgorimtosv:
        if( perc > 0.5)
              result[z] = true;
              //aca tengo duda desde que % va el true en las bolas v: de 50% supongoS

    }
	public int algoritmoA(BTree x, BTree y) {
		//.......compara X cosas
		return 0; //% de coincidencia
	}
    public int algoritmoB(BTree x, BTree y) {
    	//......compara Y cosas
    	return 0; //%coincidencia...
    }
   
}
