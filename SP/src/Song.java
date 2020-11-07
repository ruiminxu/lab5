public class Song
{
    private String position;
    private String songName;
    private String singer;
    private int streamNumber;
    private String URL;
    private double averageStreamNumber;
    private int appearCount = 0;
    private int numberOfFileAppearedIn = 0;

    public Song(String position, String songName, String singer, int streamNumber, String URL)
    {
        this.singer = singer.replaceAll("\"", "").strip();
        this.position = position;
        this.songName = songName.replaceAll("\"", "").strip();
        this.streamNumber = streamNumber;
        this.averageStreamNumber = streamNumber;
        this.URL = URL;
    }

    public void setSongName(String songName)
    {
        this.songName = songName;
    }

    public void setSinger(String singer){ this.singer = singer;}

    public void setPosition(String position)
    {
        this.position = position;
    }

    public void setURL(String URL)
    {
        this.URL = URL;
    }

    public void setStreamNumber(int streamNumber)
    {
        this.streamNumber += streamNumber;
    }

    public void setNumberOfFileAppearedIn(int count)
    {
        this.numberOfFileAppearedIn += count;
    }

    public void setAverageStreamNumber()
    {
        averageStreamNumber = (double )streamNumber/numberOfFileAppearedIn;
    }

    public void setAppearCount(int appearCount)
    {
        this.appearCount += appearCount;
    }

    public double getAverageStreamNumber()
    {
        return averageStreamNumber;
    }

    public String getSongName()
    {
        return songName;
    }

    public String getSinger() {return singer;}

    public int getAppearCount()
    {
        return appearCount;
    }

    public String getPosition()
    {
        return position;
    }

    public String getURL()
    {
        return URL;
    }

    public int getStreamNumber()
    {
        return streamNumber;
    }

    public int getNumberOfFileAppearedIn()
    {
        return numberOfFileAppearedIn;
    }
}
