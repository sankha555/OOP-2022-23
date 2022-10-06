public class Song implements Comparable<Song> {
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
        System.out.printf("%s by %s of duration %d seconds played %d times.\n", title, artist, duration,
                numberOfTimesPlayed);
    }

    @Override
    public int compareTo(Song otherSong) {
        if (this.duration > otherSong.duration) {
            return 1;
        } else if (this.duration == otherSong.duration) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration && artist.equals(song.artist) && title.equals(song.title);
    }
}
