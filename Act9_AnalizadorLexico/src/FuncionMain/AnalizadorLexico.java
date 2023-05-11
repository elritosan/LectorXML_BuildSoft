package FuncionMain;

public class AnalizadorLexico {

	public static void main(String[] args) {
        DomParser dp = new DomParser("SudamericaPoblacion.xml");
        try {
			dp.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
