package connector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DbConnector
{
    private String fileName;

    public DbConnector() { fileName = "";}
    public DbConnector(String fileName) { this.fileName = fileName;}

    public ArrayList<String> readDataFromFile(){

        FileReader fileReader = null;
        ArrayList<String> data = new ArrayList<>();
        try{
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null)
            {
                data.add(line);
            }
            bufferedReader.close();


        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        return data;
    }

    public String getFileName() { return fileName;}
}
