import java.util.ArrayList;
import java.io.*;

public class BinaryTree
{
    private SongNode root;
    private ArrayList<Song> binaryData = new ArrayList<>();
    private ArrayList<Song> subSetList = new ArrayList<>();

    public void subSet(Song begin, Song end)
    {
        int beginIndex = binaryData.indexOf(begin);
        int endIndex = binaryData.indexOf(end);

        for(int i = beginIndex + 1; i < endIndex; i++)
        {
            subSetList.add(binaryData.get(i));
        }
    }

    private void insert(SongNode current, Song song) {

    if (current != null) {

        if (song.getSongName().compareToIgnoreCase(current.getData().getSongName()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(new SongNode(song));
                binaryData.add(song);
            } else {
                insert(current.getLeft(), song);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(new SongNode(song));
                binaryData.add(song);
            } else {
                insert(current.getRight(), song);
            }
        }
    }else{
        root = new SongNode(song);
        binaryData.add(song);
     }
    }

    public void insert1(Song song)
    {
        insert(root, song);
    }


    private void printInorder(SongNode current)
    {
        if(current == null)
        {
            return;
        }

        printInorder(current.getLeft());

        System.out.println(current.getData().getSongName());

        printInorder(current.getRight());
    }



    public void print()
    {
        printInorder(root);
    }

    public SongNode getRoot()
    {
        return root;
    }

    public ArrayList<Song> getBinaryData()
    {
        return binaryData;
    }

    public ArrayList<Song> getSubSetList()
    {
        return subSetList;
    }
}
