import java.util.ArrayList;
public class Artist
{
    private String name;
    private int totalStreamNumber;
    private ArrayList<Song> songList;
    private double artistAverage;
    private int appearedCount = 0;
    private int numberOfFileAppearedIn = 0;

    public Artist(String name)
    {
        this.name = name.replaceAll("\"", "").strip();
        songList = new ArrayList<>();
    }

    public void addSong(Song song)
    {
        boolean flag = false;
        int index = 0;

        for(int i = 0; i < songList.size(); i++)
        {
            if(song.getSongName().equalsIgnoreCase(songList.get(i).getSongName()))
            {
                flag = true;
                index = i;
            }
        }

        if(!songList.isEmpty() && flag == false)
        {
            songList.add(song);
        }else if(!songList.isEmpty() && flag == true)
        {
            return;
        }else {
            songList.add(song);

        }
    }

    public double getArtistAverage()
    {
        return artistAverage;
    }

    public void setAppearedCount(int count)
    {
        this.appearedCount += count;
    }

    public void setArtistAverage()
    {
        this.artistAverage = (double) appearedCount / numberOfFileAppearedIn;
    }

    public void setNumberOfFileAppearedIn()
    {
        this.numberOfFileAppearedIn++;
    }


    public int getAppearedCount()
    {
        return appearedCount;
    }

    public void addStreamNumber(int num)
    {
        totalStreamNumber += num;
    }

    public int getTotalStreamNumber()
    {
        return totalStreamNumber;
    }

    public int getNumberOfFileAppearedIn()
    {
        return numberOfFileAppearedIn;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Song> getSongsList()
    {
        return songList;
    }

    public void printList()
    {
        System.out.println("The artist " + name + " has " + songList.size() + " songs: ");
        for(int i = 0; i < songList.size(); i++)
        {
            System.out.println(i+1 + ". " + songList.get(i).getSongName() + " " + songList.get(i).getStreamNumber());
        }
    }


}
