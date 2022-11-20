
import java.util.Comparator;
// Remove public in hackerrank submission, move imports to top in hackerrank submission
public class SpatialAudioComparator implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        boolean b1 = o1.getHasSpatialAudio();
        boolean b2 = o2.getHasSpatialAudio();
        if ((b1 && b2) || (!b1 && !b2)) {
            return o1.compareTo(o2);
        }
        return Boolean.compare(o2.getHasSpatialAudio(), o1.getHasSpatialAudio());
    }
}
