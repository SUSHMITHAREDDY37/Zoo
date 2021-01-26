import java.util.ArrayList;
import java.util.List;

public class Zoo {
	int zooId, numOfAnimals;
	String ZooLocation;
	List<Animal> animalsList=new ArrayList<>();
	public List<Animal> getAnimalsList() {
		return animalsList;
	}
	public void setAnimalsList(List<Animal> animalsList) {
		this.animalsList = animalsList;
	}
	public int getZooId() {
		return zooId;
	}
	public void setZooId(int zooId) {
		this.zooId = zooId;
	}
	public int getNumOfAnimals() {
		return numOfAnimals;
	}
	public void setNumOfAnimals(int numOfAnimals) {
		this.numOfAnimals = numOfAnimals;
	}
	public String getZooLocation() {
		return ZooLocation;
	}
	public void setZooLocation(String zooLocation) {
		ZooLocation = zooLocation;
	}
	
	
}
