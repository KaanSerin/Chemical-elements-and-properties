import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.io.File;
import java.util.Scanner;
import java.util.Hashtable;

public class elementInformation {
    public static void main(String[] args) throws FileNotFoundException {
        Dictionary elements = new Hashtable();

        File file = new File("/Users/kaanserin113/IdeaProjects/chemistryElements/src/elements.txt");
        Scanner scan = new Scanner(file);

        generateElements(elements, scan);

        scan = new Scanner(System.in);

        // The loop will terminate when an integer is entered
        while(!scan.hasNextInt()){
            String input = scan.nextLine();
            input = capitalizeString(input);
            System.out.println(elements.get(input));
        }
    }

    static void generateElements(Dictionary elements, Scanner scan){
        while(scan.hasNext()){
            String line = scan.nextLine();

            String[] lineSplit = line.split(",", 8);

            //Abbreviation of element
            String abb = lineSplit[1].replaceAll(" ", "");

            //Full name of element
            String name = lineSplit[2].replaceAll(" ", "");

            String atomicMass = lineSplit[3].replaceAll(" ", "").replaceAll("\\[|\\]", "");
            if(atomicMass.length() > 3){
                atomicMass = atomicMass.substring(0, atomicMass.length() - 3);
            }

            String atomicNumber = lineSplit[0];

            int protonNumber = Integer.parseInt(atomicNumber);
            int neutronNumber = (int)Float.parseFloat(atomicMass) - protonNumber;

            //System.out.println("Name of Element: " + name + ", Proton/Atomic Number: " + protonNumber + ", Neutron Number: " + neutronNumber + ", Mass Number: " + atomicMass + " amu");

            String info = name + ", Proton/Atomic Number: " + protonNumber + ", Neutron Number: " + neutronNumber + ", Mass Number: " + atomicMass + " amu";
            elements.put(abb, info);
        }
    }
    static String capitalizeString(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
