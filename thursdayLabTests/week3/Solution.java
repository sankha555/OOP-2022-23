import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Song {
    private final int duration;
    private final String artist;
    private final String title;
    private int numberOfTimesPlayed;

    public Song(String title, String artist, int duration) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;

    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfTimesPlayed() {
        return numberOfTimesPlayed;
    }

    /**
     * increments the number of times this song has been played.txt by 1
     */
    public void play() {
        numberOfTimesPlayed += 1;
    }

    /**
     * prints the details of this song
     */
    public void printSong() {
        System.out.printf("%s by %s of duration %d seconds played %d times.", title, artist, duration,
                numberOfTimesPlayed);
    }
}


public class Solution {
    public static void main(String[] args) {
        // Take inputs here: 
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String a = sc.nextLine(); 
        int d = sc.nextInt(); 
        int n = sc.nextInt();
        // Create a song object named song here:
        Song song = new Song(t, a, d);
        // Play the song N times here
        for (int i = 0; i < n; i++){
            song.play(); 
        }
        // Finally, print the song using the printSong() method
        song.printSong();

    }
}
