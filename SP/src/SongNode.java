public class SongNode
{
    private SongNode left;
    private SongNode right;
    private Song data;

    public SongNode(Song data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public void setLeft(SongNode left)
    {
        this.left = left;
    }

    public void setRight(SongNode right)
    {
        this.right = right;
    }

    public Song getData()
    {
        return data;
    }

    public SongNode getLeft()
    {
        return left;
    }

    public SongNode getRight()
    {
        return right;
    }

}
