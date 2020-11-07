import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class SpotifyPlayer {

    public static void main(String[] args) throws Exception{

        Scanner keyboard = new Scanner(System.in);
        String[] fileList = {"regional-global-daily-2019-01-01.csv", "regional-global-daily-2019-03-01.csv", "regional-global-daily-2019-06-01.csv", "regional-global-daily-2019-09-01.csv"};

        SpotifyHandler handler = new SpotifyHandler();

        handler.handleFile(fileList);

        ArrayList<Song> b = handler.getSongList();

        ArrayList<Artist> c = handler.getArtistList();

        quicksort(b, 0, b.size() - 1);


        BinaryTree tree = new BinaryTree();

        for(int i = 0; i < b.size(); i++)
        {
            tree.insert1(b.get(i));
        }


        tree.subSet(b.get(0), b.get(b.size() - 1));

        ArrayList<Song> binaryData = tree.getBinaryData();
        ArrayList<Song> subSetList = tree.getSubSetList();

        //This code below basically print things into a file with BufferedWriter.

        File file = new File("Artists-WeekOf11082020.txt");
        file.createNewFile();
        FileWriter writeFile = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writeFile);
        bw.write("List Of songs in four quarters:\n");

        for(int i = 0; i < binaryData.size(); i++)
        {
            bw.write(i+1 + ". " + binaryData.get(i).getSongName()
                    + " | Total Stream: " + binaryData.get(i).getStreamNumber()
                    + " | Average stream: " + binaryData.get(i).getAverageStreamNumber()
                    +"\n");
        }

        bw.write("\n");
        bw.write("Subset Report:\n");

        for(int j = 0; j < subSetList.size(); j++)
        {
            bw.write(j + 1 + ". " + subSetList.get(j).getSongName() + "\n");
        }

        bw.write("\n");
        bw.write("Artist Report:\n");

        for(int k = 0; k < c.size(); k++)
        {
            bw.write((k + 1 + ". " + c.get(k).getName()
                    + " Total Appearance count: " + c.get(k).getAppearedCount()
                    + " Average Appearance: " + c.get(k).getArtistAverage()
                    + " File Appearance: " + c.get(k).getNumberOfFileAppearedIn() + "\n"));
        }

        bw.close();

    }

    public static void quicksort(ArrayList<Song> b, int low, int high) {
        int i = low, j = high;

        String pivot = b.get(low + (high - low) / 2).getSongName();

        while (i <= j)
        {
            while (b.get(i).getSongName().compareToIgnoreCase(pivot) < 0)
            {
                i++;
            }

            while (b.get(j).getSongName().compareToIgnoreCase(pivot) > 0)
            {
            j--;
            }

            if (i <= j)
            {
            swap(b, i, j);
            i++;
            j--;
            }
         }

        if (low < j) {
            quicksort(b, low, j);
        }

        if (i < high) {
            quicksort(b, i, high);
        }


    }

    public static void swap(ArrayList<Song> b, int i, int j)
        {
            Song temp = b.get(i);
            b.set(i, b.get(j));
            b.set(j, temp);
        }
}



