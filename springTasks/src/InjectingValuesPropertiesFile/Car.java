package InjectingValuesPropertiesFile;



public class Car implements Vehicle
{
    Database database;
    public Car (Database database){
        this.database = database;
    }
    @Override
    public void saveToDatabase(Vehicle vehicle) {
        database.saveData(vehicle);
    }
}
