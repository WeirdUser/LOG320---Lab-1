import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Robin on 2016-05-12.
 */
public class FileReaderBasic {

    /** function used to save the dictionary needed for the execution of the algorithm */
    public Object readDictionary(){

        // array list of all the values contained in the dictionnary
        ArrayList<String> lineListDict = createValueTable(getFile());

        return lineListDict;
    }

    /** function used to save the lines of texts to be analysed */
    public Object readLines(){
        // array list of all the values to be analysed by the program
        ArrayList<String> LineListFile = createValueTable(getFile());

        return LineListFile;
    }

    /** create a table of values from a textfile */
    private ArrayList<String> createValueTable (String filepath){
        ArrayList<String> lineListDict;

        try(BufferedReader newReader = new BufferedReader(new FileReader(filepath))){
            String currentLine;

            lineListDict = new ArrayList<String>();

            // we fill the arrayList
            while((currentLine = newReader.readLine()) != null)
            {
                lineListDict.add(currentLine);
            }

            newReader.close();
            return lineListDict;
        }
        catch(IOException e){
            // printing the error in the console
            e.printStackTrace();
        }

        return null;
    }

    /** get the path of the file to open */
    private String getFile()
    {

        JFileChooser fileChooser = new JFileChooser();

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getPath();
        }
        else if(returnValue == JFileChooser.CANCEL_OPTION)
        {
            System.exit(0);
        }

        return null;
    }
}
