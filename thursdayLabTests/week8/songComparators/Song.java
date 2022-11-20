
public class Song implements Comparable<Song> {
    private final String artist;
    private final int durationInSeconds;
    private final long hearts;
    private boolean hasSpatialAudio;

    @Override
    public String toString() {
        return this.name;
    }

    private final String name;

    public Song(String name, String artist, int durationInSeconds, long hearts, boolean hasSpatialAudio) {
        this.name = name;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
        this.hearts = hearts;
        this.hasSpatialAudio = hasSpatialAudio;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public boolean getHasSpatialAudio() {
        return hasSpatialAudio;
    }

    public long getHearts() {
        return hearts;
    }

    @Override
    public int compareTo(Song o) {
        return Integer.compare(this.durationInSeconds, o.durationInSeconds);
    }

    public void setHasSpatialAudio(boolean hasSpatialAudio) {
        this.hasSpatialAudio = hasSpatialAudio;
    }
}
