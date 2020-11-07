import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class SpotifyHandler
{
    private ArrayList<String> csvList = new ArrayList<>();
    private ArrayList<Artist> artistList = new ArrayList<>();
    private ArrayList<Song> songList = new ArrayList<>();
    private ArrayList<Song> unSortedSongList = new ArrayList<>();
    private ArrayList<Artist> unSortedArtistList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    /*
    The handFile method let me create a queue and put all the fileName into the queue.
    Once all the fileName is filled up in the queue, then I used a ArrayList with only String to contains
    the line of information which it will be a size of 800 because each file is 200 lines.
    Then I called the handle.class method after the parsing is done.
     */
    public void handleFile(String[] fileList)
    {
        try
        {
            MyQueue que = new MyQueue();

            for(int i = 0; i < fileList.length; i++)
            {
                que.add(fileList[i]);
            }

            int counter = 0;

            int size = que.getSize();

            while(counter < size)
            {
                Scanner readFile = new Scanner(new File(que.getHead()));
                readFile.nextLine();
                readFile.nextLine();

                while (readFile.hasNextLine())
                {
                    String line = readFile.nextLine();
                    csvList.add(line);
                }

                que.remove();
                counter++;
            }

            handleClass();

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    /*
    In the handleClass method, I set up some pointer and counter to keep track of things. For example, I have a two loops [For and While],
    the while loop let me break the arrayList of String into 4 parts. The inner For Loop let me scan each of the part [200 lines each].
    That is where the leftPointer and rightPointer come in handy. I use pointerInceaser to add 200 after each part is done.
    This whole method let me break things apart and put them into classes like Song and Artist class.
     */
    public void handleClass() {

        int leftPointer = 0;
        int rightPointer = 200;
        int fileCount = 1;
        int fileCountForArtist = 0;

        int i = 0;
        int pointerIncreaser = 0;
        int size = csvList.size()/200;
        while(i < size)
        {
            for(int j = leftPointer + pointerIncreaser; j < rightPointer + pointerIncreaser; j++)
            {
                int artistDuplicateCount = 0;
                String[] temp1 = csvList.get(j).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                Artist artist = new Artist(temp1[2]);
                Song song = new Song(temp1[0], temp1[1], temp1[2], Integer.parseInt(temp1[3]), temp1[4]);
                unSortedSongList.add(song);
                unSortedArtistList.add(artist);


                boolean flag = false;
                int artistListIndex = 0;
                for (int k = 0; k < artistList.size(); k++) {
                    if (artistList.get(k).getName().equalsIgnoreCase(artist.getName())) {
                        flag = true;
                        artistListIndex = k;
                        ++artistDuplicateCount;
                    }
                }

                boolean flag1 = false;
                int songListIndex = 0;
                for (int l = 0; l < songList.size(); l++) {
                    if (songList.get(l).getSongName().equalsIgnoreCase(song.getSongName())) {
                        flag1 = true;
                        songListIndex = l;
                    }
                }
                if (songList.isEmpty()) {
                    song.setNumberOfFileAppearedIn(fileCount);
                    songList.add(song);
                } else if (!songList.isEmpty() && flag1 == false) {
                    song.setNumberOfFileAppearedIn(fileCount);
                    songList.add(song);
                } else if (!songList.isEmpty() && flag1 == true) {
                    songList.get(songListIndex).setNumberOfFileAppearedIn(fileCount);
                    songList.get(songListIndex).setStreamNumber(song.getStreamNumber());
                }

                if (artistList.isEmpty()) {
                    artist.setAppearedCount(++artistDuplicateCount);
                  // artist.setNumberOfFileAppearedIn();
                    artist.addSong(song);
                    artistList.add(artist);
                } else if (!artistList.isEmpty() && flag == false) {
                    artist.setAppearedCount(++artistDuplicateCount);
                   // artist.setNumberOfFileAppearedIn();
                    artist.addSong(song);
                    artistList.add(artist);
                } else if (!artistList.isEmpty() && flag == true) {
                    artistList.get(artistListIndex).setAppearedCount(artistDuplicateCount);
                    //artistList.get(artistListIndex).setNumberOfFileAppearedIn();
                    artistList.get(artistListIndex).addSong(song);
                }
            }

            for(int k = 0; k < artistList.size(); k++)
            {
                artistList.get(k).setNumberOfFileAppearedIn();
            }

            pointerIncreaser+=200;
            i++;
        }
        for(int k = 0; k < songList.size(); k++)
        {
            songList.get(k).setAverageStreamNumber();
        }

        for(int k = 0; k < artistList.size(); k++)
        {
            artistList.get(k).setArtistAverage();
        }
    }

    public ArrayList<Song> getUnSortedSongList()
    {
        return unSortedSongList;
    }

    public ArrayList<Song> getSongList()
    {
        return songList;
    }

    public ArrayList<Artist> getArtistList()
    {
        return artistList;
    }

    public ArrayList<String> getCsvList()
    {
        return csvList;
    }
}
