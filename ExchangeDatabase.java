package trainMaster;

import java.io.Serializable;
import java.util.ArrayList;

public class ExchangeDatabase  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4117398988009582087L;
	ArrayList<Exchange> exchanges;
	
	public void add(Exchange exchange) {
		if (!exchanges.contains(exchange))
			exchanges.add(exchange);
	}
	
	public void delete(Station station, TrainLine line) {
		Exchange aux = null;
		for(Exchange i: exchanges) {
			if(i.getLine().equals(line) && i.getStation().equals(station)) {
				aux = i;
				break;
			}
		}
		if (!aux.equals(null))
		exchanges.remove(aux);
		}
	
}
