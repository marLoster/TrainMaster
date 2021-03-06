package trainMaster;

import java.io.Serializable;
import java.util.ArrayList;

public class Station  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1381010956568694060L;
	ArrayList<Connection> connections;
	ArrayList<TrainLine> lines;
	String name;
	
	Station(String name) {
		this.name = name;
		this.connections = new ArrayList<Connection>();
		this.lines = new ArrayList<TrainLine>();
	}
	
	public void addLine(TrainLine line) {
		if (!(lines.contains(line))) {
			lines.add(line);
			for(TrainLine stationLine: lines) {
				if (stationLine.equals(line)) {
					continue;
				}
				line.getExchanges().add(new Exchange(this,stationLine));
				stationLine.getExchanges().add(new Exchange(this,line));
			}
		}
	}
	
	public void deleteLine(TrainLine line) {		//Removes line ONLY IF it doesn't go through the station !!!
		if (!(line.getStations().contains(this)))
			lines.remove(line);
	}
	
	public void printLines() {
		for(TrainLine i: lines) {
			System.out.println(i.getName());
		}
	}
	
	public void printLines(String message) {
		for(TrainLine i: lines) {
			System.out.print(message);
			System.out.println(i.getName());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}

	public ArrayList<TrainLine> getLines() {
		return lines;
	}

	public void setLines(ArrayList<TrainLine> lines) {
		this.lines = lines;
	}
}
